package com.example.test_tab_layout1.ViewCompanyList;

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
import com.example.test_tab_layout1.add_congtyActivity;
import com.example.test_tab_layout1.modify_congtyActivity;
import com.example.test_tab_layout1.update_baidangActivity;

import java.util.List;

/**
 * Project name: test_tab_layout1
 * Created by Tran Tien Vu
 * on 10, December,2019
 **/
public class CompanyAdapter extends RecyclerView.Adapter<CompanyAdapter.MyViewHoler> {

    List<CompanyInfo> companyInfoList;
    private String macongty;

    public CompanyAdapter(List<CompanyInfo> companyInfoList) {
        this.companyInfoList = companyInfoList;
    }

    @NonNull
    @Override
    public MyViewHoler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_congty, parent, false);
        return new CompanyAdapter.MyViewHoler(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHoler holder, int position) {
        CompanyInfo companyInfo = companyInfoList.get(position);
        holder.txt_item_tencongty.setText(companyInfo.getTen());
        holder.txt_item_diachicongty.setText(companyInfo.getDiachi());
        holder.txt_item_emailcongty.setText(companyInfo.getEmail());
        holder.txt_item_sdtcongty.setText(companyInfo.getStd());


    }

    @Override
    public int getItemCount() {
        return companyInfoList.size();
    }

    public class MyViewHoler extends RecyclerView.ViewHolder{

        TextView txt_item_tencongty,txt_item_diachicongty,txt_item_sdtcongty,txt_item_emailcongty;
        public MyViewHoler(final View itemView) {
            super(itemView);


            txt_item_tencongty = itemView.findViewById(R.id.txt_item_tencongty);
            txt_item_diachicongty = itemView.findViewById(R.id.txt_item_diachicongty);
            txt_item_emailcongty = itemView.findViewById(R.id.txt_emailcongty);
            txt_item_sdtcongty = itemView.findViewById(R.id.txt_item_sdtcongty);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Todo: alertDialock

                    final CharSequence[] items = {"Insert", "Delete", "Modify", "Cancle"};
                    AlertDialog.Builder builder = new AlertDialog.Builder(txt_item_tencongty.getContext());
                    builder.setTitle("Tùy chọn");
                    builder.setItems(items, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            if (items[which].equals("Delete")) {
                                //Todo: delete cong ty co macongty
                                Toast.makeText(txt_item_tencongty.getContext(), "Đã xóa", Toast.LENGTH_SHORT).show();
                            } else if (items[which].equals("Modify")) {
                                //Todo: update
                                Intent it = new Intent(txt_item_tencongty.getContext(), modify_congtyActivity.class);
                                it.putExtra("macongty", macongty);
                                txt_item_tencongty.getContext().startActivity(it);
//                               Toast.makeText(tencongty.getContext(),"Đã cập nhật",Toast.LENGTH_SHORT).show();
                            } else if (items[which].equals("Insert")) {
                                //Todo: them cong ty moi
                                Intent it = new Intent(txt_item_tencongty.getContext(), add_congtyActivity.class);
                                txt_item_tencongty.getContext().startActivity(it);
                            } else {
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
