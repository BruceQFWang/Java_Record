package bb;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;


class primary_draw implements Serializable//���࣬����ͼ�ε�Ԫ���õ����л��ӿڣ�����ʱ����
{
    int x1, y1, x2, y2; //������������
    int R, G, B;        //����ɫ������
    float stroke;       //����������ϸ����
    int type;       //������������
    String s1;
    String s2;      //��������������
    void draw(Graphics2D g2d) {
    }
    ;//�����ͼ����
}


//�����Ǹ��ֻ���ͼ�ε�Ԫ�����࣬���̳��Ը���primary_draw
class Pencil extends primary_draw//��ʻ���
{
    void draw(Graphics2D g2d) {
        g2d.setPaint(new Color(R, G, B));
        g2d.setStroke(new BasicStroke(stroke,
                BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL));
        g2d.drawLine(x1, y1, x2, y2);
    }
}

class Line extends primary_draw //ֱ����
{
    void draw(Graphics2D g2d) {
        g2d.setPaint(new Color(R, G, B));
        g2d.setStroke(new BasicStroke(stroke,
                BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL));
        g2d.drawLine(x1, y1, x2, y2);
    }
}
class Rect extends primary_draw//������
{
    void draw(Graphics2D g2d) {
        g2d.setPaint(new Color(R, G, B));
        g2d.setStroke(new BasicStroke(stroke));
        g2d.drawRect(Math.min(x1, x2), Math.min(y1, y2),
                Math.abs(x1 - x2), Math.abs(y1 - y2));
    }
}
class fillRect extends primary_draw//ʵ�ľ�����
{
    void draw(Graphics2D g2d) {
        g2d.setPaint(new Color(R, G, B));
        g2d.setStroke(new BasicStroke(stroke));
        g2d.fillRect(Math.min(x1, x2), Math.min(y1, y2),
                Math.abs(x1 - x2), Math.abs(y1 - y2));
    }
}

class Circle extends primary_draw//Բ��
{
    void draw(Graphics2D g2d) {
        g2d.setPaint(new Color(R, G, B));
        g2d.setStroke(new BasicStroke(stroke));
        g2d.drawOval(Math.min(x1, x2), Math.min(y1, y2),
                Math.max(Math.abs(x1 - x2), Math.abs(y1 - y2)),
                Math.max(Math.abs(x1 - x2), Math.abs(y1 - y2)));
    }
}
class fillCircle extends primary_draw//ʵ��Բ
{
    void draw(Graphics2D g2d) {
        g2d.setPaint(new Color(R, G, B));
        g2d.setStroke(new BasicStroke(stroke));
        g2d.fillOval(Math.min(x1, x2), Math.min(y1, y2),
                Math.max(Math.abs(x1 - x2), Math.abs(y1 - y2)),
                Math.max(Math.abs(x1 - x2), Math.abs(y1 - y2)));
    }
}

class Oval extends primary_draw//��Բ��
{
    void draw(Graphics2D g2d) {
        g2d.setPaint(new Color(R, G, B));
        g2d.setStroke(new BasicStroke(stroke));
        g2d.drawOval(Math.min(x1, x2), Math.min(y1, y2),
                Math.abs(x1 - x2), Math.abs(y1 - y2));
    }
}

class fillOval extends primary_draw//ʵ����Բ
{
    void draw(Graphics2D g2d) {
        g2d.setPaint(new Color(R, G, B));
        g2d.setStroke(new BasicStroke(stroke));
        g2d.fillOval(Math.min(x1, x2), Math.min(y1, y2),
                Math.abs(x1 - x2), Math.abs(y1 - y2));
    }
}

class RoundRect extends primary_draw//Բ�Ǿ�����
{
    void draw(Graphics2D g2d) {
        g2d.setPaint(new Color(R, G, B));
        g2d.setStroke(new BasicStroke(stroke));
        g2d.drawRoundRect(Math.min(x1, x2), Math.min(y1, y2),
                Math.abs(x1 - x2), Math.abs(y1 - y2),
                50, 35);
    }
}

class fillRoundRect extends primary_draw//ʵ��Բ�Ǿ�����
{
    void draw(Graphics2D g2d) {
        g2d.setPaint(new Color(R, G, B));
        g2d.setStroke(new BasicStroke(stroke));
        g2d.fillRoundRect(Math.min(x1, x2), Math.min(y1, y2),
                Math.abs(x1 - x2), Math.abs(y1 - y2),
                50, 35);
    }
}



class Rubber extends primary_draw//��Ƥ����
{
    void draw(Graphics2D g2d) {
        g2d.setPaint(new Color(255, 255, 255));
        g2d.setStroke(new BasicStroke(stroke + 4,
                BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL));
        g2d.drawLine(x1, y1, x2, y2);
    }
}

