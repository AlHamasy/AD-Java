package id.asad.intentactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MoveObjectActivity extends AppCompatActivity {

    private TextView tvMerek, tvTahun, tvKondisi, tvKilometer, tvPlat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move_object);

        tvMerek = findViewById(R.id.tv_merek);
        tvTahun = findViewById(R.id.tv_tahun);
        tvKondisi = findViewById(R.id.tv_kondisi);
        tvKilometer = findViewById(R.id.tv_kilometer);
        tvPlat = findViewById(R.id.tv_plat);

        Mobil dataMobil = getIntent().getParcelableExtra("MOBIL");

        tvMerek.setText(dataMobil.getMerek());
        tvTahun.setText(String.valueOf(dataMobil.getTahun()));
        tvKilometer.setText(String.valueOf(dataMobil.getKilometer()));
        tvPlat.setText(String.valueOf(dataMobil.getPlatnomor()));
        tvKondisi.setText(dataMobil.isBaru() ? "Baru" : "Bekas");

    }
}