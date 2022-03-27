package com.rijal.andatahes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    TextInputEditText txtUsia, txtBeratBdn, txtTinggiBdn;
    TextInputLayout lytUsia, lytBeratBdn, lytTinggiBdn;
    Button btnUji;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtUsia = (TextInputEditText) findViewById(R.id.txtUsia);
        txtBeratBdn = (TextInputEditText) findViewById(R.id.txtBeratBdn);
        txtTinggiBdn = (TextInputEditText) findViewById(R.id.txtTinggiBdn);
        lytUsia = (TextInputLayout) findViewById(R.id.lytUsia);
        lytBeratBdn = (TextInputLayout) findViewById(R.id.lytBeratBdn);
        lytTinggiBdn = (TextInputLayout) findViewById(R.id.lytTinggiBdn);
        btnUji = (Button) findViewById(R.id.btnUji);
        btnUji.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(tesKosong(txtUsia, txtBeratBdn, txtTinggiBdn, lytUsia, lytBeratBdn, lytTinggiBdn, view)) {
                    Toast.makeText(MainActivity.this, "isok", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private boolean tesKosong(TextInputEditText txtUsia, TextInputEditText txtBeratBdn, TextInputEditText txtTinggiBdn, TextInputLayout lytUsia, TextInputLayout lytBeratBdn, TextInputLayout lytTinggiBdn, View view) {
//        View view = (View) txtUsia.getParent();
        boolean error = false;
        if (txtUsia.getText().length() == 0) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    lytUsia.setErrorEnabled(true);
                    lytUsia.setError("Isi usia anda!");
                    txtUsia.setError("Isi Usia anda!");
                }
            });
            error = true;
        }
        if (txtBeratBdn.getText().length() == 0) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    lytBeratBdn.setErrorEnabled(true);
                    lytBeratBdn.setError("Isi usia anda!");
                    txtBeratBdn.setError("Isi Usia anda!");
                }
            });
            error = true;
        }
        if (txtTinggiBdn.getText().length() == 0) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    lytTinggiBdn.setErrorEnabled(true);
                    lytTinggiBdn.setError("Isi usia anda!");
                    txtTinggiBdn.setError("Isi Usia anda!");
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