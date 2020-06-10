package com.mykytam.courseapi.services;

import com.mykytam.courseapi.dto.CourseCreateDto;
import com.mykytam.courseapi.dto.CourseResponseDto;
import com.mykytam.courseapi.models.Course;
import com.mykytam.courseapi.repositories.CourseRepository;
import com.mykytam.courseapi.repositories.TopicRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;
    private final ConversionService conversionService;
    private final TopicRepository topicRepository;

    public List<CourseResponseDto> getAllCourses() {
        return courseRepository.findAll()
                .stream()
                .map(course -> conversionService.convert(course, CourseResponseDto.class))
                .collect(Collectors.toList());
    }

    public CourseResponseDto getCourse(Integer id) {
        Course course = courseRepository.findById(id).orElseThrow();
        return conversionService.convert(course, CourseResponseDto.class);
    }

    public void addCourse(CourseCreateDto courseDto) {
        if (!topicRepository.existsById(courseDto.getTopicId())) {
            throw new RuntimeException();
        }

        Course course = conversionService.convert(courseDto, Course.class);
        courseRepository.save(course);
    }

    public void updateCourse(Course course) {
        courseRepository.save(course);
    }

    public void deleteCourse(Integer id) {
        courseRepository.deleteById(id);
    }
}
