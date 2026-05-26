/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;
import controller.TransaksiController;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class TransaksiView extends JFrame {

    JLabel title = new JLabel("TRANSAKSI RENTAL");
    JLabel lNama = new JLabel("Nama Penyewa");
    JLabel lCariMobil = new JLabel("Cari Mobil");
    JLabel lMobil = new JLabel("Mobil");
    JLabel lLama = new JLabel("Lama Sewa");
    JLabel lHarga = new JLabel("Harga/Hari");
    JLabel lTotal = new JLabel("Total Harga");
    JLabel lBayar = new JLabel("Pembayaran");
    JLabel lStatus = new JLabel("Status");
    JLabel lCari = new JLabel("Cari");

    public JTextField tfNama = new JTextField();
    public JTextField tfCariMobil = new JTextField();
    public JTextField tfLama = new JTextField();
    public JTextField tfHarga = new JTextField();
    public JTextField tfTotal = new JTextField();
    public JTextField tfCari = new JTextField();

    public JComboBox<String> cbMobil = new JComboBox<>();

    String bayar[] = {"Lunas", "Belum Lunas"};
    public JComboBox cbBayar = new JComboBox(bayar);

    String status[] = {"Sedang Disewa", "Selesai"};
    public JComboBox cbStatus = new JComboBox(status);

    public JButton btnTambah = new JButton("Tambah");
    public JButton btnUpdate = new JButton("Update");
    public JButton btnDelete = new JButton("Delete");
    public JButton btnCetak = new JButton("Cetak Struk");

    // TAMBAH BUTTON KEMBALI
    public JButton btnKembali = new JButton("← Kembali");

    DefaultTableModel model;
    public JTable table;
    String header[] = {
        "ID", "Nama Penyewa", "Mobil",
        "Lama", "Harga/Hari", "Total",
        "Pembayaran", "Status"
    };

    public TransaksiView() {
        setTitle("Transaksi Rental");
        setSize(1200, 700);
        setLayout(null);
        setVisible(true);
        setLocationRelativeTo(null);

        add(title);
        title.setBounds(500, 10, 300, 30);

        // BUTTON KEMBALI (pojok kiri atas)
        add(btnKembali);
        btnKembali.setBounds(30, 10, 120, 30);

        // NAMA
        add(lNama);
        lNama.setBounds(30, 60, 120, 25);
        add(tfNama);
        tfNama.setBounds(170, 60, 220, 25);

        // SEARCH MOBIL
        add(lCariMobil);
        lCariMobil.setBounds(30, 100, 120, 25);
        add(tfCariMobil);
        tfCariMobil.setBounds(170, 100, 220, 25);

        // MOBIL
        add(lMobil);
        lMobil.setBounds(30, 140, 120, 25);
        add(cbMobil);
        cbMobil.setBounds(170, 140, 220, 25);

        // LAMA
        add(lLama);
        lLama.setBounds(30, 180, 120, 25);
        add(tfLama);
        tfLama.setBounds(170, 180, 220, 25);

        // HARGA
        add(lHarga);
        lHarga.setBounds(30, 220, 120, 25);
        add(tfHarga);
        tfHarga.setBounds(170, 220, 220, 25);
        tfHarga.setEditable(false);

        // TOTAL
        add(lTotal);
        lTotal.setBounds(30, 260, 120, 25);
        add(tfTotal);
        tfTotal.setBounds(170, 260, 220, 25);
        tfTotal.setEditable(false);

        // PEMBAYARAN
        add(lBayar);
        lBayar.setBounds(450, 60, 120, 25);
        add(cbBayar);
        cbBayar.setBounds(580, 60, 220, 25);

        // STATUS
        add(lStatus);
        lStatus.setBounds(450, 100, 120, 25);
        add(cbStatus);
        cbStatus.setBounds(580, 100, 220, 25);

        // BUTTON
        add(btnTambah);
        btnTambah.setBounds(900, 60, 120, 35);
        add(btnUpdate);
        btnUpdate.setBounds(1040, 60, 120, 35);
        add(btnDelete);
        btnDelete.setBounds(900, 110, 260, 35);
        add(btnCetak);
        btnCetak.setBounds(900, 160, 260, 35);

        // SEARCH PENYEWA
        add(lCari);
        lCari.setBounds(30, 320, 120, 25);
        add(tfCari);
        tfCari.setBounds(170, 320, 220, 25);

        // TABLE
        model = new DefaultTableModel(header, 0);
        table = new JTable(model);
        JScrollPane scroll = new JScrollPane(table);
        add(scroll);
        scroll.setBounds(30, 370, 1120, 250);

        // ACTION BUTTON KEMBALI
        btnKembali.addActionListener(e -> {
            dispose();
            new DashboardView();
        });

        new TransaksiController(this);
    }
}