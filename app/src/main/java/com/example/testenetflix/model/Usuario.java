package com.example.testenetflix.model;

public class Usuario {

    private Integer id;

    private String nome;

    private String senha;





    // CONSTRUTOR COM OS PARAMETROS
    public Usuario(Integer id, String nome, String senha) {
        this.id = id;
        this.nome = nome;
        this.senha = senha;

    }

    //CONSTRUTOR VAZIO
    public Usuario(){}


    // Getters e Setters


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
