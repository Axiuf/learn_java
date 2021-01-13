package Chapter5.abstractClasses;

/**
 * @author Shan Cheng
 * @date 2021/1/12-15:48
 */
public abstract class Person
{
    public abstract String getDescription();
    private String name;

    public Person(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }
}
