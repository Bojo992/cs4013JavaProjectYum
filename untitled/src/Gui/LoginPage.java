package Gui;

import utils.DataStorage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import People.*;

public class LoginPage implements ActionListener {
    private IDandPasswords login;
    private Person user;
    private String type;
    JFrame frame = new JFrame();
    JPanel panel = new JPanel();
    JLabel label = new JLabel();
    JButton loginButton = new JButton("Login");
    JButton resetButton = new JButton("Reset");
    JTextField userIDField = new JTextField();
    JPasswordField userPasswordField = new JPasswordField();
    JLabel userIDLabel = new JLabel("userID: ");
    JLabel userPasswordLabel = new JLabel("password: ");
    JLabel messageLabel = new JLabel();
    JLabel caseSensitive = new JLabel("UserID & password are case sensitive!");
    HashMap<String, Person> loginInfo = DataStorage.getAllUsernamesAndPasswords();

    LoginPage(Person user, String type) {
        this.user = user;
        this.type = type;
        userIDLabel.setBounds(50, 100, 75, 25);
        userPasswordLabel.setBounds(50, 150, 75, 25);

        messageLabel.setBounds(125, 250, 250, 35);

        caseSensitive.setBounds(125, 70, 300, 25);

        userIDField.setBounds(125, 100, 200, 25);
        userPasswordField.setBounds(125, 150, 200, 25);

        loginButton.setBounds(125, 200, 100, 25);
        loginButton.setFocusable(false);
        loginButton.addActionListener(this);

        resetButton.setBounds(225, 200, 100, 25);
        resetButton.setFocusable(false);
        resetButton.addActionListener(this);

        panel.setLayout(new FlowLayout(FlowLayout.CENTER,10,5));

        frame.add(panel, BorderLayout.NORTH);
        frame.add(panel);
        frame.add(userIDLabel);
        frame.add(userPasswordLabel);
        frame.add(messageLabel);
        frame.add(userIDField);
        frame.add(userPasswordField);
        frame.add(loginButton);
        frame.add(resetButton);
        frame.add(caseSensitive);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 420);
        frame.setLayout(new FlowLayout());
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setTitle("Restaurant Management System");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == resetButton) {
            userIDField.setText("");
            userPasswordField.setText("");
        }

        if (e.getSource() == loginButton) {
            String userID = userIDField.getText();
            String password = String.valueOf(userPasswordField.getPassword());

            if(type.equals("employee")) {
                this.user.setName(userID);
                this.user.setPassword(password);
                login = new IDandPasswords(this.user, password);
                login.createAcc(userID, this.user);

                if (loginInfo.containsKey(userID)) {
                    if (loginInfo.get(userID).getPassword().equals(password)) {
                        messageLabel.setForeground(Color.green);
                        messageLabel.setText("Login successful");
                        EmployeeMenuGUI employeeMenuGUI = new EmployeeMenuGUI();
                        frame.dispose();
                        //Here we need to implement LoginHandler
                    } else {
                        messageLabel.setForeground(Color.red);
                        messageLabel.setText("Incorrect Password");
                    }
                } else {
                    messageLabel.setForeground(Color.red);
                    messageLabel.setText("UserID Not Found");
                }
            }

            if(type.equals("customer")) {
                this.user.setName(userID);
                this.user.setPassword(password);
                login = new IDandPasswords(this.user, password);
                login.createAcc(userID, this.user);


                if (loginInfo.containsKey(userID)) {
                    if (loginInfo.get(userID).getPassword().equals(password)) {
                        messageLabel.setForeground(Color.green);
                        messageLabel.setText("Login successful");
                        UserGUI employeeMenuGUI = new UserGUI();
                        frame.dispose();
                        //Here we need to implement LoginHandler
                    } else {
                        messageLabel.setForeground(Color.red);
                        messageLabel.setText("Incorrect Password");
                    }
                } else {
                    messageLabel.setForeground(Color.red);
                    messageLabel.setText("UserID Not Found");
                }
            }

            if(type.equals("chef")) {
                this.user.setName(userID);
                this.user.setPassword(password);
                login = new IDandPasswords(this.user, password);
                login.createAcc(userID, this.user);


                if (loginInfo.containsKey(userID)) {
                    if (loginInfo.get(userID).getPassword().equals(password)) {
                        messageLabel.setForeground(Color.green);
                        messageLabel.setText("Login successful");
                        ChefMenuGUI employeeMenuGUI = new ChefMenuGUI();
                        frame.dispose();
                        //Here we need to implement LoginHandler
                    } else {
                        messageLabel.setForeground(Color.red);
                        messageLabel.setText("Incorrect Password");
                    }
                } else {
                    messageLabel.setForeground(Color.red);
                    messageLabel.setText("UserID Not Found");
                }
            }
        }

    }
}
