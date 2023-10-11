package pl.movieweb.movieweb;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.movieweb.movieweb.Category.CategoryRepository;
import pl.movieweb.movieweb.Movie.Movie;
import pl.movieweb.movieweb.Movie.MovieRepository;
import pl.movieweb.movieweb.Rating.RatingRepository;


@Controller
public class MovieWebController {

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    RatingRepository ratingRepository;


    @GetMapping("/")
    public String StartPage() {
        return "startPage";
    }

    @GetMapping("/all")
    public String MainPage(Model model) {
        model.addAttribute("items", movieRepository.getAll());
        model.addAttribute("categoryList", categoryRepository.getAllCategory());
        return "mainPage";
    }

    @GetMapping("/all/{idCategory}")
    public String FindByCategory(@PathVariable("idCategory") int idCategory, Model model) {
        String categoryName = categoryRepository.findCategoryName(idCategory);
        model.addAttribute("items", movieRepository.findMovieByCategory(categoryName));
        model.addAttribute("categoryList", categoryRepository.getAllCategory());
        return "mainPage";
    }

    @GetMapping("/add")
    public String AddMoviePage(Model model) {
        model.addAttribute("newMovie", new Movie());
        model.addAttribute("categoryList", categoryRepository.getAllCategory());
        return "addMoviePage";
    }

    @PostMapping("/add")
    public String AddMoviePage(@ModelAttribute Movie movie) {
        movieRepository.addMovie(movie);
        return "redirect:/all";
    }

    @GetMapping("/oneMovie/{id}")
    public String Movie(@PathVariable("id") int id, Model model) {
        model.addAttribute("categoryList", categoryRepository.getAllCategory());
        if (id == 0) {
            return "redirect:/all";
        }
        model.addAttribute("item", movieRepository.getOneMovie(id));
        return "moviePage";
    }

    @PostMapping("/oneMovie/{id}")
    public String Movie(@PathVariable("id") int id, @RequestParam("movieRating") int movieRating, Model model) {
        model.addAttribute("categoryList", categoryRepository.getAllCategory());
        if (id == 0) {
            return "redirect:/all";
        }
        ratingRepository.addRating(movieRating, id);
        float actualMovieRating = ratingRepository.getMovieRating(id);

        movieRepository.updateMovieRating(actualMovieRating, id);

        model.addAttribute("item", movieRepository.getOneMovie(id));
        return "moviePageVote";
    }

    @DeleteMapping("/deleteMovie/{id}")
    public String delete(@PathVariable("id") int id) {
        movieRepository.deleteOneMovie(id);
        return "redirect:/all";
    }

    @GetMapping("/editMovie/{id}")
    public String editMovie(@PathVariable("id") int id, Model model) {
        model.addAttribute("categoryList", categoryRepository.getAllCategory());
        model.addAttribute("item", movieRepository.getOneMovieToEdit(id));
        return "moviePageEdit";
    }

    @PostMapping("/editMovie/{id}")
    public String update(@ModelAttribute Movie movie) {
        movieRepository.editMovie(movie);
        return "redirect:/all";
    }

    @PostMapping("/searchMovie")
    public String SearchMovie(@RequestParam("movieTitle") String movieTitle, Model model) {
        model.addAttribute("categoryList", categoryRepository.getAllCategory());
        model.addAttribute("items", movieRepository.findMovie(movieTitle));
        return "mainPage";
    }
}
