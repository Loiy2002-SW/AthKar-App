package com.loiy.athkar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Athkar extends AppCompatActivity {

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


        String [] statement, numberOfRep;


        switch (whatData){

            case 1:
                athkar_header_textview.setText(getString(R.string.sabah_str));

                statement =  getResources().getStringArray(R.array.athkar_sabah);
                numberOfRep = getResources().getStringArray(R.array.number_of_sabah_and_masaa);

                for (int i = 0; i < statement.length; i++)
                    athkarModelList.add(new AthkarModel(statement[i], numberOfRep[i]));

                break;

            case 2:
                athkar_header_textview.setText(getString(R.string.masaa_str));

                statement =  getResources().getStringArray(R.array.athkar_masaa);
                numberOfRep = getResources().getStringArray(R.array.number_of_sabah_and_masaa);

                for (int i = 0; i < statement.length; i++)
                    athkarModelList.add(new AthkarModel(statement[i], numberOfRep[i]));

                break;

            case 3:
                athkar_header_textview.setText(getString(R.string.istekad_str));

                statement =  getResources().getStringArray(R.array.wakeup);

                for (int i = 0; i < statement.length; i++)
                    athkarModelList.add(new AthkarModel(statement[i]));

                break;

            case 4:
                athkar_header_textview.setText(getString(R.string.sleep_str));

                statement =  getResources().getStringArray(R.array.sleep);
                numberOfRep = getResources().getStringArray(R.array.sleep_number);

                for (int i = 0; i < statement.length; i++)
                    athkarModelList.add(new AthkarModel(statement[i], numberOfRep[i]));

                break;

            case 5:
                athkar_header_textview.setText(getString(R.string.jwamia_str));

                statement =  getResources().getStringArray(R.array.jwamia);

                for (int i = 0; i < statement.length; i++)
                    athkarModelList.add(new AthkarModel(statement[i]));

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