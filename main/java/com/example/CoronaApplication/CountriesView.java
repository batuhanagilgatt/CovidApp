package com.example.CoronaApplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.ders09_03.R;
import com.google.gson.Gson;

public class CountriesView extends AppCompatActivity implements CasesReq.CasesReqListener {

    TextView counryadi;
    TextView cases;
    TextView deaths;
    TextView recovered;
    TextView newdeaths;
    TextView newcases;
    TextView seriouscritical;
    TextView activecases;
    TextView totalcasesper;
    TextView deathsper;
    TextView totaltest;
    TextView testper;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ulkeview);
        counryadi = findViewById(R.id.country_name);
        cases = findViewById(R.id.cases);
        deaths = findViewById(R.id.deaths);
        recovered = findViewById(R.id.totalrecovered);
        newdeaths = findViewById(R.id.new_deaths);
        newcases = findViewById(R.id.new_cases);
        seriouscritical = findViewById(R.id.serious_critical);
        activecases = findViewById(R.id.active_cases);
        totalcasesper = findViewById(R.id.total_cases_per_1m_population);
        deathsper = findViewById(R.id.deaths_per_1m_population);
        totaltest = findViewById(R.id.total_tests);
        testper = findViewById(R.id.tests_per_1m_population);




        CasesReq req = new CasesReq(this);
        req.execute();
    }


    @Override
    public void casesReqDone(String result) {
        Gson gson = new Gson();

        CasesCountryModel model = gson.fromJson(result,CasesCountryModel.class);

            Intent intent = getIntent();
            Bundle gelenveri = intent.getExtras();
            String alinanveri = gelenveri.getString("bilgiler");

            counryadi.setText(model.countries_stat[Integer.parseInt(alinanveri)].country_name);
            cases.setText(model.countries_stat[Integer.parseInt(alinanveri)].cases);
            deaths.setText(model.countries_stat[Integer.parseInt(alinanveri)].deaths);
            recovered.setText(model.countries_stat[Integer.parseInt(alinanveri)].total_recovered);
            newdeaths.setText(model.countries_stat[Integer.parseInt(alinanveri)].new_deaths);
            newcases.setText(model.countries_stat[Integer.parseInt(alinanveri)].new_cases);
            seriouscritical.setText(model.countries_stat[Integer.parseInt(alinanveri)].serious_critical);
            activecases.setText(model.countries_stat[Integer.parseInt(alinanveri)].active_cases);
            totalcasesper.setText(model.countries_stat[Integer.parseInt(alinanveri)].total_cases_per_1m_population);
            deathsper.setText(model.countries_stat[Integer.parseInt(alinanveri)].deaths_per_1m_population);
            totaltest.setText(model.countries_stat[Integer.parseInt(alinanveri)].total_tests);
            testper.setText(model.countries_stat[Integer.parseInt(alinanveri)].tests_per_1m_population);




    }
}
