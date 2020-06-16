package com.mykytam.courseapi.converters;

import com.mykytam.courseapi.dto.CourseResponseIdDto;
import com.mykytam.courseapi.models.Course;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CourseToResponseIdDtoConverter implements Converter<Course, CourseResponseIdDto> {

    @Override
    public CourseResponseIdDto convert(Course course) {
        return CourseResponseIdDto.builder()
                .courseId(course.getId())
                .build();
    }
}
