public class MainTest
{
    public static void main(String[] args)
    {
        Main.main(new String[100]);
    }
}

class Main
{
    public static void main(String[] args)
    {
        if (args == null)
            args = new String[100];
        for (int i = 0; i < args.length; i++)
        {
            args[i] = "args_" + i;
            System.out.println(args[i]);
        }
    }
}