package bb;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;


class primary_draw implements Serializable//父类，基本图形单元，用到串行化接口，保存时所用
{
    int x1, y1, x2, y2; //定义坐标属性
    int R, G, B;        //定义色彩属性
    float stroke;       //定义线条粗细属性
    int type;       //定义字体属性
    String s1;
    String s2;      //定义字体风格属性
    void draw(Graphics2D g2d) {
    }
    ;//定义绘图函数
}


//下面是各种基本图形单元的子类，都继承自父类primary_draw
class Pencil extends primary_draw//随笔画类
{
    void draw(Graphics2D g2d) {
        g2d.setPaint(new Color(R, G, B));
        g2d.setStroke(new BasicStroke(stroke,
                BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL));
        g2d.drawLine(x1, y1, x2, y2);
    }
}

class Line extends primary_draw //直线类
{
    void draw(Graphics2D g2d) {
        g2d.setPaint(new Color(R, G, B));
        g2d.setStroke(new BasicStroke(stroke,
                BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL));
        g2d.drawLine(x1, y1, x2, y2);
    }
}
class Rect extends primary_draw//矩形类
{
    void draw(Graphics2D g2d) {
        g2d.setPaint(new Color(R, G, B));
        g2d.setStroke(new BasicStroke(stroke));
        g2d.drawRect(Math.min(x1, x2), Math.min(y1, y2),
                Math.abs(x1 - x2), Math.abs(y1 - y2));
    }
}
class fillRect extends primary_draw//实心矩形类
{
    void draw(Graphics2D g2d) {
        g2d.setPaint(new Color(R, G, B));
        g2d.setStroke(new BasicStroke(stroke));
        g2d.fillRect(Math.min(x1, x2), Math.min(y1, y2),
                Math.abs(x1 - x2), Math.abs(y1 - y2));
    }
}

class Circle extends primary_draw//圆类
{
    void draw(Graphics2D g2d) {
        g2d.setPaint(new Color(R, G, B));
        g2d.setStroke(new BasicStroke(stroke));
        g2d.drawOval(Math.min(x1, x2), Math.min(y1, y2),
                Math.max(Math.abs(x1 - x2), Math.abs(y1 - y2)),
                Math.max(Math.abs(x1 - x2), Math.abs(y1 - y2)));
    }
}
class fillCircle extends primary_draw//实心圆
{
    void draw(Graphics2D g2d) {
        g2d.setPaint(new Color(R, G, B));
        g2d.setStroke(new BasicStroke(stroke));
        g2d.fillOval(Math.min(x1, x2), Math.min(y1, y2),
                Math.max(Math.abs(x1 - x2), Math.abs(y1 - y2)),
                Math.max(Math.abs(x1 - x2), Math.abs(y1 - y2)));
    }
}

class Oval extends primary_draw//椭圆类
{
    void draw(Graphics2D g2d) {
        g2d.setPaint(new Color(R, G, B));
        g2d.setStroke(new BasicStroke(stroke));
        g2d.drawOval(Math.min(x1, x2), Math.min(y1, y2),
                Math.abs(x1 - x2), Math.abs(y1 - y2));
    }
}

class fillOval extends primary_draw//实心椭圆
{
    void draw(Graphics2D g2d) {
        g2d.setPaint(new Color(R, G, B));
        g2d.setStroke(new BasicStroke(stroke));
        g2d.fillOval(Math.min(x1, x2), Math.min(y1, y2),
                Math.abs(x1 - x2), Math.abs(y1 - y2));
    }
}

class RoundRect extends primary_draw//圆角矩形类
{
    void draw(Graphics2D g2d) {
        g2d.setPaint(new Color(R, G, B));
        g2d.setStroke(new BasicStroke(stroke));
        g2d.drawRoundRect(Math.min(x1, x2), Math.min(y1, y2),
                Math.abs(x1 - x2), Math.abs(y1 - y2),
                50, 35);
    }
}

