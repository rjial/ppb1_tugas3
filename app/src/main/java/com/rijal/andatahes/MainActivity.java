package com.rijal.andatahes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    TextInputEditText txtNama, txtUsia, txtBeratBdn, txtTinggiBdn;
    TextInputLayout lytNama, lytUsia, lytBeratBdn, lytTinggiBdn;
    Button btnUji, btnKeluar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtNama = (TextInputEditText) findViewById(R.id.txtNama);
        txtUsia = (TextInputEditText) findViewById(R.id.txtUsia);
        txtBeratBdn = (TextInputEditText) findViewById(R.id.txtBeratBdn);
        txtTinggiBdn = (TextInputEditText) findViewById(R.id.txtTinggiBdn);
        lytNama = (TextInputLayout) findViewById(R.id.lytNama);
        lytUsia = (TextInputLayout) findViewById(R.id.lytUsia);
        lytBeratBdn = (TextInputLayout) findViewById(R.id.lytBeratBdn);
        lytTinggiBdn = (TextInputLayout) findViewById(R.id.lytTinggiBdn);
        btnUji = (Button) findViewById(R.id.btnUji);
        btnKeluar = (Button) findViewById(R.id.btnKeluar);
        btnKeluar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finishAffinity();
            }
        });
        btnUji.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(tesKosong(txtNama, txtUsia, txtBeratBdn, txtTinggiBdn, lytNama, lytUsia, lytBeratBdn, lytTinggiBdn, view)) {
//                    Toast.makeText(MainActivity.this, "isok", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, BMIActivity.class);
                    intent.putExtra("NAMA", txtNama.getText().toString());
                    intent.putExtra("USIA", txtUsia.getText().toString());
                    intent.putExtra("BERAT_BADAN", txtBeratBdn.getText().toString());
                    intent.putExtra("TINGGI_BADAN", txtTinggiBdn.getText().toString());
                    startActivity(intent);
                }
            }
        });
        txtNama.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length() > 0) {
                    lytNama.setErrorEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        txtUsia.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length() > 0) {
                    lytUsia.setErrorEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        txtTinggiBdn.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length() > 0) {
                    lytTinggiBdn.setErrorEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        txtBeratBdn.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length() > 0) {
                    lytBeratBdn.setErrorEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }
    private boolean tesKosong(TextInputEditText txtNama, TextInputEditText txtUsia, TextInputEditText txtBeratBdn, TextInputEditText txtTinggiBdn, TextInputLayout lytNama, TextInputLayout lytUsia, TextInputLayout lytBeratBdn, TextInputLayout lytTinggiBdn, View view) {
//        View view = (View) txtUsia.getParent();
        boolean error = false;
        if (txtNama.getText().length() == 0) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    lytNama.setErrorEnabled(true);
                    lytNama.setError("Isi nama anda!");
                }
            });
            error = true;
        }
        if (txtUsia.getText().length() == 0) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    lytUsia.setErrorEnabled(true);
                    lytUsia.setError("Isi usia anda!");
                }
            });
            error = true;
        }
        if (txtBeratBdn.getText().length() == 0) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    lytBeratBdn.setErrorEnabled(true);
                    lytBeratBdn.setError("Isi berat badan anda!");
                }
            });
            error = true;
        }
        if (txtTinggiBdn.getText().length() == 0) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    lytTinggiBdn.setErrorEnabled(true);
                    lytTinggiBdn.setError("Isi tinggi badan anda!");
                    txtTinggiBdn.setError("Isi tinggi badan anda!");
                }
            });
            error = true;
        }
        if(error) {
            Snackbar.make(view, "Error", Snackbar.LENGTH_SHORT).show();
            return false;
        } else {
            return true;
        }
    }
}