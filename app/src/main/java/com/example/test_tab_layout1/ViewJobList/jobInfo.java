package com.example.test_tab_layout1.ViewJobList;

/**
 * Project name: test_tab_layout1
 * Created by Tran Tien Vu
 * on 07, December,2019
 **/
public class jobInfo {
    private String mabaidang,tencongviec,luong,diadiem,hantuyen,tencongty;
    public jobInfo(){

    }

    public jobInfo(String mabaidang, String tencongviec, String luong, String diadiem, String hantuyen,String tencongty) {
        this.mabaidang = mabaidang;
        this.tencongviec = tencongviec;
        this.luong = luong;
        this.diadiem = diadiem;
        this.hantuyen = hantuyen;
        this.tencongty = tencongty;
    }

    public String getMabaidang() {
        return mabaidang;
    }

    public String getTencongty() {
        return tencongty;
    }

    public void setTencongty(String tencongty) {
        this.tencongty = tencongty;
    }

    public void setMabaidang(String mabaidang) {
        this.mabaidang = mabaidang;
    }

    public String getTencongviec() {
        return tencongviec;
    }

    public void setTencongviec(String tencongviec) {
        this.tencongviec = tencongviec;
    }

    public String getLuong() {
        return luong;
    }

    public void setLuong(String luong) {
        this.luong = luong;
    }

    public String getDiadiem() {
        return diadiem;
    }

    public void setDiadiem(String diadiem) {
        this.diadiem = diadiem;
    }

    public String getHantuyen() {
        return hantuyen;
    }

    public void setHantuyen(String hantuyen) {
        this.hantuyen = hantuyen;
    }

}
