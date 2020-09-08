package id.asad.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int [] gambarBuah = {R.drawable.alpukat, R.drawable.apel, R.drawable.ceri, R.drawable.durian,
                             R.drawable.jambuair, R.drawable.manggis, R.drawable.strawberry};

        String [] namaBuah = {"Alpukat", "Apel", "Ceri", "Durian", "Jambu Air", "Manggis", "Strawberry"};

        int [] musicBuah = {R.raw.alpukat, R.raw.apel, R.raw.ceri, R.raw.durian, R.raw.jambuair, R.raw.manggis, R.raw.strawberry};

        BuahAdapter adapter = new BuahAdapter(namaBuah, gambarBuah, musicBuah);

        RecyclerView rvBuah = findViewById(R.id.rv_buah);
        rvBuah.setHasFixedSize(true);

        // linear
        //rvBuah.setLayoutManager(new LinearLayoutManager(this));

        // grid
        rvBuah.setLayoutManager(new GridLayoutManager(this, 2));

        // horizontal
        // rvBuah.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        rvBuah.setAdapter(adapter);
    }
}
