package com.example.kamusbahasasasak;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.kamusbahasasasak.model.Kamus;
import com.google.android.material.textfield.TextInputLayout;

public class FormKamusSasak extends AppCompatActivity {

    Button btnSimpan;
    TextInputLayout tilKata, tilArti, tilContoh;
    Spinner spnJenis;
    final String[] tipekamus = {Kamus.KATA_KERJA, Kamus.KATA_BENDA, Kamus.KATA_SIFAT};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_kamus_sasak);
        inisialisasiView();

    }   private void inisialisasiView() {
        btnSimpan = findViewById(R.id.btn_simpan);
        btnSimpan.setOnClickListener(view -> simpan());
        tilKata = findViewById(R.id.til_kt);
        tilArti = findViewById(R.id.til_ar);
        tilContoh = findViewById(R.id.til_cth);
        spnJenis = findViewById(R.id.spn_js);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,
                R.layout.support_simple_spinner_dropdown_item,
                tipekamus
        );
        spnJenis.setAdapter(adapter);
        spnJenis.setSelection(0);
    }

    private void simpan() {
        if (isDataValid()) {
            Kamus tr = new Kamus();
            tr.setKata(tilKata.getEditText().getText().toString());
            tr.setArti(tilArti.getEditText().getText().toString());
            tr.setContoh(tilContoh.getEditText().getText().toString());
            tr.setJenis(spnJenis.getSelectedItem().toString());
            SharedPereferenceUtility.addAllLaptop(this, tr);
            Toast.makeText(this, "Data berhasil disimpan", Toast.LENGTH_SHORT).show();

            // Kembali ke layar sebelumnya setelah 500 ms (0.5 detik)
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    finish();
                }
            }, 500);


        }
    }
    private boolean isDataValid() {
        if (tilArti.getEditText().getText().toString().isEmpty()
                || tilKata.getEditText().getText().toString().isEmpty()
                || tilContoh.getEditText().getText().toString().isEmpty()
                || spnJenis.getSelectedItem().toString().isEmpty()
        ) {
            Toast.makeText(this, "Data tidak bileh ada yang kosong", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }


    }