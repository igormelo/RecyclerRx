package com.igormelo.recyclerviewrx;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 10/02/17.
 */

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {
    private Context context;
    private List<String> nameList = new ArrayList<>();

    public MyAdapter(Context context) {
        this.context= context;
    }
    public void setData(List<String> names){
        nameList.clear();
        nameList.addAll(names);
        notifyDataSetChanged();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.textView.setText(nameList.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, " "+ nameList.get(position).toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    public int getItemCount() {
        return nameList.size();
    }
}
