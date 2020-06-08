package com.mykytam.courseapi.controllers;

import com.mykytam.courseapi.dto.CourseCreateDto;
import com.mykytam.courseapi.models.Course;
import com.mykytam.courseapi.models.Topic;
import com.mykytam.courseapi.services.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/topics/{topicId}/courses")
@RestController
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public List<Course> getAllCourses(@PathVariable String topicId) {
        return courseService.getAllCourses(topicId);
    }

    @GetMapping("{id}")
    public Course getCourse(@PathVariable String id) {
        return courseService.getCourse(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addCourse(@RequestBody CourseCreateDto course, @PathVariable String topicId) {
        course.setTopic(new Topic(topicId, "", ""));
        courseService.addCourse(course);
    }

    @PutMapping("{id}")
    public void updateCourse(@RequestBody Course course, @PathVariable String topicId, @PathVariable String id) {
        course.setTopic(new Topic(topicId, "", ""));
        courseService.updateCourse(course);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCourse(@PathVariable String id) {
        courseService.deleteCourse(id);
    }
}
