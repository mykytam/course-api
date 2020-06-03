package com.mykytam.courseapi.topic;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Topic {

    private String id;
    private String name;
    private String description;

}
