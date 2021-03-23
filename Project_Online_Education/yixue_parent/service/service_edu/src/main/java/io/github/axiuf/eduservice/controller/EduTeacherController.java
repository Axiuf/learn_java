package io.github.axiuf.eduservice.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.github.axiuf.commonutils.R;
import io.github.axiuf.eduservice.entity.EduTeacher;
import io.github.axiuf.eduservice.entity.vo.EduTeacherQuery;
import io.github.axiuf.eduservice.service.EduTeacherService;
import io.github.axiuf.servicebase.exceptionhandler.YixueException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author autoGenerator
 * @since 2021-03-01
 */
@Api(description = "讲师管理")
@RestController

@RequestMapping("/eduservice/edu-teacher")
public class EduTeacherController {
    private final EduTeacherService eduTeacherService;

    @Autowired
    public EduTeacherController(EduTeacherService eduTeacherService)
    {
        this.eduTeacherService = eduTeacherService;
    }

    // 1. 查询所有数据
    // rest风格
    @ApiOperation(value = "查询所有讲师")
    @GetMapping("/findAll")
    public R findAllTeachers()
    {

        return R.ok().data("items", eduTeacherService.list(null));
    }

    // 2. 逻辑删除讲师的方法
    @ApiOperation(value = "根据ID逻辑删除讲师")
    @DeleteMapping("/remove/{id}")
    public R removeTeacher(@ApiParam(name = "id", value = "讲师ID", required = true) @PathVariable String id)
    {
        boolean flag = eduTeacherService.removeById(id);

        if (flag)
        {
            return R.ok().data("flag", eduTeacherService.removeById(id));
        }
        else
        {
            return  R.error().data("flag", eduTeacherService.removeById(id));
        }
    }

    // 3. 分页查询列表
    @ApiOperation(value = "分页讲师列表")
    @GetMapping("pageTeacher/{page}/{limit}")
    public R pageTeacher(
            @ApiParam(name = "page", value = "当前页码", required = true)
            @PathVariable Long page,

            @ApiParam(name = "limit", value = "每页记录数", required = true)
            @PathVariable Long limit){

        Page<EduTeacher> pageParam = new Page<>(page, limit);

        eduTeacherService.page(pageParam, null);
        List<EduTeacher> records = pageParam.getRecords();
        long total = pageParam.getTotal();

        return  R.ok().data("total", total).data("rows", records);
    }

    // 4. 带条件的分页查询
    @ApiOperation(value = "条件查询分页讲师列表")
    @PostMapping ("pageTeacherCondition/{page}/{limit}")
    public R pageTeacherCondition(
            @ApiParam(name = "page", value = "当前页码", required = true)
            @PathVariable Long page,

            @ApiParam(name = "limit", value = "每页记录数", required = true)
            @PathVariable Long limit,

            @ApiParam(name = "eduTeacherQuery", value = "条件查询信息")
            @RequestBody(required = false) EduTeacherQuery eduTeacherQuery){

        // 创建分页对象
        Page<EduTeacher> pageParam = new Page<>(page, limit);
        // 创建条件查询对象
        QueryWrapper<EduTeacher> queryWrapper = new QueryWrapper<>();

        String name = eduTeacherQuery.getName();
        Integer level = eduTeacherQuery.getLevel();
        String begin = eduTeacherQuery.getBegin();
        String end = eduTeacherQuery.getEnd();

        if (!StringUtils.isEmpty(name))
        {
            queryWrapper.like("name", name);
        }
        if (!StringUtils.isEmpty(level))
        {
            queryWrapper.eq("level", level);
        }
        if (!StringUtils.isEmpty(begin)) {
            queryWrapper.ge("gmt_create", begin);
        }

        if (!StringUtils.isEmpty(end)) {
            queryWrapper.le("gmt_create", end);
        }

        queryWrapper.orderByDesc("gmt_create");

        // 根据给定的条件查询数据并封装到Wrapper中
        eduTeacherService.page(pageParam, queryWrapper);

        long total = pageParam.getTotal();
        List<EduTeacher> records = pageParam.getRecords();

        return  R.ok().data("total", total).data("rows", records);
    }

    // 5. 添加讲师的接口
    @ApiOperation(value = "添加讲师")
    @PostMapping ("/add")
    public R addTeacher(@ApiParam(name = "eduTeacher", value = "要插入的讲师信息")
                        @RequestBody(required = false) EduTeacher eduTeacher)
    {
        boolean save = eduTeacherService.save(eduTeacher);

        if (save)
        {
            return R.ok();
        }
        else
        {
            return R.error();
        }
    }

    @ApiOperation(value = "根据ID查询讲师")
    @GetMapping("/getTeacher/{id}")
    public R getTeacher(@ApiParam(name = "id", value = "讲师ID", required = true) @PathVariable String id)
    {
        return R.ok().data("teacher", eduTeacherService.getById(id));
    }

    @ApiOperation(value = "修改讲师功能")
    @PostMapping("/updateTeacher")
    public R updateTeacher(@RequestBody(required = false) EduTeacher eduTeacher)
    {
        boolean flag = eduTeacherService.updateById(eduTeacher);

        if (flag)
        {
            return R.ok();
        }
        else
        {
            return R.error();
        }
    }
}