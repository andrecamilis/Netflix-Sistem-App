package com.example.testenetflix.View;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.testenetflix.R;
import com.example.testenetflix.dao.UsuarioDAO;
import com.example.testenetflix.model.Usuario;
import com.example.testenetflix.util.ConnectionFactory;

public class TelaRegistro extends AppCompatActivity {

    public ConnectionFactory dbHelper;
    public SQLiteDatabase db;
    public ContentValues valores;


    private EditText edtTextNome;
    private EditText edtTextSenha;
    private Button btn2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_registro);
        edtTextNome = findViewById(R.id.edtTextNome);
        edtTextSenha = findViewById(R.id.edtTextSenha);
        btn2 = findViewById(R.id.bnt2);



    }
    public void gravar(View view){

        if (edtTextNome.getText().toString().equals("") || edtTextSenha.getText().toString().equals("")){
            Toast.makeText(this, "Não vai inserir as informações não?", Toast.LENGTH_SHORT).show();
        }else {
            UsuarioDAO dao = new UsuarioDAO(this);
            Usuario user = new Usuario();
            user.setNome(edtTextNome.getText().toString());
            user.setSenha(edtTextSenha.getText().toString());
            long id = dao.insert(user);
            TelaPerfilPrincipal.users = user.getNome();

            Toast.makeText(this, "Usuario cadastrado :)", Toast.LENGTH_SHORT).show();
            Intent in = new Intent(getApplicationContext(), TelaPerfil.class);
            startActivity(in);
        }

    }
}
