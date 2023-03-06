package com.loiy.athkar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
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

        holder.list_thiker_textview.setText(modelList.get(position).getStatement());
        holder.list_ajer_textview.setText(modelList.get(position).getAjer());
        holder.list_number_textview.setText(modelList.get(position).getNumberOfRep());


        holder.list_constraint.setOnClickListener(v -> {

            switch (holder.list_number_textview.getText().toString()){

                case "مرة واحدة":
                    finishThiker(holder.list_number_textview, holder.list_constraint);
                    break;


                case "ثلاث مرات":
                    holder.list_number_textview.setText("2");
                    break;


                case "أربع مرات":
                    holder.list_number_textview.setText("3");
                    break;


                case "سبع مرات":
                    holder.list_number_textview.setText("6");
                    break;

                case "عشر مرات":
                    holder.list_number_textview.setText("9");
                    break;


                case "مئة مرة":
                    holder.list_number_textview.setText("99");
                    break;

                case "تم بحمد الله":
                    Toast.makeText(mContext, mContext.getString(R.string.already_finished_str), Toast.LENGTH_SHORT).show();
                    break;

                default:
                    try{
                        byte numberOfRemain = (byte) Integer.parseInt(holder.list_number_textview.getText().toString());
                        if(numberOfRemain == 1)
                            finishThiker(holder.list_number_textview, holder.list_constraint);
                        else
                            holder.list_number_textview.setText(String.valueOf(numberOfRemain-1));
                    }catch (Exception e){

                        finishThiker(holder.list_number_textview, holder.list_constraint);

                    }


            }
        });

    }

    public void finishThiker(TextView tv, ConstraintLayout cl){

        tv.setText(mContext.getString(R.string.finished_str));
        cl.setBackgroundColor(mContext.getColor(R.color.light_blue));

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
        TextView list_thiker_textview, list_ajer_textview, list_number_textview;
        ConstraintLayout list_constraint;
        public AthkarViewHolder(@NonNull View itemView) {
            super(itemView);

            list_thiker_textview = itemView.findViewById(R.id.list_thiker_textview);
            list_ajer_textview = itemView.findViewById(R.id.list_ajer_textview);
            list_number_textview = itemView.findViewById(R.id.list_number_textview);


            list_constraint = itemView.findViewById(R.id.list_constraint);

        }
    }
}
