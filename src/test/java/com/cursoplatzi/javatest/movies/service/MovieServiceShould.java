package com.cursoplatzi.javatest.movies.service;

import com.cursoplatzi.javatest.movies.data.MovieRepository;
import com.cursoplatzi.javatest.movies.model.Genre;
import com.cursoplatzi.javatest.movies.model.Movie;
import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class MovieServiceShould {
    private MovieRepository movieRepository;
    private MovieService movieService;

    @Before
    public void setUp() throws Exception {
        movieRepository = Mockito.mock(MovieRepository.class);
        movieService = new MovieService(movieRepository);

        Mockito.when(movieRepository.findAll()).thenReturn(
                Arrays.asList(
                        new Movie(1, "Dark Knight", 152, Genre.ACTION, "Nelson"),
                        new Movie(2, "Memento", 113, Genre.THRILLER, "Cristian"),
                        new Movie(3, "There's Something About Mary", 119, Genre.COMEDY, "Sebastian"),
                        new Movie(4, "Super 8", 112, Genre.THRILLER, "Jose"),
                        new Movie(5, "Scream", 111, Genre.HORROR, "Fabian"),
                        new Movie(6, "Home Alone", 103, Genre.COMEDY, "Nelson"),
                        new Movie(7, "SuperMan", 136, Genre.ACTION, "Gustavo")
                )
        );
    }

    @Test
    public void return_movie_by_genre() {
        Collection<Movie> movies = movieService.findMovieByGenre(Genre.COMEDY);
        assertThat(getMovieId(movies), CoreMatchers.is(Arrays.asList(3, 6)));
    }

    @Test
    public void return_movies_by_length() {
        Collection<Movie> movies = movieService.finMoviesByLength(119);
        assertThat(getMovieId(movies), CoreMatchers.is(Arrays.asList(2, 3, 4, 5, 6)));
    }

    @Test
    public void return_movies_containing_string() {
        Collection<Movie> movies = movieService.finByName("super");
        assertThat(getMovieId(movies), CoreMatchers.is(Arrays.asList(4, 7)));
    }

    @Test
    public void return_movies_by_director() {
        Collection<Movie> movies = movieService.finByDirector("Nelson");
        assertThat(getMovieId(movies), CoreMatchers.is(Arrays.asList(1,6)));
    }

    private List<Integer> getMovieId(Collection<Movie> movies) {
        return movies.stream().map(Movie::getId).collect(Collectors.toList());
    }
}