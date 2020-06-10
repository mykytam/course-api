package com.mykytam.courseapi.services;

import com.mykytam.courseapi.dto.StudentCreateDto;
import com.mykytam.courseapi.models.Student;
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

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudent(Integer id) {
        return studentRepository.findById(id).orElse(null);
    }

    public void addStudent(StudentCreateDto studentDto) {

        if (studentRepository.existsById(studentDto.getId())) {
            throw new RuntimeException();
        }

        Student student = conversionService.convert(studentDto, Student.class);
        studentRepository.save(student);
    }

    public void updateStudent(Student student) {
        studentRepository.save(student);
    }

    public void deleteStudent(Integer id) {
        studentRepository.deleteById(id);
    }

}
