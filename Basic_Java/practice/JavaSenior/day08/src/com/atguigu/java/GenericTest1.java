package com.atguigu.java;

import org.junit.Test;

/**
 * 自定义泛型类
 *
 * @author Shan Cheng
 * @date 2020/12/22-11:25
 */
public class GenericTest1
{
   @Test
   public void test1()
   {
       // 如果定义了泛型类，但是实例化的时候没有指明泛型类，则认为此泛型类型为Object类型
       // 要求：如果定义了类是带泛型的，建议在实例化的时候要指明类的泛型
       Order order = new Order();
       order.setOrderT(123);
       order.setOrderT("ABC");

       // 建议：实例化的时候指明泛型的类型
       Order<String> order1 = new Order<String>("orderAA", 1001, "order: AA");
       order1.setOrderT("AA, Hello");
   }

   @Test
   public void test2()
   {
       SubOrder sub1 = new SubOrder();

       // 由于子类在继承带泛型的父类时，指明了泛型类型。则实例子类对象时，不需要指明泛类型
       sub1.setOrderT(222222222);

       SubOrder1<String> sub2 = new SubOrder1<>();
       sub2.setOrderT("3dfds");
   }
}
