package bb;

import java.awt.*;
import java.awt.event.*;

public class Notepad extends WindowAdapter implements ActionListener, ItemListener 
{
	Frame fr;
	MenuBar mb;
	Choice c1, c2; 
	CheckboxGroup cg;
	TextField tex1, tex2; 
	Panel panel1, panel2;
	Checkbox cb1, cb2; //sex
	Panel panel21, panel22, panel23, panel24, panel25;
	Menu m1, m2, m3; // File, Edit, Help
	MenuItem m11, m31; // Exit, About
	List list; Dialog AboutDia;
	Button button1, button2;  //add,clear
	Checkbox chk41, chk42, chk43, chk44; //hobby
	public Notepad() {
		fr = new Frame("Notepad");
		mb = new MenuBar();
		m1 = new Menu("File");
		m2 = new Menu("Edit");
		m3 = new Menu("Help");
		m11 = new MenuItem("Exit");
		m11.addActionListener(this);
		m1.add(m11);
		m31 = new MenuItem("About");
		m31.addActionListener(this);
		m3.add(m31);
		AboutDia = new Dialog(fr, "About", true);
		AboutDia.setSize(250, 150);
		AboutDia.addWindowListener(this);
		mb.add(m1); mb.add(m2); mb.add(m3);
		
		panel1 = new Panel();
		panel1.setLayout(new GridLayout(1, 1));
		list = new List();
		panel1.add(list);
		
		panel2 = new Panel();
		panel2.setLayout(new GridLayout(5, 1));
		panel21 = new Panel();
		panel21.setLayout(new FlowLayout());
		panel21.add(new Label("编号"));
		tex1 = new TextField(3);
		tex1.setText("1");
		tex2 = new TextField(10);
		panel21.add(tex1);
		panel21.add(new Label("姓名"));
		panel21.add(tex2);
		panel22 = new Panel();
		panel22.setLayout(new FlowLayout());
		c1 = new Choice();
		c1.addItem("江苏省"); c1.addItem("四川省");
		c1.addItemListener(this);
		c2 = new Choice();
		c2.addItem("        ");
		panel22.add(new Label("省份"));
		panel22.add(c1);
		panel22.add(new Label("城市"));
		panel22.add(c2);
		panel23 = new Panel();
		panel23.setLayout(new FlowLayout());
		cg = new CheckboxGroup();
		cb1 = new Checkbox("男", cg, false);
		cb2 = new Checkbox("女", cg, false);
		panel23.add(new Label("性别"));
		panel23.add(cb1); panel23.add(cb2);
		panel24 = new Panel();
		panel24.setLayout(new FlowLayout());
		panel24.add(new Label("爱好"));
		chk41 = new Checkbox("体育", false);
		chk42 = new Checkbox("上网", false);
		chk43 = new Checkbox("音乐", false);
		chk44 = new Checkbox("影视", false);
		panel24.add(chk41); panel24.add(chk42);
		panel24.add(chk43); panel24.add(chk44);
		panel25 = new Panel();
		panel25.setLayout(new FlowLayout());
		button1 = new Button("添加");
		button1.addActionListener(this);
		button2 = new Button("清空");
		button2.addActionListener(this);
		panel25.add(button1); panel25.add(button2);
		panel2.add(panel21); panel2.add(panel22);
		panel2.add(panel23); panel2.add(panel24);
		panel2.add(panel25);
		
		fr.addWindowListener(this);
		fr.setLayout(new GridLayout(1, 2));
		fr.add(panel1); fr.add(panel2);
		fr.setMenuBar(mb);
		fr.setSize(600, 400);
		fr.setVisible(true);
	}
	public static void main(String []args) {
		Notepad t = new Notepad();
	}
	public void windowClosing(WindowEvent e) {
		if (e.getSource() == AboutDia)
			AboutDia.setVisible(false);
		else
			System.exit(0);
	}
	
	 public void itemStateChanged(ItemEvent e)
     { 
        String a = c1.getSelectedItem();
        c2.removeAll();
		if(a == "江苏省"){
			c2.addItem("南京");
			c2.addItem("苏州");
			c2.addItem("南通");
		}
		else{
			c2.addItem("成都");
			c2.addItem("绵阳");
			c2.addItem("乐山");
		}
     }
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == m11)
			System.exit(0);
		else if (e.getSource() == m31)
			AboutDia.setVisible(true);
		else if(e.getSource() == c1){
			
		}
		else if (e.getSource() == button1) {
			String s;
			s = tex1.getText() + " " + tex2.getText();
			s += " " + c1.getSelectedItem() + " " + c2.getSelectedItem();
			if (cb1.getState()) s += " " + cb1.getLabel();
			else s += " " + cb2.getLabel();
			if (chk41.getState()) s += " " + chk41.getLabel();
			if (chk42.getState()) s += " " + chk42.getLabel();
			if (chk43.getState()) s += " " + chk43.getLabel();
			if (chk44.getState()) s += " " + chk44.getLabel();
			list.add(s);
			tex1.setText(""+(Integer.parseInt(tex1.getText()) + 1));
		}
		else if (e.getSource() == button2)
			list.removeAll();
	}
}

