package week_14;

import java.applet.Applet;
import java.awt.*;
import java.awt.image.MemoryImageSource;
import java.util.Random;
public class Fire2 extends Applet implements Runnable
{
	final int ITEM_COUNT = 10000;  // ������
	final int PIXEL_LIFE = 100;    // �������������ֵ
	private Thread thread;
	int[] particleLife;            // ������
	int[] particleColor;           // ������ɫ
	byte[] particleState;          // �����˶�״̬
	int[] liftPosX, liftPosY;      // ��������λ��
	double[] explodePosX, explodePosY;  // ��ը����λ��
	double[] vx, vy;               // ��ը���̵��ٶȷ���
	int scrWidth, scrHeight;       // ��Ļ���
	int[] pixels;                  // ��Ļ���أ�������ʾ���ӣ�
	int pixelCount;                // ��������
	MemoryImageSource offImage;    // ������ʾ���ӵ��ڴ�λͼ
	Image dbImage;                 // ������ʾ��ͼ��
	Graphics dispGraph;
	Image mapImage, dispImage;
	Random random;
	boolean isInited = false;
	public Fire2()
	{
		particleLife = new int[ITEM_COUNT];
		particleColor = new int[ITEM_COUNT];
		particleState = new byte[ITEM_COUNT];
		liftPosX = new int[ITEM_COUNT];
		liftPosY = new int[ITEM_COUNT];
		explodePosX = new double[ITEM_COUNT];
		explodePosY = new double[ITEM_COUNT];
		vx = new double[ITEM_COUNT];
		vy = new double[ITEM_COUNT];
		random = new Random();
		isInited = true;
	}	
	public void init()
	{
		particleLife = new int[ITEM_COUNT];
		particleColor = new int[ITEM_COUNT];
		particleState = new byte[ITEM_COUNT];
		liftPosX = new int[ITEM_COUNT];
		liftPosY = new int[ITEM_COUNT];
		explodePosX = new double[ITEM_COUNT];
		explodePosY = new double[ITEM_COUNT];
		vx = new double[ITEM_COUNT];
		vy = new double[ITEM_COUNT];		
		scrWidth = size().width;
		scrHeight = size().height;
		pixelCount = scrWidth * scrHeight;
		pixels = new int[pixelCount];// ����Ҫ����Ȼ�Ժ�Ĳ�������
		for (int i=0; i< pixelCount; ++i) 
		 pixels[i] = 0xff000000; 		
offImage = new MemoryImageSource(scrWidth, scrHeight, pixels, 0, scrWidth);
		offImage.setAnimated(true);
		dbImage = createImage(offImage);
		mapImage = getImage(getDocumentBase(), "smile.jpg");
		dispImage = createImage(scrWidth, scrHeight);
		dispGraph = dispImage.getGraphics();
	}	
	public void start()
	{
		if (thread == null) thread = new Thread(this);
		thread.start();
	}	
	public void stop()
	{
		if (thread != null){ 
			thread.stop();
			thread = null;
		}
	}
	public boolean mouseDown(Event e, int x, int y)
	{ //����һ������
		double speed;
		byte r, g, b;
		r = (byte)(Math.random() * 0xff);
		g = (byte)(Math.random() * 0xff);
		b = (byte)(Math.random() * 0xff);
		int color = r << 16 | g << 8 | b | 0xff000000;
		for (int i=0; i< ITEM_COUNT; ++i)
		{
			if (particleLife[i] != 0) continue;
			particleLife[i] = (int)(Math.random() * PIXEL_LIFE);
			speed = Math.random() * 6.28D;
			vx[i] = Math.cos(speed);
			vy[i] = Math.sin(speed);
			liftPosX[i] = x;
			liftPosY[i] = scrHeight - 5;
			explodePosX[i] = x;
			explodePosY[i] = y;
			particleColor[i] = color;
			particleState[i] = 1;
		}
		return true;
	}
	private void setPixel(int x, int y, int color)
{	// �����˶�����
		pixels[y * scrWidth + x] = color;
	}	
	private void moveParticles()
	{
		for (int i=0; i< ITEM_COUNT; ++i)
		{
			switch(particleState[i])
			{
		      case 1: // ���������˶�
				liftPosY[i] -= 5;
				if (liftPosY[i] <= explodePosY[i]) particleState[i] = 2;
				else if (Math.random() > 0.9)
				{
					int randX = (int)(Math.random() * 2.0); 
// ��������������ҡ��
					int randY = (int)(Math.random() * 5.0);
					setPixel(liftPosX[i] + randX, liftPosY[i] + randY, -1);	
				}
				break;
			  case 2: // ���ӱ�ը����
				particleLife[i] --;
				vy[i] += Math.random() / 20D; // ʹ�����ӵ��½���һ��
				vx[i] += Math.random() / 50D;
				explodePosX[i] += vx[i];
				explodePosY[i] += vy[i];
if (particleLife[i] == 0 || explodePosX[i] < 5 || explodePosX[i] > scrWidth - 5 || explodePosY[i] < 5 || explodePosY[i] > scrHeight - 5)
				{
					particleState[i] = 0;
					particleLife[i] = 0;
				}
else setPixel((int)explodePosX[i], (int)explodePosY[i], particleColor[i]);
				break;
			 default: break;
			}
		}
	}
	private void soften()
	{//ͼ���ữ
		byte avgR, avgG, avgB;
		int[] color = new int[9];
		for (int i=scrWidth + 1; i< pixelCount - scrWidth * 2; ++i)
		{
			int sumR = 0, sumG = 0, sumB = 0;
			color[0] = pixels[i-scrWidth-1];
			color[1] = pixels[i-scrWidth];
			color[2] = pixels[i-scrWidth+1];
			color[3] = pixels[i-1];
			color[4] = pixels[i];
			color[5] = pixels[i+1];
			color[6] = pixels[i+scrWidth-1];
			color[7] = pixels[i+scrWidth];
			color[8] = pixels[i+scrWidth+1];			
			for (int j=0; j< 9; ++j)
			{
				sumR += (color[j] & 0xff0000) >> 16;
				sumG += (color[j] & 0xff00) >> 8;
				sumB += color[j] & 0xff;
			}
			avgR = (byte)(sumR / 9);
			avgG = (byte)(sumG / 9);
			avgB = (byte)(sumB / 9);
			pixels[i] = 0xff000000 | avgR << 16 | avgG << 8 | avgB;
		}
	}
	public void run()
	{
		while (!isInited)
		{
			try 
			{ 
			  Thread.sleep(200);
			}
			catch (InterruptedException e){}
		}
		
		while (thread == Thread.currentThread())
		{
			soften();
			moveParticles();			
			offImage.newPixels(0, 0, scrWidth, scrHeight);
			try 
			{ 
			  Thread.sleep(10); 
			} catch (InterruptedException e){}
		}
	}	
	public void update(Graphics g)
	{
		paint(g);
	}
	public void paint(Graphics g)
	{
		dispGraph.drawImage(mapImage, 0, 0, this);
		dispGraph.drawImage(dbImage, 0, 0, this);
		g.drawImage(dispImage, 0, 0, this);
	}
}
