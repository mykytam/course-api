package com.mykytam.courseapi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CourseResponseDto {

    private Integer id;
    private String name;
    private String description;
    private TopicResponseDto topic;
    private Integer students;
}
