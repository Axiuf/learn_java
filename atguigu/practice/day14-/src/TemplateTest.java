import java.awt.desktop.SystemEventListener;

public class TemplateTest
{
    public static void main(String[] args)
    {
        SubTemplate t = new SubTemplate();
        t.spendTime();
    }

}


abstract class Template
{

    // 计算代码花费的时间。
    public void spendTime()
    {
        long start = System.currentTimeMillis();

        code();

        long end = System.currentTimeMillis();

        System.out.println("花费的时间：" + (end - start));
    }

    public abstract void code();

}

class SubTemplate extends Template
{
    public void code()
    {
        for (int i = 2; i <= 1000; i++)
        {
            boolean flag = true;
            for (int j = 2; j <= Math.sqrt(i); j++)
            {
                if (i % j == 0)
                {
                    flag = false;
                    break;
                }
            }

            if (flag)
                System.out.println(i);
        }
    }
}