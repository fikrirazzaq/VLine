package com.example.telc2.vline.model.responsemodel;

import com.example.telc2.vline.model.Bank;

import java.util.List;

/**
 * Created by TEL-C on 9/22/17.
 */

public class BankResponseModel {

    String sukses, pesan;
    List<Bank> result;

    public List<Bank> getResult() {
        return result;
    }

    public void setResult(List<Bank> result) {
        this.result = result;
    }

    public String getSukses() {
        return sukses;
    }

    public void setSukses(String sukses) {
        this.sukses = sukses;
    }

    public String getPesan() {
        return pesan;
    }

    public void setPesan(String pesan) {
        this.pesan = pesan;
    }

}
