package alpha;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class normal_user extends JFrame implements ActionListener{
	JFrame frame;
	JFrame j = new JFrame(); 
	JFrame s = new JFrame();
	JFrame up = new JFrame();
	
	JLabel  noadmin = new JLabel("��Ȩ�޲�����");
	
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
	JPanel panel15 = new JPanel();
	
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
	
	String[] info = { "������Ϣ" };
	JComboBox jc=new JComboBox(info);  
    JLabel jl=new JLabel("��ѡ��:"); 
    
    JScrollPane scrollPane;
    JTable content;
    Table model;
    
    String loginname;
	
	public normal_user(){}
	public normal_user(String name){
		loginname = name;
		frame = new JFrame("��Ϣ");
		frame.add(panel1,BorderLayout.WEST); 
		panel11.setLayout(new FlowLayout());
		panel11.add(jl);
		panel11.add(jc);
		
		panel15.setLayout(new FlowLayout());
		panel15.add(noadmin);
		
		panel12.setLayout(new FlowLayout());
		panel12.add(search);
		panel12.add(add);
		panel12.add(update);
		panel12.add(del);
		
		
		//panel12.setBounds(0, 300, 100, 300);
		panel13.setLayout(new FlowLayout());
		panel13.add(borrow);
		panel13.add(ret);
		
		panel14.setLayout(new FlowLayout());
		panel14.add(exit);
		
		//panel1.setBounds(0, 0, 100, 600);
		panel1.setLayout(new GridLayout(5, 1));
		panel1.add(panel11);
		panel1.add(panel15);
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

		final Table model = new Table("������Ϣ");
		content = new JTable();
        content.setModel(model); 
        
        content.setBackground(Color.YELLOW);
        scrollPane = new JScrollPane(content);
        scrollPane.setBounds(100, 0, 700, 600);
        frame.add(scrollPane,BorderLayout.EAST);
        frame.setSize(800, 600);
        frame.setVisible(true);
	}
	
	
	@SuppressWarnings("deprecation")
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==jc){
			if(jc.getSelectedItem().equals("�û���Ϣ")){

		        
			}else{
				model = new Table("������Ϣ");
				//final JTable content = new JTable();
		        content.setModel(model);
		        
		        content.setBackground(Color.YELLOW);
		        frame.add(scrollPane,BorderLayout.EAST);
				//new administrator("������Ϣ");
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
				if(( (content.getValueAt(content.getSelectedRow(), 4)).toString() ).equals("ռ��") && ( content.getValueAt(content.getSelectedRow(), 5)).toString().equals(loginname) ){
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
