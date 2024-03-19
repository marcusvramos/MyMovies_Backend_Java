package org.example.mymovies.controller;

import org.example.mymovies.entity.Movie;
import org.example.mymovies.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
@RequestMapping("/apis")
public class MovieRestController {
    @Autowired
    MovieRepository movieRepository;
    @GetMapping("/test")
    public ResponseEntity<Object> testarConexao(){
        return ResponseEntity.ok("Bem vindo a API de movies!");
    }

    @GetMapping("/rand-movie")
    public ResponseEntity<Object> getRandFilme() {
        List<Movie> movies = movieRepository.getFilmes();
        int rand = (int) (Math.random() * movies.size());
        return ResponseEntity.ok(movies.get(rand));
    }

    @GetMapping("/movies")
    public ResponseEntity<Object> getFilmes() {
        List<Movie> movies = movieRepository.getFilmes();
        return ResponseEntity.ok(movies);
    }

    @GetMapping("/get-movie")
    public ResponseEntity<Object> getMovieByQueryParam(@RequestParam("id") int id) {
        if (id >= 0 && id < movieRepository.getFilmes().size()) {
            return ResponseEntity.ok(movieRepository.getFilmes().get(id));
        }

        return ResponseEntity.badRequest().body("Filme não encontrado!");
    }

    @GetMapping("/get-movie-id/{id}")
    public ResponseEntity<Object> getMovieByParamId(@PathVariable("id") int id) {
        if (id >= 0 && id < movieRepository.getFilmes().size()) {
            return ResponseEntity.ok(movieRepository.getFilmes().get(id));
        }

        return ResponseEntity.badRequest().body("Filme não encontrado!");
    }

    @PostMapping("/add-movie")
    public ResponseEntity<Object> addMovie(@RequestBody Movie movie) {
        movieRepository.addMovie(movie);
        return ResponseEntity.ok("Filme adicionado com sucesso!");
    }

    @GetMapping("/movies/search")
    public ResponseEntity<Object> searchMoviesByTitle(@RequestParam("title") String title) {
        List<Movie> movies = movieRepository.getFilmes();
        List<Movie> foundMovies = movies.stream()
                .filter(movie -> movie.getTitulo().toLowerCase().contains(title.toLowerCase()))
                .collect(Collectors.toList());

        if (!foundMovies.isEmpty()) {
            return ResponseEntity.ok(foundMovies);
        } else {
            return ResponseEntity.badRequest().body("Nenhum filme encontrado com o título: " + title);
        }
    }
}
