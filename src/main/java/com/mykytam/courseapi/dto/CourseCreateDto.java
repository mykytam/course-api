package com.mykytam.courseapi.dto;

import com.mykytam.courseapi.models.Student;
import com.mykytam.courseapi.models.Topic;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseCreateDto {

    @NotEmpty
    private String id;

    @NotEmpty
    private String name;

    @NotEmpty
    private String description;

    @NotEmpty
    private Topic topic;

    private List<Student> student;
}
