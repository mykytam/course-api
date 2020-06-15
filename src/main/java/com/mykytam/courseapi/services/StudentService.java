package com.mykytam.courseapi.services;

import com.mykytam.courseapi.dto.StudentCreateDto;
import com.mykytam.courseapi.dto.StudentResponseDto;
import com.mykytam.courseapi.dto.StudentResponseIdDto;
import com.mykytam.courseapi.models.Course;
import com.mykytam.courseapi.models.Student;
import com.mykytam.courseapi.repositories.CourseRepository;
import com.mykytam.courseapi.repositories.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private final ConversionService conversionService;
    private final CourseRepository courseRepository;

    public List<StudentResponseDto> getAllStudents() {
        return studentRepository.findAll()
                .stream()
                .map(student -> conversionService.convert(student, StudentResponseDto.class))
                .collect(Collectors.toList());
    }

    public StudentResponseDto getStudent(Integer id) {
        Student student = studentRepository.findById(id).orElseThrow();
        return conversionService.convert(student, StudentResponseDto.class);
    }

    public StudentResponseIdDto addStudent(StudentCreateDto studentDto) {
        Course course = courseRepository.findById(studentDto.getCourseId()).orElseThrow();
        Student student = conversionService.convert(studentDto, Student.class);
        student.addCourse(course);
        studentRepository.save(student);

        return conversionService.convert(student, StudentResponseIdDto.class);
    }

    public StudentResponseIdDto updateStudent(StudentCreateDto student, Integer id) {
        Student old = studentRepository.findById(id).orElseThrow();
        old.setName(student.getName());
        old.setSurname(student.getSurname());
        studentRepository.save(old);

        return conversionService.convert(old, StudentResponseIdDto.class);
    }

    public void deleteStudent(Integer id) {
        Student toDelete = studentRepository.findById(id).orElseThrow();
        studentRepository.deleteInBatch(List.of(toDelete));
    }

}
