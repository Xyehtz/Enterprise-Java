package ca.sheridancollege.garzonba.ex5_formbinding.controllers;

import ca.sheridancollege.garzonba.ex5_formbinding.beans.VideoGames;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Controller
public class GameController {
    List<VideoGames> videoGamesList = new CopyOnWriteArrayList<>();

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("VideoGames", new VideoGames());
        return "index";
    }

    @PostMapping("/addGame")
    public String addGame(Model model, @ModelAttribute VideoGames videoGames) {
        videoGamesList.add(videoGames);
        model.addAttribute("videoGameList1", videoGamesList);
        model.addAttribute("VideoGames", videoGames);
        return "index";
    }
}
