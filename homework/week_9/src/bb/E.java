package bb;

import java.awt.*; 
import java.awt.event.*;
class WindowNull extends Frame 
{  WindowNull()                         //构造函数
   {  setLayout(null);
      MyButton button=new MyButton();  //创建按钮对象
      Panel p=new Panel();   //创建面板容器
      p.setLayout(null);     //设置面板容器为null布局 
      p.setBackground(Color.cyan);  //设置面板容器背景色
      p.add(button);                //填加按钮到面板中
      button.setBounds(20,10,25,70);  //设置按钮在面板容器中的位置
      add(p);                         //添加面板到窗口中
      p.setBounds(50,50,90,100);      //设置面板在窗口中的位置
      setBounds(120,125,200,200);    //设置窗口在屏幕的位置
      setVisible(true);               //设为可视
   }
}
class MyButton  extends Button implements ActionListener
{  int n=-1;
   MyButton()        //构造函数
   {  addActionListener(this);  //注册按钮监听器
   }
   public void paint(Graphics g)  //在子类中重写Component  Button类中的paint()方法 
   {  g.drawString("单",6,16);  //在坐标点处绘制单击我字符
      g.drawString("击",6,36);  
      g.drawString("我",6,56);
   }
   public void actionPerformed(ActionEvent e)  //点击按钮产生事件处理方法
   {  n=(n+1)%3;
      if(n==0)
         setBackground(Color.red);       //设置按钮背景色
      else if(n==1)
         setBackground(Color.yellow);
      else if(n==2)
         setBackground(Color.green);
   } 
}
public class E
{   public static void main(String args[])
    {  new WindowNull();  //创建WindowNull类实例并调用它的构造函数初始化
    }
}

