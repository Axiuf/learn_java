package io.github.axiuf.eduservice.service.impl;

import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.github.axiuf.eduservice.entity.EduSubject;
import io.github.axiuf.eduservice.entity.excel.SubjectData;
import io.github.axiuf.eduservice.entity.subject.PrimarySubject;
import io.github.axiuf.eduservice.listener.SubjectExcelListener;
import io.github.axiuf.eduservice.mapper.EduSubjectMapper;
import io.github.axiuf.eduservice.service.EduSubjectService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * <p>
 * 课程科目 服务实现类
 * </p>
 *
 * @author autoGenerator
 * @since 2021-03-05
 */
@Service
public class EduSubjectServiceImpl extends ServiceImpl<EduSubjectMapper, EduSubject> implements EduSubjectService {

    @Override
    public void saveSubject(MultipartFile file, EduSubjectService eduSubjectService)
    {
        try
        {
            InputStream in = file.getInputStream();

            EasyExcel.read(in, SubjectData.class, new SubjectExcelListener(eduSubjectService)).sheet().doRead();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public List<PrimarySubject> getAllSubjects()
    {
        QueryWrapper<EduSubject> queryWrapper1 = new QueryWrapper<>();
        queryWrapper1.eq("parent_id", "0");

        List<EduSubject> primarySubjectList = baseMapper.selectList(queryWrapper1);

        QueryWrapper<EduSubject> queryWrapper2 = new QueryWrapper<>();
        queryWrapper2.ne("parent_id", "0");

        List<EduSubject> secondarySubjectList = baseMapper.selectList(queryWrapper2);

        return null;
    }
}
