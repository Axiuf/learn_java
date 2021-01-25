public class InterfaceTest
{
    public static void main(String[] args)
    {
        ComparableCircle c1 = new ComparableCircle(19);
        ComparableCircle c2 = new ComparableCircle(18);

        System.out.println(c1.compareTo(c2));
        System.out.println(c2.compareTo(c1));
    }
}
