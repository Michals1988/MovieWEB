package pl.movieweb.movieweb.Rating;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class RatingRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public void addRating(int movieRating, int movieId) {
        jdbcTemplate.update("INSERT INTO movieweb.rating (movieId, movieRating) VALUES (?, ?)",
                movieId,
                movieRating);
    }

    public float getMovieRating(int movieId) {
        float movieRating;
        try {
            movieRating = jdbcTemplate.queryForObject("SELECT AVG(movieRating) FROM movieweb.rating WHERE movieId=?", Float.class, movieId);
        } catch (Exception e) {
            movieRating = 0;
        }
        return movieRating;
    }
}
