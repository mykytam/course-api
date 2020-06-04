package com.mykytam.courseapi.course;

import com.mykytam.courseapi.topic.Topic;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Course {
    @Id
    private String id;

    private String name;
    private String description;
    private Topic topic;
}
