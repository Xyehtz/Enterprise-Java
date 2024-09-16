package ca.sheridancollege.garzonba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ca.sheridancollege.garzonba.beans.*;
import repository.CourseList;

@Controller
public class CourseController {
	@Autowired
	private CourseList courseList;
	
	@GetMapping("/")
	public String indexPage() {
		return "index";
	}
	
	@PostMapping("/processForm")
	public String postPage(@RequestParam Long id, @RequestParam String prefix, @RequestParam int code, @RequestParam String name) {
		Course course1 = new Course(id, prefix, code, name);
		courseList.getCourseList().add(course1);
		
		System.out.println("***********");
		
		for (Course c : courseList.getCourseList()) {
			System.out.println(c);
		}
		
		return "index";
	}
}
