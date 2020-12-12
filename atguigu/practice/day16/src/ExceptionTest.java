import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

public class ExceptionTest
{
    // NullPointerException
    @Test
    public void test1()
    {
//        int[] arr = null;
//        System.out.println(arr[3]);

        String str = "ABC";
        str = null;
        System.out.println(str.charAt(0));
    }

    // IndexOutOfBoundsException
    @Test
    public void Test2()
    {
//        // ArrayIndexOutOfBoundsException
//        int[] arr = new int[4];
//        System.out.println(arr[4]);

        // StringIndexOutOfBoundsException
        String str = "ABC";
        System.out.println(str.charAt(8));
    }

    // ClassCastException
    @Test
    public void Test3()
    {
        Object obj = LocalDate.now();
        String str = (String) obj;
    }

    // NumberFormationException
    @Test
    public void Test4()
    {
        String str = "ABC";
        int num = Integer.parseInt(str);
    }

    // InputMismatchException
    @Test
    public void Test5()
    {
        Scanner in = new Scanner(System.in);
        int score = in.nextInt();

        System.out.println(score);
    }

    // ArithmeticException
    @Test
    public void Test6()
    {
        int a = 5;
        int b = 0;
        System.out.println(a / b);
    }


    // 编译时异常
    @Test
    public void Test7()
    {
        FileInputStream fis = null;
        try
        {
            File file = new File("Hello.txt");
            fis = new FileInputStream(file);

            int data = fis.read();
            while (data != -1)
            {
                System.out.print((char) data);
                data = fis.read();
            }


        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            System.out.println("好饿啊在等外卖");
            try
            {
                if (fis != null)
                fis.close();
            } catch (IOException e)
            {
                e.printStackTrace();
            }
        }

    }
}