package com.atguigu.java;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * 其他常用类的测试
 * System
 * Math
 * BigInteger
 *
 * @author axiuf
 * @create 2020/12/18-15:55
 */
public class otherClassTest
{

    @Test
    public void test()
    {
        BigInteger bi = new BigInteger("09123874902843921487281417236982173987821937");
        BigDecimal bd = new BigDecimal("2132312312.231231");
        BigDecimal bd2 = new BigDecimal("2133143125442131212.231231");
        System.out.println(bi);

        System.out.println(bd.divide(bd2, BigDecimal.ROUND_HALF_UP));
        System.out.println(bd.divide(bd2, 20000000, BigDecimal.ROUND_HALF_UP));
    }
}
