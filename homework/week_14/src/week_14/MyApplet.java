package week_14;

import java.awt.*;
import java.util.*;
import java.awt.image.*;
import java.applet.*;


//Film����������ͼƬ����.
class Film extends Canvas implements Runnable {
	
	Thread move;
	Image thumb;
	int startPoint=0;		//��ʼλ��
	final int thumbWidth=23;	//СͼƬ�Ŀ��
	
	public Film(Image thumb){
		this.thumb=thumb;
		if (move==null){
			move=new Thread(this);
			move.start();
		}
	}
		
	public void run(){
		while(true){
			repaint();
			try{
				Thread.sleep(100);
			}catch(InterruptedException e){}
			startPoint-=1;		//������һλ
			startPoint%=thumbWidth;	//����СͼƬ��Ⱥ�ص���ʼ��
                } 	
	}

	public void paint(Graphics g){
		update(g);
	}
	
	public void update(Graphics g){
		int i;
		Dimension d=size();
		Image offImage=createImage(d.width,d.height);
		Graphics offG=offImage.getGraphics();
		
		offG.setColor(new Color(242,160,255));
		offG.fillRect(0,0,d.width,d.height);
		for (i=startPoint;i<=d.width;i+=thumbWidth)
			offG.drawImage(thumb,i,0,this);
		g.drawImage(offImage,0,0,this);
	}
	
}


//AudioPlayer�������ײ����ֲ��������࣮
class AudioPlayer extends Panel {
	
	AudioClip au;
	Button play,loop,stop;
	Label label;
	
		
	AudioPlayer(AudioClip au)
	{
		setLayout(new FlowLayout(FlowLayout.RIGHT ,10,5));
		add(play=new Button ("play"));
		add(loop=new Button ("loop"));
		add(stop=new Button ("stop"));
		
		this.au=au;
		setBackground(new Color (242,160,255));
	}

	public boolean action(Event e, Object p)
	{
		if (e.target ==play)
		{
			au.play ();
		}
		else if(e.target ==loop)
		{
			au.loop ();
		}
		else if(e.target ==stop)
		{
			au.stop ();
		}
			
							
		return super.action(e, p);
	}

}


//Calendar������������ʱ�ӵ��࣮
class Calendar extends Panel implements Runnable {
	
	Button nextYear, nextMonth, nextDate, lastYear, lastMonth, lastDate;
	TextField year, month, date;
	Film myFilm;
	Thread clock;
	AudioClip chirp;
	Date today=new Date();
	String weekName[]={"Sun","Mon","Tue","Wed","Thu","Fri","Sat"};
	String monthName[]={"һ��","����","����","����","����","����","����","����","����","ʮ��","ʮһ��","ʮ����"};
	int weekColor[]={0xcc6633,0xcccc33,0xcccc33,0xcccc33,0xcccc33,0xcccc33,0x3399cc};
	

	Calendar(Image thumb, AudioClip au){
		setLayout(new FlowLayout(FlowLayout.LEFT,3,13));
		add(lastYear=new Button("<"));
		add(year=new TextField(""+(1900+today.getYear()),4));
		add(nextYear=new Button(">"));
		add(lastMonth=new Button("<"));
		add(month=new TextField(""+(today.getMonth()+1),2));
		add(nextMonth=new Button(">"));
		add(lastDate=new Button("<"));
		add(date=new TextField(""+today.getDate(),2));
		add(nextDate=new Button(">"));
		
		myFilm=new Film(thumb);
		myFilm.resize(270,15);
		add(myFilm);
		
		chirp=au;
	}
   public void run(){
     long startTime=System.currentTimeMillis();	//��¼�߳̿�ʼ��ʱ��.
                                              
		while(true){
			repaint();
			startTime+=1000;	//�����´�������ʱ��.
			try{
				  Thread.sleep(Math.max(0,startTime-System.currentTimeMillis()));
     //��֤��ͼʱ���˯��ʱ�����Ϊһ��, ����ͼ����һ��,���̲߳�˯��.
			}catch(InterruptedException e){}
                }
        }

	public void paint(Graphics g){
		update(g);

	}
  

