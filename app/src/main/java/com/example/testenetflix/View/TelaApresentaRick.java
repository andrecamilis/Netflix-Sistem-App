package com.example.testenetflix.View;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.testenetflix.R;

public class TelaApresentaRick extends AppCompatActivity {

    VideoView videoView;

    ImageView iv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_rick);
        iv = (ImageView) findViewById(R.id.img_voltar);
        videoView = (VideoView) findViewById(R.id.video);

        videoView.setVideoURI(Uri.parse(
                "android.resource://" +getPackageName() + "/"+ R.raw.rick_morty_video));

       MediaController mediaController = new MediaController(this);
       videoView.setMediaController(mediaController);
       videoView.start();


       iv.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent in = new Intent(TelaApresentaRick.this, TelaPrincipal.class);
               startActivity(in);
           }
       });

    }

    // ============ PARTE DO MENU =============//

    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater i = getMenuInflater();
        i.inflate(R.menu.menu_view,menu);
        return true;
    }
    public void irInicio(MenuItem item){
        Toast.makeText(this, "Indo para o início", Toast.LENGTH_SHORT).show();
        Intent in = new Intent(getApplicationContext(), TelaPrincipal.class);
        startActivity(in);
    }
    public void irJogos(MenuItem item){
        Toast.makeText(this, "Indo para o jogos", Toast.LENGTH_SHORT).show();
        //  in = new Intent(getApplicationContext(),TelaJogos.class);
        // startActivity(in);
    }
    public void irPerfil(MenuItem item){
        Toast.makeText(this, "Indo para o perfil", Toast.LENGTH_SHORT).show();

        Intent in = new Intent(getApplicationContext(), TelaPerfilPrincipal.class);
        startActivity(in);
    }
    // ===========================================//

}