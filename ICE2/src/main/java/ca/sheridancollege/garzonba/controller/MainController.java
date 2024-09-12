package ca.sheridancollege.garzonba.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/ambition")
    public String ambitionsPage() {
        return "ambition";
    }
    
    @GetMapping("/hobbies")
    public String hobbiesPage() {
        return "hobbies";
    }
    
    @GetMapping("/music")
    public String musicPage() {
        return "music";
    }
}
