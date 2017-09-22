package com.example.telc2.vline.model.responsemodel;

import com.example.telc2.vline.model.Bank;

import java.util.List;

/**
 * Created by TEL-C on 9/22/17.
 */

public class BankResponseModel {

    String kode, pesan;
    List<Bank> result;

    public List<Bank> getResult() {
        return result;
    }

    public void setResult(List<Bank> result) {
        this.result = result;
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getPesan() {
        return pesan;
    }

    public void setPesan(String pesan) {
        this.pesan = pesan;
    }

}
