package Gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChefAfterSelectTable implements ActionListener {
    JFrame frame = new JFrame();
    JButton buttonSeeOrder = new JButton("See Order");
    JButton buttonChangeOrder = new JButton("Change Order");
    JButton buttonLogout = new JButton("Logout");
    JLabel introMessage = new JLabel("Chef User Interface");
    JPanel panel = new JPanel();
    JPanel introMessagePanel = new JPanel();
    JPanel back = new JPanel();
    JButton leave = new JButton("Back");

    public ChefAfterSelectTable() {

        back.add(leave);
        leave.addActionListener(this);
        back.setPreferredSize(new Dimension(400,40));
        back.setBackground(Color.DARK_GRAY);

        panel.setPreferredSize(new Dimension(500,500));
        panel.setBackground(Color.LIGHT_GRAY);

        introMessagePanel.setPreferredSize(new Dimension(400,60));
        introMessagePanel.setBackground(Color.GRAY);
        introMessagePanel.add(introMessage);

        panel.add(buttonSeeOrder);
        buttonSeeOrder.addActionListener(this);

        panel.add(buttonChangeOrder);
        buttonChangeOrder.addActionListener(this);

        panel.add(buttonLogout);
        buttonLogout.addActionListener(this);

        center(frame);
        frame.setSize(420,420);
        frame.add(panel, BorderLayout.CENTER);
        frame.add(introMessagePanel, BorderLayout.NORTH);
        frame.add(back, BorderLayout.SOUTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setTitle("Chef - Restaurant Management System");

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
        if (e.getSource() == buttonSeeOrder) {
            frame.dispose();
            ChefSeeOrder chefSeeOrder = new ChefSeeOrder();
        }

        if (e.getSource() == buttonChangeOrder) {
            frame.dispose();
            ChefChangeOrder chefChangeOrder = new ChefChangeOrder();
        }

        if (e.getSource() == buttonLogout) {
            frame.dispose();
            MenuGUI menuGUI = new MenuGUI();
        }

        if (e.getSource() == leave) {
            frame.dispose();
            ChefMenuGUI chefMenuGUI = new ChefMenuGUI();

        }
    }
}
