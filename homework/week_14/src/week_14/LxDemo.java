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
//	public void init(){ //��ʼ������
//		setBackground(Color.white); //����Applet ����
//		a=new Label("");
//		add(a);}
//	public void paint(Graphics g)  //��ʾ���ֺ�ͼ��ʱ�ӵķ���
//	{
//		int xh, yh, xm, ym, xs, ys, s, m, h, xcenter, ycenter;
//		Date rightnow = new Date(); //��ȡ��ǰ���ں�ʱ��
//		String today = rightnow.toLocaleString(); //ʱ���Ӧ���ַ���
//		a.setText(today); //��ʾ����ʱ��
//		s = rightnow.getSeconds();
//		m = rightnow.getMinutes();
//		h = rightnow.getHours();
//		xcenter=100; ycenter=80; //ͼ���ӵ�ԭ��
//		//���¼������롢���롢ʱ��λ��
//		xs = (int)(Math.cos(s * 3.14f/30 - 3.14f/2) * 45 + xcenter);
//		ys = (int)(Math.sin(s * 3.14f/30 - 3.14f/2) * 45 + ycenter);
//		xm = (int)(Math.cos(m * 3.14f/30 - 3.14f/2) * 40 + xcenter);
//		ym = (int)(Math.sin(m * 3.14f/30 - 3.14f/2) * 40 + ycenter);
//		xh = (int)(Math.cos((h*30+m/2)*3.14f/180-3.14f/2)*30+xcenter);
//		yh = (int)(Math.sin((h*30+m/2)*3.14f/180-3.14f/2)*30+ycenter);
//		g.setFont(new Font("TimesRoman", Font.PLAIN, 14));
//		g.setColor(Color.orange); //���ñ�����ɫ
//		g.fill3DRect(xcenter-50,ycenter-50,100,100,true); //������
//		g.setColor(Color.darkGray); //���ñ���������ɫ
//		g.drawString("9",xcenter-45,ycenter+3); //�������ϵ�����
//		g.drawString("3",xcenter+40,ycenter+3);
//		g.drawString("12",xcenter-5,ycenter-37);
//		g.drawString("6",xcenter-3,ycenter+45);
//		//ʱ��仯ʱ����Ҫ���»�����ָ�룬��������ԭ��ָ�룬Ȼ����ָ��
//		g.setColor(Color.orange); //�ñ�����ɫ���ߣ���������ԭ��������
//		if (xs != lastxs || ys != lastys){ //����仯
//		g.drawLine(xcenter, ycenter, lastxs, lastys); }
//		if (xm != lastxm || ym != lastym) { //����仯
//		g.drawLine(xcenter, ycenter-1, lastxm, lastym);
//		g.drawLine(xcenter-1, ycenter, lastxm, lastym); }
//		if (xh != lastxh || yh != lastyh) { //ʱ��仯
//		g.drawLine(xcenter, ycenter-1, lastxh, lastyh);
//		g.drawLine(xcenter-1, ycenter, lastxh, lastyh); }
//		g.setColor(Color.red); //ʹ�ú�ɫ����ָ��
//		g.drawLine(xcenter, ycenter, xs, ys);
//		g.drawLine(xcenter, ycenter-1, xm, ym);
//		g.drawLine(xcenter-1, ycenter, xm, ym);
//		g.drawLine(xcenter, ycenter-1, xh, yh);
//		g.drawLine(xcenter-1, ycenter, xh, yh);
//		lastxs=xs; lastys=ys; //����ָ��λ��
//		lastxm=xm; lastym=ym;
//		lastxh=xh; lastyh=yh; }
//	public void start() { //�����̵߳ķ���
//		if(timer == null) {
//			timer = new Thread(this);
//			timer.start(); 
//		}
//	}
//	public void stop() //ֹͣ�̷߳���
//	{
//		timer = null; 
//	}
//	public void run(){ //ÿ��һ���ӣ�ˢ��һ�λ���ķ���
//		while (timer != null) 
//		{
//			try { Thread.sleep(1000); }
//			catch (InterruptedException e) {}
//			repaint(); //����paint()�����ػ�ʱ��
//	    }
//		timer = null; 
//	}
//	public void update(Graphics g) //��д�÷�����Ϊ��������������
//	{
//		paint(g); 
//	}
//}
//
