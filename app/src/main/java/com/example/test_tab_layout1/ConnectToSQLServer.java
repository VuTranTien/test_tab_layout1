package com.example.test_tab_layout1;

import android.os.StrictMode;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Project name: test_tab_layout1
 * Created by Tran Tien Vu
 * on 17, December,2019
 **/
public class ConnectToSQLServer {
    public static Connection cn = null;
    private ConnectToSQLServer(){

    }
    public static Connection getInstance(){
        if(cn == null){
            try{
                StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                        .permitAll().build();
                StrictMode.setThreadPolicy(policy);
                Class.forName("net.sourceforge.jtds.jdbc.Driver").newInstance();

                cn = DriverManager.getConnection("jdbc:jtds:sqlserver://192.168.43.220;databaseName=btl2;user=sa;password=tienvu;");
            }catch(Exception e){
                Log.e(e.getMessage(), "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
            }
        }
        return cn;
    }
}
