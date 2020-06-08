package com.mykytam.courseapi.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Course {

    @Id
    private String id;

    private String name;
    private String description;

    @ManyToOne
    private Topic topic;

    @ManyToMany
    private List<Student> students;
}
