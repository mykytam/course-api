package com.mykytam.courseapi.converters;

import com.mykytam.courseapi.dto.StudentCreateDto;
import com.mykytam.courseapi.models.Student;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;


@Component
public class CreateDtoToStudentConverter implements Converter<StudentCreateDto, Student> {

    @Override
    public Student convert(StudentCreateDto source) {
        return Student.builder()
                .id(source.getId())
                .name(source.getName())
                .surname(source.getSurname())
                .build();
    }
}
