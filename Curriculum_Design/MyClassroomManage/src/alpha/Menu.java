package alpha;

import java.awt.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Menu extends JFrame implements ActionListener{
	JFrame j = new JFrame();
	JButton login = new JButton("登录");  
    JButton register = new JButton("注册");  
    JLabel  name = new JLabel("用户名：");  
    JLabel password = new JLabel("密    码：");
    JTextField JName = new JTextField(15); 
    JPasswordField JPassword = new JPasswordField(15);
    JButton rregister = new JButton("注册");
    JButton rexit = new JButton("退出"); 
    JLabel rname     = new JLabel("用户名：");  
    JLabel rpassword = new JLabel(" 密码 ：");
    JLabel remail = new JLabel(" 邮箱 ：");
    JLabel rtel = new JLabel(" 电话 ：");
    JTextField rJName = new JTextField(20); 
    JTextField rJpassword = new JTextField(20);
    JTextField rJemail = new JTextField(20);
    JTextField rJtel = new JTextField(20);
    
    Checkbox cb1, cb2;
    CheckboxGroup cg;
    
	public Menu() {
		JPanel jp = new JPanel();  
	    JPanel p1=new JPanel();
	    JPanel p2=new JPanel();
	    JPanel p3=new JPanel();
	    JPanel p4=new JPanel();
        jp.setLayout(new GridLayout(4,2));  
        p1.add(name);  
        p1.add(JName);    
        p2.add(password);  
        p2.add(JPassword); 
        p3.add(login);  
        p3.add(register); 
        cg = new CheckboxGroup();
        cb1 = new Checkbox("管理员", cg, false);
        cb2 = new Checkbox("学生", cg, false);
        p4.add(cb1);
        p4.add(cb2);
        
        //p1.setLocation(200,150);
        //p2.setLocation(200,300);
        
        jp.add(p1);
        jp.add(p2);
        jp.add(p4);
        jp.add(p3);
        login.addActionListener(this); 
        register.addActionListener(this);  
        this.add(jp,BorderLayout.CENTER);   
        this.setTitle("登录窗口");  
        this.setLocation(800,400); 
        this.setSize(500,300);         
        this.setVisible(true);  
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	}
	@SuppressWarnings("deprecation")
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==register)
		{
			new UserRegister();
		}
		if(e.getSource()==login)	
		{
			try 
			{ 
				Class.forName("com.mysql.jdbc.Driver");
				Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/classroom?"
						+"useUnicode=true&characterEncoding=utf-8&useSSL=false","root","cyber");
				Statement st = connect.createStatement();
				ResultSet sql = st.executeQuery("select *from user");
				int flag=0;
				
				while(sql.next())
				{
			
					if(sql.getString("name").trim().equals(JName.getText().trim())) 
					{
		
						if(sql.getString("pw").trim().equals(JPassword.getText())) {

							if(cb1.getState()){
								if(sql.getString("id").equals("1") || sql.getString("id").equals("2") || sql.getString("id").equals("3"))
								{
									
									new administrator(sql.getString("name"));
									//admin.show(sql.getString("name"));
								}
								else JOptionPane.showMessageDialog(null,"您不是管理员！！！");
							}
							else{
								new normal_user(sql.getString("name"));
							}
							this.dispose();
						}
						else
						{
							JOptionPane.showMessageDialog(null,"您的密码有误！！！");
						}	
						flag=1;
					}
				}
				if(flag==0) {
					JOptionPane.showMessageDialog(null,"您的用户名有误！！！");
				}
			} 
			catch(SQLException e1) {} 
			catch (ClassNotFoundException e1) 
			{
				e1.printStackTrace();
			} 
		}

	}	
	public static void main(String args[]) 
	{  
		 new Menu();  
	} 
}



