package Chapter4.PackageTest;

import Chapter4.PackageTest.com.horstmann.corejava.Employee;

import static java.lang.System.*;

/**
 * This program demonstrates the use of packages.
 * @version 1.11 2004-02-19
 * @author written by Shan Cheng
 */

public class PackageTest
{
    public static void main(String[] args)
    {
        Employee harry = new Employee("Harry Hacker", 50000, 1989, 10 , 1);

        harry.raiseSalary(5);

        out.println("name = " + harry.getName() + ", salary = " + harry.getSalary());
    }
}
