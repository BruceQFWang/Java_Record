package bb;

import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

/*
 * 1:���ý���ʱ�����ܻ�������һ����С��������������ʾһ���ϴ󲿷ֵ����ݵ��������ʱ
 * ����ʹ��JScrollPane���
 * 
 * 2:JScrollPane����Ǵ�����������壬��Ҳ��һ����壬����JScrollPaneֻ��
 * ����һ����������Ҳ�����ʹ�ò��ֹ�����
 * 
 * 3:�����Ҫ��JScrollPane����з��ö���������Ҫ��������������JPanel����ϣ�
 * Ȼ��JPanel��Ϊһ�����������ӵ�JScrollPane����ϡ�
 * 
 * 4:�ӱ�ʵ�����Եõ��ڴ����д���һ���������������ֱ༭����������Ҫ��ʼ���༭����
 * �����ڳ�ʼ��ʱ��ɱ������Ĵ�Сָ�����������������������ʱ�������������������
 * ����󽫴��������ı����������������м���
 * 
 */
public class Demo2 extends JFrame{
//������Ŀ�ݼ� shift+ctrl+o
    public Demo2(){//����һ�����췽��
        Container container=getContentPane();//����һ������

        //�����ı��������
        JTextArea ta=new JTextArea(20,50);

        //����JScrollPane()������,�����ı��������ӵ������
        JScrollPane sp=new JScrollPane(ta);

        //���������ӵ���������
        container.add(sp);
        for(int i = 0;i<10;i++)
	ta.append("Hello Java \n nice to meet you!!!!");
        //�����������ⲿ����
        setTitle("�������������ֱ༭��");//���ô��ڵı�������
        setSize(200,150);//���ô��ڵĴ�С
        setLocation(200,300);
        setVisible(true);//���ÿ��ӻ�
        //���ô��ڵĹرշ�ʽ
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {

	Demo2 jp=new Demo2();
    }
}
