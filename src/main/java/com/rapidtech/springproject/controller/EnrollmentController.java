package com.rapidtech.springproject.controller;

import com.rapidtech.springproject.dto.EnrollmentDto;
import com.rapidtech.springproject.dto.EnrollmentReqDto;
import com.rapidtech.springproject.dto.EnrollmentResDto;
import com.rapidtech.springproject.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/enrollments")
@RestController
public class EnrollmentController {
    @Autowired
    private EnrollmentService enrollmentService;

    @PostMapping
    public EnrollmentResDto post(@RequestBody EnrollmentReqDto enrollmentReqDto) {
        return enrollmentService.insertEnrollment(enrollmentReqDto);
    }
}
