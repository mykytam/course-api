package com.mykytam.courseapi.services;

import com.mykytam.courseapi.dto.CourseResponseIdDto;
import com.mykytam.courseapi.exceptions.CourseNotFoundException;
import com.mykytam.courseapi.exceptions.StudentNotFoundException;
import com.mykytam.courseapi.models.Course;
import com.mykytam.courseapi.repositories.CourseRepository;
import com.mykytam.courseapi.repositories.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EnrollmentService {

    private final CourseRepository courseRepository;
    private final StudentRepository studentRepository;
    private final ConversionService conversionService;

    public CourseResponseIdDto addStudent(Integer courseId, Integer studentId) {
        Course course = courseRepository.findById(courseId).orElseThrow(() -> new CourseNotFoundException("Course not found"));
        course.addStudent(studentRepository.findById(studentId).orElseThrow(() -> new StudentNotFoundException("Student not found")));
        courseRepository.save(course);

        return conversionService.convert(course, CourseResponseIdDto.class);
    }
}
