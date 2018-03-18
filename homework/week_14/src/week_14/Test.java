package week_14;

import java.util.*;
import java.util.Date;
import java.awt.Font;
import java.awt.event.*;
import java.awt.Color;
import java.awt.Label;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.JPanel;  
import javax.swing.JTextField;  
import javax.swing.JFrame;  
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
 
public class Test extends JFrame
{
	public static void main(String[] args)
	{
		try
		{
		   Test frame = new Test();
		   frame.setTitle("����");
		}
		catch (Exception e){
			System.out.print("run error!");    
		}
	}
	private static final long serialVersionUID = 1L; 
	public Test()
	{
		 Clock clock =new Clock();
		 Calender cal = new Calender();
		 JPanel jp2 = new JPanel();
		 setLocationRelativeTo(null);
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 setSize(450,300);
		 setVisible(true);
		 this.setContentPane(clock);
		 this.getContentPane().add(cal,BorderLayout.WEST);
		 setResizable(false);
	 }

	//��ʱ��
	public class LxDemo extends JPanel implements Runnable{  
		 private static final long serialVersionUID = 1L;
		 Thread timer = null;  //�߳�
	     int lastxs=50, lastys=30, lastxm=50, lastym=30, lastxh=50, lastyh=30;
	     public void paint(Graphics g){  
	         	super.paint(g);  
	         	int xh, yh, xm, ym, xs, ys, s, m, h, xcenter, ycenter;
	         	Date rightnow = new Date(); //��ȡ��ǰ���ں�ʱ��
	         	g.drawString(rightnow.toLocaleString(), 55,60); 
	         	s = rightnow.getSeconds();
	         	m = rightnow.getMinutes();
	         	h = rightnow.getHours();
	         	xcenter=110; ycenter=150; //ͼ���ӵ�ԭ��
	         	//���¼������롢���롢ʱ��λ��
	         	xs = (int)(Math.cos(s * 3.14f/30 - 3.14f/2) * 45 + xcenter);
	         	ys = (int)(Math.sin(s * 3.14f/30 - 3.14f/2) * 45 + ycenter);
	         	xm = (int)(Math.cos(m * 3.14f/30 - 3.14f/2) * 40 + xcenter);
	         	ym = (int)(Math.sin(m * 3.14f/30 - 3.14f/2) * 40 + ycenter);
	         	xh = (int)(Math.cos((h*30+m/2)*3.14f/180-3.14f/2)*30+xcenter);
	         	yh = (int)(Math.sin((h*30+m/2)*3.14f/180-3.14f/2)*30+ycenter);
	         	g.setFont(new Font("TimesRoman", Font.PLAIN, 14));
	 			g.setColor(Color.orange); //���ñ�����ɫ
	 			g.fill3DRect(xcenter-50,ycenter-50,100,100,true); //������
	 			g.setColor(Color.darkGray); //���ñ���������ɫ
				g.drawString("9",xcenter-45,ycenter+3); //�������ϵ�����
				g.drawString("3",xcenter+40,ycenter+3);
				g.drawString("12",xcenter-5,ycenter-37);
				g.drawString("6",xcenter-3,ycenter+45);
				//ʱ��仯ʱ����Ҫ���»�����ָ�룬��������ԭ��ָ�룬Ȼ����ָ��
				g.setColor(Color.orange); //�ñ�����ɫ���ߣ���������ԭ��������
				if (xs != lastxs || ys != lastys){ //����仯
				g.drawLine(xcenter, ycenter, lastxs, lastys); }
				if (xm != lastxm || ym != lastym) { //����仯
					g.drawLine(xcenter, ycenter-1, lastxm, lastym);
					g.drawLine(xcenter-1, ycenter, lastxm, lastym); }
				if (xh != lastxh || yh != lastyh) { //ʱ��仯
					g.drawLine(xcenter, ycenter-1, lastxh, lastyh);
					g.drawLine(xcenter-1, ycenter, lastxh, lastyh); }
				g.setColor(Color.red); //ʹ�ú�ɫ����ָ��
				g.drawLine(xcenter, ycenter, xs, ys);
				g.drawLine(xcenter, ycenter-1, xm, ym);
				g.drawLine(xcenter-1, ycenter, xm, ym);
				g.drawLine(xcenter, ycenter-1, xh, yh);
				g.drawLine(xcenter-1, ycenter, xh, yh);
				lastxs=xs; lastys=ys; //����ָ��λ��
				lastxm=xm; lastym=ym;
				lastxh=xh; lastyh=yh; 
	            setBorder(new TitledBorder("ʱ��")); 
	            setBackground(Color.white); // ������ɫ
	     }
	     public Date getDate()
	     {  
	         Date timeNow = new Date();  
	         return timeNow;  
	     }  
	     // ˢ��ͼ��  
	     public void update(Graphics g)
	     {  
	         paint(g);  
	     }  
	      // ����һ��֡��ͼ�� 
	     public void start() { //�����̵߳ķ���
	 		if(timer == null) {
	 			timer = new Thread(this);
	 			timer.start(); 
	 		}
	 	 }
	 	 public void stop() //ֹͣ�̷߳���
	 	 {
	 		timer = null; 
	 	 }
	 	 public void run(){ //ÿ��һ���ӣ�ˢ��һ�λ���ķ���
	 		 while (timer != null) 
	 		 {
	 			 try { Thread.sleep(1000); }
	 			 catch (InterruptedException e) {}
	 			 repaint(); //����paint()�����ػ�ʱ��
	 		 }
	 		 timer = null; 
	 	 }
	 }  
	
