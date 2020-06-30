package com.example.CoronaApplication;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public  abstract class RootReq extends AsyncTask<Void,Void,Void> {

    String result = ""; // requestten dönen cevap burada tutulacak.

    public abstract String getReqLink();

    @Override
    protected Void doInBackground(Void... voids) {
        try {
            URL url = new URL (getReqLink()); // Apiden aldığımız url dinamikleştirildi.

            HttpURLConnection connection =(HttpsURLConnection) url.openConnection(); // Gönderdiğimiz url için bağlantı açıyoruz.
            InputStream stream = connection.getInputStream(); // Datayı çekiyoruz.

            InputStreamReader reader = new InputStreamReader(stream);// Datayı okuyoruz.
            BufferedReader bfReader = new BufferedReader(reader); // Buffer sayesinde veriyi parçalayıp okuyoruz.

            String res = "";
            while ((res = bfReader.readLine()) != null){
                result += res;
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

        //Log.d("MedipolRq:",result); Consol'a yazdırma


        return null;
    }

}
