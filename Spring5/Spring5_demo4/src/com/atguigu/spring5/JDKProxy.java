package com.atguigu.spring5;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author Shan Cheng
 * @date 2021/2/4-19:51
 */
public class JDKProxy
{
    public static void main(String[] args)
    {
        Class[] interfaces = {UserDao.class};
//        Object proxyInstance = Proxy.newProxyInstance(JDKProxy.class.getClassLoader(), interfaces, new InvocationHandler()
//        {
//            @Override
//            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable
//            {
//                return null;
//            }
//        });

        UserDaoImpl userDao = new UserDaoImpl();

        UserDao obj = (UserDao) Proxy.newProxyInstance(JDKProxy.class.getClassLoader(), interfaces, new UserDaoProxy(userDao));

        obj.add(1, 5);

        obj.update("This method is update!");
    }
}

class UserDaoProxy implements InvocationHandler
{
    private Object object;

    public UserDaoProxy(Object object)
    {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable
    {
        System.out.println("代理类的前置代码");

        Object obj = method.invoke(object, args);

        System.out.println("代理类的后置代码");

        return obj;
    }
}
