package com.example.telc2.vline.model.responsemodel;

import com.example.telc2.vline.model.Bank;
import com.example.telc2.vline.model.UserRegis;

import java.util.List;

/**
 * Created by juvetic on 9/23/17.
 */

public class UserRegisResponseModel {

    String sukses, pesan;
    List<UserRegis> result;

    public List<UserRegis> getResult() {
        return result;
    }

    public void setResult(List<UserRegis> result) {
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
