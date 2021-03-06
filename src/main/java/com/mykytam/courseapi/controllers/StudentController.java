package com.mykytam.courseapi.controllers;

import com.mykytam.courseapi.dto.StudentCreateDto;
import com.mykytam.courseapi.dto.StudentResponseDto;
import com.mykytam.courseapi.dto.StudentResponseIdDto;
import com.mykytam.courseapi.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("students")
@RestController
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

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
    public StudentResponseIdDto addStudent(@RequestBody @Valid StudentCreateDto student) {
        return studentService.addStudent(student);
    }

    @PutMapping("{id}")
    public StudentResponseIdDto updateStudent(@RequestBody @Valid StudentCreateDto student, @PathVariable Integer id) {
        return studentService.updateStudent(student, id);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteStudent(@PathVariable Integer id) {
        studentService.deleteStudent(id);
    }


}