	 //ʱ��
	public class Clock extends JPanel{   
		  private static final long serialVersionUID = 1L;
		  private UIManager.LookAndFeelInfo looks[];
		  private LxDemo clock ;
		  private JPanel pane_clock ;
		  JPanel pane_cal;
		  public Clock(){
			   super();
		       looks = UIManager.getInstalledLookAndFeels();
		       changeTheLookAndFeel(2);
		       clock = new LxDemo();
		       clock.start();
		       this.setBackground(Color.GRAY);  
		       this.setLayout(new BorderLayout());       
		       this.setOpaque(false);  
		       this.add(clock);
		       this.setBorder(new TitledBorder("ʱ������"));
		       setSize( 300, 300 );  
		       setVisible( true );  
		  }
	     private void changeTheLookAndFeel(int i){
		      try{
		       UIManager.setLookAndFeel(looks[i].getClassName());
		       SwingUtilities.updateComponentTreeUI(this);
		      }
		      catch(Exception exception){
		       exception.printStackTrace();
		      }
	     }
	 }   
	
	//�������
	public class Calender extends JPanel implements ActionListener
	{
		  private static final long serialVersionUID = 1L;
		  public  final String HOUR_OF_DAY = null;
		  //����
		  JComboBox Month = new JComboBox(); 
		  JComboBox Year = new JComboBox(); 
		  JLabel Year_l = new JLabel("��");
		  JLabel Month_l = new JLabel("��");  
		  Date now_date = new Date();
		  JLabel[] Label_day = new JLabel[49];  
		  int now_year = now_date.getYear() + 1900;
		  int now_month = now_date.getMonth();
		  boolean bool = false;
		  String year_int = null;
		  int month_int;
		  JPanel pane_ym = new JPanel();
		  JPanel pane_day = new JPanel();
		  public Calender(){ 
			   super();
			   //�趨����
			   for (int i = now_year - 10; i <= now_year + 20; i++)
			   {
				   Year.addItem(i + "");
			   }
			   for (int i = 1; i < 13; i++)
			   {
				   Month.addItem(i + "");
			   }
			   Year.setSelectedIndex(10);
			   pane_ym.add(new  JLabel("        "));
			   pane_ym.add(Year);
			   pane_ym.add(Year_l); 
			   Month.setSelectedIndex(now_month);  
			   pane_ym.add(Month);
			   pane_ym.add(Month_l);
			   pane_ym.add(new  JLabel("        "));
			   
			   Month.addActionListener(this);
			   Year.addActionListener(this); 
			   //��ʼ�����ڲ�����
			   pane_day.setLayout(new GridLayout(7, 7, 10, 10));
			   for (int i = 0; i < 49; i++) {
				    Label_day[i] = new JLabel(" ");
				    pane_day.add(Label_day[i]);
			   }
			   this.setDay();
			   this.setLayout(new BorderLayout());
			   this.add(pane_day, BorderLayout.CENTER);
			   this.add(pane_ym, BorderLayout.NORTH);
			   this.setSize(100,200);
			   this.setBorder(new TitledBorder("����"));
			   setSize(300,300); 
		  }
		  void setDay()
		  {
			   if (bool)
			   {
				    year_int = now_year + "";
				    month_int = now_month;
			   }
			   else
			   {
				    year_int = Year.getSelectedItem().toString();
				    month_int = Month.getSelectedIndex();
			   }
			   
			   int year_sel = Integer.parseInt(year_int) - 1900; //������ֵ
			   Date dt = new Date(year_sel, month_int, 1); //����һ������
			   GregorianCalendar cal = new GregorianCalendar(); //����һ��Calendarʵ��
			   cal.setTime(dt);
			   String week[] = { "��", "һ","��", "��", "��", "��", "��" };
			   int day = 0;
			   int day_week = 0;
			   for (int i = 0; i < 7; i++) {
				   Label_day[i].setText(week[i]);
			   }
			   //�·�
			   if (month_int == 0||month_int == 2 ||month_int == 4 ||
			     month_int == 6 ||
			     month_int == 9 ||month_int == 11)
			   {
				   day = 31;
			   }
			   else if (month_int == 3 ||month_int == 5 || month_int == 7||
				 month_int == 8 ||month_int == 10|| month_int == 1)
			   {
				   day = 30;
			   }
			   else
			   {
				    if (cal.isLeapYear(year_sel))
				    {
				     day = 29;
				    }
				    else
				    {
				     day = 28;
				    }
			   }
			   day_week = 7 + dt.getDay();
			   int count = 1;
			   for (int i = day_week; i < day_week + day; count++, i++)
			   {
				   if (i % 7 == 0 ||i == 13||i == 20||i == 27||
						   i == 48 ||i == 34 ||i == 41)
				   {
					   if (i == day_week + now_date.getDate() - 1)
					   {
						   Label_day[i].setForeground(Color.blue);
						   Label_day[i].setText(count + "");
					   }
					   else
					   {
						   Label_day[i].setForeground(Color.red);
						   Label_day[i].setText(count + "");
					   }
			    }
			    else
			    {
			    	if (i == day_week + now_date.getDate() - 1)
			    	{
			    		Label_day[i].setForeground(Color.blue);
			            Label_day[i].setText(count + "");
			    	}
			    	else
			    	{
			    		Label_day[i].setForeground(Color.black);
			    		Label_day[i].setText(count + "");
			    	}
			    }
		   }
		   if (day_week == 0)
		   {
			    for (int i = day; i < 49; i++)
			    {
			    	Label_day[i].setText(" ");
			    }
		   }
		   else
		   {
			    for (int i = 7; i < day_week; i++)
			    {
			    	Label_day[i].setText(" ");
			    }
			    for (int i = day_week + day; i < 49; i++)
			    {
			    	Label_day[i].setText("  ");
			    }
		   	}
		  }
		  public void actionPerformed(ActionEvent e) {
			   if (e.getSource() == Year || e.getSource() == Month) {
				   bool = false;
				   this.setDay();
			   }
		  }
	}
}
