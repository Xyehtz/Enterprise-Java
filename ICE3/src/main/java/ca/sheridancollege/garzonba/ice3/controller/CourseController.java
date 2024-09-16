package ca.sheridancollege.garzonba.ice3.controller;

import ca.sheridancollege.garzonba.ice3.beans.*;
import ca.sheridancollege.garzonba.ice3.repository.CourseList;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.print.attribute.standard.PrinterName;
import java.io.IOException;
import java.io.PrintWriter;

@Controller
public class CourseController {
    @Autowired
    private CourseList courseList;
    
    @GetMapping("/")
    public String index() {
        return "index";
    }
    
    @PostMapping("/processForm")
    public void processForm(HttpServletResponse response, @RequestParam long id, @RequestParam String prefix, @RequestParam int code, @RequestParam String name) {

        Course course = Course.builder().id(id).prefix(prefix).code(code).name(name).build();
        courseList.getCourseList().add(course);
        System.out.println("*************");

        for (Course c : courseList.getCourseList()) {
            System.out.println(c);
        }

        try {
            PrintWriter out = response.getWriter();
            String output = String.format("<html><body>Course ID: %o<br>Course Prefix: %s<br>Course Code: %o<br>Course Name: %s<br></body></html>", id, prefix, code, name);
            out.print(output);
            out.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
