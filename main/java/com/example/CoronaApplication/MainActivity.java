package com.example.CoronaApplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.ders09_03.R;
import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity implements DeathReq.DeathReqListener{

     TextView tvTotalCase;
     TextView tvTotalDeath;
     TextView tvTotalRecover;
     TextView tvDate;
     TextView tvNewCases;
     TextView tvNewDeath;
     Button etkilenenler;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        tvTotalCase = findViewById(R.id.tvTotalCase);
        tvTotalDeath = findViewById(R.id.tvTotalDeath);
        tvTotalRecover = findViewById(R.id.tvTotalRecover);
        tvDate = findViewById(R.id.tvDate);
        tvNewCases = findViewById(R.id.tvNewCases);
        tvNewDeath = findViewById(R.id.tvNewDeath);
        etkilenenler = findViewById(R.id.etkilenenUlke); //  button

        DeathReq req = new DeathReq(this);
        req.execute();
        etkilenenler.setOnClickListener(new View.OnClickListener() { // bilet al butonuna tıklandığında;
            @Override
            public void onClick(View v) {
                Intent etkilenenulke = new Intent(MainActivity.this,EtkilenenUlke.class);
                startActivity(etkilenenulke);

            }
        });
    }

    @Override
    public void deathReqDone(String result) {
        Gson gson = new Gson();

        DeathModel model = gson.fromJson(result, DeathModel.class);

        tvTotalCase.setText(model.total_cases);
        tvTotalRecover.setText(model.total_recovered);
        tvTotalDeath.setText(model.total_deaths);
        tvDate.setText(model.statistic_taken_at);
        tvNewCases.setText(model.new_cases);
        tvNewDeath.setText(model.new_deaths);
    }


}
