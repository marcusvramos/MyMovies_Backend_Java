package org.example.mymovies.entity;

public class Movie {
    private String titulo;
    private int ano;

    public Movie(String titulo, int ano) {
        this.titulo = titulo;
        this.ano = ano;
    }

    public Movie() {
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
