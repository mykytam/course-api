package com.mykytam.courseapi.services;

import com.mykytam.courseapi.dto.StudentCreateDto;
import com.mykytam.courseapi.models.Course;
import com.mykytam.courseapi.models.Student;
import com.mykytam.courseapi.repositories.CourseRepository;
import com.mykytam.courseapi.repositories.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private final ConversionService conversionService;
    private final CourseRepository courseRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudent(Integer id) {
        return studentRepository.findById(id).orElseThrow();
    }

    public void addStudent(StudentCreateDto studentDto) {
        Course course = courseRepository.findById(studentDto.getCourseId()).orElseThrow();
        Student student = conversionService.convert(studentDto, Student.class);
        student.addCourse(course);
        studentRepository.save(student);
    }

    public void updateStudent(Student student) {
        studentRepository.save(student);
    }

    public void deleteStudent(Integer id) {
        studentRepository.deleteById(id);
    }

}
