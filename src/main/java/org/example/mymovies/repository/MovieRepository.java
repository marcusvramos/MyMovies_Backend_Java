package org.example.mymovies.repository;

import org.example.mymovies.entity.Movie;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class MovieRepository {
    private List<Movie> filmes;

    public MovieRepository() {
        this.filmes = new ArrayList<>(Arrays.asList(
                new Movie("Matrix", 1999),
                new Movie("O Poderoso Chefão", 1972),
                new Movie("O Senhor dos Anéis: O Retorno do Rei", 2003),
                new Movie("O Rei Leão", 1994),
                new Movie("Forrest Gump", 1994),
                new Movie("A Origem", 2010),
                new Movie("A Lista de Schindler", 1993),
                new Movie("O Senhor dos Anéis: A Sociedade do Anel", 2001),
                new Movie("Star Wars: Episódio V - O Império Contra-Ataca", 1980),
                new Movie("Os Vingadores", 2012)
        ));
    }

    public List<Movie> getFilmes() {
        return filmes;
    }

    public void addMovie(Movie movie) {
        filmes.add(movie);
    }
}
