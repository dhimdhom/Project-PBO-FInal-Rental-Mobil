/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import javax.swing.*;

public class LoginView extends JFrame {

    JLabel title = new JLabel("LOGIN ADMIN");

    JLabel lUser = new JLabel("Username");
    JLabel lPass = new JLabel("Password");

    public JTextField tfUser = new JTextField();

    public JPasswordField pfPass =
            new JPasswordField();

    public JButton btnLogin =
            new JButton("LOGIN");

    public LoginView() {

        setTitle("Login");
        setSize(400,300);
        setLayout(null);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(title);
        title.setBounds(150,30,200,30);

        add(lUser);
        lUser.setBounds(50,80,100,25);

        add(tfUser);
        tfUser.setBounds(150,80,180,25);

        add(lPass);
        lPass.setBounds(50,130,100,25);

        add(pfPass);
        pfPass.setBounds(150,130,180,25);

        add(btnLogin);
        btnLogin.setBounds(140,190,100,30);
    }

    public String getUsername() {
        return tfUser.getText();
    }

    public String getPassword() {
        return String.valueOf(pfPass.getPassword());
    }
}