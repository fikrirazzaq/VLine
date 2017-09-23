package com.example.telc2.vline.model;

/**
 * Created by juvetic on 9/23/17.
 */

public class UserRegis {

    private String namaLengkap, username, notelp, password;

    public UserRegis(String namaLengkap, String username, String notelp, String password) {
        this.namaLengkap = namaLengkap;
        this.username = username;
        this.notelp = notelp;
        this.password = password;
    }

    public String getNamaLengkap() {
        return namaLengkap;
    }

    public void setNamaLengkap(String namaLengkap) {
        this.namaLengkap = namaLengkap;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNotelp() {
        return notelp;
    }

    public void setNotelp(String notelp) {
        this.notelp = notelp;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
