/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;

public class DashboardView extends JFrame {

    JLabel title =
            new JLabel("DASHBOARD RENTAL MOBIL");

    JLabel jam =
            new JLabel();

    JButton btnMobil =
            new JButton("DATA MOBIL");

    JButton btnTransaksi =
            new JButton("TRANSAKSI RENTAL");

    JButton btnLogout =
            new JButton("LOGOUT");

    public DashboardView() {

        setTitle("Dashboard");

        setSize(600,400);

        setLayout(null);

        setVisible(true);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE);

        // TITLE
        add(title);

        title.setBounds(
                210,40,300,30);

        // JAM
        add(jam);

        jam.setBounds(
                260,80,200,30);

        // BUTTON MOBIL
        add(btnMobil);

        btnMobil.setBounds(
                180,130,220,45);

        // BUTTON TRANSAKSI
        add(btnTransaksi);

        btnTransaksi.setBounds(
                180,190,220,45);

        // BUTTON LOGOUT
        add(btnLogout);

        btnLogout.setBounds(
                180,250,220,45);

        // ACTION BUTTON
        btnMobil.addActionListener(e -> {

            new MobilView();
        });

        btnTransaksi.addActionListener(e -> {

            new TransaksiView();
        });

        btnLogout.addActionListener(e -> {

            dispose();

            new LoginView();
        });

        // =====================================
        // MULTITHREADING JAM REALTIME
        // =====================================

        new Thread(() -> {

            while(true) {

                try {

                    SimpleDateFormat sdf =
                            new SimpleDateFormat(
                                    "HH:mm:ss");

                    jam.setText(
                            sdf.format(
                                    new Date()));

                    Thread.sleep(1000);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }).start();
    }
}