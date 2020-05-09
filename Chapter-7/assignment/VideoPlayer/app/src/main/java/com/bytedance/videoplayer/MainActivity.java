package com.bytedance.videoplayer;

import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {
    private VideoView videoView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("VideoView");
        videoView = findViewById(R.id.videoView);

        Uri uri = getIntent().getData();
        if (uri == null)
            uri = Uri.parse("android.resource://" + this.getPackageName() + "/" + R.raw.bytedance);
        videoView.setVideoURI(uri);

        MediaController mediaController = new MediaController(this);
//        videoView.setVideoPath(getVideoPath(R.raw.bytedance));
        videoView.setMediaController(mediaController);
        videoView.start();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
            hideActionBar();
        }
        else {
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
            showActionBar();
        }
    }

    private void hideActionBar() {
        // Hide UI
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
    }

    private void showActionBar() {
        // Hide UI
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.show();
        }
    }
}
