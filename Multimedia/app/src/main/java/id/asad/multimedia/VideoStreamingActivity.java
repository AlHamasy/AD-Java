package id.asad.multimedia;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.MediaController;
import android.widget.VideoView;

public class VideoStreamingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_streaming);

        VideoView videoViewStreaming = findViewById(R.id.video_view_streaming);

        MediaController controller = new MediaController(this);
        controller.setAnchorView(videoViewStreaming);
        videoViewStreaming.setMediaController(controller);

        String urlMovie = "https://www.dropbox.com/s/2xziljidxo1jzva/Moana.mp4?dl=1";

        videoViewStreaming.setVideoURI(Uri.parse(urlMovie));
        videoViewStreaming.requestFocus();

        videoViewStreaming.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.start();
            }
        });
    }
}