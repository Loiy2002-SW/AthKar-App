package com.loiy.athkar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.AthkarViewHolder> {

    List<AthkarModel> modelList;
    Context mContext;

    public RecyclerViewAdapter(List<AthkarModel> modelList, Context mContext) {
        this.modelList = modelList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.AthkarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new AthkarViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.athkar_list_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.AthkarViewHolder holder, int position) {

        holder.tvAthkarList.setText(modelList.get(position).getStatement());
        holder.tvNumberList.setText(modelList.get(position).getNumberOfRep());

    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    public class AthkarViewHolder extends RecyclerView.ViewHolder {
        TextView tvAthkarList, tvNumberList;
        public AthkarViewHolder(@NonNull View itemView) {
            super(itemView);
            tvAthkarList = itemView.findViewById(R.id.list_thiker_textview);
            tvNumberList = itemView.findViewById(R.id.list_number_textview);

        }
    }
}
