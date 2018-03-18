package bb;

import java.applet.*;
import java.awt.*;
public class TestTextArea extends Applet{ 
TextArea text1,text2,text3,text4,text5;
public void init() {
//创建多行文本框对象，初始字符串为请输入用户名，2行20列
 text1=new TextArea ("请输入用户名：",2,20);  
 text2=new TextArea (3, 30);//创建文本区对象，文本框行是3 ，列数是30
 text3=new TextArea ("请输入个人信息：",3, 20);
    text4=new TextArea (3, 30);
    text5=new TextArea ("登录",3, 20);
    add(text1);add(text2);add(text3); add(text4);add(text5);//添加5个多行文本框对象到Applet容器中
    text1.append("(英文)");   //在文本区1的请输入用户名后附加文本"(英文)"
    text5.insert("欢迎你" , 1);  //在文本区5指定位置1处查入"欢迎你"字符串
  }   
}

