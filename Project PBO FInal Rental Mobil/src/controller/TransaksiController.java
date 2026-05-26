/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import connection.Connector;
import java.sql.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import view.TransaksiView;

public class TransaksiController {

    TransaksiView view;

    int selectedId = -1;

    public TransaksiController(TransaksiView view) {

        this.view = view;

        loadMobil();

        showData("");

        // =========================================
        // SEARCH MOBIL
        // =========================================
        view.tfCariMobil.addKeyListener(
                new KeyAdapter() {

            @Override
            public void keyReleased(
                    KeyEvent e) {

                cariMobil(
                        view.tfCariMobil
                                .getText());
            }
        });

        // =========================================
        // AUTO HITUNG TOTAL
        // =========================================
        view.tfLama.addKeyListener(
                new java.awt.event.KeyAdapter() {

            public void keyReleased(
                    java.awt.event.KeyEvent evt) {

                hitungTotal();
            }
        });

        // =========================================
        // GANTI MOBIL
        // =========================================
        view.cbMobil.addActionListener(e -> {
            hitungTotal();
        });

        // =========================================
        // BUTTON TAMBAH
        // =========================================
        view.btnTambah.addActionListener(e -> {
            insertData();
        });

        // =========================================
        // BUTTON UPDATE
        // =========================================
        view.btnUpdate.addActionListener(e -> {
            updateData();
        });

        // =========================================
        // BUTTON DELETE
        // =========================================
        view.btnDelete.addActionListener(e -> {
            deleteData();
        });

        // =========================================
        // BUTTON CETAK
        // =========================================
        view.btnCetak.addActionListener(e -> {
            cetakStruk();
        });

        // =========================================
        // SEARCH PENYEWA
        // =========================================
        view.tfCari.addKeyListener(
                new java.awt.event.KeyAdapter() {

            public void keyReleased(
                    java.awt.event.KeyEvent evt) {

                showData(view.tfCari.getText());
            }
        });

        // =========================================
        // SELECT DATA TABEL
        // =========================================
        view.table.getSelectionModel()
                .addListSelectionListener(e -> {

            int row =
                    view.table.getSelectedRow();

            if (row != -1) {

                selectedId =
                        Integer.parseInt(
                                view.table
                                        .getValueAt(
                                                row, 0)
                                        .toString());

                view.tfNama.setText(
                        view.table.getValueAt(
                                row, 1).toString());

                view.tfLama.setText(
                        view.table.getValueAt(
                                row, 3).toString());

                view.tfHarga.setText(
                        view.table.getValueAt(
                                row, 4).toString());

                view.tfTotal.setText(
                        view.table.getValueAt(
                                row, 5).toString());

                view.cbBayar.setSelectedItem(
                        view.table.getValueAt(
                                row, 6).toString());

                view.cbStatus.setSelectedItem(
                        view.table.getValueAt(
                                row, 7).toString());
            }
        });
    }

