package bb;

import java.awt.*;
import java.awt.event.*;
public class TestMultiListener implements MouseMotionListener, MouseListener {
	  Frame f = new Frame("���ؼ���������");   //�������ڿ�������������
	  TextField tf = new TextField(30);//�����ı�����󣬳���Ϊ30���ַ�
	  public TestMultiListener(){//������ؼ������췽��
		f.add(new Label("�밴�����������϶�"), "North");  //�ڴ�����������ӱ�ǩ
		f.add(tf, "South");//�ڴ�������������ı��򣨵ײ���
		f.setBackground(new Color(120,175,175));//���ô��ڱ���ɫ
//�ڴ���������ע��(���)����ƶ���������this������ʵ������ʵ�ֶ��ؼ���
		f.addMouseMotionListener(this);
//�ڴ���������ע��(���)����������this�����ڣ���ʵ�ֶ��ؼ���
		f.addMouseListener(this);
		f.setSize(300, 200);	//���ô���������С
 f.setVisible(true);//��Ϊ����
	  }
	 public static void main(String args[]) {   	
		TestMultiListener t = new TestMultiListener();//����TestMultiListener��Ķ���ʵ��
	  }   
public void mouseDragged(MouseEvent e) {//��������϶�����
		String s = "����϶���λ�ã�" + e.getX() + "," + e.getY() + ")"; //ȡ���������
		tf.setText(s); //�����ı�����ʾ����϶�����
	}
	public void mouseEntered(MouseEvent e) {//���������봰�巽��
		String s = "����ѽ��봰��";
		tf.setText(s);//�����ı�����ʾ����ѽ��봰���ַ���
	}
	public void mouseExited(MouseEvent e) { //��������˳����巽��
		String s = "������Ƴ�����";
		tf.setText(s);
	}
	public void mouseMoved(MouseEvent e) { }//����ƶ�����
	public void mousePressed(MouseEvent e) { } //��갴�·���
	public void mouseClicked(MouseEvent e) { }//���������
	public void mouseReleased(MouseEvent e) { }//����ͷ��������
}	
