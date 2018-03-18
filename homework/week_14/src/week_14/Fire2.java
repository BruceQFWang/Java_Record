package week_14;

import java.applet.Applet;
import java.awt.*;
import java.awt.image.MemoryImageSource;
import java.util.Random;
public class Fire2 extends Applet implements Runnable
{
	final int ITEM_COUNT = 10000;  // 粒子数
	final int PIXEL_LIFE = 100;    // 粒子生命期最大值
	private Thread thread;
	int[] particleLife;            // 生命期
	int[] particleColor;           // 粒子颜色
	byte[] particleState;          // 粒子运动状态
	int[] liftPosX, liftPosY;      // 上升过程位置
	double[] explodePosX, explodePosY;  // 爆炸过程位置
	double[] vx, vy;               // 爆炸过程的速度分量
	int scrWidth, scrHeight;       // 屏幕宽高
	int[] pixels;                  // 屏幕像素（用来显示粒子）
	int pixelCount;                // 粒子数量
	MemoryImageSource offImage;    // 用来显示粒子的内存位图
	Image dbImage;                 // 用来显示的图像
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
		pixels = new int[pixelCount];// 很重要，不然以后的操作很慢
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
	{ //产生一簇粒子
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
{	// 粒子运动控制
		pixels[y * scrWidth + x] = color;
	}	
	private void moveParticles()
	{
		for (int i=0; i< ITEM_COUNT; ++i)
		{
			switch(particleState[i])
			{
		      case 1: // 粒子上升运动
				liftPosY[i] -= 5;
				if (liftPosY[i] <= explodePosY[i]) particleState[i] = 2;
				else if (Math.random() > 0.9)
				{
					int randX = (int)(Math.random() * 2.0); 
// 在上升过程制造摇晃
					int randY = (int)(Math.random() * 5.0);
					setPixel(liftPosX[i] + randX, liftPosY[i] + randY, -1);	
				}
				break;
			  case 2: // 粒子爆炸过程
				particleLife[i] --;
				vy[i] += Math.random() / 20D; // 使得粒子的下降不一样
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
	{//图像柔化
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
