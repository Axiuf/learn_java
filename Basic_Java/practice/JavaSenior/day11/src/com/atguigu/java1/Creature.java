package com.atguigu.java1;

import java.io.Serializable;

/**
 * @author Shan Cheng
 * @date 2020/12/26-18:56
 */
public class Creature<T> implements Serializable
{
    private char gender;
    public double weight;

    private void breath()
    {
        System.out.println("生物呼吸");
    }

    public void eat()
    {
        System.out.println("生物吃东西");
    }
}
