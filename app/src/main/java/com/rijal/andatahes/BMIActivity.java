package com.rijal.andatahes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class BMIActivity extends AppCompatActivity {

    TextView txtHaloNama, txtSkorBMI;
    Button btnKembali;
    double bmi = 0;
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
        // dewasa
        double usia_dou = Double.valueOf(usia);
        if (usia_dou > 1) {
            bmi = (2 * usia_dou) + 8;

        } else if (usia_dou <= 20) {

        } else {

        }
        bmi = ((Double.parseDouble(berat_bdn)) / Math.pow((Double.parseDouble(tinggi_bdn) * 0.01), 2));
        double scale = Math.pow(10, 1);
        bmi = Math.round(bmi * scale) / scale;
        Toast.makeText(this, "Usia : " + usia + ", Berat Badan : " + berat_bdn + "kg, Tinggi Badan : " + tinggi_bdn + "cm, BMI : " + bmi, Toast.LENGTH_SHORT).show();
        txtHaloNama = (TextView) findViewById(R.id.txtHaloNama);
        txtHaloNama.setText("Halo, " + nama);
        txtSkorBMI = (TextView) findViewById(R.id.txtSkorBMI);
        txtSkorBMI.setText(String.valueOf(bmi));
        btnKembali = (Button) findViewById(R.id.btnKembali);
        btnKembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}