package bb;

import java.applet.*;
import java.awt.*;
public class TestTextArea extends Applet{ 
TextArea text1,text2,text3,text4,text5;
public void init() {
//���������ı�����󣬳�ʼ�ַ���Ϊ�������û�����2��20��
 text1=new TextArea ("�������û�����",2,20);  
 text2=new TextArea (3, 30);//�����ı��������ı�������3 ��������30
 text3=new TextArea ("�����������Ϣ��",3, 20);
    text4=new TextArea (3, 30);
    text5=new TextArea ("��¼",3, 20);
    add(text1);add(text2);add(text3); add(text4);add(text5);//���5�������ı������Applet������
    text1.append("(Ӣ��)");   //���ı���1���������û����󸽼��ı�"(Ӣ��)"
    text5.insert("��ӭ��" , 1);  //���ı���5ָ��λ��1������"��ӭ��"�ַ���
  }   
}

