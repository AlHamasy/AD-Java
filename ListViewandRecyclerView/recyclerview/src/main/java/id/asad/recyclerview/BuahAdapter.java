package id.asad.recyclerview;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.MediaPlayer;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.IOException;

public class BuahAdapter extends RecyclerView.Adapter<BuahAdapter.MyViewHolder> {

    private String [] namaBuah;
    private int [] gambarBuah;
    private int [] musicBuah;

    public BuahAdapter(String[] namaBuah, int[] gambarBuah, int [] musicBuah) {
        this.namaBuah = namaBuah;
        this.gambarBuah = gambarBuah;
        this.musicBuah = musicBuah;
    }

    // 1. panggil layout
    @NonNull
    @Override
    public BuahAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_buah, parent, false);
        return new MyViewHolder(view);
    }

    // 3. atur data untuk ditampilkan
    @Override
    public void onBindViewHolder(@NonNull BuahAdapter.MyViewHolder holder, final int position) {

        holder.tvBuah.setText(namaBuah[position]);
        holder.imgBuah.setImageResource(gambarBuah[position]);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), namaBuah[position], Toast.LENGTH_SHORT).show();
                playMusic(musicBuah[position], view.getContext());
            }
        });
    }

    private void playMusic(int music, Context context){

        Uri uri = Uri.parse("android.resource://" + getClass().getPackage().getName() + "/" + music);

        MediaPlayer mediaPlayer = new MediaPlayer();
        mediaPlayer.setAudioAttributes(new AudioAttributes.Builder()
                                        .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                                        .build());

        try {
            mediaPlayer.setDataSource(context, uri);
            mediaPlayer.prepare();
            mediaPlayer.start();
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    // 4. atur banyak data yg tampil
    @Override
    public int getItemCount() {
        return namaBuah.length;
    }

    // 2. panggil widget
    public class MyViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgBuah;
        private TextView tvBuah;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            imgBuah = itemView.findViewById(R.id.item_image);
            tvBuah = itemView.findViewById(R.id.item_text);

        }
    }
}
