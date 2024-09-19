package ca.sheridancollege.garzonba.controller;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.io.PrintWriter;

@Controller
public class HomeController {
    @GetMapping("/form")
    public String formPage() {
        return "javaFun";
    }
    
    @PostMapping("/submitForm")
    public void submitForm(
            HttpServletResponse httpServletResponse, 
            @RequestParam String isJavaFun,
            @RequestParam(required = false) boolean addEmail, 
            @RequestParam String name, 
            @RequestParam String email) {
        try {
            PrintWriter out = httpServletResponse.getWriter();
            String output = isAddEmailNull(addEmail, name, email);
            out.print(output);
            out.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    private String isAddEmailNull(boolean addEmail, String name, String email) {
        if (!addEmail) {
            return "<h1>Thanks for filling the form, " + name + "</h1><h2>Glad you're having fun!</h2><h3>We won't add your email to the list</h3>";
        }

        return "<h1>Thanks for filling the form, " + name + "</h1><h2>Glad you're having fun!</h2><h3>We'll add your email: " + email + " to our list</h3>";
    }
}
