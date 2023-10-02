package pl.movieweb.movieweb;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movie {
    private int id;
    private String title;
    private int releaseYear;
    private String descriptionMovie;
    private int rating;
    private String img;
}
