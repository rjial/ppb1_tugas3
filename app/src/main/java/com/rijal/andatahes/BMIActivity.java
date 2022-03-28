package com.rijal.andatahes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class BMIActivity extends AppCompatActivity {

    TextView txtHaloNama, txtSkorBMI, txtStatusBMI, txtStatusWHO, txtStatusAsian;
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
            bmi = ((Double.parseDouble(berat_bdn)) / Math.pow((Double.parseDouble(tinggi_bdn) * 0.01), 2));
        } else {
            bmi = ((Double.parseDouble(berat_bdn)) / Math.pow((Double.parseDouble(tinggi_bdn) * 0.01), 2));
        }
        double scale = Math.pow(10, 1);
        bmi = Math.round(bmi * scale) / scale;
        String bmi_status_who = "";
        String bmi_status_asian = "";
        if(bmi < 18.5) {
            bmi_status_who = "Underweight";
        } else if(bmi >= 18.5 && bmi <= 24.9 ) {
            bmi_status_who = "Normal";
        } else if(bmi >= 25 && bmi <= 29.9) {
            bmi_status_who = "Overweight";
        } else if(bmi >= 30 && bmi <= 40) {
            bmi_status_who = "Obese Type 1";
        } else if(bmi >= 40.1 && bmi <= 50) {
            bmi_status_who = "Obese Type 2";
        } else if(bmi >= 50) {
            bmi_status_who = "Obese Type 3";
        }
        if(bmi < 18.5) {
            bmi_status_asian = "Underweight";
        } else if(bmi >= 18.5 && bmi <= 22.9 ) {
            bmi_status_asian = "Normal";
        } else if(bmi >= 23 && bmi <= 24.9) {
            bmi_status_asian = "Overweight";
        } else if(bmi >= 25 && bmi <= 29.9) {
            bmi_status_asian = "Pre-Obese";
        } else if(bmi >= 30 && bmi <= 40) {
            bmi_status_asian = "Obese Type 1";
        } else if(bmi >= 40.1 && bmi <= 50) {
            bmi_status_asian = "Obese Type 2";
        } else if(bmi >= 50) {
            bmi_status_asian = "Obese Type 3";
        }
        Toast.makeText(this, "BMI = " + bmi + "\n - WHO = " + bmi_status_who + "\n Asia-Pacific = " + bmi_status_asian, Toast.LENGTH_SHORT).show();
        txtHaloNama = (TextView) findViewById(R.id.txtHaloNama);
        txtHaloNama.setText("Halo, " + nama);
        txtSkorBMI = (TextView) findViewById(R.id.txtSkorBMI);
        txtSkorBMI.setText(String.valueOf(bmi));
        txtStatusBMI = (TextView) findViewById(R.id.txtStatusBMI);
        txtStatusBMI.setText(Html.fromHtml("Status tubuh anda <font color='#4caf50'>" + bmi_status_who + "</font>"));
        txtStatusWHO = (TextView) findViewById(R.id.txtStatusWHO);
        txtStatusWHO.setText(bmi_status_who);
        txtStatusAsian = (TextView) findViewById(R.id.txtStatusAsian);
        txtStatusAsian.setText(bmi_status_asian);
        btnKembali = (Button) findViewById(R.id.btnKembali);
        btnKembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}