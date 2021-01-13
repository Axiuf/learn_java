package Chapter5.abstractClasses;

/**
 * @author Shan Cheng
 * @date 2021/1/12-15:57
 */
public class Student extends Person
{
    private String major;

    public Student(String name, String major)
    {
        super(name);
        this.major = major;
    }

    @Override
    public String getDescription()
    {
        return "a student majoring in " + major;
    }
}