class Word extends primary_draw//����������
{
    void draw(Graphics2D g2d) {
        g2d.setPaint(new Color(R, G, B));
        g2d.setFont(new Font(s2, x2 + y2, ((int) stroke) * 18));
        if (s1 != null) {
            g2d.drawString(s1, x1, y1);
        }
    }
}

//���廭ͼ�Ļ���ͼ�ε�Ԫ
public class MyDrawPad extends JFrame //���࣬��չ��JFrame�࣬��������������
{
    JToolBar buttonPanel;              //���尴ť���
    private JLabel statusBar;            //��ʾ���״̬����ʾ��
    private DrawPanel drawingArea;       //��ͼ����
    private int width = 800,  height = 550;    //���廭ͼ�����ʼ��С
    primary_draw[] drawlist = new primary_draw[5000]; //������Ż���ͼ�ε�����
    private int currentChoice = 3;            //����Ĭ�ϻ�ͼ״̬Ϊ��ʻ�
    int index = 0;                         //��ǰ�Ѿ����Ƶ�ͼ����Ŀ
    private Color color = Color.black;     //��ǰ������ɫ
    int R, G, B;                           //������ŵ�ǰɫ��ֵ
    int f1, f2;                  //������ŵ�ǰ������
    String style1;              //������ŵ�ǰ����
    private float thickness = 1.0f;  //���û��ʴ�ϸ��Ĭ��ֵΪ1.0f
    JCheckBox bold, italic;   //boldΪ���壬italicΪб�壬���߿���ͬʱʹ��
    JComboBox styles, wordsize;
    Panel pan1, pan2, pan;
	
	private ObjectInputStream input;
    private ObjectOutputStream output; //����������������������úͱ���ͼ���ļ�
    private JButton choices[];         //��ť���飬����������ƵĹ��ܰ�ť
    private String names[] = {
        "�½�",              
        "��",
        "����", 
        "Ǧ��", 
        "ֱ��", 						
        "���ľ���",					
        "ʵ�ľ���", 
        "������Բ", 					
        "ʵ����Բ", 
        "Բ��",                                                                    
        "ʵ��Բ��",				
        "����Բ�Ǿ���",      			
        "ʵ��Բ�Ǿ���", 		
        "��Ƥ��",         
        "ѡ����ɫ",              
        "��ϸ", 
        "����"   	
    };
    private String tipText[] = {
            //����������ƶ�����Ӧ��ť������ͣ��ʱ��������ʾ˵����
            //���߿��Բ�������İ�ť������������
            "�����µ�ͼ��",
            "�򿪱����ͼ��",
            "���浱ǰ",
            "Ǧ��",
            "����ֱ��",
            "���ƿ��ľ���",
            "����ʵ�ľ���",
            "���ƿ�����Բ",
            "���ƿ�ʵ����Բ",
            "���ƿ���Բ",
            "����ʵ��Բ",
            "���ƿ���Բ�Ǿ���",
            "����ʵ��Բ�Ǿ���",
            "��Ƥ��",
            "ѡ��ǰ������ɫ",
            "���ô�ϸ",
            "����"
        };
    private String styleNames[] = {
        " ΢���ź� ", " ���� ", " ���� ", " ���� ", " ���� ",
        " ���� ", " Times New Roman ", " Consolas ", " Italic ",
        " Technic ", " Garamond ", ""
    };            //�ɹ�ѡ���������
    private String thickNames[] = {
            " һ�� ", " ���� ", " ���� ", " �ĺ� ", " ��� ",
            " ���� ", " �ߺ� "
        };            //�ɹ�ѡ���������
    //��Ȼ��������Ľṹ�����ö����Լ��������ϵͳ֧�ֵ�����
    private Icon items[];
    
    
    
    public MyDrawPad() //���캯��
    {
        super("Drawing Pad");
        JMenuBar bar = new JMenuBar();      //����˵���
        JMenu fileMenu = new JMenu("�ļ�");
        fileMenu.setMnemonic('F');
//�½��ļ��˵���
        JMenuItem newItem = new JMenuItem("�½�");
        newItem.setMnemonic('N');
        newItem.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        newFile();      //�����������������½��ļ�������
                    }
                });
        fileMenu.add(newItem);
//�����ļ��˵���
        JMenuItem saveItem = new JMenuItem("����");
        saveItem.setMnemonic('S');
        saveItem.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        saveFile();     //���������������ñ����ļ�������
                    }
                });
        fileMenu.add(saveItem);
        //���ļ��˵���
        JMenuItem loadItem = new JMenuItem("����");
        loadItem.setMnemonic('L');
        loadItem.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        loadFile();     //���������������ô��ļ�������
                    }
                });
        fileMenu.add(loadItem);
        fileMenu.addSeparator();
//�˳��˵���
        JMenuItem exitItem = new JMenuItem("�˳�");
        exitItem.setMnemonic('X');
        exitItem.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        System.exit(0); //��������������˳���ͼ�����
                    }
                });
        fileMenu.add(exitItem);
        bar.add(fileMenu);
