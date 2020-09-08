package id.asad.multimedia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.AudioAttributes;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnPlay, btnPause, btnStop, btnResume, btnVideo, btnVideoStreaming;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mediaPlayer = new MediaPlayer();

        Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.music);
        mediaPlayer.setAudioAttributes(new AudioAttributes.Builder()
                                        .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                                        .build()
                                        );

        try {
            mediaPlayer.setDataSource(this, uri);
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }

        btnPlay = findViewById(R.id.btn_play);
        btnPause = findViewById(R.id.btn_pause);
        btnStop = findViewById(R.id.btn_stop);
        btnResume = findViewById(R.id.btn_resume);
        btnVideo = findViewById(R.id.btn_video);
        btnVideoStreaming = findViewById(R.id.btn_video_streaming);

        btnPlay.setOnClickListener(this);
        btnPause.setOnClickListener(this);
        btnStop.setOnClickListener(this);
        btnResume.setOnClickListener(this);
        btnVideo.setOnClickListener(this);
        btnVideoStreaming.setOnClickListener(this);

        // enable & disable button
        btnPlay.setEnabled(true);
        btnPause.setEnabled(false);
        btnStop.setEnabled(false);
        btnResume.setEnabled(false);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_play:

                try {
                    mediaPlayer.prepare();
                    mediaPlayer.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                // enable & disable button
                btnPlay.setEnabled(false);
                btnPause.setEnabled(true);
                btnStop.setEnabled(true);
                btnResume.setEnabled(false);

                break;
            case R.id.btn_pause:

                if (mediaPlayer.isPlaying()) mediaPlayer.pause();

                // enable & disable button
                btnPlay.setEnabled(false);
                btnPause.setEnabled(false);
                btnStop.setEnabled(false);
                btnResume.setEnabled(true);

                break;
            case R.id.btn_stop:

                if (mediaPlayer.isPlaying() || mediaPlayer != null) mediaPlayer.stop();

                // enable & disable button
                btnPlay.setEnabled(true);
                btnPause.setEnabled(false);
                btnStop.setEnabled(false);
                btnResume.setEnabled(false);

                break;
            case R.id.btn_resume:

                if (mediaPlayer != null) mediaPlayer.start();

                // enable & disable button
                btnPlay.setEnabled(false);
                btnPause.setEnabled(true);
                btnStop.setEnabled(true);
                btnResume.setEnabled(false);

                break;
            case R.id.btn_video:

                Intent intent = new Intent(this, VideoActivity.class);
                startActivity(intent);

                break;
            case R.id.btn_video_streaming:

                Intent videoStreaming = new Intent(this, VideoStreamingActivity.class);
                startActivity(videoStreaming);

                break;
        }
    }
}