package com.example.practica_2_ldm_farmacia;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class publicidad extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_publicidad);
        VideoView mivideo = findViewById(R.id.video);

        String videop = "android.resource://" + getPackageName() +"/" + R.raw.spot_farmacia_fedefarma;
        Uri uri = Uri.parse(videop);
        mivideo.setVideoURI(uri);

        MediaController mediaController = new MediaController(this);
        mivideo.setMediaController(mediaController);
        mediaController.setAnchorView(mivideo);
    }
}