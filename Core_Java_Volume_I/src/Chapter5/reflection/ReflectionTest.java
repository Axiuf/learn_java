package Chapter5.reflection;

import java.io.File;
import java.lang.module.ModuleFinder;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Scanner;


/**
 * @author Shan Cheng
 * @date 2021/1/12-16:06
 */
public class ReflectionTest
{
    public static void main(String[] args)
    {
        String name;
        if (args.length > 0)
            name = args[0];
        else
        {
            Scanner in = new Scanner(System.in);
            System.out.print("Enter class name (e.g. java.util.Date): ");
            name = in.next();
        }

        try
        {
            Class cl = Class.forName(name);
            Class superCl = cl.getSuperclass();

            String modifiers = Modifier.toString(cl.getModifiers());
            if (modifiers.length() > 0)
                System.out.print(modifiers + " ");
            System.out.print("class " + name);
            if (superCl != null && superCl != Object.class)
                System.out.print(" extends " + superCl.getName());

            System.out.print("\n{\n");
            printConstructors(cl);
            System.out.println();
            printMethods(cl);
            System.out.println();
            printFields(cl);
            System.out.println("}");

        } catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        System.exit(0);
    }

    public static void printConstructors(Class cl)
    {
        Constructor[] constructors = cl.getDeclaredConstructors();

        for (Constructor c : constructors)
        {
            String name = c.getName();
            System.out.print("    ");
            String modifiers = Modifier.toString(c.getModifiers());
            if (modifiers.length() > 0)
                System.out.print(modifiers + " ");
            System.out.print(name + "(");

            Class[] paramTypes = c.getParameterTypes();
            for (int j = 0; j < paramTypes.length; j++)
            {
                if (j > 0)
                    System.out.print(", ");
                System.out.print(paramTypes[j].getName());
            }
            System.out.println(");");
        }
    }

    public static void printMethods(Class cl)
    {
        Method[] methods = cl.getDeclaredMethods();

        for (Method m : methods)
        {
            Class returnType = m.getReturnType();
            String name = m.getName();

            System.out.print("    ");

            String modifiers = Modifier.toString(m.getModifiers());
            if (modifiers.length() > 0)
                System.out.print(modifiers + " ");
            System.out.print(returnType.getName() + " " + name + "(");

            Class[] parameterTypes = m.getParameterTypes();
            for (int j = 0; j < parameterTypes.length; j++)
            {
                if (j > 0)
                    System.out.print(", ");
                System.out.print(parameterTypes[j].getName());
            }
            System.out.println(");");
        }
    }

    public static void printFields(Class cl)
    {
        Field[] fields = cl.getDeclaredFields();
        for (Field f : fields)
        {
            Class<?> type = f.getType();
            String name = f.getName();
            System.out.print("    ");
            String modifiers = Modifier.toString(f.getModifiers());
            if (modifiers.length() > 0)
                System.out.print(modifiers + " ");
            System.out.println(type.getName() + " " + name + ";");
        }
    }
}
