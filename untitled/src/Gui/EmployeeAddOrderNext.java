package Gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EmployeeAddOrderNext implements ActionListener {

    JFrame frame = new JFrame();
    JTextField addOrderTextField = new JTextField(40);
    JLabel introMessage = new JLabel("Employee User Interface");
    JLabel addOrderLabel = new JLabel("Add Order Description : ");
    JPanel introMessagePanel = new JPanel();
    JPanel panel = new JPanel();
    JPanel back = new JPanel();
    JButton leave = new JButton("Back");

    public EmployeeAddOrderNext() {

        back.add(leave);
        leave.addActionListener(this);
        back.setPreferredSize(new Dimension(400,40));
        back.setBackground(Color.DARK_GRAY);

        panel.setPreferredSize(new Dimension(500,500));
        panel.setBackground(Color.LIGHT_GRAY);
        panel.add(addOrderTextField);
        panel.add(addOrderLabel);

        introMessagePanel.setPreferredSize(new Dimension(400,60));
        introMessagePanel.setBackground(Color.GRAY);
        introMessagePanel.add(introMessage);

        center(frame);
        frame.add(panel, BorderLayout.CENTER);
        frame.add(back, BorderLayout.SOUTH);
        frame.add(introMessagePanel, BorderLayout.NORTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,420);
        frame.setTitle("Employee - Restaurant Management System");
        frame.setVisible(true);
    }

    private static void center(JFrame frame) {

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

        int w = frame.getSize().width;
        int h = frame.getSize().height;
        int x = (dim.width - w) / 2;
        int y = (dim.height - h) / 2;

        frame.setLocation(x,y);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == leave) {
            frame.dispose();
            EmployeeMenuGUI employeeMenuGUI = new EmployeeMenuGUI();

        }
    }
}
