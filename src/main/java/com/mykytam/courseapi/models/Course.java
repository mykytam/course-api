package com.mykytam.courseapi.models;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String description;

    @ManyToOne
    private Topic topic;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "course_student",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    @EqualsAndHashCode.Exclude
    @Builder.Default
    private Set<Student> students = new HashSet<>();

    public Course(Integer id) {
        this.id = id;
    }

    public void addStudent(Student student) {
        students.add(student);
        student.getCourses().add(this);
    }
}