class fillRoundRect extends primary_draw//实心圆角矩形类
{
    void draw(Graphics2D g2d) {
        g2d.setPaint(new Color(R, G, B));
        g2d.setStroke(new BasicStroke(stroke));
        g2d.fillRoundRect(Math.min(x1, x2), Math.min(y1, y2),
                Math.abs(x1 - x2), Math.abs(y1 - y2),
                50, 35);
    }
}



class Rubber extends primary_draw//橡皮擦类
{
    void draw(Graphics2D g2d) {
        g2d.setPaint(new Color(255, 255, 255));
        g2d.setStroke(new BasicStroke(stroke + 4,
                BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL));
        g2d.drawLine(x1, y1, x2, y2);
    }
}

class Word extends primary_draw//输入文字类
{
    void draw(Graphics2D g2d) {
        g2d.setPaint(new Color(R, G, B));
        g2d.setFont(new Font(s2, x2 + y2, ((int) stroke) * 18));
        if (s1 != null) {
            g2d.drawString(s1, x1, y1);
        }
    }
}

//定义画图的基本图形单元
public class MyDrawPad extends JFrame //主类，扩展了JFrame类，用来生成主界面
{
    JToolBar buttonPanel;              //定义按钮面板
    private JLabel statusBar;            //显示鼠标状态的提示条
    private DrawPanel drawingArea;       //画图区域
    private int width = 800,  height = 550;    //定义画图区域初始大小
    primary_draw[] drawlist = new primary_draw[5000]; //用来存放基本图形的数组
    private int currentChoice = 3;            //设置默认画图状态为随笔画
    int index = 0;                         //当前已经绘制的图形数目
    private Color color = Color.black;     //当前画笔颜色
    int R, G, B;                           //用来存放当前色彩值
    int f1, f2;                  //用来存放当前字体风格
    String style1;              //用来存放当前字体
    private float thickness = 1.0f;  //设置画笔粗细，默认值为1.0f
    JCheckBox bold, italic;   //bold为粗体，italic为斜体，二者可以同时使用
    JComboBox styles, wordsize;
    Panel pan1, pan2, pan;
	
	private ObjectInputStream input;
    private ObjectOutputStream output; //定义输入输出流，用来调用和保存图像文件
    private JButton choices[];         //按钮数组，存放以下名称的功能按钮
    private String names[] = {
        "新建",              
        "打开",
        "保存", 
        "铅笔", 
        "直线", 						
        "空心矩形",					
        "实心矩形", 
        "空心椭圆", 					
        "实心椭圆", 
        "圆形",                                                                    
        "实心圆形",				
        "空心圆角矩形",      			
        "实心圆角矩形", 		
        "橡皮擦",         
        "选择颜色",              
        "粗细", 
        "文字"   	
    };
    private String tipText[] = {
            //这里是鼠标移动到相应按钮上面上停留时给出的提示说明条
            //读者可以参照上面的按钮定义对照着理解
            "绘制新的图形",
            "打开保存的图形",
            "保存当前",
            "铅笔",
            "绘制直线",
            "绘制空心矩形",
            "绘制实心矩形",
            "绘制空心椭圆",
            "绘制空实心椭圆",
            "绘制空心圆",
            "绘制实心圆",
            "绘制空心圆角矩形",
            "绘制实心圆角矩形",
            "橡皮擦",
            "选择当前绘制颜色",
            "设置粗细",
            "文字"
        };
    private String styleNames[] = {
        " 微软雅黑 ", " 等线 ", " 楷体 ", " 宋体 ", " 仿宋 ",
        " 隶书 ", " Times New Roman ", " Consolas ", " Italic ",
        " Technic ", " Garamond ", ""
    };            //可供选择的字体项
    private String thickNames[] = {
            " 一号 ", " 二号 ", " 三号 ", " 四号 ", " 五号 ",
            " 六号 ", " 七号 "
        };            //可供选择的字体项
    //当然这里的灵活的结构可以让读者自己随意添加系统支持的字体
    private Icon items[];
    
    
    
