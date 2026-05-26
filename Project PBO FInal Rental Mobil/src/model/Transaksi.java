/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class Transaksi {

    private int id;
    private String namaPenyewa;
    private int idMobil;
    private int lamaSewa;
    private double hargaPerHari;
    private double totalHarga;
    private String statusPembayaran;
    private String statusSewa;

    public Transaksi(
            int id,
            String namaPenyewa,
            int idMobil,
            int lamaSewa,
            double hargaPerHari,
            double totalHarga,
            String statusPembayaran,
            String statusSewa) {

        this.id = id;
        this.namaPenyewa = namaPenyewa;
        this.idMobil = idMobil;
        this.lamaSewa = lamaSewa;
        this.hargaPerHari = hargaPerHari;
        this.totalHarga = totalHarga;
        this.statusPembayaran = statusPembayaran;
        this.statusSewa = statusSewa;
    }

    public int getId() {
        return id;
    }

    public String getNamaPenyewa() {
        return namaPenyewa;
    }

    public int getIdMobil() {
        return idMobil;
    }

    public int getLamaSewa() {
        return lamaSewa;
    }

    public double getHargaPerHari() {
        return hargaPerHari;
    }

    public double getTotalHarga() {
        return totalHarga;
    }

    public String getStatusPembayaran() {
        return statusPembayaran;
    }

    public String getStatusSewa() {
        return statusSewa;
    }
}
