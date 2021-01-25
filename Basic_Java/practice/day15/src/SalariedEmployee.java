import java.time.LocalDate;

public class SalariedEmployee extends Employee
{
    private double monthlySalary;

    public SalariedEmployee(String name, int number, MyDate birthday, double monthlySalary)
    {
        super(name, number, birthday);
        this.monthlySalary = monthlySalary;
    }

    public double earnings()
    {
        if (this.getBirthday().getMonth() == LocalDate.now().getMonthValue())
        {
            monthlySalary += 1000;
            System.out.println("Happy birthday!, you salary is raised by 1000!");
        }
        return monthlySalary;
    }

    public double getMonthlySalary()
    {
        return monthlySalary;
    }

    public void setMonthlySalary(double monthlySalary)
    {
        this.monthlySalary = monthlySalary;
    }

    public String toString()
    {
        return this.getClass() + ": " + super.toString();
    }
}