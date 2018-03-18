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
		   frame.setTitle("日历");
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

	//画时钟
	public class LxDemo extends JPanel implements Runnable{  
		 private static final long serialVersionUID = 1L;
		 Thread timer = null;  //线程
	     int lastxs=50, lastys=30, lastxm=50, lastym=30, lastxh=50, lastyh=30;
	     public void paint(Graphics g){  
	         	super.paint(g);  
	         	int xh, yh, xm, ym, xs, ys, s, m, h, xcenter, ycenter;
	         	Date rightnow = new Date(); //获取当前日期和时间
	         	g.drawString(rightnow.toLocaleString(), 55,60); 
	         	s = rightnow.getSeconds();
	         	m = rightnow.getMinutes();
	         	h = rightnow.getHours();
	         	xcenter=110; ycenter=150; //图形钟的原点
	         	//以下计算秒针、分针、时针位置
	         	xs = (int)(Math.cos(s * 3.14f/30 - 3.14f/2) * 45 + xcenter);
	         	ys = (int)(Math.sin(s * 3.14f/30 - 3.14f/2) * 45 + ycenter);
	         	xm = (int)(Math.cos(m * 3.14f/30 - 3.14f/2) * 40 + xcenter);
	         	ym = (int)(Math.sin(m * 3.14f/30 - 3.14f/2) * 40 + ycenter);
	         	xh = (int)(Math.cos((h*30+m/2)*3.14f/180-3.14f/2)*30+xcenter);
	         	yh = (int)(Math.sin((h*30+m/2)*3.14f/180-3.14f/2)*30+ycenter);
	         	g.setFont(new Font("TimesRoman", Font.PLAIN, 14));
	 			g.setColor(Color.orange); //设置表盘颜色
	 			g.fill3DRect(xcenter-50,ycenter-50,100,100,true); //画表盘
	 			g.setColor(Color.darkGray); //设置表盘数字颜色
				g.drawString("9",xcenter-45,ycenter+3); //画表盘上的数字
				g.drawString("3",xcenter+40,ycenter+3);
				g.drawString("12",xcenter-5,ycenter-37);
				g.drawString("6",xcenter-3,ycenter+45);
				//时间变化时，需要重新画各个指针，即先消除原有指针，然后画新指针
				g.setColor(Color.orange); //用表的填充色画线，可以消除原来画的线
				if (xs != lastxs || ys != lastys){ //秒针变化
				g.drawLine(xcenter, ycenter, lastxs, lastys); }
				if (xm != lastxm || ym != lastym) { //分针变化
					g.drawLine(xcenter, ycenter-1, lastxm, lastym);
					g.drawLine(xcenter-1, ycenter, lastxm, lastym); }
				if (xh != lastxh || yh != lastyh) { //时针变化
					g.drawLine(xcenter, ycenter-1, lastxh, lastyh);
					g.drawLine(xcenter-1, ycenter, lastxh, lastyh); }
				g.setColor(Color.red); //使用红色画新指针
				g.drawLine(xcenter, ycenter, xs, ys);
				g.drawLine(xcenter, ycenter-1, xm, ym);
				g.drawLine(xcenter-1, ycenter, xm, ym);
				g.drawLine(xcenter, ycenter-1, xh, yh);
				g.drawLine(xcenter-1, ycenter, xh, yh);
				lastxs=xs; lastys=ys; //保存指针位置
				lastxm=xm; lastym=ym;
				lastxh=xh; lastyh=yh; 
	            setBorder(new TitledBorder("时间")); 
	            setBackground(Color.white); // 定义颜色
	     }
	     public Date getDate()
	     {  
	         Date timeNow = new Date();  
	         return timeNow;  
	     }  
	     // 刷新图层  
	     public void update(Graphics g)
	     {  
	         paint(g);  
	     }  
	      // 画出一个帧的图像 
	     public void start() { //启动线程的方法
	 		if(timer == null) {
	 			timer = new Thread(this);
	 			timer.start(); 
	 		}
	 	 }
	 	 public void stop() //停止线程方法
	 	 {
	 		timer = null; 
	 	 }
	 	 public void run(){ //每隔一秒钟，刷新一次画面的方法
	 		 while (timer != null) 
	 		 {
	 			 try { Thread.sleep(1000); }
	 			 catch (InterruptedException e) {}
	 			 repaint(); //调用paint()方法重画时钟
	 		 }
	 		 timer = null; 
	 	 }
	 }  
	
	 //时钟
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
		       this.setBorder(new TitledBorder("时间日期"));
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
	
	//设计日历
	public class Calender extends JPanel implements ActionListener
	{
		  private static final long serialVersionUID = 1L;
		  public  final String HOUR_OF_DAY = null;
		  //定义
		  JComboBox Month = new JComboBox(); 
		  JComboBox Year = new JComboBox(); 
		  JLabel Year_l = new JLabel("年");
		  JLabel Month_l = new JLabel("月");  
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
			   //设定年月
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
			   //初始化日期并绘制
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
			   this.setBorder(new TitledBorder("日历"));
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
			   
			   int year_sel = Integer.parseInt(year_int) - 1900; //获得年份值
			   Date dt = new Date(year_sel, month_int, 1); //构造一个日期
			   GregorianCalendar cal = new GregorianCalendar(); //创建一个Calendar实例
			   cal.setTime(dt);
			   String week[] = { "日", "一","二", "三", "四", "五", "六" };
			   int day = 0;
			   int day_week = 0;
			   for (int i = 0; i < 7; i++) {
				   Label_day[i].setText(week[i]);
			   }
			   //月份
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
