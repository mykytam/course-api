package com.mykytam.courseapi.services;

import com.mykytam.courseapi.dto.CourseCreateDto;
import com.mykytam.courseapi.dto.CourseResponseDto;
import com.mykytam.courseapi.dto.CourseResponseIdDto;
import com.mykytam.courseapi.exceptions.EntityNotFoundException;
import com.mykytam.courseapi.models.Course;
import com.mykytam.courseapi.models.Topic;
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
        Course course = courseRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id));
        return conversionService.convert(course, CourseResponseDto.class);
    }

    public CourseResponseIdDto addCourse(CourseCreateDto courseDto) {
        Course course = conversionService.convert(courseDto, Course.class);

        Course saved = courseRepository.save(course);
        return conversionService.convert(saved, CourseResponseIdDto.class);
    }

    public CourseResponseIdDto updateCourse(CourseCreateDto courseDto, Integer id) {
        Course courseToUpdate = courseRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id));
        courseToUpdate.setName(courseDto.getName());
        courseToUpdate.setDescription(courseDto.getDescription());
        Topic topic = topicRepository.findById(courseDto.getTopicId()).orElseThrow(() -> new EntityNotFoundException(courseDto.getTopicId()));
        courseToUpdate.setTopic(topic);

        Course saved = courseRepository.save(courseToUpdate);
        return conversionService.convert(saved, CourseResponseIdDto.class);
    }

    public void deleteCourse(Integer id) {
        courseRepository.deleteById(id);
    }
}
