package com.example.testenetflix.View;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.testenetflix.R;

public class TelaAviso extends AppCompatActivity {

    Button blzBotao, naoBotao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_aviso);

        blzBotao = findViewById(R.id.blzBotao);
        naoBotao = findViewById(R.id.naoBotao);

        blzBotao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(TelaAviso.this, "Estamos entendidos", Toast.LENGTH_SHORT).show();
                Intent in = new Intent(TelaAviso.this, TelaRegistro.class);
                startActivity(in);
            }
        });

        naoBotao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(TelaAviso.this, "Blz então falou ai ", Toast.LENGTH_LONG).show();
                 finish();
            }
        });


    }
}