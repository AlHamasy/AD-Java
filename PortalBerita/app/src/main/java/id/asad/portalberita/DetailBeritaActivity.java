package id.asad.portalberita;

import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import id.asad.portalberita.api.ApiClient;
import id.asad.portalberita.model.DataBeritaItem;

public class DetailBeritaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_berita);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        CollapsingToolbarLayout toolBarLayout = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);
        toolBarLayout.setTitle(getTitle());

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        ImageView imgDetail = findViewById(R.id.img_detail);
        TextView tvDetailIsi = findViewById(R.id.tv_detail_isi);

        DataBeritaItem dataBeritaItem = getIntent().getParcelableExtra("DETAIL");
        tvDetailIsi.setText(dataBeritaItem.getIsiBerita());
        Glide.with(this)
                .load(ApiClient.URL_IMAGE + dataBeritaItem.getImageBerita())
                .error(R.drawable.ic_launcher_background)
                .into(imgDetail);
        toolBarLayout.setTitle(dataBeritaItem.getJudulBerita());

    }
}