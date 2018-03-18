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
		super("带有工具栏按钮的窗口");
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
	setContentPane(panel);  //JFrame不能直接添加组件，需要设置内容窗格(内容面板)
	panel.setLayout(new BorderLayout());
	panel.setPreferredSize(new Dimension(300,150));
	panel.add(toolBar,BorderLayout.NORTH);
	panel.add(scrollPane,BorderLayout.CENTER);
	pack();      //调整窗口大小，以适合其子组件的首选大小和布局
 	setVisible(true);
  }
	public void actionPerformed(ActionEvent e) {
		String s="";
		if (e.getSource()==button1)
			s="左按钮被单击\n";
		else if (e.getSource()==button2)
				s="中按钮被单击\n";
		else if (e.getSource()==button3)
				s="右按钮被单击\n";
		textArea.append(s);
	}
}

