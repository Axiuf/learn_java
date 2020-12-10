public class AbstractTest
{
    public static void main(String[] args)
    {
        Person p1 = new Student("Cheng", 20);
        p1.eat();
    }
}

abstract class Person
{
    String name;
    int age;

    public Person(String name, int age)
    {
        this.name = name;
        this.age = age;
    }

    abstract public void eat();

}

class Student extends Person
{
    public Student(String name, int age)
    {
        super(name, age);
    }

    @Override
    public void eat()
    {
        System.out.println("人吃饭");
    }
}