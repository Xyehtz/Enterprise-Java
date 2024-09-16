package ca.sheridancollege.garzonba.ice3.repository;


import ca.sheridancollege.garzonba.ice3.beans.Course;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
@Data
public class CourseListImplementation implements CourseList {
    private List<Course> courseList = new CopyOnWriteArrayList<>();
    
    @Override
    public void emptyList() {

    }
}
