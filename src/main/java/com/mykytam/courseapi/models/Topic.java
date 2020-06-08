package com.mykytam.courseapi.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Topic {

    @Id
    private Integer id;

    private String name;
    private String description;

    public Topic(Integer id) {
        this.id = id;
    }
}
