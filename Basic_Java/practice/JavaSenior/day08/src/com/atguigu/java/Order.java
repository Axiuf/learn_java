package com.atguigu.java;

/**
 * 自定义泛型类
 *
 *
 * @author Shan Cheng
 * @date 2020/12/22-11:20
 */
public class Order<T>
{
    String orderName;
    int orderId;

    // 类的内部结构就可以使用类的泛型
    T orderT;

    public Order()
    {
    }

    public Order(String orderName, int orderId, T orderT)
    {
        this.orderName = orderName;
        this.orderId = orderId;
        this.orderT = orderT;
    }

    public T getOrderT()
    {
        return orderT;
    }

    public void setOrderT(T orderT)
    {
        this.orderT = orderT;
    }
}
