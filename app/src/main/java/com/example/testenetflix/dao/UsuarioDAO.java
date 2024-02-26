package com.example.testenetflix.dao;

import static com.example.testenetflix.util.ConnectionFactory.COLUMN_ID;
import static com.example.testenetflix.util.ConnectionFactory.COLUMN_NOME;
import static com.example.testenetflix.util.ConnectionFactory.COLUMN_SENHA;
import static com.example.testenetflix.util.ConnectionFactory.TABLE_NAME;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.testenetflix.model.Usuario;
import com.example.testenetflix.util.ConnectionFactory;

import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {
    private ConnectionFactory conexao;
    private SQLiteDatabase banco;

    public UsuarioDAO(Context context){
        // ConnectionFactory com o banco de dados
        conexao = new ConnectionFactory(context);
        banco = conexao.getWritableDatabase();

    }


    public long insert(Usuario usuario){
        ContentValues values = new ContentValues();
        values.put("nome", usuario.getNome());
        values.put("senha",usuario.getSenha());

        return(banco.insert("usuario", null, values));
    }

    public Usuario read(Integer id){
        String args[] = {String.valueOf(id)};
        Cursor cursor = banco.query(TABLE_NAME, new String[]{ COLUMN_ID, COLUMN_NOME, COLUMN_SENHA}, "id = ?",args, null, null,null);
        cursor.moveToFirst();
        Usuario user = new Usuario();
        if (cursor.getCount()> 0){
            user.setId(cursor.getInt(0));
            user.setNome(cursor.getString(1));
            user.setSenha(cursor.getString(2));
        }
        return user;
    }

    public List<Usuario> usuarioList(){
        List<Usuario> userlist = new ArrayList<>();
        Cursor cursor = banco.query(TABLE_NAME, new String[]{COLUMN_ID, COLUMN_NOME, COLUMN_SENHA},
                null, null, null, null, null);
        while(cursor.moveToNext()) {
            Usuario user = new Usuario();
            user.setId(cursor.getInt(0));
            user.setNome(cursor.getString(1));
            user.setSenha(cursor.getString(2));
            userlist.add(user);
        }
        return userlist;
    }
}
