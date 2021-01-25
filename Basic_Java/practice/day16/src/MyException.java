public class MyException extends RuntimeException
{
    @java.io.Serial
    static final long serialVersionUID = -7034897190745769869L;

    public MyException()
    {
    }

    public MyException(String msg)
    {
        super(msg);
    }
}
