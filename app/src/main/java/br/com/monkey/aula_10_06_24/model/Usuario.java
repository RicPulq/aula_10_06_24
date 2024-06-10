package br.com.monkey.aula_10_06_24.model;

public class Usuario {
    String nome, sobrenome, idade, username;

    public Usuario() {
    }

    public Usuario(String nome, String sobrenome, String idade, String username) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.idade = idade;
        this.username = username;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
