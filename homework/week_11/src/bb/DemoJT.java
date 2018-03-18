package bb;


import java.awt.*;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;

public class DemoJT {

    private static void createAndShowGUI() {

        // Create and set up the window.
        final JFrame frame = new JFrame("Four programming language");

        // Display the window.
        frame.setSize(500, 300);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // set grid layout for the frame
        frame.getContentPane().setLayout(new GridLayout(1, 1));

        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);

        Icon image = new ImageIcon("image/java.gif");
        tabbedPane.addTab("Java", new JLabel(image, JLabel.CENTER));

        image = new ImageIcon("image/python.gif");
        tabbedPane.addTab("Python", new JLabel(image, JLabel.CENTER));

        image = new ImageIcon("image/react.gif");
        tabbedPane.addTab("React", new JLabel(image, JLabel.CENTER));;
        
        image = new ImageIcon("image/ruby.gif");
        tabbedPane.addTab("Ruby", new JLabel(image, JLabel.CENTER));

        frame.getContentPane().add(tabbedPane);

    }

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI(); 
            }
        });
    }
}

