package Chapter3;

import java.util.*;

/**
 * This program demonstrates console input.
 * @version 1.10 2004-02-10
 * @author written by Shan Cheng
 */

public class InputTest
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        System.out.print("What is your name? ");
        String name = in.nextLine();

        System.out.print("How old are you? ");
        int age = in.nextInt();

        System.out.println("Hello, " + name + ". Next year, you'll be " + (age + 1));

    }
}
