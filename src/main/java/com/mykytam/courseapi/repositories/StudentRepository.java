package com.mykytam.courseapi.repositories;

import com.mykytam.courseapi.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
