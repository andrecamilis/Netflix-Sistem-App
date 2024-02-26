package com.example.testenetflix.View;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.testenetflix.R;

public class TelaApresentacao extends AppCompatActivity {
    ViewPager viewPager;


    Button bnt1;
    TextView privaBotao,entrarBotao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_apresentacao);

        bnt1 = (Button) findViewById(R.id.bnt1);
        privaBotao = findViewById(R.id.privaBotao);
        entrarBotao = findViewById(R.id.entrarBotao);


        privaBotao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(TelaApresentacao.this, TelaAviso.class);
                startActivity(in);
            }
        });

        entrarBotao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(getApplicationContext(), TelaLogin.class);
                startActivity(in);
            }
        });



    }

    public void bnt1(View view){
        Intent in = new Intent(TelaApresentacao.this, TelaRegistro.class);
        startActivity(in);

    }
}