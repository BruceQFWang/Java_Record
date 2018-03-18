package bb;

import java.io.*;
import java.awt.*;
import java.awt.event.*;
public class TestGUIDemo01 extends Frame implements ItemListener
{

	Panel lpanel1,lpanel2;
	CheckboxGroup lcheckboxgroup;
	Checkbox plain,bold,italic;
	Button lbutton;
	public TestGUIDemo01(String title)
	{
		super(title);
	}
	public void creat()
	{
		
		
		lpanel1=new Panel();
		lpanel2=new Panel();
		
		lpanel1.setLayout(new FlowLayout());
		lpanel2.setLayout(new FlowLayout());
		lcheckboxgroup=new CheckboxGroup();
		plain=new Checkbox("��ͨ",lcheckboxgroup,true);
		plain.addItemListener(this);
		bold=new Checkbox("����",lcheckboxgroup,false);
		bold.addItemListener(this);
		italic=new Checkbox("б��",lcheckboxgroup,false);
		italic.addItemListener(this);
		lbutton=new Button("���Ͻ�ͨ��ѧ");
		lpanel2.add(lbutton);
		lpanel1.add(plain);
		lpanel1.add(bold);
		lpanel1.add(italic);
		setLayout(new GridLayout(2,1));
		add(lpanel1);
		add(lpanel2);
		setSize(300,400);
		setVisible(true);
		addWindowListener(new WindowAdapter()       //�����ڲ�������¼�����
		{
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
		});
		
	}
	public void itemStateChanged(ItemEvent e)
	{
		if(e.getSource()==plain)
		{
			lbutton.setFont(new Font("SansSerf",Font.PLAIN,14));
		}
		else if(e.getSource()==bold)
		{
			lbutton.setFont(new Font("SansSerf",Font.BOLD,14));
		}else
			lbutton.setFont(new Font("SansSerf",Font.ITALIC,14));
	}

	public static void main(String[] args) 
	{
		TestGUIDemo01 fr=new TestGUIDemo01("GUI����ʵ��");
		fr.creat();

	}

}
