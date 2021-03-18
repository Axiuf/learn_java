package io.github.axiuf.eduservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.github.axiuf.eduservice.client.VodClient;
import io.github.axiuf.eduservice.entity.EduVideo;
import io.github.axiuf.eduservice.mapper.EduVideoMapper;
import io.github.axiuf.eduservice.service.EduVideoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 课程视频 服务实现类
 * </p>
 *
 * @author autoGenerator
 * @since 2021-03-07
 */
@Service
public class EduVideoServiceImpl extends ServiceImpl<EduVideoMapper, EduVideo> implements EduVideoService {

    private VodClient vodClient;

    @Autowired
    public void setVodClient(VodClient vodClient)
    {
        this.vodClient = vodClient;
    }

    @Override
    public void removeVideoByCourseId(String id)
    {
        QueryWrapper<EduVideo> wrapper = new QueryWrapper<>();
        wrapper.eq("course_id", id);
        wrapper.select("video_source_id");
        List<EduVideo> eduVideos = baseMapper.selectList(wrapper);

        ArrayList<String> ids = new ArrayList<>();
        for (EduVideo video : eduVideos)
        {

            ids.add(video.getVideoSourceId());
        }

        if (ids.size() > 0)
        {
            vodClient.deleteBatch(ids);
        }

        QueryWrapper<EduVideo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("course_id", id);

        baseMapper.delete(queryWrapper);
    }
}
