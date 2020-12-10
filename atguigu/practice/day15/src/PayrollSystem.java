public class PayrollSystem
{
    public static void main(String[] args)
    {
        Employee[] staff = new Employee[2];

        staff[0] = new SalariedEmployee("Cheng", 21718553, new MyDate(1995, 12, 5), 20000);
        staff[1] = new HourlyEmployee("Alex", 28123123, new MyDate(1993, 3, 23), 200, 100);

        for (Employee e : staff)
        {
            System.out.println(e.toString());
            System.out.println("Your salary is " + e.earnings());
        }
    }

}
