/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class Mobil {

    private int id;
    private String namaMobil;
    private double hargaPerHari;
    private String statusMobil;

    public Mobil(
            int id,
            String namaMobil,
            double hargaPerHari,
            String statusMobil) {

        this.id = id;
        this.namaMobil = namaMobil;
        this.hargaPerHari = hargaPerHari;
        this.statusMobil = statusMobil;
    }

    public int getId() {
        return id;
    }

    public String getNamaMobil() {
        return namaMobil;
    }

    public double getHargaPerHari() {
        return hargaPerHari;
    }

    public String getStatusMobil() {
        return statusMobil;
    }
}
