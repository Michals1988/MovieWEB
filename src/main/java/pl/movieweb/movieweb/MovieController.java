package pl.movieweb.movieweb;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class MovieController {

    @Autowired
    MovieRepository movieRepository;

    @GetMapping("/all")
    public String MainPage(Model model) {
        model.addAttribute("items", movieRepository.getAll());
        return "mainPage";
    }

    @GetMapping("/add")
    public String AddMoviePage(Model model) {
        model.addAttribute("newMovie", new Movie());
        return "addMoviePage";
    }

    @PostMapping("/add")
    public String AddMoviePage(@ModelAttribute Movie movie) {
        movieRepository.addMovie(movie);
        return "redirect:/all";
    }

    @GetMapping("/oneMovie/{id}")
    public String Movie(@PathVariable("id") int id, Model model) {
        model.addAttribute("item", movieRepository.getOneMovie(id));
        return "moviePage";
    }

    @DeleteMapping("/deleteMovie/{id}")
    public String delete(@PathVariable("id") int id) {
        movieRepository.deleteOneMovie(id);
        return "redirect:/all";
    }

    @GetMapping("/editMovie/{id}")
    public String MainPage(@PathVariable("id") int id, Model model) {
        model.addAttribute("item", movieRepository.getOneMovie(id));
        return "moviePageEdit";
    }

    @PostMapping("/editMovie/{id}")
    public String update(@ModelAttribute Movie movie) {
        movieRepository.editMovie(movie);
        return "redirect:/all";
    }
}
