//package week_14;
//
//import java.awt.Color;
//import java.util.*;
//import java.awt.*;
//import java.applet.*;
//public class LxDemo  extends Applet implements Runnable
//{
//	Thread timer = null;
//	Label a;
//	int lastxs=50, lastys=30, lastxm=50, lastym=30, lastxh=50, lastyh=30;
//	public void init(){ //初始化方法
//		setBackground(Color.white); //设置Applet 背景
//		a=new Label("");
//		add(a);}
//	public void paint(Graphics g)  //显示数字和图形时钟的方法
//	{
//		int xh, yh, xm, ym, xs, ys, s, m, h, xcenter, ycenter;
//		Date rightnow = new Date(); //获取当前日期和时间
//		String today = rightnow.toLocaleString(); //时间对应的字符串
//		a.setText(today); //显示数字时钟
//		s = rightnow.getSeconds();
//		m = rightnow.getMinutes();
//		h = rightnow.getHours();
//		xcenter=100; ycenter=80; //图形钟的原点
//		//以下计算秒针、分针、时针位置
//		xs = (int)(Math.cos(s * 3.14f/30 - 3.14f/2) * 45 + xcenter);
//		ys = (int)(Math.sin(s * 3.14f/30 - 3.14f/2) * 45 + ycenter);
//		xm = (int)(Math.cos(m * 3.14f/30 - 3.14f/2) * 40 + xcenter);
//		ym = (int)(Math.sin(m * 3.14f/30 - 3.14f/2) * 40 + ycenter);
//		xh = (int)(Math.cos((h*30+m/2)*3.14f/180-3.14f/2)*30+xcenter);
//		yh = (int)(Math.sin((h*30+m/2)*3.14f/180-3.14f/2)*30+ycenter);
//		g.setFont(new Font("TimesRoman", Font.PLAIN, 14));
//		g.setColor(Color.orange); //设置表盘颜色
//		g.fill3DRect(xcenter-50,ycenter-50,100,100,true); //画表盘
//		g.setColor(Color.darkGray); //设置表盘数字颜色
//		g.drawString("9",xcenter-45,ycenter+3); //画表盘上的数字
//		g.drawString("3",xcenter+40,ycenter+3);
//		g.drawString("12",xcenter-5,ycenter-37);
//		g.drawString("6",xcenter-3,ycenter+45);
//		//时间变化时，需要重新画各个指针，即先消除原有指针，然后画新指针
//		g.setColor(Color.orange); //用表的填充色画线，可以消除原来画的线
//		if (xs != lastxs || ys != lastys){ //秒针变化
//		g.drawLine(xcenter, ycenter, lastxs, lastys); }
//		if (xm != lastxm || ym != lastym) { //分针变化
//		g.drawLine(xcenter, ycenter-1, lastxm, lastym);
//		g.drawLine(xcenter-1, ycenter, lastxm, lastym); }
//		if (xh != lastxh || yh != lastyh) { //时针变化
//		g.drawLine(xcenter, ycenter-1, lastxh, lastyh);
//		g.drawLine(xcenter-1, ycenter, lastxh, lastyh); }
//		g.setColor(Color.red); //使用红色画新指针
//		g.drawLine(xcenter, ycenter, xs, ys);
//		g.drawLine(xcenter, ycenter-1, xm, ym);
//		g.drawLine(xcenter-1, ycenter, xm, ym);
//		g.drawLine(xcenter, ycenter-1, xh, yh);
//		g.drawLine(xcenter-1, ycenter, xh, yh);
//		lastxs=xs; lastys=ys; //保存指针位置
//		lastxm=xm; lastym=ym;
//		lastxh=xh; lastyh=yh; }
//	public void start() { //启动线程的方法
//		if(timer == null) {
//			timer = new Thread(this);
//			timer.start(); 
//		}
//	}
//	public void stop() //停止线程方法
//	{
//		timer = null; 
//	}
//	public void run(){ //每隔一秒钟，刷新一次画面的方法
//		while (timer != null) 
//		{
//			try { Thread.sleep(1000); }
//			catch (InterruptedException e) {}
//			repaint(); //调用paint()方法重画时钟
//	    }
//		timer = null; 
//	}
//	public void update(Graphics g) //重写该方法是为了消除抖动现象
//	{
//		paint(g); 
//	}
//}
//
