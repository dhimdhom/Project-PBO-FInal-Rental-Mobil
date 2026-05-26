/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import connection.Connector;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import view.MobilView;

public class MobilController {

    MobilView view;

    int selectedId = -1;

    public MobilController(MobilView view) {

        this.view = view;

        showData("");

        view.btnTambah.addActionListener(e -> {
            insertData();
        });

        view.btnUpdate.addActionListener(e -> {
            updateData();
        });

        view.btnDelete.addActionListener(e -> {
            deleteData();
        });

        view.btnClear.addActionListener(e -> {
            view.clearForm();
        });

        view.tfCari.addKeyListener(
                new java.awt.event.KeyAdapter() {

            public void keyReleased(
                    java.awt.event.KeyEvent evt) {

                showData(view.tfCari.getText());
            }
        });

        view.table.getSelectionModel()
                .addListSelectionListener(e -> {

            int row = view.table.getSelectedRow();

            if(row != -1) {

                selectedId = Integer.parseInt(
                        view.table.getValueAt(
                                row,0).toString());

                view.tfNama.setText(
                        view.table.getValueAt(
                                row,1).toString());

                view.tfHarga.setText(
                        view.table.getValueAt(
                                row,2).toString());

                view.cbStatus.setSelectedItem(
                        view.table.getValueAt(
                                row,3).toString());
            }
        });
    }

    public void showData(String keyword) {

        DefaultTableModel model =
                (DefaultTableModel)
                        view.table.getModel();

        model.setRowCount(0);

        try {

            String query =
                    "SELECT * FROM mobil "
                    + "WHERE nama_mobil LIKE ?";

            Connection con =
                    Connector.getConnection();

            PreparedStatement ps =
                    con.prepareStatement(query);

            ps.setString(1,
                    "%" + keyword + "%");

            ResultSet rs = ps.executeQuery();

            while(rs.next()) {

                model.addRow(new Object[]{

                    rs.getInt("id"),
                    rs.getString("nama_mobil"),
                    rs.getDouble("harga_per_hari"),
                    rs.getString("status_mobil")
                });
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void insertData() {

        try {

            String query =
                    "INSERT INTO mobil "
                    + "VALUES(null,?,?,?)";

            Connection con =
                    Connector.getConnection();

            PreparedStatement ps =
                    con.prepareStatement(query);

            ps.setString(1,
                    view.getNamaMobil());

            ps.setDouble(2,
                    view.getHarga());

            ps.setString(3,
                    view.getStatus());

            ps.executeUpdate();

            JOptionPane.showMessageDialog(
                    null,
                    "Mobil Berhasil Ditambah");

            showData("");

            view.clearForm();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateData() {

        if(selectedId == -1) {

            JOptionPane.showMessageDialog(
                    null,
                    "Pilih Data Dulu");

            return;
        }

        try {

            String query =
                    "UPDATE mobil SET "
                    + "nama_mobil=?, "
                    + "harga_per_hari=?, "
                    + "status_mobil=? "
                    + "WHERE id=?";

            Connection con =
                    Connector.getConnection();

            PreparedStatement ps =
                    con.prepareStatement(query);

            ps.setString(1,
                    view.getNamaMobil());

            ps.setDouble(2,
                    view.getHarga());

            ps.setString(3,
                    view.getStatus());

            ps.setInt(4,
                    selectedId);

            ps.executeUpdate();

            JOptionPane.showMessageDialog(
                    null,
                    "Data Berhasil Update");

            showData("");

            view.clearForm();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteData() {

        if(selectedId == -1) {

            JOptionPane.showMessageDialog(
                    null,
                    "Pilih Data Dulu");

            return;
        }

        try {

            String query =
                    "DELETE FROM mobil "
                    + "WHERE id=?";

            Connection con =
                    Connector.getConnection();

            PreparedStatement ps =
                    con.prepareStatement(query);

            ps.setInt(1,
                    selectedId);

            ps.executeUpdate();

            JOptionPane.showMessageDialog(
                    null,
                    "Data Berhasil Dihapus");

            showData("");

            view.clearForm();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}