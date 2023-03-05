package com.loiy.athkar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SplashScreen extends AppCompatActivity {

    //Declaration
    Animation animationZoom;
    ImageView imageView;
    Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // remove the title from splash screen
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen);

        animationZoom = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.zoom);
        imageView = findViewById(R.id.splash_background_imageview);
        imageView.startAnimation(animationZoom);

        handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                    //go to MainActivity
                    Intent i = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(i);
                    finish();
            }
        }, 3000);


    }
}