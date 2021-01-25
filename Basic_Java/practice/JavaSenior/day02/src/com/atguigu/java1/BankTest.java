package com.atguigu.java1;

/**
 * @author axiuf
 * @create 2020/12/15-12:35
 */
public class BankTest
{
}

class Bank
{
    private Bank()
    {

    }

    private static Bank instance = null;

    private static Bank getInstance()
    {
        // 效率稍差
        synchronized (Bank.class)
        {
            if (instance == null)
                instance = new Bank();

            return instance;
        }
    }
}
