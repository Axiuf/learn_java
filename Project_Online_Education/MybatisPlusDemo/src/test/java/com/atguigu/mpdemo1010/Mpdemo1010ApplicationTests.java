package com.atguigu.mpdemo1010;

import com.atguigu.mpdemo1010.bean.User;
import com.atguigu.mpdemo1010.mapper.UserMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class Mpdemo1010ApplicationTests
{
    @Autowired
    private UserMapper userMapper;

    @Test
    public void contextLoads()
    {
    }

    @Test
    public void testSelectList()
    {
        List<User> userList = userMapper.selectList(null);
        userList.forEach(System.out::println);
    }

    @Test
    public void testInsert()
    {
        User user = new User();
        user.setName("OptimisticLocker");
        user.setEmail("OptimisticLocker@baomidou.com");
        user.setAge(100);

        int num = userMapper.insert(user);
        System.out.println("insertNum: " + num);
    }

    @Test
    public void testUpdate()
    {
        User user = new User();
        user.setId(3L);
        user.setAge(119);
        user.setName("Tomcat");

        int num = userMapper.updateById(user);
        System.out.println("updateNum: " + num);
    }

    @Test
    public void testOptimisticLock()
    {
        Long id = 1366039382641745921L;

        User user = userMapper.selectById(id);

        user.setName("OptimisticLock3");

        int num = userMapper.updateById(user);

        System.out.println(num);
    }

    @Test
    public void testSelectPage()
    {
        Page<User> page = new Page<>(1, 5);

        userMapper.selectPage(page, null);

        System.out.println(page.getCurrent());
        System.out.println(page.getRecords());
        System.out.println(page.getSize());
        System.out.println(page.getTotal());
        System.out.println(page.hasNext());
        System.out.println(page.hasPrevious());
    }

    @Test
    public void testSelectById()
    {
        System.out.println(userMapper.selectById(1L));

        System.out.println(userMapper.deleteById(1L));

        System.out.println(userMapper.selectById(1L));
    }

    @Test
    public void testQueryWrapper()
    {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();

        queryWrapper.gt("id", 100);

        System.out.println(userMapper.selectList(queryWrapper));
    }
}
