package com.example.telc2.vline.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by juvetic on 9/23/17.
 */

public class BankMarker {
    @SerializedName("bank_nama")
    private String bankNama;
    @SerializedName("bank_latitude")
    private String bankLat;
    @SerializedName("bank_longitude")
    private String bankLon;

    public BankMarker(String bankNama, String bankLat,
                  String bankLon) {
        this.bankNama = bankNama;
        this.bankLat = bankLat;
        this.bankLon = bankLon;
    }

    public String getBankNama() {
        return bankNama;
    }

    public void setBankNama(String bankNama) {
        this.bankNama = bankNama;
    }

    public String getBankLat() {
        return bankLat;
    }

    public void setBankLat(String bankLat) {
        this.bankLat = bankLat;
    }

    public String getBankLon() {
        return bankLon;
    }

    public void setBankLon(String bankLon) {
        this.bankLon = bankLon;
    }
}
