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
     super("�������Ĵ���");
     addWindowListener(new WindowAdapter() 
     {
         public void windowClosing(WindowEvent e) 
         {
           System.exit(0);
         }
     });
	setSize(350,250); //���ô��ڴ�С
	setLocation(200,200);//���ô�����ʾλ��
	setFont(new Font("Arial",Font.PLAIN,12)); //��������
	setLayout(new FlowLayout());
	Area=new TextArea (6,40);
	tf1=new TextField(10); tf2=new TextField(10);
	btn1=new Button("��ʾ"); btn2=new Button("�˳�");
	f=new TextField(20);
	add(Area); add(new Label("�û���"));
	add(tf1); add(new Label("�绰"));
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
		f.setText("�㰴��:"+ e.getActionCommand() + "��ť");
	if (e.getSource()==tf1)
		Area.append("�û�����"+tf1.getText()+"\n");
    if (e.getSource()==tf2)
		Area.append("�� ����"+tf2.getText()+"\n");
	if (e.getSource()==btn2) {
		System.exit(0);
   }           
  }
}

