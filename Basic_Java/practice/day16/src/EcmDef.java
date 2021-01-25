public class EcmDef
{
    public static void main(String[] args)
    {
        try
        {
            int i = Integer.parseInt(args[0]);
            int j = Integer.parseInt(args[1]);
            int res = ecm(i, j);

            System.out.println(res);
        }
        catch (NumberFormatException e)
        {
            System.out.println("数据类型不一致");
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            System.out.println("缺少命令行参数");
        }
        catch (ArithmeticException e)
        {
            System.out.println("除0");
        }
        catch (EcDef e)
        {
            System.out.println(e.getMessage());
        }

    }



    public static int ecm(int i, int j) throws EcDef
    {
        if  (i < 0 || j < 0)
            throw new EcDef("分子或者分母为负数了");
        else
            return i / j;
    }
}
