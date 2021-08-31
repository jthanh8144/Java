package test;

import java.awt.*;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
 
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
 
public class test1 {
    private JFrame mainFrame;
    private JLabel headerLabel, lb1, lb2, lb3;
    JTextField t1, t2, t3;
    private JPanel controlPanel;
 
    public test1() {
        prepareGUI();
    }
 
    public static void main(String[] args) {
        test1 demo = new test1();
        demo.showGridBagLayoutDemo();
    }
 
    private void prepareGUI() {
        mainFrame = new JFrame();
        mainFrame.setSize(400, 400);
        mainFrame.setLayout(new GridLayout(3, 1));
        headerLabel = new JLabel("", JLabel.CENTER);
        lb1 = new JLabel("lb1");
        lb1.setHorizontalAlignment(SwingConstants.RIGHT); //
        lb2 = new JLabel("lb2");
        lb3 = new JLabel("lb3");
        t1 = new JTextField();
        t2 = new JTextField();
        t3 = new JTextField();
        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });
        controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());
//        mainFrame.add(headerLabel);
        mainFrame.add(controlPanel);
        mainFrame.setVisible(true);
        mainFrame.setTitle("Ví dụ GridBagLayout trong Java Swing");
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
 
    private void showGridBagLayoutDemo() {
//        headerLabel.setText("Layout in action: GridBagLayout");
        JPanel panel = new JPanel();
        panel.setSize(400, 800);
        GridBagLayout layout = new GridBagLayout();
        panel.setLayout(layout);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(lb1, gbc);
        gbc.gridx = 1;
        gbc.gridy = 0;
        panel.add(t1, gbc);
        
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipady = 30;
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(new JButton("Button 3"), gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(new JButton("Button 4"), gbc);
        
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        panel.add(new JButton("Button 5"), gbc);
        controlPanel.add(panel);
        mainFrame.setVisible(true);
    }
}