package com.mykytam.courseapi.repositories;

import com.mykytam.courseapi.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Integer> {

}
