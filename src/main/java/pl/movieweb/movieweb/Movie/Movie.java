package pl.movieweb.movieweb.Movie;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movie {
    private int id;
    private String categoryNameMovie;
    private String title;
    private int releaseYear;
    private String descriptionMovie;
    private float rating;
    private String img;

//    public Movie(int id, String title, int releaseYear, String descriptionMovie, int rating, String img) {
//        this.id=id;
//        this.title = title;
//        this.releaseYear = releaseYear;
//        this.descriptionMovie = descriptionMovie;
//        this.rating = rating;
//        this.img = img;
//    }
}
