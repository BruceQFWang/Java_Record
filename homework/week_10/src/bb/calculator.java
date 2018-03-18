package bb;

import java.awt.*;
import java.awt.event.*;

public class calculator extends WindowAdapter implements ActionListener
{
	Frame fr = new Frame("计算器");
	Button add, sub, mul, div;
	TextField tex1, tex2, tex3;
	public calculator() {
		Panel panel1 = new Panel();
		Panel panel2 = new Panel();
		panel1.setLayout(new GridLayout(3, 1));
		panel2.setLayout(new GridLayout(2, 2));
		Panel panel11 = new Panel();
		Panel panel12 = new Panel();
		Panel panel13 = new Panel();
		panel11.setLayout(new FlowLayout());
		panel12.setLayout(new FlowLayout());
		panel13.setLayout(new FlowLayout());
		tex1 = new TextField(20);  tex2 = new TextField(20);  
		tex3 = new TextField(20);
		panel11.add(new Label("操作数")); panel11.add(tex1);
		panel12.add(new Label("操作数")); panel12.add(tex2);
		panel13.add(new Label("结果  "));  panel13.add(tex3);
		panel1.add(panel11); panel1.add(panel12); panel1.add(panel13);
		add = new Button("+"); sub = new Button("-");
		mul = new Button("*"); div = new Button("/");
		add.addActionListener(this);
		sub.addActionListener(this);
		mul.addActionListener(this);
		div.addActionListener(this);
		panel2.add(add); panel2.add(sub);
		panel2.add(mul); panel2.add(div);
		fr.addWindowListener(this);
		fr.setLayout(new GridLayout(2, 1));
		fr.add(panel1); fr.add(panel2);
		fr.setSize(500, 300);
		fr.setVisible(true); 
	}
	public static void main(String []args) {
		calculator t = new calculator();
	}
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}
	public void actionPerformed(ActionEvent e) {
		try {
			int a = Integer.parseInt(tex1.getText());
			int b = Integer.parseInt(tex2.getText());
			if (e.getSource() == add) {
				int ans = a + b;
				tex3.setText(String.valueOf(ans));
			} else if (e.getSource() == sub) {
				int ans = a - b;
				tex3.setText(String.valueOf(ans));
			} else if (e.getSource() == mul) {
				int ans = a * b;
				tex3.setText(String.valueOf(ans));
			} else if (e.getSource() == div) {
				int ans = a / b;
				tex3.setText(String.valueOf(ans));
			}
		} catch(ArithmeticException e1) {
			tex3.setText("除0错误");
		} 
	}
}

