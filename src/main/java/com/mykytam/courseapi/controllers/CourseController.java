package com.mykytam.courseapi.controllers;

import com.mykytam.courseapi.dto.CourseCreateDto;
import com.mykytam.courseapi.dto.CourseResponseDto;
import com.mykytam.courseapi.dto.CourseResponseIdDto;
import com.mykytam.courseapi.services.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("courses")
@RestController
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @GetMapping
    public List<CourseResponseDto> getAllCourses() {
        return courseService.getAllCourses();
    }

    @GetMapping("{id}")
    public CourseResponseDto getCourse(@PathVariable Integer id) {
        return courseService.getCourse(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CourseResponseIdDto addCourse(@RequestBody @Valid CourseCreateDto course) {
        return courseService.addCourse(course);
    }

    @PutMapping("{id}")
    public CourseResponseIdDto updateCourse(@RequestBody @Valid CourseCreateDto course, @PathVariable Integer id) {
        return courseService.updateCourse(course, id);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCourse(@PathVariable Integer id) {
        courseService.deleteCourse(id);
    }
}
