package alpha;

import java.awt.*;
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
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JComboBox;



public class administrator extends JFrame implements ActionListener{
	JFrame frame;
	JFrame j = new JFrame(); 
	JFrame s = new JFrame();
	JFrame up = new JFrame();
	
	JTextField Name = new JTextField(20); 
    JTextField password = new JTextField(20);
    JTextField email = new JTextField(20);
    JTextField tel = new JTextField(20);
    
    JTextField update_id = new JTextField(20);
    JTextField update_name = new JTextField(20);
    JTextField update_pw = new JTextField(20);
    JTextField update_email = new JTextField(20);
    JTextField update_tel = new JTextField(20);

    JTextField search_id = new JTextField(20);
	
	JPanel panel1 = new JPanel();
	JPanel panel11 = new JPanel();
	JPanel panel12 = new JPanel();
	JPanel panel13 = new JPanel();
	JPanel panel14 = new JPanel();
	
	JButton borrow = new JButton("����");
	JButton ret = new JButton("�黹");
	
	JButton search = new JButton("��ѯ");
	JButton add = new JButton("���");
	JButton update = new JButton("�޸�");
	JButton del = new JButton("ɾ��");
	JButton exit = new JButton("�˳�");
	JButton add_ok = new JButton("���");
	JButton update_ok = new JButton("ȷ��");
	JButton search_ok = new JButton("ȷ��");
	
	String[] info = { "�û���Ϣ", "������Ϣ" };
	JComboBox jc=new JComboBox(info);  
    JLabel jl=new JLabel("��ѡ��:"); 
    
    JScrollPane scrollPane;
    JTable content;
    Table model;
    
    String loginname;
	
	public administrator(){}
	public administrator(String name){
		loginname = name;
		frame = new JFrame("��Ϣ");
		//frame.setLayout(null);
		frame.add(panel1,BorderLayout.WEST);
		//panel11.setBounds(0, 0, 100, 300);
		panel11.setLayout(new FlowLayout());
		panel11.add(jl);
		panel11.add(jc);
		
		panel12.setLayout(new FlowLayout());
		panel12.add(search);
		panel12.add(add);
		panel12.add(update);
		panel12.add(del);
		
		panel13.setLayout(new FlowLayout());
		panel13.add(borrow);
		panel13.add(ret);
		
		panel14.setLayout(new FlowLayout());
		panel14.add(exit);
		
		panel1.setLayout(new GridLayout(4, 1));
		panel1.add(panel11);
		panel1.add(panel12);
		panel1.add(panel13);
		panel1.add(panel14);
		
		search.addActionListener(this);
		add.addActionListener(this);
		update.addActionListener(this);
		del.addActionListener(this);
		exit.addActionListener(this);
		jc.addActionListener(this);
		borrow.addActionListener(this);
		ret.addActionListener(this);
		
		
		//���table
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		final Table model = new Table("�û���Ϣ");
		content = new JTable();
        content.setModel(model); 
        
        content.setBackground(Color.YELLOW);
        scrollPane = new JScrollPane(content);
        scrollPane.setBounds(100, 0, 700, 600);
        frame.add(scrollPane,BorderLayout.EAST);
        
        frame.setSize(800, 600);
        frame.setVisible(true);
	}
	
	public void user_add()
	{
	    JLabel rname = new JLabel("�û�����");  
	    JLabel rpassword = new JLabel(" ���� ��");
	    JLabel remail = new JLabel(" ���� ��");
	    JLabel rtel = new JLabel(" �绰 ��");
		JPanel jp = new JPanel();  
	    JPanel adp1=new JPanel();
	    JPanel adp2=new JPanel();
	    JPanel adp3=new JPanel();
	    JPanel adp4=new JPanel();
	    JPanel adp5=new JPanel();
        jp.setLayout(new GridLayout(5,2));  
        adp1.add(rname);  
        adp1.add(Name);  
        adp2.add(rpassword);  
        adp2.add(password);
        adp4.add(remail);
        adp4.add(email);
        adp5.add(rtel);
        adp5.add(tel);
        adp3.add(add_ok);    
        adp3.add(exit);
        jp.add(adp1);
        jp.add(adp2);
        jp.add(adp4);
        jp.add(adp5);
        jp.add(adp3); 
        add_ok.addActionListener(this);
        j.add(jp,BorderLayout.CENTER);   
        j.setTitle("�û����");  
        j.setSize(370,260); 
        j.setLocation(800,400); 
        j.setVisible(true);  
        j.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
	}
	
