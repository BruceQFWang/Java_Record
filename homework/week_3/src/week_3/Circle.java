package week_3;

public class Circle
{ 	private float r;//����˽�б���Բ�뾶
	Circle (){}	//����չ��캯��
	Circle (float x) //����չ��캯������ʼ������ r��
	{r=x;}
	public void set_value(float x) //��ʼ��Բ�뾶��ֵ
	{ r=x; }
	public double mj() //��Բ���
	{ return(3.14*r*r); }
	public double zc() //��Բ�ܳ�
	{ 	double y;
		y=2*3.14*r;
		return(y);
	}
	public static void main(String args[])
	{ 	Circle ex1 = new Circle(), ex2 = new Circle();  //������ Circle ���󣨻������������ʼ��
		ex1.set_value(3.2f); //��ʼ�� Circle �����Բ�뾶��ֵ
		System.out.println("���="+ex1.mj()+"�ܳ�="+ex1.zc());
		ex2.set_value(5.5f); //������ Circle �������ð뾶Ϊ 5.5.
		System.out.println("���="+ex2.mj()+"�ܳ�="+ex2.zc());
	}
}
