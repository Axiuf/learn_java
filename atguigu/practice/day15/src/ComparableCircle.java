public class ComparableCircle extends Circle implements CompareObject
{
    public ComparableCircle(int radius)
    {
        super(radius);
    }

    @Override
    public int compareTo(Object o)
    {
        if (this == o)
            return 0;

        if (o instanceof ComparableCircle)
        {
            ComparableCircle other = (ComparableCircle) o;
            return this.getRadius() - other.getRadius();
        }
        else
            throw new RuntimeException("传入的对象数据类型不匹配");
    }
}