package com.rijal.andatahes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class BMIActivity extends AppCompatActivity {

    TextView txtHaloNama;
    Button btnKembali;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmiactivity);
        String nama = getIntent().getExtras().getString("NAMA");
        if (nama.split(" ").length > 0) {
            nama = nama.split(" ")[0];
        }
        String usia = getIntent().getExtras().getString("USIA");
        String berat_bdn = getIntent().getExtras().getString("BERAT_BADAN");
        String tinggi_bdn = getIntent().getExtras().getString("TINGGI_BADAN");
        Toast.makeText(this, "Usia : " + usia + ", Berat Badan : " + berat_bdn + "kg, Tinggi Badan : " + tinggi_bdn + "cm", Toast.LENGTH_SHORT).show();
        txtHaloNama = (TextView) findViewById(R.id.txtHaloNama);
        txtHaloNama.setText("Halo, " + nama);
        btnKembali = (Button) findViewById(R.id.btnKembali);
        btnKembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}