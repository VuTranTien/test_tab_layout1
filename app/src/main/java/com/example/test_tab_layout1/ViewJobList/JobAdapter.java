package com.example.test_tab_layout1.ViewJobList;

import android.app.AlertDialog;
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

import java.util.List;

import static androidx.core.content.ContextCompat.startActivity;

/**
 * Project name: test_tab_layout1
 * Created by Tran Tien Vu
 * on 07, December,2019
 **/
public class JobAdapter extends RecyclerView.Adapter<JobAdapter.MyViewHolder> {

    private List<jobInfo> jobInfoListList;

    private static String mabaidang;
    class MyViewHolder extends RecyclerView.ViewHolder {
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
//                    final CharSequence[] items = {"Thêm","Xóa","Sửa"};
//                    AlertDialog.Builder builder = new AlertDialog.Builder(tencongty.getContext());
//                    builder.setTitle("Tùy chọn");
//                    builder.setItems(i)

                    Intent it = new Intent(tencongty.getContext(), thongtincongviecActivity.class);
                    it.putExtra("mabaidang",mabaidang);
                    tencongty.getContext().startActivity(it);
                }
            });
        }
    }

    public JobAdapter(List<jobInfo> jobInfoListList) {
        this.jobInfoListList = jobInfoListList;
    }

    @NonNull
    @Override
    public JobAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_congviec, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
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
}
