package week_14;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.util.*;
import javax.swing.*;
public class BounceThread
{
   public static void main(String[] args)
   {
      JFrame frame = new BounceFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.show();
   }
}

class BounceFrame extends JFrame
{  
   static int i = 0;
	public BounceFrame()
   {
	  setSize(WIDTH, HEIGHT);
      setTitle("BounceThread");
      Container contentPane = getContentPane();
      canvas = new BallCanvas();
      contentPane.add(canvas, BorderLayout.CENTER);
      JPanel buttonPanel = new JPanel();
      addButton(buttonPanel, "Start",
         new ActionListener()
            {  
               public void actionPerformed(ActionEvent evt)
               {
                  addBall((i++)%4); //
               }
            });
      addButton(buttonPanel, "Close",
         new ActionListener()
            {
               public void actionPerformed(ActionEvent evt)
               {
                  System.exit(0);
               }
            });
      contentPane.add(buttonPanel, BorderLayout.SOUTH);
   } 

   public void addButton(Container c, String title,
      ActionListener listener)
   {
      JButton button = new JButton(title);
      c.add(button);
      button.addActionListener(listener);
   }

   public void addBall(int _id)
   {  Ball b1 = new Ball(canvas, _id);
      canvas.add(b1);
      BallThread thread1 = new BallThread(b1);
      thread1.start();
   }

   private BallCanvas canvas;
   public static final int WIDTH = 450;
   public static final int HEIGHT = 350;  
}

class BallThread extends Thread
{  
   public BallThread(Ball aBall) 
   {
	 b = aBall; 
   }
   public void run()
   {
      try
      {
         for (int i = 1; i <= 1000; i++)
         {
            b.move();
            sleep(5);
         }
      }
      catch (InterruptedException exception) { }
   }
   private Ball b;
}

class BallCanvas extends JPanel
{   
	public void add(Ball b)
   {
      balls.add(b);
      
   }
   public void paintComponent(Graphics g)
   {
      super.paintComponent(g);
      Graphics2D g2 = (Graphics2D)g;
  
      for (int i = 0; i < balls.size(); i++)
      {
         Ball b = (Ball)balls.get(i);
         b.draw(g2);
      }     
   }
   private ArrayList balls = new ArrayList();
}


class Ball
{  
   int id = 0;
   public Ball(Component c, int _id){ 
	   canvas = c; 
	   id = _id;
   } 
   public void draw(Graphics2D g2)
   {
      g2.fill(new Ellipse2D.Double(x, y, XSIZE, YSIZE));
      if(id == 0)g2.setColor(Color.orange); 
      else if(id == 1)g2.setColor(Color.cyan);
      else if(id == 2)g2.setColor(Color.blue);
      else g2.setColor(Color.green);  
   }  
   public void move()
   {
      x += dx;
      y += dy;
      if (x < 0)
      { 
         x = 0;
         dx = -dx;
      }
      if (x + XSIZE >= canvas.getWidth())
      {
         x = canvas.getWidth() - XSIZE; 
         dx = -dx; 
      }
      if (y < 0)
      {
         y = 0; 
         dy = -dy;
      }
      if (y + YSIZE >= canvas.getHeight())
      {
         y = canvas.getHeight() - YSIZE;
         dy = -dy; 
      }
      canvas.repaint();
   }
   private Component canvas;
   private static final int XSIZE = 15;
   private static final int YSIZE = 15;
   private int x = 0;
   private int y = 0;
   private int dx = 2;
   private int dy = 2;
}

