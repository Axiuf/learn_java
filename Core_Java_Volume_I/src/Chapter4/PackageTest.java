package Chapter4;

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
        Employee5 harry = new Employee5("Harry Hacker", 50000, 1989, 10 , 1);

        harry.raiseSalary(5);

        out.println("name = " + harry.getName() + ", salary = " + harry.getSalary());
    }
}
