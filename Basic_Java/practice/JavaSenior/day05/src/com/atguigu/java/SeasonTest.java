package com.atguigu.java;

/**
 * 一、枚举类的使用
 * 1. 枚举类的理解：当类的对象的是有限个，确定时，则称之为枚举类
 * 2. 当需要定义一组常量时，强烈建议使用枚举类
 * 3. 如果枚举类中只有一个对象，则相当于单例模式
 *
 * 二、如何去定义枚举类
 * 1. JDK5.0之前，自定义枚举类
 * 2. JDK5.0，可以使用enum关键字自定义枚举类
 *
 * 三、Enum类中的常用方法
 *  values()
 *  valueOf(String objName)
 *  toString()
 *
 * 四、使用enum关键字定义的枚举类实现接口的情况
 * 1. 实现接口，在enum1类中实现抽象方法
 * 2.
 *
 *
 * @author axiuf
 * @create 2020/12/18-19:27
 */
public class SeasonTest
{
    public static void main(String[] args)
    {
        Season season = Season.SPRING;
        System.out.println(season.getSeasonDesc());
    }
}

// 自定义枚举类
class Season
{
    // 1. 声明Season对象的属性：private final修饰
    private final String seasonName;
    private final String seasonDesc;

    // 2. 私有化类的构造器，并给对象属性赋值
    private Season(String seasonName, String seasonDesc)
    {
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }

    // 3. 提供当前枚举类的多个对象，声明为public static final
    public static final Season SPRING = new Season("春天", "春暖花开");
    public static final Season SUMMER = new Season("夏天", "百花齐放");
    public static final Season AUTUMN = new Season("秋天", "秋高气爽");
    public static final Season WINTER = new Season("冬天", "腊雪寒梅");

    // 4. 其他的诉求：获取枚举类对象的属性

    public String getSeasonName()
    {
        return seasonName;
    }

    public String getSeasonDesc()
    {
        return seasonDesc;
    }

    // 5. toString方法

    @Override
    public String toString()
    {
        return "Season{" +
                "seasonName='" + seasonName + '\'' +
                ", seasonDesc='" + seasonDesc + '\'' +
                '}';
    }
}