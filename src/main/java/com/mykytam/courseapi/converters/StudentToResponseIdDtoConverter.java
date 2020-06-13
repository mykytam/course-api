package com.mykytam.courseapi.converters;

import com.mykytam.courseapi.dto.StudentResponseIdDto;
import com.mykytam.courseapi.models.Student;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StudentToResponseIdDtoConverter implements Converter<Student, StudentResponseIdDto> {
    @Override
    public StudentResponseIdDto convert(Student student) {
        return StudentResponseIdDto.builder()
                .studentId(student.getId())
                .build();
    }
}
