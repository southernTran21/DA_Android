package com.example.da_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class check_main extends AppCompatActivity {

    TextView resultScan;
    ImageView imvShowQRCODE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_main);

        resultScan = findViewById(R.id.resultScan);
        imvShowQRCODE = findViewById(R.id.imvShowQRCODE);

        Intent intent = getIntent();
        String result = intent.getStringExtra("resultScan");

//        resultScan.setText(result);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constant.PATH)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

        Call<List<facility>> call = jsonPlaceHolderApi.getFacility(result);
        call.enqueue(new Callback<List<facility>>() {
            @Override
            public void onResponse(Call<List<facility>> call, Response<List<facility>> response) {
                List<facility> s = response.body();
                MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
                for (facility result : s) {
                    String content = "";
                    content += "ID: " + result.getId() + "\n";
                    content += "Name: " +result.getName() + "\n";
                    try {
                        BitMatrix bitMatrix = multiFormatWriter.encode(result.getQRCODE(), BarcodeFormat.QR_CODE,400,400);
                        BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
                        Bitmap bm = barcodeEncoder.createBitmap(bitMatrix);
                        imvShowQRCODE.setImageBitmap(bm);
                    } catch (WriterException e) {
                        e.printStackTrace();
                    }

                    resultScan.append(content);
                }
            }

            @Override
            public void onFailure(Call<List<facility>> call, Throwable t) {

            }
        });

    }
}