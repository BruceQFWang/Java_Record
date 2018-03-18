package bb;

import java.awt.*;
import java.awt.event.*;

public class TestGUIDemo extends Frame implements ItemListener {
	Panel lpanel1, lpanel2;
	CheckboxGroup lcheckboxgroup;
	Checkbox plain, bold, italic;
	Button lbutton;
	TextArea ta;
	public TestGUIDemo(String title){
		super(title);
	}
	public void creat() {
		lpanel1 = new Panel();
		lpanel2 = new Panel();
		
		lpanel1.setLayout(new FlowLayout());
		lpanel2.setLayout(new FlowLayout());
		lcheckboxgroup = new CheckboxGroup();
		plain = new Checkbox("普通", lcheckboxgroup, true);
		plain.addItemListener(this);
		bold = new Checkbox("黑体", lcheckboxgroup, false);
		bold.addItemListener(this);
		italic = new Checkbox("斜体", lcheckboxgroup, false);
		italic.addItemListener(this);
		lbutton = new Button("西南交通大学");
		lpanel2.add(lbutton);
		lpanel1.add(plain);
		lpanel1.add(bold);
		lpanel1.add(italic);
		ta = new TextArea();
		setLayout(new BorderLayout());
		add("North", lpanel1);
		add("Center", ta);
		add("South", lpanel2);
		setSize(300, 400);
		setVisible(true);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {System.exit(0);}
		});
	}
	public void itemStateChanged(ItemEvent e) {
		if (e.getSource() == plain) {
			ta.setFont(new Font("SansSerf", Font.PLAIN, 14));
			lbutton.setFont(new Font("SansSerf", Font.PLAIN, 14));
		}
		else if (e.getSource() == bold) {
			ta.setFont(new Font("SansSerf", Font.BOLD, 14));
			lbutton.setFont(new Font("SansSerf", Font.BOLD, 14));
		}
		else if (e.getSource() == italic) {
			ta.setFont(new Font("SansSerf", Font.ITALIC, 14));
			lbutton.setFont(new Font("SansSerf", Font.ITALIC, 14));
		}
	}
	public static void main(String []args) {
		TestGUIDemo fr = new TestGUIDemo("GUI测试实例");
		fr.creat();
	}
}



