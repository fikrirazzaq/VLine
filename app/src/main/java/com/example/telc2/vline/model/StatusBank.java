package com.example.telc2.vline.model;

/**
 * Created by juvetic on 9/23/17.
 */

public class StatusBank {

    private String namaBank, nomorantriansekarang, jumlahantrian, nomorantrian;

    public StatusBank(String namaBank, String nomorantriansekarang, String jumlahantrian, String nomorantrian) {
        this.namaBank = namaBank;
        this.nomorantriansekarang = nomorantriansekarang;
        this.jumlahantrian = jumlahantrian;
        this.nomorantrian = nomorantrian;
    }

    public String getNamaBank() {
        return namaBank;
    }

    public void setNamaBank(String namaBank) {
        this.namaBank = namaBank;
    }

    public String getNomorantriansekarang() {
        return nomorantriansekarang;
    }

    public void setNomorantriansekarang(String nomorantriansekarang) {
        this.nomorantriansekarang = nomorantriansekarang;
    }

    public String getJumlahantrian() {
        return jumlahantrian;
    }

    public void setJumlahantrian(String jumlahantrian) {
        this.jumlahantrian = jumlahantrian;
    }

    public String getNomorantrian() {
        return nomorantrian;
    }

    public void setNomorantrian(String nomorantrian) {
        this.nomorantrian = nomorantrian;
    }
}
