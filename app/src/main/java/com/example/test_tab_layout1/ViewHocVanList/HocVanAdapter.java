package com.example.test_tab_layout1.ViewHocVanList;

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

import com.example.test_tab_layout1.R;
import com.example.test_tab_layout1.ViewAccountList.AccountAdapter;
import com.example.test_tab_layout1.add_hocvanActivity;
import com.example.test_tab_layout1.add_new_accountActivity;
import com.example.test_tab_layout1.modify_hocvanActivity;
import com.example.test_tab_layout1.update_accountActivity;

import java.util.List;

/**
 * Project name: test_tab_layout1
 * Created by Tran Tien Vu
 * on 10, December,2019
 **/
public class HocVanAdapter extends RecyclerView.Adapter<HocVanAdapter.MyViewHoler>{

    List<HocVanInfo> hocVanInfoList;

    public HocVanAdapter(List<HocVanInfo> hocVanInfoList) {
        this.hocVanInfoList = hocVanInfoList;
    }

    @NonNull
    @Override
    public MyViewHoler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_hocvan, parent, false);
        return new HocVanAdapter.MyViewHoler(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHoler holder, int position) {
        HocVanInfo hocVanInfo = hocVanInfoList.get(position);
        holder.tentruong.setText(hocVanInfo.getTentruong());
        holder.chuyennganh.setText(hocVanInfo.getChuyennganh());
        holder.namtotnghiep.setText(hocVanInfo.getNamtotnghiep());
        holder.masocv.setText(hocVanInfo.getMasocv());


    }

    @Override
    public int getItemCount() {
        return hocVanInfoList.size();
    }

    public class MyViewHoler extends RecyclerView.ViewHolder{

        TextView tentruong, masocv, namtotnghiep, chuyennganh;
        public MyViewHoler(@NonNull View itemView) {
            super(itemView);
            tentruong = itemView.findViewById(R.id.txt_item_tentruong);
            masocv = itemView.findViewById(R.id.txt_item_masocv);
            namtotnghiep = itemView.findViewById(R.id.txt_item_namtotnghiep);
            chuyennganh = itemView.findViewById(R.id.txt_item_chuyennganh);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final CharSequence[] items = {"Insert","Delete", "Modify", "Cancle"};
                    AlertDialog.Builder builder = new AlertDialog.Builder(tentruong.getContext());
                    builder.setTitle("Tùy chọn");
                    builder.setItems(items, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            if (items[which].equals("Delete")) {
                                //Todo: delete hoc van

                                Toast.makeText(tentruong.getContext(), "Đã xóa", Toast.LENGTH_SHORT).show();
                            } else if (items[which].equals("Modify")) {
                                //Todo: update
                                Intent it = new Intent(tentruong.getContext(), modify_hocvanActivity.class);
                                //Todo: dung it.putExtra() de gui data can thiet
                                tentruong.getContext().startActivity(it);
//                               Toast.makeText(tencongty.getContext(),"Đã cập nhật",Toast.LENGTH_SHORT).show();
                            } else if(items[which].equals("Insert")) {
                                Intent it = new Intent(tentruong.getContext(), modify_hocvanActivity.class) ;
                                tentruong.getContext().startActivity(it);
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
