package Gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserViewReservation implements ActionListener {
    JFrame frame = new JFrame();
    JPanel panel = new JPanel();
    JPanel introMessagePanel = new JPanel();
    JLabel introMessage = new JLabel("User Interface");
    JLabel viewReservation = new JLabel("These are your reservation :");
    JPanel back = new JPanel();
    JButton leave = new JButton("Back");

    public UserViewReservation() {

        back.add(leave);
        leave.addActionListener(this);
        back.setPreferredSize(new Dimension(400,40));
        back.setBackground(Color.DARK_GRAY);

        panel.setPreferredSize(new Dimension(500,500));
        panel.setBackground(Color.LIGHT_GRAY);
        panel.add(viewReservation);

        introMessagePanel.setPreferredSize(new Dimension(400,60));
        introMessagePanel.setBackground(Color.GRAY);
        introMessagePanel.add(introMessage);

        center(frame);
        frame.add(back, BorderLayout.SOUTH);
        frame.add(panel, BorderLayout.CENTER);
        frame.add(introMessagePanel, BorderLayout.NORTH);
        frame.setSize(420,420);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("User - Restaurant Management System");
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
            UserGUI userGUI = new UserGUI();

        }

    }
}
