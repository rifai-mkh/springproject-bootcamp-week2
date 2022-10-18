package com.rapidtech.springproject.service;

import com.rapidtech.springproject.dto.EnrollmentReqDto;
import com.rapidtech.springproject.dto.EnrollmentResDto;

import java.util.List;

public interface EnrollmentService {
    List<EnrollmentResDto> getAllEnrollments();
    EnrollmentResDto insertEnrollment(EnrollmentReqDto enrollmentReqDto);
    EnrollmentResDto updateEnrollment(Long enrollmentid, EnrollmentReqDto enrollmentReqDto);
    void deleteEnrollment(Long enrollmentid);
}
