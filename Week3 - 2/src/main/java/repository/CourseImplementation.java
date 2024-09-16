package repository;

import java.util.List;
import org.springframework.stereotype.Component;
import ca.sheridancollege.garzonba.beans.Course;

@Component
public class CourseImplementation implements CourseList {
	private List<Course> courseList = new CopyOnWrtieArrayList<Course>();
	
	public List<Course> getCourseList() {
		return courseList;
	}
}
