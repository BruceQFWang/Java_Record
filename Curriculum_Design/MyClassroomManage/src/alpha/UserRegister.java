package alpha;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JPasswordField;


public class UserRegister extends JFrame implements ActionListener {
	 private int width = 600;
	 private int height = 500;
	 private JLabel titlelb;
	 
	 //用户名标签 
	 private JLabel nameLb;
	 //密码标签 
	 private JLabel passwordLb;
	 //邮箱标签 
	 private JLabel emailLb;
	 //联系电话标签 
	 private JLabel phoneLb;
	 //用户名文本框 
	 private JTextField nameTf;
	 //密码文本框 
	 private JPasswordField passwordTf;
	 
	 //联系电话文本框 
	 private JTextField phoneTf;
	 // 邮箱文本框 
	 private JTextField emailTf;

	 //确定按钮
	 private JButton okBtn;
	 //重置
	 private JButton resetBtn;

	 //构造方法 
	 public UserRegister() {
		 initComponents();
		 layoutComponents();
		 addListeners();
	     
	     this.setVisible(true); 
		 setSize(516, 483);// 设置大小
		 //setModal(true);//设置为模态窗口
		 setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		 setLocationRelativeTo(null);// 居屏幕中间显示
	 }
	 
	 //初始化组件
	 private void initComponents() {
		  titlelb= new JLabel("注   册");
		  nameLb = new JLabel("用户名");
		  nameLb.setFont(new Font("宋体", Font.PLAIN, 15));
		  passwordLb = new JLabel("\u5BC6  \u7801");
		  passwordLb.setFont(new Font("宋体", Font.PLAIN, 15));
		  phoneLb = new JLabel("联系电话"); 
		  phoneLb.setFont(new Font("宋体", Font.PLAIN, 15));
		  emailLb = new JLabel("\u90AE  \u7BB1");
		  emailLb.setFont(new Font("宋体", Font.PLAIN, 15));
		  
		  nameTf=new JTextField();
		  passwordTf=new JPasswordField();
		  phoneTf=new JTextField();
		  emailTf=new JTextField();
		  
		  okBtn = new JButton("确定");
		  okBtn.setFont(new Font("宋体", Font.PLAIN, 15));
		  resetBtn = new JButton("重置");
		  resetBtn.setFont(new Font("宋体", Font.PLAIN, 15));
	 }

	 //布局组件
	 private void layoutComponents() {
		 getContentPane().setLayout(null);// 去除默认的边界布局
	  
		 titlelb.setBounds(182, 20, 80, 30);
		 titlelb.setFont(new Font("", Font.BOLD, 26));
	  
		 nameLb.setBounds(100, 85, 80, 30);
		 nameTf.setBounds(200, 86, 250, 30);
		  
		 passwordLb.setBounds(100, 155, 80, 30);
		 passwordTf.setBounds(200, 156, 250, 30);
		  
		  
		 emailLb.setBounds(100,225,80,30);
		 emailTf.setBounds(200, 226, 250, 30);
		  
		 phoneLb.setBounds(100,295,80,30);
		 phoneTf.setBounds(200, 296, 250, 30);
		  
		 okBtn.setBounds(151, 386, 80, 30);
		 resetBtn.setBounds(289, 386, 80, 30);
		  
		 getContentPane().add(titlelb);
		 getContentPane().add(nameLb);
		 getContentPane().add(nameTf);
		 getContentPane().add(passwordLb);
		 getContentPane().add(passwordTf);
		 getContentPane().add(emailLb);
		 getContentPane().add(emailTf);
		 getContentPane().add(phoneLb);
		 getContentPane().add(phoneTf);
		 getContentPane().add(okBtn);
		 getContentPane().add(resetBtn);
	}

	 //添加监听器

	 private void addListeners() {
		  okBtn.addActionListener(this);
		  resetBtn.addActionListener(this);
	 }

	 /**
	  * 点击按钮触发的操作都写在这里
	  */
	 @Override
	 public void actionPerformed(ActionEvent e) {
		  if(e.getSource() == okBtn){//点击确定按钮
			  register();//注册
		  }else if(e.getSource()==resetBtn){//点击重置按钮
			  reset();//重置
		  }
	 }
	 
	 //注册
	 private void register() {
		  String name = nameTf.getText().trim();
		  String password = new String(passwordTf.getPassword());
		  String email = emailTf.getText().trim();
		  String tel = phoneTf.getText().trim();
		  
		  System.out.println(name);
		  System.out.println(password);
		  System.out.println(tel);
		  System.out.println(email);
		  
	        int id=2;
	    	try 
			{ 
				Class.forName("com.mysql.jdbc.Driver");
				Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/classroom?"
						+ "useUnicode=true&characterEncoding=utf-8&useSSL=false","root","cyber");
				PreparedStatement St=connect.prepareStatement("insert into user(name,pw,email,tel) VALUES(?,?,?,?)");
				St.setString(1, name);
				St.setString(2, password);
				St.setString(3, email);
				St.setString(4, tel);
				St.executeUpdate();
			} 
			catch(SQLException e1) {} 
			catch (ClassNotFoundException e1) 
			{
				e1.printStackTrace();
			} 
			JOptionPane.showMessageDialog(null,"恭喜您，注册成功！！！");
			
			//this.setVisible(false);
	 }
	 
	 //重置
	 private void reset() {
		  nameTf.setText("");
		  passwordTf.setText("");

		  phoneTf.setText("");
		  emailTf.setText("");
	
		  nameTf.requestFocus();//获得焦点
	 }
}





