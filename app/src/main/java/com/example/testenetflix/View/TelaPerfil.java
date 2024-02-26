package com.example.testenetflix.View;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;


import androidx.appcompat.app.AppCompatActivity;

import com.example.testenetflix.R;
import com.example.testenetflix.model.Usuario;
import com.example.testenetflix.util.ConnectionFactory;

import java.sql.Blob;

public class TelaPerfil extends AppCompatActivity {

 ConnectionFactory connectionFactory;

 SQLiteDatabase sqLiteDatabase;
 ImageView imgAzul, imgRosa,imgVerde, imgVermelho, imgAmarelo;
 Blob blob;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_perfil);


        imgAzul = findViewById(R.id.imgAzul);
        imgRosa = findViewById(R.id.imgRosa);
        imgVerde = findViewById(R.id.imgVerde);
        imgVermelho = findViewById(R.id.imgVermelho);
        imgAmarelo = findViewById(R.id.imgAmarelo);



        imgAzul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgAzul.setImageResource(R.drawable.foto1);
                Usuario user = new Usuario();

                Intent in = new Intent(getApplicationContext(), TelaPrincipal.class);
                startActivity(in);
            }
        });

        imgRosa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgRosa.setImageResource(R.drawable.foto2);
            }
        });

        imgVerde.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgVerde.setImageResource(R.drawable.foto3);
            }
        });

        imgVermelho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgVermelho.setImageResource(R.drawable.foto4);
            }
        });

        imgAmarelo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgAmarelo.setImageResource(R.drawable.foto5);
            }
        });

    }


}