    // =========================================
    // LOAD MOBIL
    // =========================================
    public void loadMobil() {

        view.cbMobil.removeAllItems();

        try {

            String query =
                    "SELECT * FROM mobil "
                    + "WHERE status_mobil='Tersedia'";

            Connection con =
                    Connector.getConnection();

            Statement st =
                    con.createStatement();

            ResultSet rs =
                    st.executeQuery(query);

            while (rs.next()) {

                view.cbMobil.addItem(
                        rs.getInt("id")
                        + " - "
                        + rs.getString(
                                "nama_mobil"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // =========================================
    // SEARCH MOBIL
    // =========================================
    public void cariMobil(String keyword) {

        view.cbMobil.removeAllItems();

        try {

            String query =
                    "SELECT * FROM mobil "
                    + "WHERE status_mobil='Tersedia' "
                    + "AND nama_mobil LIKE ?";

            Connection con =
                    Connector.getConnection();

            PreparedStatement ps =
                    con.prepareStatement(query);

            ps.setString(
                    1,
                    "%" + keyword + "%");

            ResultSet rs =
                    ps.executeQuery();

            while(rs.next()) {

                view.cbMobil.addItem(

                        rs.getInt("id")
                        + " - "
                        + rs.getString(
                                "nama_mobil"));
            }

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    // =========================================
    // HITUNG TOTAL
    // =========================================
    public void hitungTotal() {

        try {

            if (view.cbMobil.getSelectedItem()
                    == null) {
                return;
            }

            String mobil =
                    view.cbMobil
                    .getSelectedItem()
                    .toString();

            int idMobil =
                    Integer.parseInt(
                            mobil.split(" - ")[0]);

            String query =
                    "SELECT * FROM mobil "
                    + "WHERE id=?";

            Connection con =
                    Connector.getConnection();

            PreparedStatement ps =
                    con.prepareStatement(query);

            ps.setInt(1, idMobil);

            ResultSet rs =
                    ps.executeQuery();

            rs.next();

            double harga =
                    rs.getDouble(
                            "harga_per_hari");

            view.tfHarga.setText(
                    String.valueOf(harga));

            int lama = 0;

            if (!view.tfLama.getText()
                    .isEmpty()) {

                lama =
                        Integer.parseInt(
                                view.tfLama
                                        .getText());
            }

            double total =
                    harga * lama;

            view.tfTotal.setText(
                    String.valueOf(total));

        } catch (Exception e) {
        }
    }

    // =========================================
    // TAMPIL DATA
    // =========================================
    public void showData(String keyword) {

        DefaultTableModel model =
                (DefaultTableModel)
                        view.table.getModel();

        model.setRowCount(0);

        try {

            String query =
                    "SELECT transaksi.*, "
                    + "mobil.nama_mobil "
                    + "FROM transaksi "
                    + "JOIN mobil "
                    + "ON transaksi.id_mobil = mobil.id "
                    + "WHERE nama_penyewa LIKE ?";

            Connection con =
                    Connector.getConnection();

            PreparedStatement ps =
                    con.prepareStatement(query);

            ps.setString(1,
                    "%" + keyword + "%");

            ResultSet rs =
                    ps.executeQuery();

            while (rs.next()) {

                model.addRow(new Object[]{

                    rs.getInt("id"),

                    rs.getString("nama_penyewa"),

                    rs.getString("nama_mobil"),

                    rs.getInt("lama_sewa"),

                    rs.getDouble("harga_per_hari"),

                    rs.getDouble("total_harga"),

                    rs.getString("status_pembayaran"),

                    rs.getString("status_sewa")
                });
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // =========================================
    // INSERT DATA
    // =========================================
    public void insertData() {

        try {

            String mobil =
                    view.cbMobil
                    .getSelectedItem()
                    .toString();

            int idMobil =
                    Integer.parseInt(
                            mobil.split(" - ")[0]);

            double harga =
                    Double.parseDouble(
                            view.tfHarga.getText());

            int lama =
                    Integer.parseInt(
                            view.tfLama.getText());

            double total =
                    Double.parseDouble(
                            view.tfTotal.getText());

            String query =
                    "INSERT INTO transaksi "
                    + "VALUES(null,?,?,?,?,?,?,?)";

            Connection con =
                    Connector.getConnection();

            PreparedStatement ps =
                    con.prepareStatement(query);

            ps.setString(1,
                    view.tfNama.getText());

            ps.setInt(2, idMobil);

            ps.setInt(3, lama);

            ps.setDouble(4, harga);

            ps.setDouble(5, total);

            ps.setString(6,
                    view.cbBayar
                            .getSelectedItem()
                            .toString());

            ps.setString(7,
                    view.cbStatus
                            .getSelectedItem()
                            .toString());

            ps.executeUpdate();

            // UPDATE STATUS MOBIL
            String updateMobil =
                    "UPDATE mobil SET "
                    + "status_mobil='Tidak Tersedia' "
                    + "WHERE id=?";

            PreparedStatement ps2 =
                    con.prepareStatement(updateMobil);

            ps2.setInt(1, idMobil);

            ps2.executeUpdate();

            JOptionPane.showMessageDialog(
                    null,
                    "Transaksi Berhasil");

            showData("");

            loadMobil();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // =========================================
    // UPDATE DATA
    // =========================================
    public void updateData() {

        if (selectedId == -1) {

            JOptionPane.showMessageDialog(
                    null,
                    "Pilih Data Dulu");

            return;
        }

        try {

            String status =
                    view.cbStatus
                    .getSelectedItem()
                    .toString();

            String mobil =
                    view.cbMobil
                    .getSelectedItem()
                    .toString();

            int idMobilBaru =
                    Integer.parseInt(
                            mobil.split(" - ")[0]);

            int lama =
                    Integer.parseInt(
                            view.tfLama.getText());

            double harga =
                    Double.parseDouble(
                            view.tfHarga.getText());

            double total =
                    Double.parseDouble(
                            view.tfTotal.getText());

            Connection con =
                    Connector.getConnection();

            // STATUS SELESAI
            if (status.equals("Selesai")) {

                String getMobil =
                        "SELECT id_mobil "
                        + "FROM transaksi "
                        + "WHERE id=?";

                PreparedStatement psm =
                        con.prepareStatement(getMobil);

                psm.setInt(1, selectedId);

                ResultSet rs =
                        psm.executeQuery();

                rs.next();

                int idMobil =
                        rs.getInt("id_mobil");

                // KEMBALIKAN STATUS MOBIL
                String updateMobil =
                        "UPDATE mobil SET "
                        + "status_mobil='Tersedia' "
                        + "WHERE id=?";

                PreparedStatement ps2 =
                        con.prepareStatement(updateMobil);

                ps2.setInt(1, idMobil);

                ps2.executeUpdate();

                // HAPUS TRANSAKSI
                String delete =
                        "DELETE FROM transaksi "
                        + "WHERE id=?";

                PreparedStatement psDelete =
                        con.prepareStatement(delete);

                psDelete.setInt(1, selectedId);

                psDelete.executeUpdate();

                JOptionPane.showMessageDialog(
                        null,
                        "Rental Selesai");

            } else {

                String query =
                        "UPDATE transaksi SET "
                        + "nama_penyewa=?, "
                        + "id_mobil=?, "
                        + "lama_sewa=?, "
                        + "harga_per_hari=?, "
                        + "total_harga=?, "
                        + "status_pembayaran=?, "
                        + "status_sewa=? "
                        + "WHERE id=?";

                PreparedStatement ps =
                        con.prepareStatement(query);

                ps.setString(1,
                        view.tfNama.getText());

                ps.setInt(2,
                        idMobilBaru);

                ps.setInt(3,
                        lama);

                ps.setDouble(4,
                        harga);

                ps.setDouble(5,
                        total);

                ps.setString(6,
                        view.cbBayar
                                .getSelectedItem()
                                .toString());

                ps.setString(7,
                        status);

                ps.setInt(8,
                        selectedId);

                ps.executeUpdate();

                JOptionPane.showMessageDialog(
                        null,
                        "Data Berhasil Diupdate");
            }

            showData("");

            loadMobil();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // =========================================
    // DELETE DATA
    // =========================================
    public void deleteData() {

        if (selectedId == -1) {

            JOptionPane.showMessageDialog(
                    null,
                    "Pilih Data Dulu");

            return;
        }

        try {

            String query =
                    "DELETE FROM transaksi "
                    + "WHERE id=?";

            Connection con =
                    Connector.getConnection();

            PreparedStatement ps =
                    con.prepareStatement(query);

            ps.setInt(1, selectedId);

            ps.executeUpdate();

            JOptionPane.showMessageDialog(
                    null,
                    "Data Berhasil Dihapus");

            showData("");

            loadMobil();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // =========================================
    // CETAK STRUK
    // =========================================
    public void cetakStruk() {

        int row =
                view.table.getSelectedRow();

        if (row == -1) {

            JOptionPane.showMessageDialog(
                    null,
                    "Pilih Data Dulu");

            return;
        }

        String struk =

                "=========== STRUK RENTAL ===========\n"

                + "Nama Penyewa : "
                + view.table.getValueAt(row, 1)

                + "\n"

                + "Mobil : "
                + view.table.getValueAt(row, 2)

                + "\n"

                + "Lama Sewa : "
                + view.table.getValueAt(row, 3)

                + " Hari\n"

                + "Harga/Hari : "
                + view.table.getValueAt(row, 4)

                + "\n"

                + "Total Harga : "
                + view.table.getValueAt(row, 5)

                + "\n"

                + "Pembayaran : "
                + view.table.getValueAt(row, 6)

                + "\n"

                + "Status : "
                + view.table.getValueAt(row, 7)

                + "\n"

                + "===================================";

        JOptionPane.showMessageDialog(
                null,
                struk);
    }
}