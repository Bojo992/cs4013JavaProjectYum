/**
 * The ActionListener Loop here is meant to throw LoginPage, however since we have not implemented it yet, I have
 * made it skip the login and go straight to selected interface.
 */

package Gui;

import People.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuGUI implements ActionListener {
    private Person user;
    JFrame frame = new JFrame();
    JButton buttonEmployee = new JButton("Employee");
    JButton buttonUser = new JButton("User");
    JButton buttonChef = new JButton("Chef");
    JLabel introMessage = new JLabel("Please pick who you want to login as : ");
    JPanel panel = new JPanel();
    JPanel introMessagePanel = new JPanel();
    JPanel back = new JPanel();
    JButton leave = new JButton("Quit");

    public MenuGUI() {

        frame.add(back, BorderLayout.SOUTH);
        back.add(leave);
        leave.addActionListener(this);
        back.setPreferredSize(new Dimension(400,40));
        back.setBackground(Color.DARK_GRAY);

        buttonEmployee.setBounds(150, 200, 200, 25);
        buttonEmployee.addActionListener(this);
        buttonUser.setBounds(275, 200, 200, 25);
        buttonUser.addActionListener(this);
        buttonChef.setBounds(400, 200, 200, 25);
        buttonChef.addActionListener(this);

        panel.setPreferredSize(new Dimension(500, 500));
        panel.setBackground(Color.LIGHT_GRAY);
        panel.setSize(400, 400);
        panel.add(buttonEmployee);
        panel.add(buttonUser);
        panel.add(buttonChef);

        introMessagePanel.setPreferredSize(new Dimension(400, 60));
        introMessagePanel.setBackground(Color.GRAY);
        introMessagePanel.add(introMessage);

        center(frame);
        frame.add(panel, BorderLayout.CENTER);
        frame.add(introMessagePanel, BorderLayout.NORTH);
        frame.setSize(420, 420);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("LoginSelect - Restaurant Management System");
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
        if (e.getSource() == buttonEmployee) {
            frame.dispose();
            this.user = new Waiter("", "waiter");
            LoginPage loginPage = new LoginPage(this.user, "employee");
        }

        if (e.getSource() == buttonUser) {
            frame.dispose();
            this.user = new Customer("");
            LoginPage loginPage = new LoginPage(this.user, "customer");
        }

        if (e.getSource() == buttonChef) {
            frame.dispose();
            this.user = new Chef("", "chef");
            LoginPage loginPage = new LoginPage(this.user, "chef");
        }

        if(e.getSource() == leave) {
            frame.dispose();
        }
    }
}


