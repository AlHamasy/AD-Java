package id.asad.portalberita;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextClock;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import id.asad.portalberita.api.ApiClient;
import id.asad.portalberita.model.DataBeritaItem;

public class BeritaAdapter extends RecyclerView.Adapter<BeritaAdapter.MyViewHolder> {

    private List<DataBeritaItem> dataBeritaItems;

    public BeritaAdapter(List<DataBeritaItem> dataBeritaItems) {
        this.dataBeritaItems = dataBeritaItems;
    }

    // 1. panggil layout
    @NonNull
    @Override
    public BeritaAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_berita, parent, false);
        return new MyViewHolder(view);
    }

    // 4. tampilkan data
    @Override
    public void onBindViewHolder(@NonNull BeritaAdapter.MyViewHolder holder, int position) {

        Context context = holder.itemView.getContext();

        holder.tvPenulis.setText(dataBeritaItems.get(position).getPenulisBerita());
        holder.tvJudul.setText(dataBeritaItems.get(position).getJudulBerita());

        String gambar = ApiClient.URL_IMAGE + dataBeritaItems.get(position).getImageBerita();
        Glide.with(context).load(gambar).error(R.drawable.ic_launcher_foreground).into(holder.imgBerita);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(context, DetailBeritaActivity.class);
                intent.putExtra("DETAIL", dataBeritaItems.get(position));
                context.startActivity(intent);
            }
        });
    }

    // 3. set berapa data yg tampil
    @Override
    public int getItemCount() {
        return dataBeritaItems.size();
    }

    // 2. panggil widget
    public class MyViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgBerita;
        private TextView tvJudul, tvPenulis;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            imgBerita = itemView.findViewById(R.id.item_image);
            tvJudul = itemView.findViewById(R.id.item_tv_judul);
            tvPenulis = itemView.findViewById(R.id.item_tv_penulis);

        }
    }
}