	public void user_update() 
	{
		JLabel rid = new JLabel(" ��ʶ�ţ�");
		JLabel rname = new JLabel("  ���� ��");
		JLabel rpw = new JLabel("  ���� ��");
		JLabel remail = new JLabel("  ���� ��");
		JLabel rtel = new JLabel      ("  �绰 ��");
		JPanel jp1 = new JPanel();
		JPanel p=new JPanel();
	    JPanel p1=new JPanel();
	    JPanel p2=new JPanel();		    
	    JPanel p3=new JPanel();
	    JPanel p4=new JPanel();
	    JPanel p5=new JPanel();
	    jp1.setLayout(new GridLayout(6,1));
	    p.add(rid);
	    p.add(update_id);
	    p1.add(rname);  
        p1.add(update_name);  
        p2.add(rpw);  
	    p2.add(update_pw);
        p3.add(remail);
	    p3.add(update_email);
	    p4.add(rtel);
	    p4.add(update_tel);
	    p5.add(update_ok);
	    p5.add(exit);
	    jp1.add(p);
	    jp1.add(p1);
	    jp1.add(p2);
	    jp1.add(p3);
	    jp1.add(p4);
	    jp1.add(p5);
	    update_ok.addActionListener(this);
	    up.add(jp1,BorderLayout.CENTER);   
	    up.setTitle("�û��޸�");  
	    up.setSize(370,260); 
	    up.setLocation(800,400); 
	    up.setVisible(true);  
	    up .setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
	}

	public void user_search()
	{
		JLabel id = new JLabel("�������û���ʶ��:");
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		p1.add(id);
		p1.add(search_id);
		p2.add(search_ok);
		p2.add(exit);
		s.setLayout(new GridLayout(2,1));
		s.add(p1);
		s.add(p2);
		search_ok.addActionListener(this);
		s.setTitle("�û���ѯ");
		s.setLocation(850, 500);
		s.pack();
		s.setVisible(true);
	}

