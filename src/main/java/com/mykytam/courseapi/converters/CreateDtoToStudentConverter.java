package com.mykytam.courseapi.converters;

import com.mykytam.courseapi.dto.StudentCreateDto;
import com.mykytam.courseapi.models.Student;
import com.mykytam.courseapi.repositories.CourseRepository;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Collections;


@Component
public class CreateDtoToStudentConverter implements Converter<StudentCreateDto, Student> {

    private final CourseRepository courseRepository;

    public CreateDtoToStudentConverter(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public Student convert(StudentCreateDto source) {
        return Student.builder()
                .id(source.getId())
                .name(source.getName())
                .surname(source.getSurname())
                .course(courseRepository.findAllById(Collections.singleton(source.getCourseId())))
                .build();
    }
}