    public MyDrawPad() //构造函数
    {
        super("Drawing Pad");
        JMenuBar bar = new JMenuBar();      //定义菜单条
        JMenu fileMenu = new JMenu("文件");
        fileMenu.setMnemonic('F');
//新建文件菜单条
        JMenuItem newItem = new JMenuItem("新建");
        newItem.setMnemonic('N');
        newItem.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        newFile();      //如果被触发，则调用新建文件函数段
                    }
                });
        fileMenu.add(newItem);
//保存文件菜单项
        JMenuItem saveItem = new JMenuItem("保存");
        saveItem.setMnemonic('S');
        saveItem.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        saveFile();     //如果被触发，则调用保存文件函数段
                    }
                });
        fileMenu.add(saveItem);
        //打开文件菜单项
        JMenuItem loadItem = new JMenuItem("加载");
        loadItem.setMnemonic('L');
        loadItem.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        loadFile();     //如果被触发，则调用打开文件函数段
                    }
                });
        fileMenu.add(loadItem);
        fileMenu.addSeparator();
//退出菜单项
        JMenuItem exitItem = new JMenuItem("退出");
        exitItem.setMnemonic('X');
        exitItem.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        System.exit(0); //如果被触发，则退出画图板程序
                    }
                });
        fileMenu.add(exitItem);
        bar.add(fileMenu);
//设置提示菜单条
        JMenu helpMenu = new JMenu("帮助");
        helpMenu.setMnemonic('H');
//设置提示菜单项
        JMenuItem aboutItem = new JMenuItem("关于");
        aboutItem.setMnemonic('A');
        aboutItem.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        JOptionPane.showMessageDialog(null,
                                "This is a  drawing pad!/nCopyright (c) 2017 SWJTU University ",
                                " 画图板程序说明 ",
                                JOptionPane.INFORMATION_MESSAGE);
                    }
                });
        helpMenu.add(aboutItem);
        bar.add(helpMenu);
        items = new ImageIcon[names.length];
        
//创建各种基本图形的按钮
        drawingArea = new DrawPanel();
        pan = new Panel();
        pan1 = new Panel();
        pan2 = new Panel();
        pan.setLayout(new GridLayout(2, 1));
        pan1.setLayout(new GridLayout(9, 1));
        pan2.setLayout(new GridLayout(1, 1));
        choices = new JButton[names.length];
        //buttonPanel = new JToolBar(JToolBar.VERTICAL);
        buttonPanel = new JToolBar(JToolBar.HORIZONTAL);
        ButtonHandler handler = new ButtonHandler();
        ButtonHandler1 handler1 = new ButtonHandler1();
//导入我们需要的图形图标，这些图标都存放在与源文件相同的目录下面
        for (int i = 0; i < choices.length; i++) {
            //如果在jbuilder下运行本程序，则应该用这条语句导入图片
            items[i] = new ImageIcon("image/"+names[i] + ".jpg");
            //默认的在jdk或者jcreator下运行，用此语句导入图片
            choices[i] = new JButton("", items[i]);
            choices[i].setToolTipText(tipText[i]);
            if(i<=3 || i>=13)buttonPanel.add(choices[i]);
            else pan1.add(choices[i]);
        }
//将动作侦听器加入按钮里面
        for (int i = 3; i < choices.length - 3; i++) {
            choices[i].addActionListener(handler);
        }
        choices[0].addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        newFile();
                    }
                });
        choices[1].addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        loadFile();
                    }
                });
        choices[2].addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        saveFile();
                    }
                });
        choices[choices.length - 3].addActionListener(handler1);
        choices[choices.length - 2].addActionListener(handler1);
        choices[choices.length - 1].addActionListener(handler1);
