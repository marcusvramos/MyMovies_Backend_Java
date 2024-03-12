package org.example.mymovies.entity;

public class Filme {
    private String titulo;
    private int ano;

    public Filme(String titulo, int ano) {
        this.titulo = titulo;
        this.ano = ano;
    }

    public Filme() {
        this("", 0);
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }
}
