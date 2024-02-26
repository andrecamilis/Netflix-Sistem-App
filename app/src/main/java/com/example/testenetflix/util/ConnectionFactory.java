package com.example.testenetflix.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class ConnectionFactory extends SQLiteOpenHelper {
    private static final String NAME ="banco.db";
    private static final int VERSION = 1;


    // Nome das tabelas e colunas

    public static final String TABLE_NAME = "usuario";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NOME = "nome";
    public static final String COLUMN_SENHA = "senha";


    public ConnectionFactory(@Nullable Context context){
        super(context, NAME,null,VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        String createTableSQL = "CREATE TABLE " + TABLE_NAME + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_NOME + " VARCHAR(50), " +
                COLUMN_SENHA + " VARCHAR(50));";

        db.execSQL(createTableSQL);

        /*db.execSQL("create table usuario(id integer primary key autoincrement,"+
                "nome varchar(50), senha varchar(12))");*/
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int i,int i1){
        String sql = "DROP TABLE IF EXISTS usuario";
        db.execSQL(sql);
        onCreate(db);
    }
}
