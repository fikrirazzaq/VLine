package com.example.telc2.vline.model;

/**
 * Created by juvetic on 9/23/17.
 */

public class InfoBank {

    private String alamat, jambuka, estimasi, noantriteller, jumlahantriteller, noantrics, jumlahantrics;

    public InfoBank(String alamat, String jambuka, String estimasi, String noantriteller, String jumlahantriteller, String noantrics, String jumlahantrics) {
        this.alamat = alamat;
        this.jambuka = jambuka;
        this.estimasi = estimasi;
        this.noantriteller = noantriteller;
        this.jumlahantriteller = jumlahantriteller;
        this.noantrics = noantrics;
        this.jumlahantrics = jumlahantrics;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getJambuka() {
        return jambuka;
    }

    public void setJambuka(String jambuka) {
        this.jambuka = jambuka;
    }

    public String getEstimasi() {
        return estimasi;
    }

    public void setEstimasi(String estimasi) {
        this.estimasi = estimasi;
    }

    public String getNoantriteller() {
        return noantriteller;
    }

    public void setNoantriteller(String noantriteller) {
        this.noantriteller = noantriteller;
    }

    public String getJumlahantriteller() {
        return jumlahantriteller;
    }

    public void setJumlahantriteller(String jumlahantriteller) {
        this.jumlahantriteller = jumlahantriteller;
    }

    public String getNoantrics() {
        return noantrics;
    }

    public void setNoantrics(String noantrics) {
        this.noantrics = noantrics;
    }

    public String getJumlahantrics() {
        return jumlahantrics;
    }

    public void setJumlahantrics(String jumlahantrics) {
        this.jumlahantrics = jumlahantrics;
    }
}
