package com.atguigu.bean;

/**
 * @author Shan Cheng
 * @date 2021/1/7-15:12
 */
public class Order
{
    private int orderId;
    private int orderName;
    private int orderDate;

    public Order()
    {
    }

    public Order(int orderId, int orderName, int orderDate)
    {
        this.orderId = orderId;
        this.orderName = orderName;
        this.orderDate = orderDate;
    }

    public int getOrderId()
    {
        return orderId;
    }

    public void setOrderId(int orderId)
    {
        this.orderId = orderId;
    }

    public int getOrderName()
    {
        return orderName;
    }

    public void setOrderName(int orderName)
    {
        this.orderName = orderName;
    }

    public int getOrderDate()
    {
        return orderDate;
    }

    public void setOrderDate(int orderDate)
    {
        this.orderDate = orderDate;
    }

    @Override
    public String toString()
    {
        return "Order{" +
                "orderId=" + orderId +
                ", orderName=" + orderName +
                ", orderDate=" + orderDate +
                '}';
    }
}
