package ca.sheridancollege.garzonba.ex4_thymeleaf.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course {
    private String name;
    private String prefix;
    private long id;
    private long code;
}
