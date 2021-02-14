package com.atguigu.spring5;

/**
 * @author Shan Cheng
 * @date 2021/2/4-19:48
 */
public class UserDaoImpl implements UserDao
{
    @Override
    public int add(int a, int b)
    {
        System.out.println("add方法的结果是：" + a + b);
        return a + b;
    }

    @Override
    public String update(String id)
    {
        System.out.println("update方法更新了：" + id);
        return id;
    }
}
