package bb;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class TestGUI03 extends JFrame implements ActionListener {
	JButton button1,button2,button3;
	JToolBar toolBar;
	JTextArea textArea;
	JScrollPane scrollPane;
	JPanel panel;
	public static void main(String[] args) {
		new TestGUI03();
	}
	public TestGUI03() {
		super("���й�������ť�Ĵ���");
		addWindowListener(new WindowAdapter() {
		   public void windowClosing(WindowEvent e) {
             System.exit(0);
           } 
        });
	button1=new JButton(new ImageIcon("image/01.gif"));
	button2=new JButton(new ImageIcon("image/02.gif"));
	button3=new JButton(new ImageIcon("image/03.gif"));
	button1.addActionListener(this);
	button2.addActionListener(this);
	button3.addActionListener(this);
	toolBar=new JToolBar();
	toolBar.add(button1);
	toolBar.add(button2);
	toolBar.add(button3);
	textArea=new JTextArea(6,30);
	scrollPane=new JScrollPane(textArea);
	panel=new JPanel();
	setContentPane(panel);  //JFrame����ֱ������������Ҫ�������ݴ���(�������)
	panel.setLayout(new BorderLayout());
	panel.setPreferredSize(new Dimension(300,150));
	panel.add(toolBar,BorderLayout.NORTH);
	panel.add(scrollPane,BorderLayout.CENTER);
	pack();      //�������ڴ�С�����ʺ������������ѡ��С�Ͳ���
 	setVisible(true);
  }
	public void actionPerformed(ActionEvent e) {
		String s="";
		if (e.getSource()==button1)
			s="��ť������\n";
		else if (e.getSource()==button2)
				s="�а�ť������\n";
		else if (e.getSource()==button3)
				s="�Ұ�ť������\n";
		textArea.append(s);
	}
}

