package com.rapidtech.springproject.service;

import com.rapidtech.springproject.dto.EnrollmentDto;
import com.rapidtech.springproject.dto.EnrollmentReqDto;
import com.rapidtech.springproject.dto.EnrollmentResDto;

public interface EnrollmentService {
    //void registerStudentToCourse(EnrollmentDto enrollmentDto);
    EnrollmentResDto insertEnrollment(EnrollmentReqDto enrollmentReqDto);
}
