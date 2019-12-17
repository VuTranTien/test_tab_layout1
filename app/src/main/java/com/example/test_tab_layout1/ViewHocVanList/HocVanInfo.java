package com.example.test_tab_layout1.ViewHocVanList;

/**
 * Project name: test_tab_layout1
 * Created by Tran Tien Vu
 * on 10, December,2019
 **/
public class HocVanInfo {
    private String tentruong, masocv, namtotnghiep,chuyennganh;
    public HocVanInfo(){

    }

    public HocVanInfo(String tentruong, String masocv, String namtotnghiep, String chuyennganh) {
        this.tentruong = tentruong;
        this.masocv = masocv;
        this.namtotnghiep = namtotnghiep;
        this.chuyennganh = chuyennganh;
    }

    public String getTentruong() {
        return tentruong;
    }

    public void setTentruong(String tentruong) {
        this.tentruong = tentruong;
    }

    public String getMasocv() {
        return masocv;
    }

    public void setMasocv(String masocv) {
        this.masocv = masocv;
    }

    public String getNamtotnghiep() {
        return namtotnghiep;
    }

    public void setNamtotnghiep(String namtotnghiep) {
        this.namtotnghiep = namtotnghiep;
    }

    public String getChuyennganh() {
        return chuyennganh;
    }

    public void setChuyennganh(String chuyennganh) {
        this.chuyennganh = chuyennganh;
    }
}
