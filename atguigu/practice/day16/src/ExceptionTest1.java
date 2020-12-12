import org.junit.Test;

public class ExceptionTest1
{
    @Test
    public void test1()
    {
        String str = "123";
        str = "abc";
        try
        {
            int num = Integer.parseInt(str);
        } catch (NullPointerException e)
        {
            System.out.println("数值转换异常，不用着急。");
            e.printStackTrace();
        } catch (NumberFormatException e)
        {

        }
    }
}
