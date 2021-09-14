package com.example.presidentlistrecyclerview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.presidentlistrecyclerview.databinding.RowLayoutBinding;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    List<President> presidentList;
    Context context;

    public MyAdapter(List<President> presidentList, Context context) {
        this.presidentList = presidentList;
        this.context = context;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private final RowLayoutBinding binding;

        MyViewHolder(RowLayoutBinding binding){
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(RowLayoutBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.binding.tvRowName.setText(presidentList.get(position).getName());
        holder.binding.tvYear.setText(String.valueOf(presidentList.get(position).getDateOfElection()));
        Glide.with(context).load(presidentList.get(position).getImageURL()).into(holder.binding.ivPortrait);

        holder.binding.rowPresidentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, AddOneActivity.class);
                intent.putExtra("id", presidentList.get(position).getId());
                context.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return presidentList.size();
    }
}
