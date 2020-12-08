package Chapter5;

import Chapter5.equals.Employee;

import java.util.*;

/**
 * This program demonstrates ArrayList Class.
 * @version 1.11
 * @author written by Shan Cheng
 */

public class ArrayTest
{
    public static void main(String[] args)
    {
        ArrayList<Employee> staff = new ArrayList<>();

        staff.add(new Employee("Carl Cracker", 75000, 1987, 12, 15));
        staff.add(new Employee("Harry Hacker", 50000, 1989, 10, 1));
        staff.add(new Employee("Tom Tester", 40000, 1990, 3, 15));

        for (Employee e : staff)
            e.raiseSalary(5);

        for (Employee e : staff)
            System.out.println("name = " + e.getName() + ", salary = " + e.getSalary() + ", hireDay = " + e.getHireDay());
    }
}
