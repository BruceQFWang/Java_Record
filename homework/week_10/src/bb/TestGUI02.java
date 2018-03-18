package bb;

import java.awt.*;
import java.awt.event.*;
public class TestGUI02 extends Frame implements ActionListener 
{
  Button btn1, btn2;
  TextField f,tf1,tf2;
  TextArea Area;
  TestGUI02() 
  {
     super("添加组件的窗口");
     addWindowListener(new WindowAdapter() 
     {
         public void windowClosing(WindowEvent e) 
         {
           System.exit(0);
         }
     });
	setSize(350,250); //设置窗口大小
	setLocation(200,200);//设置窗口显示位置
	setFont(new Font("Arial",Font.PLAIN,12)); //设置字体
	setLayout(new FlowLayout());
	Area=new TextArea (6,40);
	tf1=new TextField(10); tf2=new TextField(10);
	btn1=new Button("显示"); btn2=new Button("退出");
	f=new TextField(20);
	add(Area); add(new Label("用户名"));
	add(tf1); add(new Label("电话"));
	add(tf2); add(f); add(btn1); add(btn2);
	tf1.addActionListener(this); tf2.addActionListener(this);
	btn1.addActionListener(this); btn2.addActionListener(this);
	show();
  }
  public static void main(String args[])
  {
	new TestGUI02();
  }
  public void actionPerformed(ActionEvent e) 
  {
	if (e.getSource()==btn1)
		f.setText("你按下:"+ e.getActionCommand() + "按钮");
	if (e.getSource()==tf1)
		Area.append("用户名："+tf1.getText()+"\n");
    if (e.getSource()==tf2)
		Area.append("电 话："+tf2.getText()+"\n");
	if (e.getSource()==btn2) {
		System.exit(0);
   }           
  }
}

