package Chapter5.objectAnalyzer;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * @author Shan Cheng
 * @date 2021/1/12-21:01
 */
public class ObjectAnalyzerTest
{
    public static void main(String[] args)
    {
        ArrayList<Integer> squares = new ArrayList<>();
        for (int i = 1; i <= 5; i++)
        {
            squares.add(i * i);
        }
        System.out.println(new ObjectAnalyzer().toString(squares));
    }
}