//字体风格选择
        styles = new JComboBox(styleNames);
        styles.setMaximumRowCount(8);
        styles.addItemListener(
                new ItemListener() {
                    public void itemStateChanged(ItemEvent e) {
                        style1 = styleNames[styles.getSelectedIndex()];
                    }
                });
        wordsize = new JComboBox(thickNames);
        wordsize.setMaximumRowCount(4);
        wordsize.addItemListener(
                new ItemListener() {
                    public void itemStateChanged(ItemEvent e) {
                        thickness = 7.0f-wordsize.getSelectedIndex();
                    }
                });
//字体选择
        bold = new JCheckBox("粗细");
        italic = new JCheckBox("斜体");
        checkBoxHandler cHandler = new checkBoxHandler();
        bold.addItemListener(cHandler);
        italic.addItemListener(cHandler);
        JPanel wordPanel = new JPanel();
        buttonPanel.add(bold);
        buttonPanel.add(italic);
        buttonPanel.add(styles);
        buttonPanel.add(wordsize);
        styles.setMinimumSize(new Dimension(50, 20));
        styles.setMaximumSize(new Dimension(100, 20));
        wordsize.setMinimumSize(new Dimension(30, 20));
        wordsize.setMaximumSize(new Dimension(65, 20));
        Container c = getContentPane();
        super.setJMenuBar(bar);
        c.add(buttonPanel, BorderLayout.NORTH);
        pan.add(pan1);  pan.add(pan2);
        pan.setPreferredSize(new Dimension(30, 200));
        c.add(pan, BorderLayout.WEST);
        c.add(drawingArea, BorderLayout.CENTER);
        statusBar = new JLabel();
        c.add(statusBar, BorderLayout.SOUTH);
        statusBar.setText("     Welcome To The  Drawing Pad!!!  :)");
        createNewItem();
        setSize(width, height);
        show();
    }
//按钮侦听器ButtonHanler类，内部类，用来侦听基本按钮的操作
    public class ButtonHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (int j = 3; j < choices.length - 3; j++) {
                if (e.getSource() == choices[j]) {
                    currentChoice = j;
                    createNewItem();
                    repaint();
                }
            }
        }
    }
//按钮侦听器ButtonHanler1类，用来侦听颜色选择、画笔粗细设置、文字输入按钮的操作
    public class ButtonHandler1 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == choices[choices.length - 3]) {
                chooseColor();
            }
            if (e.getSource() == choices[choices.length - 2]) {
                setStroke();
            }
            if (e.getSource() == choices[choices.length - 1]) {
                JOptionPane.showMessageDialog(null,
                        "点击画板选择键入文字的位置",
                        "Hint", JOptionPane.INFORMATION_MESSAGE);
                currentChoice = 14;
                createNewItem();
                repaint();
            }
        }
    }
