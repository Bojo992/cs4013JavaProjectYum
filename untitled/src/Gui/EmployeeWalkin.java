package Gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EmployeeWalkin implements ActionListener {

    JFrame frame = new JFrame();
    JButton checkTables = new JButton("Check available tables");
    JButton reserveTables = new JButton("Reserve a table");
    JButton goBack = new JButton("Back");
    JPanel panel = new JPanel();
    JPanel introMessagePanel = new JPanel();
    JPanel backPanel = new JPanel();
    JLabel introMessage = new JLabel("Employee User Interface");
    JPanel back = new JPanel();
    JButton leave = new JButton("Back");

    public EmployeeWalkin() {

        back.add(leave);
        leave.addActionListener(this);
        back.setPreferredSize(new Dimension(400,40));
        back.setBackground(Color.DARK_GRAY);

        introMessagePanel.setPreferredSize(new Dimension(400, 60));
        introMessagePanel.setBackground(Color.GRAY);
        introMessagePanel.add(introMessage);

        panel.setPreferredSize(new Dimension(500, 500));
        panel.setBackground(Color.LIGHT_GRAY);
        panel.add(reserveTables);
        reserveTables.addActionListener(this);
        panel.add(checkTables);
        checkTables.addActionListener(this);

        backPanel.setPreferredSize(new Dimension(400, 40));
        backPanel.setBackground(Color.DARK_GRAY);
        backPanel.add(goBack);


        center(frame);
        frame.add(backPanel, BorderLayout.SOUTH);
        frame.add(back, BorderLayout.SOUTH);
        frame.add(panel, BorderLayout.CENTER);
        frame.add(introMessagePanel, BorderLayout.NORTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 420);
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
        if (e.getSource() == checkTables) {
            frame.dispose();
            EmployeeWalkinCheckTable employeeWalkinCheckTable = new EmployeeWalkinCheckTable();
        }

        if (e.getSource() == reserveTables) {
            frame.dispose();
            EmployeeSelectTableForWalkin employeeSelectTableForWalkin = new EmployeeSelectTableForWalkin();
        }

        if (e.getSource() == leave) {
            frame.dispose();
            EmployeeMenuGUI employeeMenuGUI = new EmployeeMenuGUI();

        }
    }


}
