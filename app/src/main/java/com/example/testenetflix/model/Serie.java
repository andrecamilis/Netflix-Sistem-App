package com.example.testenetflix.model;

public class Serie {

    private int id_serie; // Primary Key
    private String uri_capa;
    private String uri_video;
    private String nome;
    private int id_categoria; // Foreign Key
    private String sinopse;
    private String estrelando;
    private String ano_lancamento;
    private int faixa_etaria;
    private int qnt_temporadas;
    private int id_episodio; // Foreign Key

}
