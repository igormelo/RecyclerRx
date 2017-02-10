package com.igormelo.recyclerviewrx;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by root on 10/02/17.
 */

public class MyViewHolder extends RecyclerView.ViewHolder {
    public TextView textView;
    public MyViewHolder(View itemView) {
        super(itemView);
        textView = (TextView) itemView.findViewById(R.id.tvName);
    }
}
