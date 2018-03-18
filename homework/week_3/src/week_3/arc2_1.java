package week_3;

class Rect{	//定义矩阵类
	private double w,h;
	Rect(double w,double h){ //构造方法
		this.w = w;
		this.h = h;
	}
	Rect(Rect s){ //构造方法
		w = s.w;
		h = s.h;
	}
	double getW(){ //返回宽
		return w;
	}
	double getH(){ //返回高
		return h;
	}
	double area(){ //求面积
		return getW()*getH();
	}
}
public class arc2_1{ //测试类
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


