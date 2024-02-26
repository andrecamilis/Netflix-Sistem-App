package com.example.testenetflix.View;


import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.testenetflix.R;
import com.google.android.material.bottomsheet.BottomSheetDialog;

public class TelaPrincipal extends AppCompatActivity {
    ImageButton bnt1, bnt2,rickmorty;
    BottomSheetDialog dialog;

    VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_principal);

        rickmorty = findViewById(R.id.rick);

        rickmorty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(getApplicationContext(), TelaApresentaRick.class);
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



    public void pinkblider(View view){
        bnt1 = findViewById(R.id.pinkblide);
        dialog = new BottomSheetDialog(this);
      final Dialog dialog = new Dialog(this);
      dialog.setContentView(R.layout.peaky);
        dialog.show();
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        dialog.getWindow().setGravity(Gravity.BOTTOM);

    }




    public void minoma(View view){
        bnt1 = findViewById(R.id.mi);
        dialog = new BottomSheetDialog(this);
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.minoma);
        dialog.show();
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        dialog.getWindow().setGravity(Gravity.BOTTOM);

    }

    public void des(View view){
        bnt1 = findViewById(R.id.de);
        dialog = new BottomSheetDialog(this);
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.des);
        dialog.show();
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        dialog.getWindow().setGravity(Gravity.BOTTOM);

    }
    public void boja(View view){
        bnt1 = findViewById(R.id.bo);
        dialog = new BottomSheetDialog(this);
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.bojack);
        dialog.show();
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        dialog.getWindow().setGravity(Gravity.BOTTOM);

    }

    public void the(View view){
        bnt1 = findViewById(R.id.thew);
        dialog = new BottomSheetDialog(this);
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.thew);
        dialog.show();
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        dialog.getWindow().setGravity(Gravity.BOTTOM);

    }

    public void aviao(View view) {
        bnt1 = findViewById(R.id.avi);
        dialog = new BottomSheetDialog(this);
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.aviao);
        dialog.show();
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        dialog.getWindow().setGravity(Gravity.BOTTOM);

    }

    public void konoTrailer(View view){
        bnt1 = findViewById(R.id.ko);

        Intent in = new Intent(TelaPrincipal.this, TelaApresentaKono.class);
        startActivity(in);

    }
    public void aviso (View view){
        bnt2 = findViewById(R.id.salvar);
        Toast.makeText(this, "Filme: Konosuba salvo" , Toast.LENGTH_SHORT).show();
    }


    public void animes(View view){
        bnt1 = findViewById(R.id.anim);
        Intent in = new Intent(this,TelaAnime.class);
        startActivity(in);

    }

    public void star(View view){
        bnt1 = findViewById(R.id.star);
    }


    public void gta(View view){
       Intent in = new Intent(getApplicationContext(), TelaApresentarGtaSeis.class);
       startActivity(in);
    }

}
