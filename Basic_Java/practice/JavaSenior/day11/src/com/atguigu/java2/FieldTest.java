package com.atguigu.java2;

import com.atguigu.java1.Person;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * 获取当前运行时类的属性结构
 *
 * @author Shan Cheng
 * @date 2020/12/26-19:11
 */
public class FieldTest
{
    @Test
    public void test1()
    {
        Class<Person> aClass = Person.class;

        // getFields(): 获取当前运行时类及其父类中声明为public访问权限的属性
        Field[] fields = aClass.getFields();
        for (Field f : fields)
        {
            System.out.println(f);
        }
        System.out.println();


        // getDeclaredFields(): 获取当前运行时类中声明的所有属性。（不包括父类中声明的属性）
        Field[] declaredField = aClass.getDeclaredFields();
        for (Field f : declaredField)
        {
            System.out.println(f);
        }
    }


    // 权限修饰符 数据类型 变量名
    @Test
    public void test()
    {
        Class<Person> aClass = Person.class;
        Field[] declaredFields = aClass.getDeclaredFields();
        for (Field f : declaredFields)
        {
            int modifiers = f.getModifiers();
            System.out.print(Modifier.toString(modifiers) + "\t");

            Class<?> type = f.getType();
            System.out.print(type.getName() + "\t");

            String name = f.getName();
            System.out.print(name);

            System.out.println();
        }
    }
}
