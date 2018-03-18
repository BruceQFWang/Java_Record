package bb;

import java.awt.*;
import javax.swing.*;
public class Demo1
{
  public static void main(String args[])
  {
	  JFrame form = new JFrame("Table试验");
	  final Object[]row = {"姓名","学号","语文成绩","数学成绩","总分"};
	  Object[][] rowData = { {"张三","01","81","80","160"},{"李四","02","93","72","165"},
			                 {"王麻子","03","99","97","196"}
			           };
	  JTable tb= new JTable(rowData,row);
	  JScrollPane pane = new JScrollPane(tb);
	  form.getContentPane().add(pane);
	  form.setVisible(true);
	  form.pack();
  }
}