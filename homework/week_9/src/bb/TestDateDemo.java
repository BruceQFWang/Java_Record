package bb;

import java.util.*;
import javax.swing.JOptionPane;
public class TestDateDemo
{
        public static void main(String[] agrs){
        String str = JOptionPane.showInputDialog("�����һ����ݣ�");
        int firstYear = Integer.parseInt(str);
        str = JOptionPane.showInputDialog("�����·ݣ�");
        int firstMonth = Integer.parseInt(str);
        str = JOptionPane.showInputDialog("���ڣ�");
        int firstDay = Integer.parseInt(str);

        str = JOptionPane.showInputDialog("����ڶ�����ݣ�");
        int secondYear = Integer.parseInt(str);
        str = JOptionPane.showInputDialog("�����·ݣ�");
        int secondMonth = Integer.parseInt(str);
        str = JOptionPane.showInputDialog("���ڣ�");
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
            System.out.println("����������ͬ");
        }else if(date2.after(date1)){
            System.out.println("�ڶ������ڴ�");
        }else if(date2.before(date1)){
            System.out.println("��һ�����ڴ�");
        }
        long days=(timeOne-timeTwo)/(1000*60*60*24);
        System.out.println(firstYear+"��"+firstMonth+"��"+firstDay+"��");
        System.out.println(secondYear+"��"+secondMonth+"��"+secondDay+"��");
        System.out.println("������� "+days);
    }
}

