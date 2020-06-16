package com.mykytam.courseapi.converters;

import com.mykytam.courseapi.dto.CourseResponseDto;
import com.mykytam.courseapi.models.Course;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CourseToResponseDtoConverter implements Converter<Course, CourseResponseDto> {

    private final TopicToResponseDtoConverter topicToResponseDtoConverter;

    @Override
    public CourseResponseDto convert(Course source) {
        return CourseResponseDto.builder()
                .id(source.getId())
                .name(source.getName())
                .description(source.getDescription())
                .topic(topicToResponseDtoConverter.convert(source.getTopic()))
                .students(source.getStudents().size())
                .build();

    }
}
