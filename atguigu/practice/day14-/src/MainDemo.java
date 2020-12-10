public class MainDemo
{
    public static void main(String[] args)
    {
        for (String arg : args)
        {
            System.out.println("*****" + arg);

            int num = Integer.parseInt(arg, 10);
            System.out.println("#####" + num);
        }
    }
}