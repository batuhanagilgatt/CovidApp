package com.example.CoronaApplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.ders09_03.R;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class EtkilenenUlke extends AppCompatActivity implements AffectedReq.AffectedReqListener {

    ListView countries;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.etkilenenulke);

        countries = findViewById(R.id.countries);

        AffectedReq req = new AffectedReq(this);
        req.execute();


    }


    @Override
    public void affectedReqDone(String result) {
        Gson gson = new Gson();
         AffectedCountriesModel model = gson.fromJson(result,AffectedCountriesModel.class);

       final List<String> values = new ArrayList<>();

       for (int i = 0; i<model.affected_countries.length;i++){ // modelin uzunluğu kadar dön.
            values.add(model.affected_countries[i]); // her döndüğün değeri ekle.
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,R.layout.listitem,R.id.ulkeler,values);
        countries.setAdapter(arrayAdapter);

        countries.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent etkilenenulke = new Intent(EtkilenenUlke.this,CountriesView.class);

                Bundle bundle = new Bundle();
                bundle.putString("bilgiler",""+position);
                etkilenenulke.putExtras(bundle);
                startActivity(etkilenenulke);
            }
        });






    }



}
