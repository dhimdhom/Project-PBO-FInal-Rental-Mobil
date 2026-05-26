/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connector {

    public static Connection connection;

    public static Connection getConnection() {

        try {

            String url = "jdbc:mysql://localhost/rental_mobil_pbo";
            String user = "root";
            String pass = "";

            DriverManager.registerDriver(
                    new com.mysql.cj.jdbc.Driver());

            connection = DriverManager.getConnection(
                    url, user, pass);

            System.out.println("Koneksi Berhasil");

        } catch (Exception e) {

            System.out.println("Koneksi Gagal");
            e.printStackTrace();
        }

        return connection;
    }
}