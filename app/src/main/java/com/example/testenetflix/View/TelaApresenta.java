package com.example.testenetflix.View;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.testenetflix.R;

public class TelaApresenta extends AppCompatActivity {

    VideoView videoView;

    ImageView iv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela);
        iv = (ImageView) findViewById(R.id.img_voltar);
        videoView = (VideoView) findViewById(R.id.video);

        videoView.setVideoURI(Uri.parse(
                "android.resource://" +getPackageName() + "/"+ R.raw.kono_subarashii_zueira));

       MediaController mediaController = new MediaController(this);
       videoView.setMediaController(mediaController);
       videoView.start();


       iv.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent in = new Intent(TelaApresenta.this, TelaPrincipal.class);
               startActivity(in);
           }
       });

    }

}