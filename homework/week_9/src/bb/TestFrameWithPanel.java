package bb;

import java.awt.*; 
public class TestFrameWithPanel 
{ 
	   public static void main(String args[]) 
	   {

	        Frame f = new Frame("My FrameWithPanel Test ");   //����������Ĵ��������������ʵ�� 
	      Panel pan = new Panel();   //�ڴ��������ϴ��������������        
	      f.setSize(180,100);        //���ZFrame������ڴ�С����p�ߣ�         
	      f.setBackground(Color.blue); //���ZFrame�������ɫΪ��ɫ 

	      f.setLayout(null);         // ȡ�����ֹ���������ͬʱ�������ں���������     
	      pan.setSize(100,60);      //���������С����p�ߣ� 

	      pan.setBackground(Color.green);  //���Z��������������ɫΪ��ɫ         
	      f.add(pan);                    //�ڴ��������������������������         
	      f.setVisible(true);              //���ZFrame���Ϊ����          
	    }
}
