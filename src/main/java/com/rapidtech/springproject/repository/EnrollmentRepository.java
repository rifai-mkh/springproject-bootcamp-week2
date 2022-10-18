package com.rapidtech.springproject.repository;

import com.rapidtech.springproject.model.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnrollmentRepository extends JpaRepository<Enrollment,Long> {
}
