package repository;

import java.util.List;
import ca.sheridancollege.garzonba.beans.*;

public interface CourseList {
	public List<Course> getCourseList();
	
	public void setCourseList(List<Course> courseList);
	
	public void emptyList() {
		getCourseList().clear();
	}
}
