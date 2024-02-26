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

public class TelaApresentaKono extends AppCompatActivity {

    VideoView videoView;

    ImageView iv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_konos);
        iv = (ImageView) findViewById(R.id.voltar);
        videoView = (VideoView) findViewById(R.id.videoView3);

        videoView.setVideoURI(Uri.parse(
                "android.resource://" +getPackageName() + "/"+ R.raw.kono_subarashii_zueira));

       MediaController mediaController = new MediaController(this);
       videoView.setMediaController(mediaController);
       videoView.start();


       iv.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent in = new Intent(TelaApresentaKono.this, TelaPrincipal.class);
               startActivity(in);
           }
       });

    }

}