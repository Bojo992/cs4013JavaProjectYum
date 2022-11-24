package Gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserGUI implements ActionListener {
    JFrame frame = new JFrame();
    JPanel panel = new JPanel();
    JPanel introMessagePanel = new JPanel();
    JLabel introMessage = new JLabel("User Interface");
    JButton reserveTable = new JButton("Reserve a table");
    JButton viewReservation = new JButton("View Reservation");
    JButton cancelReservation = new JButton("Cancel Reservation");
    JButton Back = new JButton("Back");
    JPanel back = new JPanel();
    JButton leave = new JButton("Quit");

    public UserGUI() {

        back.add(leave);
        leave.addActionListener(this);
        back.setPreferredSize(new Dimension(400,40));
        back.setBackground(Color.DARK_GRAY);

        panel.setPreferredSize(new Dimension(500,500));
        panel.setBackground(Color.LIGHT_GRAY);
        panel.add(cancelReservation);
        cancelReservation.addActionListener(this);
        panel.add(reserveTable);
        reserveTable.addActionListener(this);
        panel.add(viewReservation);
        viewReservation.addActionListener(this);
        panel.add(Back);
        Back.addActionListener(this);

        introMessagePanel.setPreferredSize(new Dimension(400,60));
        introMessagePanel.setBackground(Color.GRAY);

        center(frame);
        frame.add(back, BorderLayout.SOUTH);
        frame.add(panel, BorderLayout.CENTER);
        frame.add(introMessagePanel, BorderLayout.NORTH);
        introMessagePanel.add(introMessage);
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
        if (e.getSource() == reserveTable) {
            frame.dispose();
            UserReserveTable userReserveTable = new UserReserveTable();
        }

        if (e.getSource() == viewReservation) {
            frame.dispose();
            UserViewReservation userViewReservation = new UserViewReservation();
        }

        if (e.getSource() == cancelReservation) {
            frame.dispose();
            UserCancelReservation userCancelReservation = new UserCancelReservation();
        }

        if (e.getSource() == Back) {
            frame.dispose();
            MenuGUI menuGUI = new MenuGUI();
        }
        if (e.getSource() == leave) {
            frame.dispose();

        }
    }
}