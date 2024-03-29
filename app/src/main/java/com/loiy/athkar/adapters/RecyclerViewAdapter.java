package com.loiy.athkar.adapters;

import static com.loiy.athkar.ui.AthkarShow.recyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.loiy.athkar.model.AthkarModel;
import com.loiy.athkar.R;

import java.util.List;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.view.MotionEvent;


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.AthkarViewHolder> {

    List<AthkarModel> modelList;
    Context mContext;

    private boolean hasScrolled = false;


    public static int count = 0;
    public RecyclerViewAdapter(List<AthkarModel> modelList, Context mContext) {
        this.modelList = modelList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public AthkarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new AthkarViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.athkar_list_item,parent,false));
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public void onBindViewHolder(@NonNull AthkarViewHolder holder, int position) {

        holder.list_thiker_textview.setText(modelList.get(position).getStatement());
        holder.list_ajer_textview.setText(modelList.get(position).getAjer());

        if (modelList.get(position).getSanad() != null){

            holder.list_sanad_textview.setText(modelList.get(position).getSanad());
            holder.list_show_more_textview.setVisibility(View.VISIBLE);

            holder.list_show_more_textview.setOnClickListener(v -> {


                if(holder.list_ajer_textview.getVisibility() == View.GONE) {

                    holder.list_ajer_textview.setVisibility(View.VISIBLE);
                    holder.list_sanad_textview.setVisibility(View.VISIBLE);
                    holder.list_show_more_textview.setCompoundDrawablesRelativeWithIntrinsicBounds(mContext.getDrawable(R.drawable.ic_arrow_downward), null, null, null);

                }else {

                    holder.list_ajer_textview.setVisibility(View.GONE);
                    holder.list_sanad_textview.setVisibility(View.GONE);
                    holder.list_show_more_textview.setCompoundDrawablesRelativeWithIntrinsicBounds(mContext.getDrawable(R.drawable.ic_arrow_backward), null, null, null);


                }

            });

        }



        // if the card isn't clicked this mean that the number or repeats should be in words like (مرة واحدة) which is the default number of repeats format.
        if (didNotClicked(modelList.get(position).numberOfRep)){
            holder.list_number_textview.setText(modelList.get(position).getNumberOfRep());
        }


        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);

                //turn off the animation
                setOnClickAnimation(holder.list_constraint, false);

                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    hasScrolled = false;
                }else {
                    hasScrolled = true;
                }
            }
        });


        holder.list_constraint.setOnTouchListener((view, motionEvent) -> {


            if (!hasScrolled){

            switch (motionEvent.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    // Handle touch down event
                    if (!modelList.get(position).getNumberOfRep().equals("0")){
                        //turn on the animation
                        setOnClickAnimation(holder.list_constraint, true);
                    }
                    return true;
                case MotionEvent.ACTION_UP:
                case MotionEvent.ACTION_CANCEL:
                    // Handle touch up event
                    //turn off the animation
                    setOnClickAnimation(holder.list_constraint, false);

                    // depending on the text of the clicked layout the below cases will be executed (decrease by one).
                    switch (holder.list_number_textview.getText().toString()){

                        case "مرة واحدة":
                            finishThiker(holder.list_number_textview, holder.list_constraint, position);
                            break;


                        case "ثلاث مرات":
                            holder.list_number_textview.setText("2");
                            modelList.get(position).setNumberOfRep("2");
                            break;


                        case "أربع مرات":
                            holder.list_number_textview.setText("3");
                            modelList.get(position).setNumberOfRep("3");
                            break;


                        case "سبع مرات":
                            holder.list_number_textview.setText("6");
                            modelList.get(position).setNumberOfRep("6");
                            break;

                        case "عشر مرات":
                            holder.list_number_textview.setText("9");
                            modelList.get(position).setNumberOfRep("9");
                            break;

                        case "33 مرة":
                            holder.list_number_textview.setText("32");
                            modelList.get(position).setNumberOfRep("32");
                            break;

                        case "34 مرة":
                            holder.list_number_textview.setText("33");
                            modelList.get(position).setNumberOfRep("33");
                            break;


                        case "مئة مرة":
                            holder.list_number_textview.setText("99");
                            modelList.get(position).setNumberOfRep("99");
                            break;

                        case "تم بحمد الله":
                            Toast.makeText(mContext, mContext.getString(R.string.already_finished_str), Toast.LENGTH_SHORT).show();
                            break;

                        // if the number of repeats is not text this mean it's a number so it should be decreased by one
                        // unless it is 1 the it will return to (تم بحمد الله) via -finishThiker- method.
                        default:
                            try{
                                byte numberOfRemain = (byte) Integer.parseInt(holder.list_number_textview.getText().toString());
                                if(numberOfRemain == 1)
                                    finishThiker(holder.list_number_textview, holder.list_constraint, position);
                                else{
                                    holder.list_number_textview.setText(String.valueOf(numberOfRemain-1));
                                    modelList.get(position).setNumberOfRep(String.valueOf(numberOfRemain-1));
                                }

                            }catch (Exception e){

                                finishThiker(holder.list_number_textview, holder.list_constraint, position);

                            }


                    }

                    return true;
            }
        }
            return false;
        });



    }

    private void setOnClickAnimation(ConstraintLayout layout, boolean activeTheAnim){

        AnimatorSet set = new AnimatorSet();
        AnimatorSet setBack = new AnimatorSet();

        if(activeTheAnim){

            ObjectAnimator scaleX = ObjectAnimator.ofFloat(layout, "scaleX", 0.95f);
            ObjectAnimator scaleY = ObjectAnimator.ofFloat(layout, "scaleY", 0.95f);

            set.playTogether(scaleX, scaleY);
            set.setDuration(10);


        }else {

            ObjectAnimator scaleXBack = ObjectAnimator.ofFloat(layout, "scaleX", 1f);
            ObjectAnimator scaleYBack = ObjectAnimator.ofFloat(layout, "scaleY", 1f);

            setBack.playTogether(scaleXBack, scaleYBack);
            setBack.setDuration(10);
            set.playSequentially(setBack);
        }

        set.start();
    }

    //returns true if the text of the thiker isn't clicked yet.
    private boolean didNotClicked(String numberOfRep) {

        return numberOfRep.equals("مرة واحدة") || numberOfRep.equals("ثلاث مرات") || numberOfRep.equals("أربع مرات") ||
                numberOfRep.equals("سبع مرات") || numberOfRep.equals("عشر مرات") || numberOfRep.equals("33 مرة") ||
                numberOfRep.equals("34 مرة") || numberOfRep.equals("مئة مرة");
    }

    //change the text of the thiker to (تم بحمد الله) when the number of repeats becomes 0.
    public void finishThiker(TextView tv, ConstraintLayout cl, int position){
        count++;
        tv.setText(mContext.getString(R.string.finished_str));
        modelList.get(position).setNumberOfRep(String.valueOf(0));
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
        TextView list_thiker_textview, list_ajer_textview, list_number_textview, list_sanad_textview, list_show_more_textview;
        ConstraintLayout list_constraint;
        public AthkarViewHolder(@NonNull View itemView) {
            super(itemView);

            list_thiker_textview = itemView.findViewById(R.id.list_thiker_textview);
            list_ajer_textview = itemView.findViewById(R.id.list_ajer_textview);
            list_number_textview = itemView.findViewById(R.id.list_number_textview);
            list_sanad_textview = itemView.findViewById(R.id.list_sanad_textview);
            list_show_more_textview = itemView.findViewById(R.id.list_show_more_textview);


            list_constraint = itemView.findViewById(R.id.list_constraint);

        }
    }

}
