package com.example.livestreaming;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.appbar.MaterialToolbar;

public class MainActivity extends AppCompatActivity {
    public static String PACKAGE_NAME;
    MaterialToolbar toolbar;
    VideoView videoView;

    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        PACKAGE_NAME = getApplicationContext().getPackageName();
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

        ViewPager2 viewPager2 = findViewById(R.id.viewPager);
        ViewPagerAdapter adapter = new ViewPagerAdapter();
        viewPager2.setAdapter(adapter);
    }
}