package ca.sheridancollege.garzonba.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// Main controller of the website
@Controller
public class MainController {
    // When the user goes to http://localhost:8080/aboutme spring boot will return the about.html file
    @GetMapping("/aboutme")
    public String aboutmePage() {
        return "about.html";
    } 
}
