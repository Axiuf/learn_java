public class StudentTest
{
    public static void main(String[] args)
    {
        try
        {
            Student s = new Student();
            s.register(-1000);
            System.out.println(s);
        } catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

    }
}


class Student
{
    private int id;


    public void register(int id) throws MyException
    {
        if (id > 0)
        {
            this.id = id;
        }
        else
        {
            throw new MyException("您输入的数据非法！");
        }

    }
}
