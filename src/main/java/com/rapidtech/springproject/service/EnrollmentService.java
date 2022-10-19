package com.rapidtech.springproject.service;

import com.rapidtech.springproject.dto.EnrollmentDto;
import com.rapidtech.springproject.dto.EnrollmentReqDto;
import com.rapidtech.springproject.dto.EnrollmentResDto;

import java.util.List;

public interface EnrollmentService {
    List<EnrollmentDto> getAllEnrollments();
    EnrollmentDto getEnrollmentId (Long enrollmentid);
    EnrollmentResDto insertEnrollment(EnrollmentReqDto enrollmentReqDto);
    EnrollmentResDto updateEnrollment(Long enrollmentid, EnrollmentReqDto enrollmentReqDto);
    void deleteEnrollment(Long enrollmentid);
}
