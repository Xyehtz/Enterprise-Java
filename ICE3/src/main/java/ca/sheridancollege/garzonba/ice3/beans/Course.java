package ca.sheridancollege.garzonba.ice3.beans;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder
public class Course {
    @NonNull
    private long id;
    private String prefix;
    private int code;
    private String name;
}
