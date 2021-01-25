package com.atguigu.java;


/**
 * @author Shan Cheng
 * @date 2020/12/28-14:22
 */
public interface MyInterface
{
    void methodAbstract();

    static void methodStatic()
    {
        System.out.println("接口中的静态方法");
    }

    default void methodDefault()
    {
        System.out.println("接口中的默认方法");
    }

    private void methodPrivate()
    {
        System.out.println("接口中的私有方法");
    }
}