	public void update(Graphics g){

		int i,j;
		Dimension d=size();
		Image offImage=createImage(d.width,d.height);
		Graphics offG=offImage.getGraphics();
	
		//set the background color
		setBackground(new Color(242,160,255));
		offG.setColor(getBackground());
		offG.fillRect(0, 0, 500, 350);

		//draw calendar shadow
		offG.setColor(new Color(80,150,80));
		offG.fillRect(25,100,340,230);

		//draw calendar base
		offG.setColor(new Color(100,230,195));
		offG.fillRect(15,90,340,230);
		offG.setFont(new Font("Helvetica",Font.BOLD,20));
		for (i=0;i<=6;i++) {
			offG.setColor(Color.darkGray);
			offG.drawString(weekName[i],26+i*48,110);
			offG.setColor(Color.white);
			offG.drawString(weekName[i],24+i*48,108);
		}
		//draw author information
		offG.setColor(Color.gray);
		offG.drawString("12��������2��    ��˼��     2012914205",10,350);
		//draw vertical bars
	for (i=350; i>0; i-=10) {
	offG.setColor(new  Color(170+85*i/350,255,170+85*i/350));                                                                                                                  
		offG.fillRect(380,i,40,9);
		}

		//draw year
		offG.setColor(new Color(200,255,200));
		offG.setFont(new Font("Courier",Font.ITALIC,66));
		String yearString=""+(1900+today.getYear());
		for (j=0;j<=6;j+=2)
		for (i=0;i<=3;i++)
			           offG.drawString(yearString.substring(i,i+1),415+j,168+49*i);

		//draw horizontal bars
		offG.setColor(Color.black);
		offG.drawLine(6,60,250,60);
		offG.setColor(new Color(100,200,100));
		offG.drawLine(5,65,495,65);
		offG.drawLine(5,66,495,66);

		//draw circles
		offG.setColor(Color.black);
		offG.drawOval(560,5,120,120);
		offG.setColor(Color.black);
		offG.drawOval(570,15,100,100);
		
		//draw Month
		offG.setFont(new                 Font("Monospaced",Font.BOLD+Font.ITALIC,25));
		offG.setColor(Color.orange);
		offG.drawString(monthName[today.getMonth()],280,57);
		
		//draw date
		Font myFont=new Font("DialogInput",Font.BOLD,50);
		FontMetrics fontSize=getFontMetrics(myFont);
		offG.setFont(myFont);
		String temp=""+today.getDate();
		Color dateColor=new Color(weekColor[today.getDay()]);
		int x=380-fontSize.stringWidth(temp)/2;
		int y=59;
		offG.setColor(dateColor.brighter());
		offG.drawString(temp,x-1,y-1);
		offG.setColor(dateColor.darker());
		offG.drawString(temp,x+1,y+1);
		offG.setColor(dateColor);
		offG.drawString(temp,x,y);
		
		//draw clock
		offG.setColor(Color.black);
		offG.drawOval(560,60,10,10);	//9��
		offG.drawOval(670,60,10,10);	//3��
		offG.drawOval(615,5,10,10);	//12��
		offG.drawOval(615,115,10,10);	//6��
		offG.drawOval(571,36,5,5);	//10��
		offG.drawOval(591,16,5,5);	//11��
		offG.drawOval(644,16,5,5);	//1��
		offG.drawOval(663,36,5,5);	//2��
		offG.drawOval(663,89,5,5);	//4��
		offG.drawOval(644,109,5,5);	//5��
		offG.drawOval(591,109,5,5);	//7��
		offG.drawOval(571,89,5,5);	//8��
		Date now=new Date();
		double hour=now.getHours()+now.getMinutes()/60.;
		double minute=now.getMinutes()+now.getSeconds()/60.;
		double second=now.getSeconds();
		offG.setColor(Color.black);
		offG.drawLine(620,65,(int)(620+30*Math.sin(hour*Math.PI/6)),(int)(65-30*Math.cos(hour*Math.PI/6)));
		offG.drawLine(620,65,(int)(620+45*Math.sin(minute*Math.PI/30)),(int)(65-45*Math.cos(minute*Math.PI/30)));
		offG.setColor(Color.black);
		offG.drawLine(620,65,(int)(620+48*Math.sin(second*Math.PI/30)),(int)(65-48*Math.cos(second*Math.PI/30)));

		//draw calendar dates
		boolean raised;
		offG.setFont(new Font("Serif",Font.PLAIN,15));
		Date newDay=new Date(today.getYear(),today.getMonth(),1);
	newDay.setDate(1-newDay.getDay());//�ҳ��������Ͻǵ�����
		for (j=0;j<=5;j++) {
			for (i=0;i<=6;i++) {
				offG.setColor(new Color(220,255,165));
				if (today.getDate()!=newDay.getDate() || today.getMonth()!=newDay.getMonth())
				raised=true;	//��������,��ť�ϸ�
				else
				raised=false;	//��ǰ����,��ť�³�
				           offG.fill3DRect(17+i*48,114+j*34,48,34,raised);
			if (today.getMonth()==newDay.getMonth())
		offG.setColor(Color.black);	//��������,��ɫ
			else
			offG.setColor(Color.black);	//��������,ǳɫ
				           offG.drawString(""+newDay.getDate(),20+i*48,129+j*34);
				newDay.setDate(newDay.getDate()+1);
			}
		}
		
		g.drawImage(offImage,0,0,this);
	}


