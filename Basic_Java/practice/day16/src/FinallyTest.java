import org.junit.Test;

import java.io.File;

public class FinallyTest
{
    @Test
    public void test1()
    {
        try
        {
            int a = 10;
            int b = 0;
            System.out.println(a / b);
        }
        catch (ArithmeticException e)
        {
            e.printStackTrace();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            System.out.println("我好饿啊在等外卖");
        }
    }

    @Test
    public void Test2()
    {
        try
        {
            int[] arr = new int[10];
            System.out.println(arr[9]);
            System.out.println(1);
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            e.printStackTrace();
            System.out.println(2);
        }
        finally
        {
            System.out.println("我一定会被执行");
            System.out.println(3);
        }
    }

    @Test
    public void Test3()
    {

    }
}
