package Gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EmployeeMenuGUI implements ActionListener {
    JFrame frame = new JFrame();
    JButton walkIn = new JButton("Walk-Ins");
    JButton addOrder = new JButton("Add Order");
    JButton viewTables = new JButton("View Tables");
    JButton changeOrder = new JButton("Change Order");
    JButton orderList = new JButton("Order List");
    JButton logout = new JButton("Logout");
    JLabel introMessage = new JLabel("Employee User Interface");
    JPanel back = new JPanel();
    JButton leave = new JButton("Back");
    JPanel introMessagePanel = new JPanel();
    JPanel panel = new JPanel();

    EmployeeMenuGUI() {

        back.add(leave);
        leave.addActionListener(this);
        back.setPreferredSize(new Dimension(400,40));
        back.setBackground(Color.DARK_GRAY);

        introMessagePanel.setPreferredSize(new Dimension(400, 60));
        introMessagePanel.setBackground(Color.GRAY);
        introMessagePanel.add(introMessage);

        panel.setPreferredSize(new Dimension(500, 500));
        panel.setBackground(Color.LIGHT_GRAY);
        panel.add(walkIn);
        walkIn.addActionListener(this);
        panel.add(addOrder);
        addOrder.addActionListener(this);
        panel.add(viewTables);
        viewTables.addActionListener(this);
        panel.add(changeOrder);
        changeOrder.addActionListener(this);
        panel.add(orderList);
        orderList.addActionListener(this);
        panel.add(logout);
        logout.addActionListener(this);
        panel.setSize(400, 400);

        center(frame);
        frame.add(back, BorderLayout.SOUTH);
        frame.add(introMessagePanel, BorderLayout.NORTH);
        frame.add(panel, BorderLayout.CENTER);
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
        if (e.getSource() == walkIn) {
            frame.dispose();
            EmployeeWalkin employeeWalkin = new EmployeeWalkin();
        }

        if (e.getSource() == addOrder) {
            frame.dispose();
            EmployeeAddOrder employeeAddOrder = new EmployeeAddOrder();
        }

        if (e.getSource() == viewTables) {
            frame.dispose();
            EmployeeViewTables employeeViewTables = new EmployeeViewTables();
        }

        if (e.getSource() == changeOrder) {
            frame.dispose();
            EmployeeCurrentOrders employeeCurrentOrders = new EmployeeCurrentOrders();
        }

        if (e.getSource() == orderList) {
            frame.dispose();
            EmployeeCurrentOrders employeeCurrentOrders = new EmployeeCurrentOrders();
        }

        if (e.getSource() == logout) {
            frame.dispose();
            MenuGUI menuGUI = new MenuGUI();
        }

        if (e.getSource() == leave) {
            frame.dispose();
            MenuGUI menuGUI = new MenuGUI();

        }
    }
}