	public boolean action(Event evt, Object arg){
		if (evt.target.equals(lastYear)) {	//��һ��
			today.setYear(today.getYear()-1);
			repaint();
		}
		if (evt.target.equals(nextYear)) {	//��һ��
			today.setYear(today.getYear()+1);
			repaint();
		}
		if (evt.target.equals(lastMonth)) {	//�ϸ���
			today.setMonth(today.getMonth()-1);
			repaint();
		}
		if (evt.target.equals(nextMonth)) {	//�¸���
			today.setMonth(today.getMonth()+1);
			repaint();
		}
		if (evt.target.equals(lastDate)) {	//ǰһ��
			today.setDate(today.getDate()-1);
			repaint();
		}
		if (evt.target.equals(nextDate)) {	//��һ��
			today.setDate(today.getDate()+1);
			repaint();
		}
		setDateText();
		return true;	
	}
	
	public boolean mouseDown(Event evt, int x, int y){
	 if (x>16 && x<354 && y>113 && y<319) {
		Date newDay=new                                  Date(today.getYear(),today.getMonth(),1);
		newDay.setDate(1-newDay.getDay());
		int Column=(int)(x-17)/48;//��������������һ��
		int Row=(int)(y-114)/34;//��������������һ��
		newDay.setDate(newDay.getDate()+Row*7+Column);
		today=new Date(newDay.getTime());
		chirp.play();			//����
		setDateText();
		repaint();
		return true;
		}
		return false;
	}
	
	public boolean lostFocus(Event evt, Object what){
		int num;
		try{
			if (evt.target.equals(year)) {
				num=Integer.valueOf(year.getText()).intValue();
				if (num!=today.getYear() && num>=1000 && num<=9999) {
					today.setYear(num-1900);
					repaint();
				}
			}
			if (evt.target.equals(month)) {
				num=Integer.valueOf(month.getText()).intValue();
				if (num!=today.getMonth() && num>=1 && num<=12) {
					today.setMonth(num-1);
					repaint();
				}
			}
			if (evt.target.equals(date)) {
				num=Integer.valueOf(date.getText()).intValue();
				if (num!=today.getDate()) {
					Date newDay=new Date(today.getTime());
					newDay.setDate(num);
					if (newDay.getMonth()==today.getMonth()) {
						today.setDate(num);
						repaint();
					}
				}
			}
	}catch(NumberFormatException e){	//����Ĳ�������
		}
		setDateText();	//���벻�Ϸ�,��������Ϊԭֵ
		return true;
	}
	
    public boolean keyDown(Event evt, int key) {
	if (key==10) return(lostFocus(evt, evt.arg)); //���˻س���
	else return (super.keyDown(evt,key));
	}
	
	
	void setDateText(){
		year.setText(""+(1900+today.getYear()));
		month.setText(""+(today.getMonth()+1));
		date.setText(""+today.getDate());
	}
	
}


public class MyApplet extends Applet{
	Calendar calendar;
	AudioPlayer audioPlayer;
	
	public void init() {
		String auname=getParameter("auname");
		if (auname==null)
		{
			auname="ding.au";
		}
		AudioClip au=getAudioClip(getCodeBase(),auname); 
		audioPlayer=new AudioPlayer(au);
		
		Image thumb=getImage(getCodeBase(),"thumb.gif");
		au=getAudioClip(getCodeBase(),"chirp.au");
		calendar=new Calendar(thumb,au);
		
		setLayout(new BorderLayout());
		add("Center",calendar);
		add("South",audioPlayer);
	}
	
	
	public void start(){
		if (calendar.myFilm.move==null){
		calendar.myFilm.move=new Thread(calendar.myFilm);
			calendar.myFilm.move.start();
		}
		if (calendar.clock==null) {
			calendar.clock=new Thread(calendar);
			calendar.clock.start();
		}
	}

	public void stop(){
		calendar.myFilm.move.stop();
		calendar.myFilm.move=null;
		
		calendar.clock.stop();
		calendar.clock=null;
	}
	
	public void destroy()
	{
		audioPlayer.au.stop ();
		super.destroy();
	}
}
