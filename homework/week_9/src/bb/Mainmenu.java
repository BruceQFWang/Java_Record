package bb;

import java.awt.*;
import java.awt.event.*;
import javax.swing.JOptionPane;
public class Mainmenu implements ActionListener{
Frame f = new Frame("µÇÂ¼");
TextField id = new TextField(30);
TextField pw = new TextField(30);
Button b1=new Button("µÇÂ¼");
Button b2=new Button("Çå¿Õ");
public void display() {
f.setSize(320,200);
f.setLocation(500, 500);
f.setBackground(Color.gray);
pw.setEchoChar('*');
f.setLayout(new FlowLayout(FlowLayout.CENTER,5,10));
f.add(new Label("ÓÃ»§Ãû"));
f.add(id);
f.add(new Label("ÃÜÂë "));
f.add(pw);
f.add(b1);
f.add(b2);
b1.addActionListener(this);
b2.addActionListener(this);
f.addWindowListener(new WinClass());
f.setVisible(true);
} public void actionPerformed(ActionEvent e) {
if(e.getSource()==b2)
{
id.setText("");
pw.setText("");
} else
{
String str1 = id.getText();
String str2 = pw.getText();
if(str1.equals("admin")&&str2.equals("123456") )
JOptionPane.showMessageDialog(null, "¹§Ï²Äã£¬ µÇÂ½³É¹¦£¡ £¡ £¡ ");
else
JOptionPane.showMessageDialog(null, "µÇÂ½Ê§°Ü£¡ £¡ £¡ ");
}
} class WinClass extends WindowAdapter{
public void windowClosing(WindowEvent e) {
System.exit(0);
}
}
public static void main(String[] args) {
// TODO Auto-generated method stub
Mainmenu a = new Mainmenu();
a.display();
}
}
