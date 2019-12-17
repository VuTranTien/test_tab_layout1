package com.example.test_tab_layout1.ViewJobList;

import com.example.test_tab_layout1.ConnectToSQLServer;

import java.sql.ResultSet;
import java.sql.Statement;

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
        try {
            Statement state = ConnectToSQLServer.getInstance().createStatement();
            ResultSet rsTenCty = state.executeQuery("select TenCty from Nguoi_dung nd join Cong_ty ct on nd.MaSoCty = ct.MaSoCty where nd.Username = '" + this.tencongty + "'");
            rsTenCty.next();
            this.tencongty = rsTenCty.getString(1);
        }catch (Exception e){

        }
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
