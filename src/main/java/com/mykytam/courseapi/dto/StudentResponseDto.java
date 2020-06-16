package com.mykytam.courseapi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentResponseDto {

    private Integer id;
    private String name;
    private String surname;
    private List<String> courses;

}
