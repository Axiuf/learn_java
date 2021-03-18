package io.github.axiuf.eduservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.github.axiuf.eduservice.entity.EduChapter;
import io.github.axiuf.eduservice.entity.EduVideo;
import io.github.axiuf.eduservice.entity.chapter.ChapterVo;
import io.github.axiuf.eduservice.entity.chapter.VideoVo;
import io.github.axiuf.eduservice.mapper.EduChapterMapper;
import io.github.axiuf.eduservice.service.EduChapterService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.axiuf.eduservice.service.EduVideoService;
import io.github.axiuf.servicebase.exceptionhandler.YixueException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 课程 服务实现类
 * </p>
 *
 * @author autoGenerator
 * @since 2021-03-07
 */
@Service
public class EduChapterServiceImpl extends ServiceImpl<EduChapterMapper, EduChapter> implements EduChapterService {

    private EduVideoService eduVideoService;

    @Autowired
    public void setEduVideoService(EduVideoService eduVideoService)
    {
        this.eduVideoService = eduVideoService;
    }

    @Override
    public List<ChapterVo> getChapterByCourse(String courseId)
    {
        QueryWrapper<EduChapter> wrapper1 = new QueryWrapper<>();
        wrapper1.eq("course_id", courseId);

        List<EduChapter> chapterList = baseMapper.selectList(wrapper1);


        QueryWrapper<EduVideo> wrapper2 = new QueryWrapper<>();
        wrapper2.eq("course_id", courseId);
        List<EduVideo> videoList = eduVideoService.list(wrapper2);

        ArrayList<ChapterVo> finalList = new ArrayList<>();

        for (int i = 0; i < chapterList.size(); i++)
        {
            EduChapter eduChapter = chapterList.get(i);
            ChapterVo chapterVo = new ChapterVo();

            BeanUtils.copyProperties(eduChapter, chapterVo);

            List<VideoVo> videoVoList = new ArrayList<>();
            for (int j = 0; j < videoList.size(); j++)
            {
                EduVideo eduVideo = videoList.get(j);

                if (eduVideo.getChapterId().equals(eduChapter.getId()))
                {
                    VideoVo videoVo = new VideoVo();
                    BeanUtils.copyProperties(eduVideo, videoVo);

                    videoVoList.add(videoVo);
                }
            }

            chapterVo.setChildren(videoVoList);

            finalList.add(chapterVo);
        }


        return finalList;
    }

    @Override
    public boolean deleteChapter(String id)
    {
        QueryWrapper<EduVideo> wrapper = new QueryWrapper<>();

        wrapper.eq("chapter_id", id);
        int count = eduVideoService.count(wrapper);
        if (count > 0)
        {
            throw new YixueException(20001, "存在小节，不能删除");
        }
        else
        {
            int result = baseMapper.deleteById(id);

            return result > 0;
        }
    }

    @Override
    public void removeChapterByCourseId(String id)
    {
        QueryWrapper<EduChapter> queryWrapper = new QueryWrapper<>();

        queryWrapper.eq("course_id", id);

        baseMapper.delete(queryWrapper);
    }
}
