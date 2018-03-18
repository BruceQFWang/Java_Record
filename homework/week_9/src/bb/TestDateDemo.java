package bb;

import java.util.*;
import javax.swing.JOptionPane;
public class TestDateDemo
{
        public static void main(String[] agrs){
        String str = JOptionPane.showInputDialog("输入第一个年份：");
        int firstYear = Integer.parseInt(str);
        str = JOptionPane.showInputDialog("输入月份：");
        int firstMonth = Integer.parseInt(str);
        str = JOptionPane.showInputDialog("日期：");
        int firstDay = Integer.parseInt(str);

        str = JOptionPane.showInputDialog("输入第二个年份：");
        int secondYear = Integer.parseInt(str);
        str = JOptionPane.showInputDialog("输入月份：");
        int secondMonth = Integer.parseInt(str);
        str = JOptionPane.showInputDialog("日期：");
        int secondDay = Integer.parseInt(str);

        Calendar calendar = Calendar.getInstance();
        calendar.set(firstYear,firstMonth,firstDay);

        long timeOne = calendar.getTimeInMillis();    
        System.out.println(timeOne);
        calendar.set(secondYear,secondMonth,secondDay);
        long timeTwo = calendar.getTimeInMillis();
        Date date1=new Date(timeOne);
        Date date2=new Date(timeTwo);
        if(date2.equals(date1)){
            System.out.println("两个日期相同");
        }else if(date2.after(date1)){
            System.out.println("第二个日期大");
        }else if(date2.before(date1)){
            System.out.println("第一个日期大");
        }
        long days=(timeOne-timeTwo)/(1000*60*60*24);
        System.out.println(firstYear+"年"+firstMonth+"月"+firstDay+"日");
        System.out.println(secondYear+"年"+secondMonth+"月"+secondDay+"日");
        System.out.println("相隔天数 "+days);
    }
}

