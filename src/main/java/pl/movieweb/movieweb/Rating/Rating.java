package pl.movieweb.movieweb.Rating;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Rating {
    int id;
    int movieId;
    int movieRating;
}
