package com.example.test_tab_layout1.ViewJobList;

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
import com.example.test_tab_layout1.thongtincongviecActivity;
import com.example.test_tab_layout1.update_baidangActivity;

import java.util.List;

/**
 * Project name: test_tab_layout1
 * Created by Tran Tien Vu
 * on 07, December,2019
 **/
public class RecJobAdapter extends RecyclerView.Adapter<RecJobAdapter.MyViewHolder> {
    private static String mabaidang;
    private List<jobInfo> jobInfoListList;

    public RecJobAdapter(List<jobInfo> jobInfoListList) {
        this.jobInfoListList = jobInfoListList;
    }

    @NonNull
    @Override
    public RecJobAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_congviec, parent, false);
        return new RecJobAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecJobAdapter.MyViewHolder holder, int position) {
        jobInfo jb = jobInfoListList.get(position);
        holder.tencongviec.setText(jb.getTencongviec());
        holder.tencongty.setText(jb.getTencongty());
        holder.diadiem.setText(jb.getDiadiem());
        holder.luong.setText(jb.getLuong());
        holder.hantuyen.setText(jb.getHantuyen());
        mabaidang = jb.getMabaidang();

    }

    @Override
    public int getItemCount() {
        return jobInfoListList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tencongty, tencongviec, logo,diadiem,luong,hantuyen;
        MyViewHolder(final View view) {
            super(view);
            tencongty = view.findViewById(R.id.txt_item_tencongty);
            tencongviec = view.findViewById(R.id.txt_item_tencongviec);
//            logo = view.findViewById(R.id.img_static_logo);
            hantuyen = view.findViewById(R.id.txt_item_hantuyen);
            diadiem = view.findViewById(R.id.txt_item_diadiem);
            luong = view.findViewById(R.id.txt_item_luong);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                    tencongty.setText(String.valueOf(getAdapterPosition()));
                    final CharSequence[] items = {"Delete","Modify","Cancle"};
                    AlertDialog.Builder builder = new AlertDialog.Builder(tencongty.getContext());
                    builder.setTitle("Tùy chọn");
                    builder.setItems(items, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                           if(items[which].equals("Delete")) {
                               //Todo: delete cong viec
                               Toast.makeText(tencongty.getContext(),"Đã xóa",Toast.LENGTH_SHORT).show();
                           }
                           else if(items[which].equals("Modify")){
                               //Todo: update
                               Intent it = new Intent(tencongty.getContext(), update_baidangActivity.class);
                               it.putExtra("mabaidang",mabaidang);
                               tencongty.getContext().startActivity(it);
//                               Toast.makeText(tencongty.getContext(),"Đã cập nhật",Toast.LENGTH_SHORT).show();
                           }
                           else{
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
