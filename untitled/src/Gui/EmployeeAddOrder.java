package Gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EmployeeAddOrder implements ActionListener {
    JFrame frame = new JFrame();
    JPanel panel = new JPanel();
    JPanel introMessagePanel = new JPanel();
    JLabel introMessage = new JLabel("Employee User Interface");
    JLabel selectTable = new JLabel("Select table you want to add order to : ");
    JButton buttonTemp = new JButton("Next");
    JPanel back = new JPanel();
    JButton leave = new JButton("Back");

    public EmployeeAddOrder() {

        back.add(leave);
        leave.addActionListener(this);
        back.setPreferredSize(new Dimension(400,40));
        back.setBackground(Color.DARK_GRAY);

        introMessagePanel.setPreferredSize(new Dimension(400,60));
        introMessagePanel.setBackground(Color.GRAY);
        introMessagePanel.add(introMessage);

        panel.setPreferredSize(new Dimension(500,500));
        panel.setBackground(Color.LIGHT_GRAY);
        panel.add(buttonTemp);
        buttonTemp.addActionListener(this);
        panel.add(selectTable);

        center(frame);
        frame.add(panel, BorderLayout.CENTER);
        frame.add(back, BorderLayout.SOUTH);
        frame.add(introMessagePanel, BorderLayout.NORTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,420);
        frame.setVisible(true);
        frame.setTitle("Employee - Restaurant Management System");
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
        if (e.getSource() == buttonTemp) {
            frame.dispose();
            EmployeeAddOrderNext employeeAddOrderNext = new EmployeeAddOrderNext();
        }

        if (e.getSource() == leave) {
            frame.dispose();
            EmployeeMenuGUI employeeMenuGUI = new EmployeeMenuGUI();

        }
    }
}
