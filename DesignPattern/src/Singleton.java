/**
 * @author Shan Cheng
 * @since 2021/4/11
 */

/**
 * 双重校验锁实现单例模式，即Double Check Lock (DCL)
 */
public class Singleton
{
    private static volatile Singleton uniqueSingleton;

    private Singleton()
    {

    }

    public static Singleton getUniqueSingleton()
    {
        if (uniqueSingleton == null)
        {
            synchronized (Singleton.class)
            {
                if (uniqueSingleton == null)
                {
                    uniqueSingleton = new Singleton();
                }
            }

        }

        return uniqueSingleton;
    }
}
