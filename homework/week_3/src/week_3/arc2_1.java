package week_3;

class Rect{	//���������
	private double w,h;
	Rect(double w,double h){ //���췽��
		this.w = w;
		this.h = h;
	}
	Rect(Rect s){ //���췽��
		w = s.w;
		h = s.h;
	}
	double getW(){ //���ؿ�
		return w;
	}
	double getH(){ //���ظ�
		return h;
	}
	double area(){ //�����
		return getW()*getH();
	}
}
public class arc2_1{ //������
	public static void main(String args[]){
		Rect s[] = new Rect[3];
		s[0] = new Rect(2,3);
		s[1] = new Rect(5,6);
		s[2] = new Rect(new Rect(7,8));
		for(int i= 0; i<s.length;i++){
		System.out.print("s["+i+"] area="+s[i].area());
		System.out.println(" wide ="+s[i].getW()+" high ="+s[i].getH());
		}
 	}
}