//鼠标事件mouseA类，继承了MouseAdapter，用来完成鼠标相应事件操作
    class mouseA extends MouseAdapter {
        public void mousePressed(MouseEvent e) {
            statusBar.setText("     Mouse Pressed at(" + e.getX() +
                    ", " + e.getY() + ")");//设置状态提示
            drawlist[index].x1 = drawlist[index].x2 = e.getX();
            drawlist[index].y1 = drawlist[index].y2 = e.getY();
            //如果当前选择的图形是随笔画或者橡皮擦，则进行下面的操作
            if (currentChoice == 3 || currentChoice == 13) {
            	drawlist[index].x1 = drawlist[index].x2 = e.getX();
            	drawlist[index].y1 = drawlist[index].y2 = e.getY();
                index++;
                createNewItem();
            }
            //如果当前选择的图形式文字输入，则进行下面操作
            if (currentChoice == 14) {
            	drawlist[index].x1 = e.getX();
            	drawlist[index].y1 = e.getY();
                String input;
                input = JOptionPane.showInputDialog(
                        "请输入文字!");
                drawlist[index].s1 = input;
                drawlist[index].x2 = f1;
                drawlist[index].y2 = f2;
                drawlist[index].s2 = style1;
                drawlist[index].stroke = thickness;
                index++;
                currentChoice = 14;
                createNewItem();
                drawingArea.repaint();
            }
        }
        public void mouseReleased(MouseEvent e) {
            statusBar.setText("     Mouse Released at(" + e.getX() +
                    ", " + e.getY() + ")");
            if (currentChoice == 3 || currentChoice == 13) {
            	drawlist[index].x1 = e.getX();
            	drawlist[index].y1 = e.getY();
            }
            drawlist[index].x2 = e.getX();
            drawlist[index].y2 = e.getY();
            repaint();
            index++;
            createNewItem();
        }
        public void mouseEntered(MouseEvent e) {
            statusBar.setText("     Mouse Entered at(" + e.getX() +
                    ", " + e.getY() + ")");
        }
        public void mouseExited(MouseEvent e) {
            statusBar.setText("     Mouse Exited at(" + e.getX() +
                    ", " + e.getY() + ")");
        }
    }
//鼠标事件mouseB类继承了MouseMotionAdapter，用来完成鼠标拖动和鼠标移动时的相应操作
    class mouseB extends MouseMotionAdapter {
        public void mouseDragged(MouseEvent e) {
            statusBar.setText("     Mouse Dragged at(" + e.getX() +
                    ", " + e.getY() + ")");
            if (currentChoice == 3 || currentChoice == 13) {
            	drawlist[index - 1].x1 = drawlist[index].x2 = drawlist[index].x1 = e.getX();
            	drawlist[index - 1].y1 = drawlist[index].y2 = drawlist[index].y1 = e.getY();
                index++;
                createNewItem();
            } else {
            	drawlist[index].x2 = e.getX();
            	drawlist[index].y2 = e.getY();
            }
            repaint();
        }
        public void mouseMoved(MouseEvent e) {
            statusBar.setText("     Mouse Moved at(" + e.getX() +
                    ", " + e.getY() + ")");
        }
    }
//选择字体风格时候用到的事件侦听器类，加入到字体风格的选择框中
    private class checkBoxHandler implements ItemListener {
        public void itemStateChanged(ItemEvent e) {
            if (e.getSource() == bold) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    f1 = Font.BOLD;
                } else {
                    f1 = Font.PLAIN;
                }
            }
            if (e.getSource() == italic) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    f2 = Font.ITALIC;
                } else {
                    f2 = Font.PLAIN;
                }
            }
        }
    }
//画图面板类，用来画图
    class DrawPanel extends JPanel {
        public DrawPanel() {
            setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
            setBackground(Color.white);
            addMouseListener(new mouseA());
            addMouseMotionListener(new mouseB());
        }
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;    //定义画笔
            int j = 0;
            while (j <= index) {
                draw(g2d, drawlist[j]);
                j++;
            }
        }
        void draw(Graphics2D g2d, primary_draw i) {
            i.draw(g2d);//将画笔传入到各个子类中，用来完成各自的绘图
        }
    }
//新建一个画图基本单元对象的程序段
    void createNewItem() {
        if (currentChoice == 14)//进行相应的游标设置
        {
            drawingArea.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
        } else {
            drawingArea.setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
        }
        switch (currentChoice) {
            case 3:
            	drawlist[index] = new Pencil();
                break;
            case 4:
            	drawlist[index] = new Line();
                break;
            case 5:
            	drawlist[index] = new Rect();
                break;
            case 6:
            	drawlist[index] = new fillRect();
                break;
            case 7:
            	drawlist[index] = new Oval();
                break;
            case 8:
            	drawlist[index] = new fillOval();
                break;
            case 9:
            	drawlist[index] = new Circle();
                break;
            case 10:
            	drawlist[index] = new fillCircle();
                break;
            case 11:
            	drawlist[index] = new RoundRect();
                break;
            case 12:
            	drawlist[index] = new fillRoundRect();
                break;
            case 13:
            	drawlist[index] = new Rubber();
                break;
            case 14:
            	drawlist[index] = new Word();
                break;
        }
        drawlist[index].type = currentChoice;
        drawlist[index].R = R;
        drawlist[index].G = G;
        drawlist[index].B = B;
        drawlist[index].stroke = thickness;
    }
