import java.time.LocalDate;

public class HourlyEmployee extends Employee
{
    private double wage;
    private int hour;

    public String toString()
    {
        return this.getClass() + ": " + super.toString();
    }

    public double earnings()
    {
        if (this.getBirthday().getMonth() == LocalDate.now().getMonthValue())
        {
            System.out.println("Happy birthday!, you salary is raised by 1000!");
            return wage * hour + 1000;
        }
        return wage * hour;
    }

    public HourlyEmployee(String name, int number, MyDate birthday, double wage, int hour)
    {
        super(name, number, birthday);
        this.wage = wage;
        this.hour = hour;
    }
}
