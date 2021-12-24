package com.example.livestreaming;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.appbar.MaterialToolbar;

public class MainActivity extends AppCompatActivity {
    MaterialToolbar toolbar;
    VideoView videoView;
    ImageButton thumbUp;
    String videoUri;

    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        toolbar = findViewById(R.id.toolbar);
        videoView = findViewById(R.id.video_view);
        toolbar.setOnMenuItemClickListener(item -> {
            switch (item.getItemId()){
                case R.id.search:
                    Toast.makeText(MainActivity.this, "search", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.share:
                    Toast.makeText(MainActivity.this, "Share", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.more:
                    Toast.makeText(MainActivity.this, "More", Toast.LENGTH_SHORT).show();
                    break;
                default:
            }
            return true;
        });

        MediaController mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);
        videoUri = "android.resource://" + getPackageName() + "/" + R.raw.vertical;
        videoView.setVideoURI(Uri.parse(videoUri));
        videoView.requestFocus();
        videoView.start();

        thumbUp = findViewById(R.id.thumb_up);
        thumbUp.setOnClickListener(view ->
                Toast.makeText(MainActivity.this, "Thumb Up", Toast.LENGTH_SHORT).show());
    }
}