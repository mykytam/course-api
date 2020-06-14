package com.mykytam.courseapi.controllers;

import com.mykytam.courseapi.dto.CourseResponseIdDto;
import com.mykytam.courseapi.services.EnrollmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("course/{courseId}/student/{studentId}")
@RestController
@RequiredArgsConstructor
public class EnrollmentController {

    private final EnrollmentService enrollmentService;

    @PatchMapping
    public CourseResponseIdDto addStudent(@PathVariable Integer courseId, @PathVariable Integer studentId) {
        return enrollmentService.addStudent(courseId, studentId);
    }
}
