package com.mykytam.courseapi.services;

import com.mykytam.courseapi.dto.CourseCreateDto;
import com.mykytam.courseapi.models.Course;
import com.mykytam.courseapi.models.Topic;
import com.mykytam.courseapi.repositories.CourseRepository;
import com.mykytam.courseapi.repositories.TopicRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CourseService {

    private final CourseRepository courseRepository;
    private final ConversionService conversionService;
    private final TopicRepository topicRepository;

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Course getCourse(Integer id) {
        return courseRepository.findById(id).orElse(null);
    }

    public void addCourse(CourseCreateDto courseDto) {

        if (!topicRepository.existsById(courseDto.getTopicId())) {
            throw new RuntimeException();
        }

        Course course = conversionService.convert(courseDto, Course.class);
        course.setTopic(new Topic(courseDto.getTopicId()));
        courseRepository.save(course);
    }

    public void updateCourse(Course course) {
        courseRepository.save(course);
    }

    public void deleteCourse(Integer id) {
        courseRepository.deleteById(id);
    }
}
