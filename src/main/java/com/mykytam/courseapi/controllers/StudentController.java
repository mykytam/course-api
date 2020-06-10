package com.mykytam.courseapi.controllers;

import com.mykytam.courseapi.dto.StudentCreateDto;
import com.mykytam.courseapi.dto.StudentResponseDto;
import com.mykytam.courseapi.models.Student;
import com.mykytam.courseapi.services.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("students")
@RestController
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<StudentResponseDto> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("{id}")
    public StudentResponseDto getStudent(@PathVariable Integer id) {
        return studentService.getStudent(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addStudent(@RequestBody @Valid StudentCreateDto student) {
        studentService.addStudent(student);
    }

    @PutMapping("{id}")
    public void updateStudent(@RequestBody Student student) {
        studentService.updateStudent(student);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteStudent(@PathVariable Integer id) {
        studentService.deleteStudent(id);
    }


}
