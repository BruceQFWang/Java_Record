package bb;

import java.awt.*;
import java.awt.event.*;
import java.awt.Dialog;

public class MenuTest extends WindowAdapter implements ActionListener{
	Frame fr; 
	Dialog AboutDia;
	public void display() {
		fr=new Frame("Menu");
		MenuBar mb=new MenuBar();
		fr.setMenuBar(mb);
		fr.addWindowListener(this);
		Menu m1=new Menu("File");
		Menu m2=new Menu("Format");
		Menu m3=new Menu("Help");
		Menu m4=new Menu("进制");
		mb.add(m1);    		mb.add(m2);
		mb.setHelpMenu(m3);
		MenuItem m11 = new MenuItem("Exit");
		MenuItem m21=new MenuItem("中文");
		MenuItem m31 = new MenuItem("About");
		MenuItem m41=new MenuItem("二进制");
		MenuItem m42=new MenuItem("八进制");
		MenuItem m43=new MenuItem("十进制");
		m1.add(m11); m1.addActionListener(this);
		m2.add(m21); m2.add(m4);
		m3.add(m31); m3.addActionListener(this);
		m4.add(m41); m4.add(m42); m4.add(m43);
		fr.pack();
		fr.setSize(300,100); 
		fr.setLocation(100,100); 
		fr.setVisible(true);
		AboutDia = new Dialog(fr, "About", true);
		AboutDia.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {AboutDia.setVisible(false);}
		});
	}
	public static void main(String args[]) {
		(new MenuTest()).display();
	}
	public void windowClosing(WindowEvent e){
		System.exit(0);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "Exit") System.exit(0);
		else if (e.getActionCommand() == "About") {
			AboutDia.setVisible(true);
		}
	}
}
