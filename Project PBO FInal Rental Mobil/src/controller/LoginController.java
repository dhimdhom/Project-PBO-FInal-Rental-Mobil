/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import connection.Connector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import view.DashboardView;
import view.LoginView;

public class LoginController {

    LoginView view;

    public LoginController(LoginView view) {

        this.view = view;

        view.btnLogin.addActionListener(e -> login());
    }

    public void login() {

        try {

            String query =
                    "SELECT * FROM admin "
                    + "WHERE username=? AND password=?";

            Connection con =
                    Connector.getConnection();

            PreparedStatement ps =
                    con.prepareStatement(query);

            ps.setString(1, view.getUsername());
            ps.setString(2, view.getPassword());

            ResultSet rs = ps.executeQuery();

            if(rs.next()) {

                JOptionPane.showMessageDialog(
                        null,
                        "Login Berhasil");

                new DashboardView();

                view.dispose();

            } else {

                JOptionPane.showMessageDialog(
                        null,
                        "Username / Password Salah");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}