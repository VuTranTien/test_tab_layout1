package com.example.test_tab_layout1.ViewAccountList;

/**
 * Project name: test_tab_layout1
 * Created by Tran Tien Vu
 * on 10, December,2019
 **/
public class AccountInfo {
    private String username,pass,email,hotendem,ten,sdt,diachi,accountType,macongty;

    public AccountInfo(String username, String pass, String email, String hotendem, String ten, String sdt, String diachi, String accountType, String macongty) {
        this.username = username;
        this.pass = pass;
        this.email = email;
        this.hotendem = hotendem;
        this.ten = ten;
        this.sdt = sdt;
        this.diachi = diachi;
        this.accountType = accountType;
        this.macongty = macongty;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHotendem() {
        return hotendem;
    }

    public void setHotendem(String hotendem) {
        this.hotendem = hotendem;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getMacongty() {
        return macongty;
    }

    public void setMacongty(String macongty) {
        this.macongty = macongty;
    }
}
