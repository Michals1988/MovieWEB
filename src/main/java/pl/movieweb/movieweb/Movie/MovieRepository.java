package pl.movieweb.movieweb.Movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pl.movieweb.movieweb.Category.Category;

import java.util.List;

@Repository
public class MovieRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    String emptyDescription = "Jeszcze nikt nie dodał opisu";
    String emptyImage = "https://almparts.co.za/wp-content/uploads/2021/12/no-image-available-icon.jpg";

    public void addMovie(Movie movie) {
        if (movie.getImg().isEmpty()) {
            movie.setImg(emptyImage);
        }
        if (movie.getDescriptionMovie().isEmpty()) {
            movie.setDescriptionMovie(emptyDescription);
        }
        float firstRating=0;
        jdbcTemplate.update("INSERT INTO movieweb.library (title, categoryNameMovie, releaseYear, descriptionMovie, rating, img) VALUES (?, ?, ?, ?, ?, ?)",
                movie.getTitle(),
                movie.getCategoryNameMovie(),
                movie.getReleaseYear(),
                movie.getDescriptionMovie(),
                firstRating,
                movie.getImg());
    }

    public List<Movie> getAll() {
        List<Movie> movieList;
        movieList = jdbcTemplate.query("SELECT * FROM movieweb.library", BeanPropertyRowMapper.newInstance(Movie.class));
        if (movieList.isEmpty()) {
            Movie movie = new Movie(0, "Brak kategorii", "Brak filmów", 0, "Brak opisu", 0, "https://almparts.co.za/wp-content/uploads/2021/12/no-image-available-icon.jpg");
            movieList.add(movie);
        }
        return movieList;
    }

    public void deleteOneMovie(int id) {
        jdbcTemplate.update("DELETE FROM movieweb.library WHERE id = ?", id);
    }

    public Movie getOneMovie(int id) {
        Movie movie;
        movie = jdbcTemplate.queryForObject("SELECT * FROM movieweb.library WHERE " + "id = ?", BeanPropertyRowMapper.newInstance(Movie.class), id);
        return movie;
    }

    public Movie getOneMovieToEdit(int id) {
        Movie movie;
        movie = jdbcTemplate.queryForObject("SELECT * FROM movieweb.library WHERE " + "id = ?", BeanPropertyRowMapper.newInstance(Movie.class), id);
        if (movie.getDescriptionMovie().equals(emptyDescription)) {
            movie.setDescriptionMovie("");
        }
        if (movie.getImg().equals(emptyImage)) {
            movie.setImg("");
        }
        return movie;
    }


    public void editMovie(Movie movie) {
        System.out.println(movie.toString());
        if (movie.getImg().isEmpty()) {
            movie.setImg(emptyImage);
        }
        if (movie.getDescriptionMovie().isEmpty()) {
            movie.setDescriptionMovie(emptyDescription);
        }
        jdbcTemplate.update("UPDATE movieweb.library SET title=?, categoryNameMovie=?, releaseYear=?, descriptionMovie=?, img=? WHERE id=?",
                movie.getTitle(),
                movie.getCategoryNameMovie(),
                movie.getReleaseYear(),
                movie.getDescriptionMovie(),
                movie.getImg(),
                movie.getId());
    }

    public List<Movie> findMovie(String movieTitle) {
        List<Movie> movieList;
        movieTitle = "%" + movieTitle + "%";
        movieList = jdbcTemplate.query("SELECT * FROM movieweb.library WHERE title LIKE ?", BeanPropertyRowMapper.newInstance(Movie.class), movieTitle);
        System.out.println(movieTitle);
        System.out.println(movieList.toString());
        if (movieList.isEmpty()) {
            Movie movie = new Movie(0, "Brak kategorii", "Brak filmów", 0, "Brak opisu", 0, "https://almparts.co.za/wp-content/uploads/2021/12/no-image-available-icon.jpg");
            movieList.add(movie);
        }
        return movieList;
    }

    public List<Movie> findMovieByCategory(String categoryName) {
        List<Movie> movieList;
        movieList = jdbcTemplate.query("SELECT * FROM movieweb.library WHERE categoryNameMovie=?", BeanPropertyRowMapper.newInstance(Movie.class), categoryName);

        if (movieList.isEmpty()) {
            Movie movie = new Movie(0, "Brak kategorii", "Brak filmów", 0, "Brak opisu", 0, "https://almparts.co.za/wp-content/uploads/2021/12/no-image-available-icon.jpg");
            movieList.add(movie);
        }
        return movieList;
    }

    public void updateMovieRating(float movieRating, int movieId) {
        jdbcTemplate.update("UPDATE movieweb.library SET rating=? WHERE id=?",
                movieRating,
                movieId);
    }
}

