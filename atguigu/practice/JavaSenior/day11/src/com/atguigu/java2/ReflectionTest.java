package com.atguigu.java2;

import com.atguigu.java1.Person;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 调用运行时类中指定的结构：属性、方法、构造器
 *
 * @author Shan Cheng
 * @date 2020/12/26-23:26
 */
public class ReflectionTest
{
    @Test
    public void testField() throws NoSuchFieldException, IllegalAccessException, InstantiationException
    {
        Class<Person> aClass = Person.class;
        // 创建运行时类的对象
        Person p = (Person) aClass.newInstance();

        // 获取指定的属性：要求运行时类中属性声明为public，一般不用
        Field id = aClass.getField("id");

        /*
        设置当前属性的值
        set(): 参数一：指明设置哪那个对象的属性 参数2：将此属性值设置为多少
         */
        int pId = (int) id.get(p);
        System.out.println(pId);
    }

    @Test
    public void testField2() throws IllegalAccessException, InstantiationException, NoSuchFieldException
    {
        Class<Person> aClass = Person.class;

        Person person = aClass.newInstance();

        // 1. 获取运行时类中指定变量名的属性
        Field name = aClass.getDeclaredField("name");

        // 2. 保证当前属性是可访问的
        name.setAccessible(true);

        // 3. 获取、设置指定对象的此属性值
        name.set(person, "Tom");

        System.out.println(name.get(person));
    }

    /*
    如何获取运行时类中指定的方法
     */
    @Test
    public void testMethod() throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException
    {
        Class<Person> aClass = Person.class;

        Person person = aClass.newInstance();

        // 参数一：指定的方法的名称
        // 参数二：指明的获取方法的形参列表
        Method show = aClass.getDeclaredMethod("show", String.class);

        show.setAccessible(true );

        /*

         */
        show.invoke(person, "CHN");
    }
}
