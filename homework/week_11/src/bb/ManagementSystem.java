package bb;

import java.awt.*;
import java.awt.event.*;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.JPasswordField;

public class ManagementSystem implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		String password = new String(JP.getPassword());
		if (e.getSource() == b1) {
			if (password.equals("")) {
				JOptionPane.showMessageDialog(fr, "请输入密码！", "提示消息", JOptionPane.WARNING_MESSAGE);
				return ;
			}
			if (jr1.isSelected()) {
				String[] director = {"Jeff Dean", "tensorflow", "caffe", "theano"};
				String[] director_password = {"888888", "888888", "654321", "654321"};
				boolean fg = false;
				for(int i=0; i<4; i++){
					if ( JT.getText().equals(director[i]) && password.equals(director_password[i]) ) {
						JOptionPane.showMessageDialog(fr, "登录成功！");
						fg = true;
					}
				}
				
				if(!fg)JOptionPane.showMessageDialog(fr, "用户名或密码错误！\n请重新输入", "提示消息", JOptionPane.ERROR_MESSAGE);
			
			}
			else {
				String[] staff = {"Alice", "Bob", "王秋锋", "Cyberdebut"};
				String[] staff_password = {"123456", "1234546", "666666", "666666"};
				boolean fg = false;
				for(int i=0; i<4; i++){
					if ( JT.getText().equals(staff[i]) && password.equals(staff_password[i]) ) {
						JOptionPane.showMessageDialog(fr, "登录成功！");
						fg = true;
					}
				}
				
				if(!fg)JOptionPane.showMessageDialog(fr, "用户名或密码错误！\n请重新输入", "提示消息", JOptionPane.ERROR_MESSAGE);
			}
		}
		else {
			JT.setText("");
			JP.setText("");
		}
	}
	
	JFrame fr = new JFrame("ManagementSystem display");
	JTextField JT;
	ButtonGroup bg;
	JPasswordField JP;
	JButton b1, b2;
	JRadioButton jr1, jr2;
	JPanel p1, p2, p3, p4;
	
	ManagementSystem() {
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fr.setLayout(new GridLayout(4, 1));
		
		p1 = new JPanel(); 
		p1.setLayout(new FlowLayout());
		p1.add(new Label("用户名"));
		JT = new JTextField(20);
		p1.add(JT);
		
		p2 = new JPanel(); p2.setLayout(new FlowLayout());
		p2.add(new Label(" 密码  "));
		JP = new JPasswordField(20);
		p2.add(JP);
		
		p3 = new JPanel(); p3.setLayout(new FlowLayout());
		p3.add(new Label("权限"));
		jr1 = new JRadioButton("主管", true);
		jr2 = new JRadioButton("员工");
		bg = new ButtonGroup();
		bg.add(jr1); bg.add(jr2);
		p3.add(jr1); p3.add(jr2);
		
		p4 = new JPanel(); p4.setLayout(new FlowLayout());
		b1 = new JButton("登录"); b2 = new JButton("重置");
		b1.addActionListener(this);
		b2.addActionListener(this);
		p4.add(b1); p4.add(b2);
		
		fr.add(p1); fr.add(p2);
		fr.add(p3); fr.add(p4);
		fr.pack();
		fr.setVisible(true);
	}
	public static void main(String []args) {
		new ManagementSystem();
	}
	
}



