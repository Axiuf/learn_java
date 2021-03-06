package io.github.axiuf.eduservice.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.github.axiuf.eduservice.entity.EduSubject;
import io.github.axiuf.eduservice.entity.excel.SubjectData;
import io.github.axiuf.eduservice.service.EduSubjectService;
import io.github.axiuf.servicebase.exceptionhandler.YixueException;

/**
 * @author Shan Cheng
 * @since 2021/3/5
 */


public class SubjectExcelListener extends AnalysisEventListener<SubjectData>
{
    public EduSubjectService subjectService;

    public SubjectExcelListener()
    {
    }

    public SubjectExcelListener(EduSubjectService subjectService)
    {
        this.subjectService = subjectService;
    }

    @Override
    public void invoke(SubjectData subjectData, AnalysisContext analysisContext)
    {
        if (subjectData == null)
        {
            throw new YixueException(20001, "文件数据为空");
        }


        EduSubject oneSubject = this.existOneSubject(subjectService, subjectData.getOneSubjectName());
        if (oneSubject == null)
        {
            oneSubject = new EduSubject();
            oneSubject.setParentId("0");
            oneSubject.setTitle(subjectData.getOneSubjectName());

            subjectService.save(oneSubject);
        }

        String id = oneSubject.getId();

        EduSubject twoSubject = this.existTwoSubject(subjectService, subjectData.getTwoSubjectName(), id);
        if (twoSubject == null)
        {
            twoSubject = new EduSubject();
            twoSubject.setParentId(id);
            twoSubject.setTitle(subjectData.getTwoSubjectName());

            subjectService.save(twoSubject);
        }

    }

    private EduSubject existOneSubject(EduSubjectService subjectService, String name)
    {
        QueryWrapper<EduSubject> queryWrapper = new QueryWrapper<>();

        queryWrapper.eq("title", name);
        queryWrapper.eq("parent_id", "0");
        EduSubject eduSubject = subjectService.getOne(queryWrapper);
        return eduSubject;
    }

    private EduSubject existTwoSubject(EduSubjectService subjectService, String name, String id)
    {
        QueryWrapper<EduSubject> queryWrapper = new QueryWrapper<>();

        queryWrapper.eq("title", name);
        queryWrapper.eq("parent_id", id);
        EduSubject eduSubject = subjectService.getOne(queryWrapper);
        return eduSubject;
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext)
    {

    }
}
