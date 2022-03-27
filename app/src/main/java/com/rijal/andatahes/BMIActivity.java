package com.rijal.andatahes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class BMIActivity extends AppCompatActivity {

    Button btnKembali;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmiactivity);
        String usia = getIntent().getExtras().getString("USIA");
        String berat_bdn = getIntent().getExtras().getString("BERAT_BADAN");
        String tinggi_bdn = getIntent().getExtras().getString("TINGGI_BADAN");
        Toast.makeText(this, "Usia : " + usia + ", Berat Badan : " + berat_bdn + "kg, Tinggi Badan : " + tinggi_bdn + "cm", Toast.LENGTH_SHORT).show();
        btnKembali = (Button) findViewById(R.id.btnKembali);
        btnKembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}