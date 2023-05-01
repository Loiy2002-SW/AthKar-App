package com.loiy.athkar.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.loiy.athkar.R;
import com.loiy.athkar.adapters.RecyclerViewAdapter;
import com.loiy.athkar.model.AthkarModel;

import java.util.ArrayList;
import java.util.List;

public class AthkarShow extends AppCompatActivity {

    RecyclerView recyclerView;
    List<AthkarModel> athkarModelList = new ArrayList<>();

    TextView athkar_header_textview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_athkar);

        athkar_header_textview = findViewById(R.id.athkar_header_textview);

        recyclerView = findViewById(R.id.athkar_recyclerview);

        int whatData = -1;

        Intent getData = getIntent();

        if(getData != null){
            whatData = getData.getIntExtra("whatData",-1);
        }


        String [] statement, numberOfRep, ajer;


        switch (whatData){

            case 1:
                athkar_header_textview.setText(getString(R.string.sabah_str));

                statement =  getResources().getStringArray(R.array.athkar_sabah);
                ajer =  getResources().getStringArray(R.array.sabah_and_masaa_thwab_arr);
                numberOfRep = getResources().getStringArray(R.array.number_of_sabah_and_masaa);

                for (int i = 0; i < statement.length; i++)
                    athkarModelList.add(new AthkarModel(statement[i], ajer[i], numberOfRep[i]));

                break;

            case 2:
                athkar_header_textview.setText(getString(R.string.masaa_str));

                statement =  getResources().getStringArray(R.array.athkar_masaa);
                ajer =  getResources().getStringArray(R.array.sabah_and_masaa_thwab_arr);
                numberOfRep = getResources().getStringArray(R.array.number_of_sabah_and_masaa);

                for (int i = 0; i < statement.length; i++)
                    athkarModelList.add(new AthkarModel(statement[i], ajer[i], numberOfRep[i]));

                break;

            case 3:
                athkar_header_textview.setText(getString(R.string.istekad_str));

                statement =  getResources().getStringArray(R.array.wakeup);
                ajer =  getResources().getStringArray(R.array.wakeup_thwab_arr);

                for (int i = 0; i < statement.length; i++)
                    athkarModelList.add(new AthkarModel(statement[i], ajer[i], "مرة واحدة"));

                break;

            case 4:
                athkar_header_textview.setText(getString(R.string.sleep_str));

                statement =  getResources().getStringArray(R.array.sleep);
                ajer =  getResources().getStringArray(R.array.sleep_thwab_arr);
                numberOfRep = getResources().getStringArray(R.array.sleep_number);

                for (int i = 0; i < statement.length; i++)
                    athkarModelList.add(new AthkarModel(statement[i], ajer[i], numberOfRep[i]));

                break;

            case 5:
                athkar_header_textview.setText(getString(R.string.jwamia_str));

                statement =  getResources().getStringArray(R.array.jwamia);

                for (int i = 0; i < statement.length; i++)
                    athkarModelList.add(new AthkarModel(statement[i], "", "مرة واحدة"));

                break;

            case -1:
                Toast.makeText(this, getString(R.string.some_thing_wrong), Toast.LENGTH_SHORT).show();
                break;


        }


        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(athkarModelList, getApplicationContext());

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(recyclerViewAdapter);

    }
}