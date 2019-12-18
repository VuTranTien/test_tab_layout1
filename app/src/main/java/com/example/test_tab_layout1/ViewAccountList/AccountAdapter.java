package com.example.test_tab_layout1.ViewAccountList;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.test_tab_layout1.ConnectToSQLServer;
import com.example.test_tab_layout1.R;
import com.example.test_tab_layout1.add_new_accountActivity;
import com.example.test_tab_layout1.ui.recruiter.PageViewInform;
import com.example.test_tab_layout1.update_accountActivity;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

/**
 * Project name: test_tab_layout1
 * Created by Tran Tien Vu
 * on 10, December,2019
 **/
public class AccountAdapter extends RecyclerView.Adapter<AccountAdapter.MyViewHoler> {

    List<AccountInfo> accountInfoList;
    String _username;

    public AccountAdapter(List<AccountInfo> accountInfoList) {
        this.accountInfoList = accountInfoList;
    }

    @NonNull
    @Override
    public AccountAdapter.MyViewHoler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_account, parent, false);
        return new AccountAdapter.MyViewHoler(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHoler holder, int position) {
        AccountInfo accountInfo = accountInfoList.get(position);
        holder.tencongty.setText(accountInfo.getMacongty());
        holder.sdt.setText(accountInfo.getSdt());
        holder.diachi.setText(accountInfo.getDiachi());
        holder.hovaten.setText(accountInfo.getHotendem() + " " + accountInfo.getTen());
        holder.username.setText(accountInfo.getUsername());
        _username = accountInfo.getUsername();

    }


    @Override
    public int getItemCount() {
        return accountInfoList.size();
    }

    public class MyViewHoler extends RecyclerView.ViewHolder {
        TextView username, hovaten, diachi, sdt, tencongty;

        public MyViewHoler(@NonNull final View itemView) {
            super(itemView);
            username = itemView.findViewById(R.id.txt_item_username);
            hovaten = itemView.findViewById(R.id.txt_item_hovaten);
            diachi = itemView.findViewById(R.id.txt_item_diachiuser);
            sdt = itemView.findViewById(R.id.txt_item_sdt_user);
            tencongty = itemView.findViewById(R.id.txt_item_tencongty);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final CharSequence[] items = {"Insert","Delete", "Modify", "Cancle"};
                    AlertDialog.Builder builder = new AlertDialog.Builder(tencongty.getContext());
                    builder.setTitle("Tùy chọn");
                    builder.setItems(items, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            if (items[which].equals("Delete")) {
                                //Todo: delete cong viec

                                try {
                                    Statement state = ConnectToSQLServer.getInstance().createStatement();
                                    state.executeQuery("delete from Nguoi_dung where Username = '"  +
                                            username.getText().toString() + "'"
                                    );
                                }catch(Exception e){

                                }
                                accountInfoList.remove(getAdapterPosition());
                                notifyDataSetChanged();
                                Toast.makeText(tencongty.getContext(), "Đã xóa", Toast.LENGTH_SHORT).show();
                            } else if (items[which].equals("Modify")) {
                                //Todo: update
                                Intent it = new Intent(tencongty.getContext(), update_accountActivity.class);
                                it.putExtra("username", _username);
                                tencongty.getContext().startActivity(it);
//                               Toast.makeText(tencongty.getContext(),"Đã cập nhật",Toast.LENGTH_SHORT).show();
                            } else if(items[which].equals("Insert")) {
                                Intent it = new Intent(tencongty.getContext(), add_new_accountActivity.class) ;
                                tencongty.getContext().startActivity(it);
                            }
                            else {
                                dialog.dismiss();
                            }
                        }
                    });
                    builder.show();

                }
            });
        }
    }



}
