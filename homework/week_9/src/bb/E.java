package bb;

import java.awt.*; 
import java.awt.event.*;
class WindowNull extends Frame 
{  WindowNull()                         //���캯��
   {  setLayout(null);
      MyButton button=new MyButton();  //������ť����
      Panel p=new Panel();   //�����������
      p.setLayout(null);     //�����������Ϊnull���� 
      p.setBackground(Color.cyan);  //���������������ɫ
      p.add(button);                //��Ӱ�ť�������
      button.setBounds(20,10,25,70);  //���ð�ť����������е�λ��
      add(p);                         //�����嵽������
      p.setBounds(50,50,90,100);      //��������ڴ����е�λ��
      setBounds(120,125,200,200);    //���ô�������Ļ��λ��
      setVisible(true);               //��Ϊ����
   }
}
class MyButton  extends Button implements ActionListener
{  int n=-1;
   MyButton()        //���캯��
   {  addActionListener(this);  //ע�ᰴť������
   }
   public void paint(Graphics g)  //����������дComponent  Button���е�paint()���� 
   {  g.drawString("��",6,16);  //������㴦���Ƶ������ַ�
      g.drawString("��",6,36);  
      g.drawString("��",6,56);
   }
   public void actionPerformed(ActionEvent e)  //�����ť�����¼�������
   {  n=(n+1)%3;
      if(n==0)
         setBackground(Color.red);       //���ð�ť����ɫ
      else if(n==1)
         setBackground(Color.yellow);
      else if(n==2)
         setBackground(Color.green);
   } 
}
public class E
{   public static void main(String args[])
    {  new WindowNull();  //����WindowNull��ʵ�����������Ĺ��캯����ʼ��
    }
}

