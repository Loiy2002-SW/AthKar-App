package com.loiy.athkar.ui;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.fragment.app.FragmentManager;


import com.loiy.athkar.R;
import com.loiy.athkar.adapters.RecyclerViewAdapter;


public class ConfirmDialog extends AppCompatDialogFragment {


    Button btnYes, btnNo;
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        //instance from AlertDialog
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.confirm_dialog, null);

        btnYes = view.findViewById(R.id.confirm_yes_button);
        btnNo = view.findViewById(R.id.confirm_no_button);

        btnYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                fragmentManager.beginTransaction().remove(ConfirmDialog.this).commit();
                RecyclerViewAdapter.count = 0;

                startActivity(new Intent(getContext(), MainActivity.class));
                getActivity().finish();
            }
        });

        btnNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                fragmentManager.beginTransaction().remove(ConfirmDialog.this).commit();
                Toast.makeText(getContext(), "اكمل اذكارك *_*", Toast.LENGTH_SHORT).show();
            }
        });


        builder.setView(view);

        return builder.create();
    }

}