	@SuppressWarnings("deprecation")
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==jc){
			if(jc.getSelectedItem().equals("�û���Ϣ")){
				model = new Table("�û���Ϣ");
		        content.setModel(model);
		        
		        content.setBackground(Color.YELLOW);
		        frame.add(scrollPane,BorderLayout.EAST);
		        
			}else{
				model = new Table("������Ϣ");
		        content.setModel(model);
		        
		        content.setBackground(Color.YELLOW);
		        frame.add(scrollPane,BorderLayout.EAST);
			}
		}
		
		if(e.getSource() == del){
			try{ Class.forName("com.mysql.jdbc.Driver"); //ע������
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/classroom?"
						+"useUnicode=true&characterEncoding=utf-8&useSSL=false", "root", "cyber");//��ȡ���ݿ�����
				Statement stmt = conn.createStatement();//����ִ�����
				String sql1 = null;
				if((jc.getSelectedItem()).toString()=="�û���Ϣ")   {    
					sql1 = "delete from user where id=";
				}
				else if((jc.getSelectedItem()).toString() == "������Ϣ"){    
					sql1 = "delete from rooms where id=";   
				}
				
				
				sql1 = sql1+(content.getValueAt(content.getSelectedRow(), 0)).toString();
				stmt.executeUpdate(sql1);
				
				String sql2 = null;
				if((jc.getSelectedItem()).toString()=="�û���Ϣ")   {    
					sql2="select * from user";
				}
				else if((jc.getSelectedItem()).toString() == "������Ϣ"){    
					sql2="select * from rooms";    
				}
				
				ResultSet rs = stmt.executeQuery(sql2);
					
				model = new Table((jc.getSelectedItem()).toString());
		        content.setModel(model);
		        
		        content.setBackground(Color.YELLOW);
		        frame.add(scrollPane,BorderLayout.EAST);
	        
			} catch(SQLException es){
				es.printStackTrace();
			} catch(ClassNotFoundException es){
				es.printStackTrace();
			}
		}
		
		if(e.getSource()==add)
		{
			user_add();
			this.dispose();
		}
		
		if(e.getSource()==update)
		{
			user_update();
			this.dispose();
		}
		
		if(e.getSource()==search)
		{
			user_search();
			this.dispose();
		}
		
		if(e.getSource()== add_ok)
		{
			String name = Name.getText().trim();
			String Password = password.getText().trim();
			String Email = email.getText().trim();
			String Tel = tel.getText().trim();
			try 
			{ 
				Class.forName("com.mysql.jdbc.Driver");
				Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/classroom?"
						+ "useUnicode=true&characterEncoding=utf-8&useSSL=false","root","cyber");
				PreparedStatement St=connect.prepareStatement("INSERT INTO user (name,pw,email,tel) VALUES(?,?,?,?)");
				St.setString(1, name);
				St.setString(2, Password);
				St.setString(3, Email);
				St.setString(4, Tel);
				St.executeUpdate();
			} 
			catch(SQLException e1) {
				e1.printStackTrace();
			} 
			catch (ClassNotFoundException e1) 
			{
				e1.printStackTrace();
			} 
			JOptionPane.showMessageDialog(null,"��ӳɹ�");
			
			model = new Table((jc.getSelectedItem()).toString());
			//final JTable content = new JTable();
	        content.setModel(model);
	        
	        content.setBackground(Color.YELLOW);
	        frame.add(scrollPane,BorderLayout.EAST);
			//j.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		}
		
		if(e.getSource()==update_ok)
		{
			int fl=0;
			try 
			{ 
				Class.forName("com.mysql.jdbc.Driver");
				Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/classroom?"
						+ "useUnicode=true&characterEncoding=utf-8&useSSL=false","root","cyber");
				Statement st = connect.createStatement();
				ResultSet sql = st.executeQuery("select *from user");
				PreparedStatement up = connect.prepareStatement("update user set name=?  where id=?");
				PreparedStatement up1 = connect.prepareStatement("update user set pw=?  where id=?");
				PreparedStatement up2 = connect.prepareStatement("update user set email=?  where id=?");
				PreparedStatement up3 = connect.prepareStatement("update user set tel=?  where id=?");
				while(sql.next())
				{
					if(sql.getString("id").equals(update_id.getText()))
					{
						String b = sql.getString("id");
						if(update_name.getText().trim().equals("")) {}
						else
						{
							String a = update_name.getText().trim();
							up.setString(1, a);
							up.setString(2, b);
							up.executeUpdate();
						}
						if(update_pw.getText().trim().equals("")) {}
						else
						{
							String a = update_pw.getText().trim();
							up1.setString(1, a);
							up1.setString(2, b);
							up1.executeUpdate();
						}
						if(update_email.getText().trim().equals("")) {}
						else
						{
							String a = update_email.getText().trim();
							up2.setString(1, a);
							up2.setString(2, b);
							up2.executeUpdate();
						}
						if(update_tel.getText().trim().equals("")) {}
						else
						{
							String a = update_tel.getText().trim();
							up3.setString(1, a);
							up3.setString(2, b);
							up3.executeUpdate();
						}
						fl=1;
						JOptionPane.showMessageDialog(null,"�޸ĳɹ�������");
						model = new Table((jc.getSelectedItem()).toString());
						//final JTable content = new JTable();
				        content.setModel(model);
				        
				        content.setBackground(Color.YELLOW);
				        frame.add(scrollPane,BorderLayout.EAST);
					}
				}
				if(fl==0)
				{
					JOptionPane.showMessageDialog(null,"�û���ʶ�����󣡣���");
				}
			}
			catch(SQLException e1) {} 
			catch (ClassNotFoundException e1) 
			{
				e1.printStackTrace();
			} 
		}
		
		if(e.getSource()==search_ok)
		{
			try 
			{ 
				int flag=0;
				Class.forName("com.mysql.jdbc.Driver");
				Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/classroom?"
						+ "useUnicode=true&characterEncoding=utf-8&useSSL=false","root","cyber");
				Statement st = connect.createStatement();
				ResultSet sql = st.executeQuery("select *from user");
				while(sql.next())
				{
					if(sql.getString("id").equals(search_id.getText()))
					{
						String out = sql.getString("id") +"�û�������Ϊ"+ sql.getString("name") + "���û�����Ϊ"
						+ sql.getString("pw") + "������" +sql.getString("email")+ "���绰" + sql.getString("tel");
						JOptionPane.showMessageDialog(null,out);
						flag=1;
					}
				}
				if(flag==0)
				{
					JOptionPane.showMessageDialog(null,"�û�������");
				}
			}
			catch(SQLException e1) {} 
			catch (ClassNotFoundException e1) 
			{
				e1.printStackTrace();
			} 
		}
		
		if(e.getSource() == borrow){
			if((jc.getSelectedItem()).toString() == "������Ϣ"){
				try{ Class.forName("com.mysql.jdbc.Driver"); //ע������
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/classroom?"
						+"useUnicode=true&characterEncoding=utf-8&useSSL=false", "root", "cyber");//��ȡ���ݿ�����
				Statement stmt = conn.createStatement();//����ִ�����
				
				int fg = 1;
				String sql1 = null, state = null;
				if(( (content.getValueAt(content.getSelectedRow(), 4)).toString() ).equals("����") ){
					state = "ռ��"; 
				}else{
					state = "ռ��"; fg = 0;
				}
				
				if(fg == 1){
					sql1 = "update rooms set busy='"+state+"' where id="+(content.getValueAt(content.getSelectedRow(), 0)).toString();
					stmt.executeUpdate(sql1);
					sql1 = "update rooms set name='"+loginname+"' where id="+(content.getValueAt(content.getSelectedRow(), 0)).toString();
					stmt.executeUpdate(sql1);					
				}
					
				ResultSet rs = stmt.executeQuery("select * from rooms");
						
				model = new Table((jc.getSelectedItem()).toString());
			    content.setModel(model);
			        
			    content.setBackground(Color.YELLOW);
			    frame.add(scrollPane,BorderLayout.EAST);
				
	        
				} catch(SQLException es){
					es.printStackTrace();
				} catch(ClassNotFoundException es){
					es.printStackTrace();
				}
				
			}
			
		}
		
		if(e.getSource() == ret){
			if((jc.getSelectedItem()).toString() == "������Ϣ"){
				try{ Class.forName("com.mysql.jdbc.Driver"); //ע������
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/classroom?"
						+"useUnicode=true&characterEncoding=utf-8&useSSL=false", "root", "cyber");//��ȡ���ݿ�����
				Statement stmt = conn.createStatement();//����ִ�����	
				
				int fg = 1;
				String sql1 = null, state = null;
				if(( (content.getValueAt(content.getSelectedRow(), 4)).toString() ).equals("ռ��") ){
					state = "����"; 
				}else{
					state = "����"; fg = 0;
				}
				
				if(fg == 1){
					sql1 = "update rooms set busy='"+state+"' where id="+(content.getValueAt(content.getSelectedRow(), 0)).toString();
					stmt.executeUpdate(sql1);
					sql1 = "update rooms set name='' where id="+(content.getValueAt(content.getSelectedRow(), 0)).toString();
					stmt.executeUpdate(sql1);					
				}
				
				ResultSet rs = stmt.executeQuery("select * from rooms");
						
				model = new Table((jc.getSelectedItem()).toString());
			    content.setModel(model);
			        
			    content.setBackground(Color.YELLOW);
			    frame.add(scrollPane,BorderLayout.EAST);
				
	        
				} catch(SQLException es){
					es.printStackTrace();
				} catch(ClassNotFoundException es){
					es.printStackTrace();
				}
				
			}
			
		}
		
		if(e.getSource()==exit)
		{
			System.exit(0);
		}
	}	
	
}
