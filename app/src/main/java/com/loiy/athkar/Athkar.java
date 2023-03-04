package com.loiy.athkar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.List;

public class Athkar extends AppCompatActivity {

    RecyclerView recyclerView;
    List<AthkarModel> athkarModelList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_athkar);
        recyclerView = findViewById(R.id.athkar_recyclerview);

    }
}