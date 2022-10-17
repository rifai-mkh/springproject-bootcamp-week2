package com.rapidtech.springproject.repository;

import com.rapidtech.springproject.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course,Long> {
}
