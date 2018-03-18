package bb;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;     //ChangeEvent属于Swing事件 
public class Demo3 implements ChangeListener {
	JFrame f = null;
	JSlider slider1;
	JSlider slider2;
	JSlider slider3;
	JLabel label1;
	JLabel label2;
	JLabel label3;

	public Demo3() {
		f = new JFrame("JSlider Example");
		Container contentPane = f.getContentPane();

		JPanel panel1 = new JPanel();
		panel1.setLayout(new GridLayout(2, 1));
		slider1 = new JSlider();// 建立一个默认的JSlider组件.
		label1 = new JLabel("目前刻度：" + slider1.getValue());
		panel1.add(label1);
		panel1.add(slider1);
		panel1.setBorder(BorderFactory.createTitledBorder(BorderFactory
				.createEtchedBorder(), "Slider 1", TitledBorder.LEFT,
				TitledBorder.TOP));

		JPanel panel2 = new JPanel();
		panel2.setLayout(new GridLayout(2, 1));
		/*
		 * 下面五行程序建立一个水平方向JSlider组件,并设置其取大值,最小值,初始值与延伸区值,所谓的延伸区值
		 * JScrollBar限制JSlider刻度可变动的范围,也就是说延伸区就像是一个障碍区,是无法通行的.延伸区
		 * 设得越大,刻度可变动的范围就越小
		 * .例如若minimum值设为0,maximan值设为100,而extent值设为0,则JSlider刻度可变动
		 * 的区域大小为100-50-0=50刻度(从0-50).
		 */
		slider2 = new JSlider(JSlider.HORIZONTAL);
		slider2.setMinimum(0);
		slider2.setMaximum(100);
		slider2.setValue(30);
		slider2.setExtent(50);
		label2 = new JLabel("目前刻度：" + slider2.getValue());
		panel2.add(label2);
		panel2.add(slider2);
		panel2.setBorder(BorderFactory.createTitledBorder(BorderFactory
				.createEtchedBorder(), "Slider 2", TitledBorder.LEFT,
				TitledBorder.TOP));

		JPanel panel3 = new JPanel();
		panel3.setLayout(new GridLayout(2, 1));
		// 下面两行建立一个具有最大最小值的JSlider组件,并设置此JSlider组件为垂直方向.
		slider3 = new JSlider(20, 80);
		slider3.setOrientation(JSlider.VERTICAL);
		label3 = new JLabel("目前刻度：" + slider3.getValue());
		panel3.add(label3);
		panel3.add(slider3);
		panel3.setBorder(BorderFactory.createTitledBorder(BorderFactory
				.createEtchedBorder(), "Slider 3", TitledBorder.LEFT,
				TitledBorder.TOP));

		slider1.addChangeListener(this);
		slider2.addChangeListener(this);
		slider3.addChangeListener(this);

		panel1.setPreferredSize(new Dimension(300, 100));
		panel2.setPreferredSize(new Dimension(300, 100));
		panel3.setPreferredSize(new Dimension(150, 200));

		GridBagConstraints c;
		int gridx, gridy, gridwidth, gridheight, anchor, fill, ipadx, ipady;
		double weightx, weighty;
		Insets inset;

		GridBagLayout gridbag = new GridBagLayout();
		contentPane.setLayout(gridbag);

		gridx = 0; // 第0行
		gridy = 0; // 第0列
		gridwidth = 2; // 占两单位宽度
		gridheight = 1; // 占一单位高度
		weightx = 0; // 窗口增大时组件宽度增大比率0
		weighty = 0; // 窗口增大时组件高度增大比率0
		anchor = GridBagConstraints.CENTER; // 容器大于组件size时将组件
		// 置于容器中央
		fill = GridBagConstraints.BOTH; // 窗口拉大时会填满水平与垂
		// 直空间
		inset = new Insets(0, 0, 0, 0); // 组件间间距
		ipadx = 0; // 组件内水平宽度
		ipady = 0; // 组件内垂直高度
		c = new GridBagConstraints(gridx, gridy, gridwidth, gridheight,
				weightx, weighty, anchor, fill, inset, ipadx, ipady);
		gridbag.setConstraints(panel1, c);
		contentPane.add(panel1);

		gridx = 0;
		gridy = 1;
		c = new GridBagConstraints(gridx, gridy, gridwidth, gridheight,
				weightx, weighty, anchor, fill, inset, ipadx, ipady);
		gridbag.setConstraints(panel2, c);
		contentPane.add(panel2);

		gridx = 2;
		gridy = 0;
		gridwidth = 1; // 占一单位宽度
		gridheight = 2; // 占两单位高度
		c = new GridBagConstraints(gridx, gridy, gridwidth, gridheight,
				weightx, weighty, anchor, fill, inset, ipadx, ipady);
		gridbag.setConstraints(panel3, c);
		contentPane.add(panel3);

		f.pack();
		f.setVisible(true);

		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	public static void main(String[] args) {
		new Demo3();
	}

	// 处理ChangeEvent事件,当用户移动滑动杆时,label上的值会随着用户的移动而改变.
	public void stateChanged(ChangeEvent e) {
		if ((JSlider) e.getSource() == slider1)
			label1.setText("目前刻度：" + slider1.getValue());
		if ((JSlider) e.getSource() == slider2)
			label2.setText("目前刻度：" + slider2.getValue());
		if ((JSlider) e.getSource() == slider3)
			label3.setText("目前刻度：" + slider3.getValue());
	}
}