//选择当前颜色程序段
    public void chooseColor() {
        color = JColorChooser.showDialog(MyDrawPad.this,
                "Choose a color", color);
        R = color.getRed();
        G = color.getGreen();
        B = color.getBlue();
        drawlist[index].R = R;
        drawlist[index].G = G;
        drawlist[index].B = B;
    }
//选择当前线条粗细程序段
    public void setStroke() {
        String input;
        input = JOptionPane.showInputDialog(
                "请输入大小 ！( >0 )");
        thickness = Float.parseFloat(input);
        drawlist[index].stroke = thickness;
    }
//保存图形文件程序段
    public void saveFile() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int result = fileChooser.showSaveDialog(this);
        if (result == JFileChooser.CANCEL_OPTION) {
            return;
        }
        File fileName = fileChooser.getSelectedFile();
        fileName.canWrite();
        if (fileName == null || fileName.getName().equals("")) {
            JOptionPane.showMessageDialog(fileChooser, "Invalid File Name",
                    "Invalid File Name", JOptionPane.ERROR_MESSAGE);
        } else {
            try {
                fileName.delete();
                FileOutputStream fos = new FileOutputStream(fileName);
                output = new ObjectOutputStream(fos);
                primary_draw record;
                output.writeInt(index);
                for (int i = 0; i < index; i++) {
                    primary_draw p = drawlist[i];
                    output.writeObject(p);
                    output.flush();    //将所有图形信息强制转换成父类线性化存储到文件中
                }
                output.close();
                fos.close();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
    }
//打开一个图形文件程序段
    public void loadFile() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.CANCEL_OPTION) {
            return;
        }
        File fileName = fileChooser.getSelectedFile();
        fileName.canRead();
        if (fileName == null || fileName.getName().equals("")) {
            JOptionPane.showMessageDialog(fileChooser, "Invalid File Name",
                    "Invalid File Name", JOptionPane.ERROR_MESSAGE);
        } else {
            try {
                FileInputStream fis = new FileInputStream(fileName);
                input = new ObjectInputStream(fis);
                primary_draw inputRecord;
                int countNumber = 0;
                countNumber = input.readInt();
                for (index = 0; index < countNumber; index++) {
                    inputRecord = (primary_draw) input.readObject();
                    drawlist[index] = inputRecord;
                }
                createNewItem();
                input.close();
                repaint();
            } catch (EOFException endofFileException) {
                JOptionPane.showMessageDialog(this, "no more record in file",
                        "class not found", JOptionPane.ERROR_MESSAGE);
            } catch (ClassNotFoundException classNotFoundException) {
                JOptionPane.showMessageDialog(this, "Unable to Create Object",
                        "end of file", JOptionPane.ERROR_MESSAGE);
            } catch (IOException ioException) {
                JOptionPane.showMessageDialog(this, "error during read from file",
                        "read Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
//新建一个文件程序段
    public void newFile() {
        index = 0;
        currentChoice = 3;
        color = Color.black;
        thickness = 1.0f;
        createNewItem();
        repaint();//将有关值设置为初始状态，并且重画
    }
//主函数段
    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
        }//将界面设置为当前windows风格
        MyDrawPad newPad = new MyDrawPad();
        newPad.addWindowListener(
                new WindowAdapter() {
                    public void windowClosing(WindowEvent e) {
                        System.exit(0);
                    }
                });
    }
}
