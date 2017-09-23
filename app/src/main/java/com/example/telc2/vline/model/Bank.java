package com.example.telc2.vline.model;

/**
 * Created by TEL-C on 9/22/17.
 */

public class Bank {

    private String bank_id;
    private String bank_nama;
    private String bank_gambar;
    private String bank_nomor_antri_teller_sekarang;
    private String bank_nomor_antri_cs_sekarang;
    private String bank_jumlah_antri_teller;
    private String bank_jumlah_antri_cs;

    public Bank(String bank_id, String bank_nama, String bank_nomor_antri_teller_sekarang, String bank_nomor_antri_cs_sekarang, String bank_jumlah_antri_teller, String bank_jumlah_antri_cs) {
        this.bank_id = bank_id;
        this.bank_nama = bank_nama;
        this.bank_nomor_antri_teller_sekarang = bank_nomor_antri_teller_sekarang;
        this.bank_nomor_antri_cs_sekarang = bank_nomor_antri_cs_sekarang;
        this.bank_jumlah_antri_teller = bank_jumlah_antri_teller;
        this.bank_jumlah_antri_cs = bank_jumlah_antri_cs;
    }

    public String getBank_id() {
        return bank_id;
    }

    public void setBank_id(String bank_id) {
        this.bank_id = bank_id;
    }

    public String getBank_nama() {
        return bank_nama;
    }

    public void setBank_nama(String bank_nama) {
        this.bank_nama = bank_nama;
    }

    public String getBank_gambar() {
        return bank_gambar;
    }

    public void setBank_gambar(String bank_gambar) {
        this.bank_gambar = bank_gambar;
    }

    public String getBank_nomor_antri_teller_sekarang() {
        return bank_nomor_antri_teller_sekarang;
    }

    public void setBank_nomor_antri_teller_sekarang(String bank_nomor_antri_teller_sekarang) {
        this.bank_nomor_antri_teller_sekarang = bank_nomor_antri_teller_sekarang;
    }

    public String getBank_nomor_antri_cs_sekarang() {
        return bank_nomor_antri_cs_sekarang;
    }

    public void setBank_nomor_antri_cs_sekarang(String bank_nomor_antri_cs_sekarang) {
        this.bank_nomor_antri_cs_sekarang = bank_nomor_antri_cs_sekarang;
    }

    public String getBank_jumlah_antri_teller() {
        return bank_jumlah_antri_teller;
    }

    public void setBank_jumlah_antri_teller(String bank_jumlah_antri_teller) {
        this.bank_jumlah_antri_teller = bank_jumlah_antri_teller;
    }

    public String getBank_jumlah_antri_cs() {
        return bank_jumlah_antri_cs;
    }

    public void setBank_jumlah_antri_cs(String bank_jumlah_antri_cs) {
        this.bank_jumlah_antri_cs = bank_jumlah_antri_cs;
    }
}
