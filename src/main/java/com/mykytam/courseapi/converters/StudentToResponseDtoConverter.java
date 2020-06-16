package com.mykytam.courseapi.converters;

import com.mykytam.courseapi.dto.StudentResponseDto;
import com.mykytam.courseapi.models.Course;
import com.mykytam.courseapi.models.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class StudentToResponseDtoConverter implements Converter<Student, StudentResponseDto> {

    @Override
    public StudentResponseDto convert(Student source) {
        return StudentResponseDto.builder()
                .id(source.getId())
                .name(source.getName())
                .surname(source.getSurname())
                .courses(source.getCourses().stream().map(Course::getName).collect(Collectors.toList()))
                .build();
    }
}
