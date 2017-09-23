package com.example.telc2.vline.model.responsemodel;

import com.example.telc2.vline.model.Bank;
import com.example.telc2.vline.model.InfoBank;

import java.util.List;

/**
 * Created by juvetic on 9/23/17.
 */

public class InfoBankResponseModel {

    String sukses, pesan;
    List<InfoBank> result;

    public List<InfoBank> getResult() {
        return result;
    }

    public void setResult(List<InfoBank> result) {
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
