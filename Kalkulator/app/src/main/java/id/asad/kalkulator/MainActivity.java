package id.asad.kalkulator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    // deklarasi
    private Button btnTambah, btnKurang, btnBagi, btnKali;
    private EditText edtAwal, edtAkhir;
    private TextView tvHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnTambah = findViewById(R.id.btn_tambah);
        btnKurang = findViewById(R.id.btn_kurang);
        btnBagi = findViewById(R.id.btn_bagi);
        btnKali = findViewById(R.id.btn_kali);
        edtAkhir = findViewById(R.id.edt_akhir);
        edtAwal = findViewById(R.id.edt_awal);
        tvHasil = findViewById(R.id.tv_hasil);

        btnTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validasi(edtAwal.getText().toString(), edtAkhir.getText().toString(), '+');
            }
        });

        btnKurang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validasi(edtAwal.getText().toString(), edtAkhir.getText().toString(), '-');
            }
        });

        btnKali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validasi(edtAwal.getText().toString(), edtAkhir.getText().toString(), '*');
            }
        });

        btnBagi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validasi(edtAwal.getText().toString(), edtAkhir.getText().toString(), '/');
            }
        });
    }

    private void validasi(String awal, String akhir, char operator){
        if (awal.isEmpty() || akhir.isEmpty()) tampilToast("tidak boleh kosong");
        else hitung(Double.parseDouble(awal), Double.parseDouble(akhir), operator);
    }

    private void tampilToast(String pesan){
        Toast.makeText(this, pesan, Toast.LENGTH_SHORT).show();
    }

    private void hitung(double awal, double akhir, char operator){

        double hasil = 0.0;
        switch (operator){
            case '+':
                hasil = awal + akhir;
                break;
            case '-':
                hasil = awal - akhir;
                break;
            case '*':
                hasil = awal * akhir;
                break;
            case '/':
                hasil = awal / akhir;
                break;
        }

        DecimalFormat format = new DecimalFormat("0.#");
        tvHasil.setText(format.format(hasil));
    }
}