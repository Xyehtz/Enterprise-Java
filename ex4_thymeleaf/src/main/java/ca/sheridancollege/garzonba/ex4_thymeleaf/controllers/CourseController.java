package ca.sheridancollege.garzonba.ex4_thymeleaf.controllers;

import ca.sheridancollege.garzonba.ex4_thymeleaf.beans.Course;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Controller
public class CourseController {
    List<Course> courseList = new CopyOnWriteArrayList<Course>();
    
    @GetMapping("/")
    private String index(Model model) {
        model.addAttribute("courseList", courseList);
        return "index";
    }
    
    @PostMapping("/addCourse")
    public String addCourse(@RequestParam String name, @RequestParam String prefix, @RequestParam long id, @RequestParam long code, Model model) {
        Course course = new Course(name, prefix, id, code);
        courseList.add(course);
        model.addAttribute("courseList", courseList);
        
        return "index";
    }
}
