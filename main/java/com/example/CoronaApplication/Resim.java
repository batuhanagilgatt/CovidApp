package com.example.CoronaApplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.ders09_03.R;

public class Resim extends AppCompatActivity  {

    ImageView resim;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashscreen);

        new ImageDownload((ImageView) findViewById(R.id.resim))
                .execute("https://coronavirus-monitor.p.rapidapi.com/coronavirus/random_masks_usage_instructions.php?rapidapi-key=08ce889c3emshc741b13c3e2385fp1da0cdjsn483f402d5e6a");

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Resim.this,MainActivity.class);
                startActivity(intent);
            }
        }, 20000);
    }



}
