package bb;

import java.awt.*;
import javax.swing.*;
public class Demo1
{
  public static void main(String args[])
  {
	  JFrame form = new JFrame("Table����");
	  final Object[]row = {"����","ѧ��","���ĳɼ�","��ѧ�ɼ�","�ܷ�"};
	  Object[][] rowData = { {"����","01","81","80","160"},{"����","02","93","72","165"},
			                 {"������","03","99","97","196"}
			           };
	  JTable tb= new JTable(rowData,row);
	  JScrollPane pane = new JScrollPane(tb);
	  form.getContentPane().add(pane);
	  form.setVisible(true);
	  form.pack();
  }
}