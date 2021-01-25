package com.atguigu.java;

/**
 * @author Shan Cheng
 * @date 2020/12/28-14:27
 */
public class MyInterfaceImpl implements MyInterface
{

    @Override
    public void methodAbstract()
    {

    }

    @Override
    public void methodDefault()
    {

    }

    public static void main(String[] args)
    {
        // 接口中的静态方法只能由接口自己调用
        MyInterface.methodStatic();
        MyInterfaceImpl myInterface = new MyInterfaceImpl();

        // 接口中的静态方法
    }
}
