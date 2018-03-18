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
	 
	 //�û�����ǩ 
	 private JLabel nameLb;
	 //�����ǩ 
	 private JLabel passwordLb;
	 //�����ǩ 
	 private JLabel emailLb;
	 //��ϵ�绰��ǩ 
	 private JLabel phoneLb;
	 //�û����ı��� 
	 private JTextField nameTf;
	 //�����ı��� 
	 private JPasswordField passwordTf;
	 
	 //��ϵ�绰�ı��� 
	 private JTextField phoneTf;
	 // �����ı��� 
	 private JTextField emailTf;

	 //ȷ����ť
	 private JButton okBtn;
	 //����
	 private JButton resetBtn;

	 //���췽�� 
	 public UserRegister() {
		 initComponents();
		 layoutComponents();
		 addListeners();
	     
	     this.setVisible(true); 
		 setSize(516, 483);// ���ô�С
		 //setModal(true);//����Ϊģ̬����
		 setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		 setLocationRelativeTo(null);// ����Ļ�м���ʾ
	 }
	 
	 //��ʼ�����
	 private void initComponents() {
		  titlelb= new JLabel("ע   ��");
		  nameLb = new JLabel("�û���");
		  nameLb.setFont(new Font("����", Font.PLAIN, 15));
		  passwordLb = new JLabel("\u5BC6  \u7801");
		  passwordLb.setFont(new Font("����", Font.PLAIN, 15));
		  phoneLb = new JLabel("��ϵ�绰"); 
		  phoneLb.setFont(new Font("����", Font.PLAIN, 15));
		  emailLb = new JLabel("\u90AE  \u7BB1");
		  emailLb.setFont(new Font("����", Font.PLAIN, 15));
		  
		  nameTf=new JTextField();
		  passwordTf=new JPasswordField();
		  phoneTf=new JTextField();
		  emailTf=new JTextField();
		  
		  okBtn = new JButton("ȷ��");
		  okBtn.setFont(new Font("����", Font.PLAIN, 15));
		  resetBtn = new JButton("����");
		  resetBtn.setFont(new Font("����", Font.PLAIN, 15));
	 }

	 //�������
	 private void layoutComponents() {
		 getContentPane().setLayout(null);// ȥ��Ĭ�ϵı߽粼��
	  
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

	 //��Ӽ�����

	 private void addListeners() {
		  okBtn.addActionListener(this);
		  resetBtn.addActionListener(this);
	 }

	 /**
	  * �����ť�����Ĳ�����д������
	  */
	 @Override
	 public void actionPerformed(ActionEvent e) {
		  if(e.getSource() == okBtn){//���ȷ����ť
			  register();//ע��
		  }else if(e.getSource()==resetBtn){//������ð�ť
			  reset();//����
		  }
	 }
	 
	 //ע��
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
			JOptionPane.showMessageDialog(null,"��ϲ����ע��ɹ�������");
			
			//this.setVisible(false);
	 }
	 
	 //����
	 private void reset() {
		  nameTf.setText("");
		  passwordTf.setText("");

		  phoneTf.setText("");
		  emailTf.setText("");
	
		  nameTf.requestFocus();//��ý���
	 }
}





