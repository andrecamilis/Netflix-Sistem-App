package com.example.testenetflix.View;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.testenetflix.R;

public class TelaAnime extends AppCompatActivity {

    Button ib;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_anime);


    }

    public void konoTrailer2(View view){
        ib = findViewById(R.id.botaoAnime3);
        Intent in = new Intent(TelaAnime.this, TelaApresentaKono.class);
        startActivity(in);
    }
}