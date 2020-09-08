package id.asad.intentactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MoveDataActivity extends AppCompatActivity {

    // deklarasi
    private TextView tvNama, tvUmur;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move_data);

        tvNama = findViewById(R.id.tv_nama);
        tvUmur = findViewById(R.id.tv_umur);

        // terima data dr MainActivity
        String nama = getIntent().getStringExtra("NAMA");
        int umur = getIntent().getIntExtra("UMUR", 1);

        tvNama.setText(nama);
        tvUmur.setText(String.valueOf(umur));
    }
}