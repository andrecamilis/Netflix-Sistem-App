package com.example.testenetflix.View;

import static com.example.testenetflix.View.TelaPerfilPrincipal.users;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.testenetflix.R;
import com.example.testenetflix.dao.UsuarioDAO;
import com.example.testenetflix.model.Usuario;
import com.example.testenetflix.util.ConnectionFactory;

public class TelaLogin extends AppCompatActivity {


    EditText editTextNome, editTextSenha;
    ConnectionFactory dbHelper;
    ImageButton btnCadastrar;
    SQLiteDatabase db;
    ImageView voltar;
    Cursor cursor;

    private UsuarioDAO dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_login);

        editTextNome = findViewById(R.id.editTextNome);
        editTextSenha = findViewById(R.id.editTextSenha);
        btnCadastrar = findViewById(R.id.btnCadastrar);
        voltar = findViewById(R.id.voltar);

        voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(TelaLogin.this, TelaRegistro.class);
                Toast.makeText(TelaLogin.this, "Realize o cadastro aew", Toast.LENGTH_SHORT).show();
                startActivity(in);
            }
        });
    }

    // Gravar os dados no banco de dados

    @SuppressLint("Range")
    public void login(View view){
        String nome = editTextNome.getText().toString();
        String senha = editTextSenha.getText().toString();
        // Chamando a classe Connectio Factory
        dbHelper = new ConnectionFactory(getApplicationContext());
        db = dbHelper.getReadableDatabase();

        if (editTextNome.getText().toString().equals("") || editTextSenha.getText().toString().equals("")){
            Toast.makeText(this, "Não vai inserir as informações não?", Toast.LENGTH_SHORT).show();
        }else{// DANDO UM SELECT NA TABELA USUARIO COM OS PARAMETROS NOME E SENHA;
            String query = "SELECT * FROM usuario WHERE nome = ? AND senha = ?";
            String[] selectionArgs = {nome , senha};

            cursor = db.rawQuery(query, selectionArgs);

            if (cursor.moveToFirst()){
                Usuario user = new Usuario();
                user.setNome(nome);
                user.setSenha(cursor.getString(cursor.getColumnIndex("senha")));
                user.setNome(cursor.getString(cursor.getColumnIndex("nome")));
                TelaPerfilPrincipal.users = user.getNome();

                System.out.println("Pegando SENHA dados no BD "+ user.getSenha());
                System.out.println("Pegando SENHA dados no BD "+ user.getSenha());


                cursor.close();
                dbHelper.close();

                Toast.makeText(this, "Bem vindo!", Toast.LENGTH_SHORT).show();
                Intent in = new Intent(getApplicationContext(), TelaPrincipal.class);
                startActivity(in);
            }else {
                Toast.makeText(this, "Aew man o login falhou", Toast.LENGTH_SHORT).show();
            }
        }


    }
}