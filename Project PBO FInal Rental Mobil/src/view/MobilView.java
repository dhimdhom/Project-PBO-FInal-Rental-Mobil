/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;
import controller.MobilController;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class MobilView extends JFrame {
    JLabel title = new JLabel("DATA MOBIL");
    JLabel lNama = new JLabel("Mobil");
    JLabel lHarga = new JLabel("Harga / Hari");
    JLabel lStatus = new JLabel("Status Mobil");
    JLabel lCari = new JLabel("Cari");
    public JTextField tfNama = new JTextField();
    public JTextField tfHarga = new JTextField();
    public JTextField tfCari = new JTextField();
    String status[] = {
        "Tersedia",
        "Tidak Tersedia"
    };
    public JComboBox cbStatus =
            new JComboBox(status);
    public JButton btnTambah =
            new JButton("Tambah");
    public JButton btnUpdate =
            new JButton("Update");
    public JButton btnDelete =
            new JButton("Delete");
    public JButton btnClear =
            new JButton("Clear");

    // TAMBAH BUTTON KEMBALI
    public JButton btnKembali =
            new JButton("← Kembali");

    DefaultTableModel model;
    public JTable table;
    String header[] = {
        "ID",
        "Nama Mobil",
        "Harga/Hari",
        "Status"
    };

    public MobilView() {
        setTitle("Data Mobil");
        setSize(900, 600);
        setLayout(null);
        setVisible(true);
        setLocationRelativeTo(null);

        add(title);
        title.setBounds(350, 10, 300, 30);

        // BUTTON KEMBALI (pojok kiri atas)
        add(btnKembali);
        btnKembali.setBounds(30, 10, 120, 30);

        add(lNama);
        lNama.setBounds(30, 60, 120, 25);
        add(tfNama);
        tfNama.setBounds(150, 60, 220, 25);

        add(lHarga);
        lHarga.setBounds(30, 100, 120, 25);
        add(tfHarga);
        tfHarga.setBounds(150, 100, 220, 25);

        add(lStatus);
        lStatus.setBounds(30, 140, 120, 25);
        add(cbStatus);
        cbStatus.setBounds(150, 140, 220, 25);

        add(btnTambah);
        btnTambah.setBounds(450, 60, 100, 30);
        add(btnUpdate);
        btnUpdate.setBounds(570, 60, 100, 30);
        add(btnDelete);
        btnDelete.setBounds(690, 60, 100, 30);
        add(btnClear);
        btnClear.setBounds(450, 110, 340, 30);

        add(lCari);
        lCari.setBounds(30, 200, 100, 25);
        add(tfCari);
        tfCari.setBounds(150, 200, 220, 25);

        model = new DefaultTableModel(header, 0);
        table = new JTable(model);
        JScrollPane scroll = new JScrollPane(table);
        add(scroll);
        scroll.setBounds(30, 250, 820, 250);

        // ACTION BUTTON KEMBALI
        btnKembali.addActionListener(e -> {
            dispose();
            new DashboardView();
        });

        new MobilController(this);
    }

    public String getNamaMobil() {
        return tfNama.getText();
    }

    public double getHarga() {
        return Double.parseDouble(tfHarga.getText());
    }

    public String getStatus() {
        return cbStatus.getSelectedItem().toString();
    }

    public void clearForm() {
        tfNama.setText("");
        tfHarga.setText("");
    }
}