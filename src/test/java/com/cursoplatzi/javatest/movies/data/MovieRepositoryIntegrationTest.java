package com.cursoplatzi.javatest.movies.data;

import com.cursoplatzi.javatest.movies.model.Genre;
import com.cursoplatzi.javatest.movies.model.Movie;
import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.ScriptUtils;

import javax.sql.DataSource;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

public class MovieRepositoryIntegrationTest {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;
    private MovieRepositoryJdbc movieRepositoryJdbc;

    @Before
    public void setUp() throws Exception {
        dataSource = new DriverManagerDataSource(
                "jdbc:h2:~/test;MODE=MYSQL", "sa", "sa");
        ScriptUtils.executeSqlScript(dataSource.getConnection(), new ClassPathResource("sql-scripts/test-data.sql"));

        jdbcTemplate = new JdbcTemplate(dataSource);
        movieRepositoryJdbc = new MovieRepositoryJdbc(jdbcTemplate);

    }

    @Test
    public void load_all_movies() throws SQLException {
        Collection<Movie> movies = movieRepositoryJdbc.findAll();
        assertThat(movies, CoreMatchers.is(Arrays.asList(
                new Movie(1, "Dark Knight", 152, Genre.ACTION, "Nelson"),
                new Movie(2, "Memento", 113, Genre.THRILLER, "Cristian"),
                new Movie(3, "Matrix", 136, Genre.ACTION, "Sebas")
        )));
    }

    @Test
    public void load_movie_by_id() {
        Movie movieId = movieRepositoryJdbc.findById(2);
        assertThat(movieId, CoreMatchers.is(new Movie(2, "Memento", 113, Genre.THRILLER, "Nelson")));
    }

    @Test
    public void insert_a_movie() {

        movieRepositoryJdbc.saveOrUpdate(new Movie("Super 8", 112, Genre.THRILLER, "Juan"));
        Movie movieFromBd = movieRepositoryJdbc.findById(4);
        assertThat(movieFromBd, CoreMatchers.is(new Movie(4, "Super 8", 112, Genre.THRILLER, "Juan")));
    }

    @Test
    public void load_movies_containing_string() {

    }

    @After
    public void tearDown() throws Exception {
        final Statement s = dataSource.getConnection().createStatement();
        s.execute("drop all objects delete files");
    }
}