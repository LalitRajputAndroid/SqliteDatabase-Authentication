package com.example.showdatalist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textview.MaterialTextView;

import java.util.ArrayList;

public class myadapter extends RecyclerView.Adapter<myadapter.viewholder> {

    ArrayList<modal> list;
    public myadapter(ArrayList<modal> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.single_row,parent,false);
        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
        holder.t1.setText(list.get(position).getName());
        holder.t2.setText(list.get(position).getEmail());
        holder.t3.setText(list.get(position).getPassword());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class viewholder extends RecyclerView.ViewHolder{
        MaterialTextView t1,t2,t3;

        public viewholder(@NonNull View itemView) {
            super(itemView);
            t1 = itemView.findViewById(R.id.t1_id);
            t2 = itemView.findViewById(R.id.t2_id);
            t3 = itemView.findViewById(R.id.t3_id);
        }
    }
}
