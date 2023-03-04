package com.loiy.athkar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    CardView main_sabah_cardview, main_masaa_cardview, main_istekad_cardview, main_sleep_cardview, main_jwamia_cardview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        main_sabah_cardview = findViewById(R.id.main_sabah_cardview);
        main_masaa_cardview = findViewById(R.id.main_masaa_cardview);
        main_istekad_cardview = findViewById(R.id.main_istekad_cardview);
        main_sleep_cardview = findViewById(R.id.main_sleep_cardview);
        main_jwamia_cardview = findViewById(R.id.main_jwamia_cardview);

        main_sabah_cardview.setOnClickListener(this::onCardViewClick);
        main_masaa_cardview.setOnClickListener(this::onCardViewClick);
        main_istekad_cardview.setOnClickListener(this::onCardViewClick);
        main_sleep_cardview.setOnClickListener(this::onCardViewClick);
        main_jwamia_cardview.setOnClickListener(this::onCardViewClick);
    }

    private void onCardViewClick(View v) {


        Intent goToRecycler = new Intent(getApplicationContext(), Athkar.class);


        switch (v.getId()){


            case R.id.main_sabah_cardview:

                goToRecycler.putExtra("whatData", 1);
                startActivity(goToRecycler);
                break;


            case R.id.main_masaa_cardview:

                goToRecycler.putExtra("whatData", 2);
                startActivity(goToRecycler);
                break;


            case R.id.main_istekad_cardview:

                goToRecycler.putExtra("whatData", 3);
                startActivity(goToRecycler);
                break;


            case R.id.main_sleep_cardview:

                goToRecycler.putExtra("whatData", 4);
                startActivity(goToRecycler);
                break;

            case R.id.main_jwamia_cardview:

                goToRecycler.putExtra("whatData", 5);
                startActivity(goToRecycler);

        }

    }
}