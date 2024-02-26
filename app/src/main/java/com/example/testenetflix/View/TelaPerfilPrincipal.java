package com.example.testenetflix.View;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.testenetflix.R;
import com.example.testenetflix.dao.UsuarioDAO;
import com.example.testenetflix.model.Usuario;

import java.util.List;

public class TelaPerfilPrincipal extends AppCompatActivity {

    ImageView ivNorti, ivDonw, placeHolder;


    private List<Usuario> usuarios;
    TextView nomeUsuario, id;

    ImageView rickMorty;

     static String  users = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_perfil_principal);

        id = findViewById(R.id.id);
        nomeUsuario = findViewById(R.id.nomeUser);
        ivNorti = findViewById(R.id.imgNorti);
        ivDonw = findViewById(R.id.imgDown);
        rickMorty = findViewById(R.id.rick);

        UsuarioDAO userdao = new UsuarioDAO(this);
        usuarios = userdao.usuarioList();
        for(Usuario usuario: usuarios){
            nomeUsuario.setText(users);


        }

        rickMorty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(getApplicationContext(), TelaApresentaRick.class);
                startActivity(in);
            }
        });


      //  String caminhoImagem = users.getCaminhoImagem();
      //  byte[]imagemBytes = users.getCaminhoImagem().getBytes();

      /*  if (caminhoImagem !=null && !caminhoImagem.isEmpty()){
            Toast.makeText(this, "TEM IMAGEM SALVA", Toast.LENGTH_SHORT).show();
        } else if (imagemBytes !=null && imagemBytes.length > 0) {
            Toast.makeText(this, "USE OS BITES PARA EXIBIR", Toast.LENGTH_SHORT).show();

        }*/


        ivNorti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), TelaNortificacao.class);
                startActivity(in);
            }
        });

    }

}