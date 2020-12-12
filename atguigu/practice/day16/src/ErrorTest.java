public class ErrorTest
{
    public static void main(String[] args)
    {
        main(args); // 栈溢出
        Integer[] array = new Integer[1024 * 1024 * 1024]; // 堆溢出，内存耗尽
    }
}