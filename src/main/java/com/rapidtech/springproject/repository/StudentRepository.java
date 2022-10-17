package com.rapidtech.springproject.repository;

import com.rapidtech.springproject.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> {
}
