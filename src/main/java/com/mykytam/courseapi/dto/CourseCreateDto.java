package com.mykytam.courseapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseCreateDto {

    @NotBlank
    private String name;

    @NotBlank
    private String description;

    @NotNull
    @Min(1)
    private Integer topicId;

}
