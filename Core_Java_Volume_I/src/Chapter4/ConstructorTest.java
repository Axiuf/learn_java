package Chapter4;

import java.util.*;

/**
 * This program demonstrates object construction.
 * @version  1.01
 * @author written by Shan Cheng
 */

public class ConstructorTest
{
    public static void main(String[] args)
    {
        Employee4[] staff = new Employee4[3];

        staff[0] = new Employee4("Harry", 40000);
        staff[1] = new Employee4(60000);
        staff[2] = new Employee4();

        for (Employee4 e : staff)
            System.out.println("name = " + e.getName() + ", id = " + e.getId() + ", salary = "
                + e.getSalary());
    }
}

class Employee4
{
    private static int nextId;

    private final int id;
    private String name = "";
    private double salary;

    static
    {
        Random generator = new Random();

        nextId = generator.nextInt(10000);
    }

    {
        id = nextId;
        nextId++;
    }

    public Employee4(String n, double s)
    {
        name = n;
        salary = s;
    }

    public Employee4(double s)
    {
        this("Employee #" + nextId, s);
    }

    public Employee4()
    {
    }

    public String getName()
    {
        return name;
    }

    public double getSalary()
    {
        return salary;
    }

    public int getId()
    {
        return id;
    }
}
