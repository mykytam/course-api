package com.mykytam.courseapi.services;

import com.mykytam.courseapi.dto.CourseCreateDto;
import com.mykytam.courseapi.models.Course;
import com.mykytam.courseapi.repositories.CourseRepository;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    private final CourseRepository courseRepository;
    private final ConversionService conversionService;

    public CourseService(CourseRepository courseRepository, ConversionService conversionService) {
        this.courseRepository = courseRepository;
        this.conversionService = conversionService;
    }

    public List<Course> getAllCourses(String topicId) {
        return courseRepository.findByTopicId(topicId);
    }

    public Course getCourse(String id) {
        return courseRepository.findById(id).orElse(null);
    }

    public void addCourse(CourseCreateDto courseDto) {
        Course course = conversionService.convert(courseDto, Course.class);
        courseRepository.save(course);
    }

    public void updateCourse(Course course) {
        courseRepository.save(course);
    }

    public void deleteCourse(String id) {
        courseRepository.deleteById(id);
    }
}
