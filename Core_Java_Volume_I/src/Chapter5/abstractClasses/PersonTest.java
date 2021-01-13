package Chapter5.abstractClasses;

/**
 * @author Shan Cheng
 * @date 2021/1/12-15:59
 */
public class PersonTest
{
    public static void main(String[] args)
    {
        Person[] people = new Person[2];

        people[0] = new Employee("Harry Hacker", 50000, 1989, 10, 1);
        people[1] = new Student("Maria Morris", "Computer Science");

        for (Person p : people)
            System.out.println(p.getName() + ", " + p.getDescription());
    }
}