//������ʾ�˵���
        JMenu helpMenu = new JMenu("����");
        helpMenu.setMnemonic('H');
//������ʾ�˵���
        JMenuItem aboutItem = new JMenuItem("����");
        aboutItem.setMnemonic('A');
        aboutItem.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        JOptionPane.showMessageDialog(null,
                                "This is a  drawing pad!/nCopyright (c) 2017 SWJTU University ",
                                " ��ͼ�����˵�� ",
                                JOptionPane.INFORMATION_MESSAGE);
                    }
                });
        helpMenu.add(aboutItem);
        bar.add(helpMenu);
        items = new ImageIcon[names.length];
        
//�������ֻ���ͼ�εİ�ť
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
//����������Ҫ��ͼ��ͼ�꣬��Щͼ�궼�������Դ�ļ���ͬ��Ŀ¼����
        for (int i = 0; i < choices.length; i++) {
            //�����jbuilder�����б�������Ӧ����������䵼��ͼƬ
            items[i] = new ImageIcon("image/"+names[i] + ".jpg");
            //Ĭ�ϵ���jdk����jcreator�����У��ô���䵼��ͼƬ
            choices[i] = new JButton("", items[i]);
            choices[i].setToolTipText(tipText[i]);
            if(i<=3 || i>=13)buttonPanel.add(choices[i]);
            else pan1.add(choices[i]);
        }
//���������������밴ť����
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
//������ѡ��
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
//����ѡ��
        bold = new JCheckBox("��ϸ");
        italic = new JCheckBox("б��");
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
//��ť������ButtonHanler�࣬�ڲ��࣬��������������ť�Ĳ���
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
//��ť������ButtonHanler1�࣬����������ɫѡ�񡢻��ʴ�ϸ���á��������밴ť�Ĳ���
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
                        "�������ѡ��������ֵ�λ��",
                        "Hint", JOptionPane.INFORMATION_MESSAGE);
                currentChoice = 14;
                createNewItem();
                repaint();
            }
        }
    }
//����¼�mouseA�࣬�̳���MouseAdapter��������������Ӧ�¼�����
    class mouseA extends MouseAdapter {
        public void mousePressed(MouseEvent e) {
            statusBar.setText("     Mouse Pressed at(" + e.getX() +
                    ", " + e.getY() + ")");//����״̬��ʾ
            drawlist[index].x1 = drawlist[index].x2 = e.getX();
            drawlist[index].y1 = drawlist[index].y2 = e.getY();
            //�����ǰѡ���ͼ������ʻ�������Ƥ�������������Ĳ���
            if (currentChoice == 3 || currentChoice == 13) {
            	drawlist[index].x1 = drawlist[index].x2 = e.getX();
            	drawlist[index].y1 = drawlist[index].y2 = e.getY();
                index++;
                createNewItem();
            }
            //�����ǰѡ���ͼ��ʽ�������룬������������
            if (currentChoice == 14) {
            	drawlist[index].x1 = e.getX();
            	drawlist[index].y1 = e.getY();
                String input;
                input = JOptionPane.showInputDialog(
                        "����������!");
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
//����¼�mouseB��̳���MouseMotionAdapter�������������϶�������ƶ�ʱ����Ӧ����
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
//ѡ��������ʱ���õ����¼��������࣬���뵽�������ѡ�����
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
//��ͼ����࣬������ͼ
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
            Graphics2D g2d = (Graphics2D) g;    //���廭��
            int j = 0;
            while (j <= index) {
                draw(g2d, drawlist[j]);
                j++;
            }
        }
        void draw(Graphics2D g2d, primary_draw i) {
            i.draw(g2d);//�����ʴ��뵽���������У�������ɸ��ԵĻ�ͼ
        }
    }
//�½�һ����ͼ������Ԫ����ĳ����
    void createNewItem() {
        if (currentChoice == 14)//������Ӧ���α�����
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
//ѡ��ǰ��ɫ�����
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
//ѡ��ǰ������ϸ�����
    public void setStroke() {
        String input;
        input = JOptionPane.showInputDialog(
                "�������С ��( >0 )");
        thickness = Float.parseFloat(input);
        drawlist[index].stroke = thickness;
    }
//����ͼ���ļ������
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
                    output.flush();    //������ͼ����Ϣǿ��ת���ɸ������Ի��洢���ļ���
                }
                output.close();
                fos.close();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
    }
//��һ��ͼ���ļ������
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
//�½�һ���ļ������
    public void newFile() {
        index = 0;
        currentChoice = 3;
        color = Color.black;
        thickness = 1.0f;
        createNewItem();
        repaint();//���й�ֵ����Ϊ��ʼ״̬�������ػ�
    }
//��������
    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
        }//����������Ϊ��ǰwindows���
        MyDrawPad newPad = new MyDrawPad();
        newPad.addWindowListener(
                new WindowAdapter() {
                    public void windowClosing(WindowEvent e) {
                        System.exit(0);
                    }
                });
    }
}
