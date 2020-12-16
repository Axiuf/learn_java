package com.atguigu.exer;

/**
 * 两个储户分别向同一个账户存3000元，每次存1000，存3次，每次存完打印账户余额
 *
 * 分析：
 * 1. 是否是多线程的问题？ 是，两个储户线程
 * 2. 是否有共享的数据？ 是，账户（或者账户余额）
 * 3. 是否有线程安全的问题？ 有
 * 4. 需要考虑如何解决线程安全的问题，三种方法都可以
 *
 * @author axiuf
 * @create 2020/12/15-17:11
 */
class Account
{
    private static double balance;

    public Account(double balance)
    {
        this.balance = balance;
    }

    public synchronized void deposit(double amt)
    {
        if (amt > 0)
        {
            balance += amt;

            try
            {
                Thread.sleep(100);
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + "：存钱成功，余额为：" + balance);
        }
    }

}

class Customer extends Thread
{
    private Account acct;

    public Customer(Account acct)
    {
        this.acct = acct;
    }

    @Override
    public void run()
    {
        for (int i = 0; i < 3; i++)
        {

            acct.deposit(1000);
        }
    }
}


public class AccountTest
{
    public static void main(String[] args)
    {
        Account account = new Account(0);

        Customer c1 = new Customer(account);
        Customer c2 = new Customer(account);

        c1.setName("甲");
        c2.setName("乙");

        c1.start();
        c2.start();
    }
}
