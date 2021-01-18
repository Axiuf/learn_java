package timer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

/**
 * @author Shan Cheng
 * @date 2021/1/14-9:28
 */
public class TimerTest
{
    public static void main(String[] args)
    {
        TimePrinter listener = new TimePrinter();

        Timer t = new Timer(10000, listener);
        t.start();
        JOptionPane.showMessageDialog(null, "Quit program?");
        System.exit(0);
    }
}

class TimePrinter implements ActionListener
{
    @Override
    public void actionPerformed(ActionEvent e)
    {
        System.out.println("At the tone, the time is " + new Date());
        Toolkit.getDefaultToolkit().beep();
    }
}