package Gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChefMenuGUI implements ActionListener {
    JFrame frame = new JFrame();
    JButton viewTables = new JButton();
    JScrollBar s = new JScrollBar();
    JLabel introMessage = new JLabel("Chef User Interface");
    JLabel tableMessage = new JLabel("Select a table : ");
    JButton buttonTemp = new JButton("temp");
    JPanel back = new JPanel();
    JButton leave = new JButton("Back");
    JPanel panel = new JPanel();
    JPanel introMessagePanel = new JPanel();

    public ChefMenuGUI() {

        back.add(leave);
        leave.addActionListener(this);
        back.setPreferredSize(new Dimension(400,40));
        back.setBackground(Color.DARK_GRAY);

        panel.setPreferredSize(new Dimension(500,500));
        panel.setBackground(Color.LIGHT_GRAY);
        panel.add(tableMessage);
        panel.add(buttonTemp); //temp
        buttonTemp.addActionListener(this);

        introMessagePanel.setPreferredSize(new Dimension(400,60));
        introMessagePanel.setBackground(Color.GRAY);
        introMessagePanel.add(introMessage);

        s.setBounds(100,100,50,100);

        center(frame);
        frame.add(panel, BorderLayout.CENTER);
        frame.add(introMessagePanel, BorderLayout.NORTH);
        frame.add(s, BorderLayout.EAST);
        frame.add(back, BorderLayout.SOUTH);
        frame.setSize(420,420);
        frame.setTitle("Chef - Restaurant Management System");
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
        if(e.getSource() == buttonTemp) {
            frame.dispose();
            ChefAfterSelectTable chefAfterSelectTable = new ChefAfterSelectTable();
        }

        if (e.getSource() == leave) {
            frame.dispose();
            MenuGUI menuGUI = new MenuGUI();

        }

    }
}
