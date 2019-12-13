package com.ben.duan1_shop.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ben.duan1_shop.Model.Hienthi;
import com.ben.duan1_shop.R;

public class HienthiAdapter extends RecyclerView.Adapter<HienthiAdapter.ViewHolder> {

    private Hienthi[] itemsData;

    public HienthiAdapter(Hienthi[] itemsData){
        this.itemsData = itemsData;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // create a new view
        View itemLayoutView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.sp_item, null);

        // create ViewHolder

        ViewHolder viewHolder = new ViewHolder(itemLayoutView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.txtViewTitle.setText(itemsData[position].getTv());
        holder.imgViewIcon.setImageResource(itemsData[position].getHinh());

    }

    @Override
    public int getItemCount() {
        return itemsData.length;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder{

        public TextView txtViewTitle;
        public ImageView imgViewIcon;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtViewTitle = (TextView) itemView.findViewById(R.id.tv);
            imgViewIcon = (ImageView) itemView.findViewById(R.id.iv);
        }
    }


}
