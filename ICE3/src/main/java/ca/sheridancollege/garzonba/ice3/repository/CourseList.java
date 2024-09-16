package ca.sheridancollege.garzonba.ice3.repository;

import ca.sheridancollege.garzonba.ice3.beans.Course;

import java.util.List;

public interface CourseList {
    public List<Course> getCourseList();
    public void setCourseList(List<Course> courseList);
    public void emptyList();
}
