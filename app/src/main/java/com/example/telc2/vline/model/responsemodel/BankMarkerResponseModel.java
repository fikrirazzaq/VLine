package com.example.telc2.vline.model.responsemodel;

import com.example.telc2.vline.model.Bank;
import com.example.telc2.vline.model.BankMarker;

import java.util.List;

/**
 * Created by juvetic on 9/23/17.
 */

public class BankMarkerResponseModel {

    String sukses, pesan;
    List<BankMarker> result;

    public List<BankMarker> getResult() {
        return result;
    }

    public void setResult(List<BankMarker> result) {
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
