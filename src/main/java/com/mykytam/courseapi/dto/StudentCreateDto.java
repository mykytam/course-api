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
public class StudentCreateDto {

    @NotBlank
    private String name;

    @NotBlank
    private String surname;

    @NotNull
    @Min(1)
    private Integer courseId;
}
