package id.asad.portalberita;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.List;

import id.asad.portalberita.api.ApiClient;
import id.asad.portalberita.model.DataBeritaItem;
import id.asad.portalberita.model.ResponseBerita;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rvBerita = findViewById(R.id.rv_berita);
        rvBerita.setHasFixedSize(true);
        rvBerita.setLayoutManager(new LinearLayoutManager(this));

        ApiClient.service.getDataBerita("tb_berita").enqueue(new Callback<ResponseBerita>() {
            @Override
            public void onResponse(Call<ResponseBerita> call, Response<ResponseBerita> response) {
                if (response.isSuccessful()){

                    // ambil semua json
                    ResponseBerita responseBerita = response.body();
                    List<DataBeritaItem> dataBeritaItems = responseBerita.getDataBerita();

                    BeritaAdapter adapter = new BeritaAdapter(dataBeritaItems);
                    adapter.notifyDataSetChanged();
                    rvBerita.setAdapter(adapter);
                }
            }
            @Override
            public void onFailure(Call<ResponseBerita> call, Throwable t) {
                Log.d("MainActivity", t.getLocalizedMessage());
            }
        });
    }
}