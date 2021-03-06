package com.cursoplatzi.javatest.movies.service;

import com.cursoplatzi.javatest.movies.data.MovieRepository;
import com.cursoplatzi.javatest.movies.model.Genre;
import com.cursoplatzi.javatest.movies.model.Movie;

import java.util.Collection;
import java.util.stream.Collectors;

public class MovieService {
    private MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Collection findMovieByGenre(Genre genre) {
        return movieRepository.findAll().stream().
                filter(movie -> movie.getGenre() == genre).collect(Collectors.toList());
    }

    public Collection<Movie> finMoviesByLength(int length) {
        return movieRepository.findAll().stream().
                filter(movie -> movie.getMinutes() <= length).collect(Collectors.toList());
    }

    public Collection<Movie> finByName(String partString) {
        return movieRepository.findAll().stream()
                .filter(movie -> movie.getName().toLowerCase().contains(partString.toLowerCase())).collect(Collectors.toList());
    }

    public Collection<Movie> finByDirector(String director) {
        return movieRepository.findAll().stream()
                .filter(movie -> movie.getDirector().toLowerCase().equals(director.toLowerCase())).collect(Collectors.toList());
    }
}
