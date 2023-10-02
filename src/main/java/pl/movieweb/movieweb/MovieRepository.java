package pl.movieweb.movieweb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MovieRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public void addMovie(Movie movie) {
        jdbcTemplate.update("INSERT INTO movieweb.library (title, releaseYear, rating, descriptionMovie, img) VALUES (?, ?, ?, ?, ?)",
                movie.getTitle(),
                movie.getReleaseYear(),
                movie.getRating(),
                movie.getDescriptionMovie(),
                movie.getImg());
    }

    public List<Movie> getAll() {
        List<Movie> movieList;
        movieList = jdbcTemplate.query("SELECT * FROM movieweb.library", BeanPropertyRowMapper.newInstance(Movie.class));
        return movieList;
    }

    public void deleteOneMovie(int id) {
        jdbcTemplate.update("DELETE FROM movieweb.library WHERE " + "id = ?", id);
    }

    public Movie getOneMovie(int id) {
        Movie movie;
        movie = jdbcTemplate.queryForObject("SELECT * FROM movieweb.library WHERE " + "id = ?", BeanPropertyRowMapper.newInstance(Movie.class), id);
        return movie;
    }

    public void editMovie(Movie movie) {
        System.out.println(movie.toString());
        jdbcTemplate.update("UPDATE movieweb.library SET title=?, releaseYear=?, descriptionMovie=?, rating=?, img=? WHERE id=?",
                movie.getTitle(),
                movie.getReleaseYear(),
                movie.getDescriptionMovie(),
                movie.getRating(),
                movie.getImg(),
                movie.getId());
    }
}
