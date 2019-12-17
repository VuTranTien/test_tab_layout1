package com.example.test_tab_layout1.ViewCompanyList;

/**
 * Project name: test_tab_layout1
 * Created by Tran Tien Vu
 * on 10, December,2019
 **/
public class CompanyInfo {
    private String macongty, email, std, website, mota, diachi, ten;
    public CompanyInfo(){

    }

    public CompanyInfo(String macongty, String email, String std, String website, String mota, String diachi, String ten) {
        this.macongty = macongty;
        this.email = email;
        this.std = std;
        this.website = website;
        this.mota = mota;
        this.diachi = diachi;
        this.ten = ten;
    }

    public String getMacongty() {
        return macongty;
    }

    public void setMacongty(String macongty) {
        this.macongty = macongty;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStd() {
        return std;
    }

    public void setStd(String std) {
        this.std = std;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }
}
