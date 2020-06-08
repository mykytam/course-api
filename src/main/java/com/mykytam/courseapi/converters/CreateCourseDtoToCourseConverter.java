package com.mykytam.courseapi.converters;

import com.mykytam.courseapi.dto.CourseCreateDto;
import com.mykytam.courseapi.models.Course;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CreateCourseDtoToCourseConverter implements Converter<CourseCreateDto, Course> {

    @Override
    public Course convert(CourseCreateDto source) {
        return Course.builder()
                .id(source.getId())
                .name(source.getName())
                .description(source.getDescription())
                .topic(source.getTopic())
                .students(source.getStudent())
                .build();
    }
}
