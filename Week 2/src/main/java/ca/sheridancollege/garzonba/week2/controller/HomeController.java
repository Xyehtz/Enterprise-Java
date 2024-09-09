package ca.sheridancollege.garzonba.week2.controller;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.io.PrintWriter;

// Assigning the file as a controller
@Controller
public class HomeController {
    // Mapping root
    @GetMapping("/")
    // Handling method
    public String indexPage() {
        // View to load
        return "index";
    }
    
    // map the /formPost path to a POST request
    @PostMapping("/formPost")
    /* To get the params from the HTML form,
    we must use the same names, both in the HTML and the Java method.
    In the Java method, we also need
    to use the @RequestParam decorator so spring knows
    that it is a param that it will receive.
    HttpServrletResponse will let us override the response*/
    public void formPage(HttpServletResponse response, String firstName, String lastName, String email, Long studentId, @RequestParam(required = false) boolean checkbox) {
        try {
            // Create a writer to format the data. Close it at the end
            PrintWriter out = response.getWriter();
            String output = String.format("<html><body>%s<br>%s<br>%s<br>%o<br>Checkbox: %b</body></html>", firstName, lastName, email, studentId, checkbox);
            out.print(output);
            out.close();
        } catch (IOException e) {
            // Writers need to be inside a try catch block even if there are no errors
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
