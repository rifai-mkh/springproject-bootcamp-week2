package com.rapidtech.springproject.controller;

import com.rapidtech.springproject.dto.*;
import com.rapidtech.springproject.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/enrollments")
@RestController
public class EnrollmentController {
    @Autowired
    private EnrollmentService enrollmentService;

    @GetMapping
    public List<EnrollmentDto> getAllEnrollments(){
        return enrollmentService.getAllEnrollments();
    }

    @GetMapping("/{enrollmentid}")
    public EnrollmentDto getById(@PathVariable("enrollmentid") Long enrollmentid){
        return enrollmentService.getEnrollmentId(enrollmentid);
    }

    @PostMapping
    public EnrollmentResDto post(@RequestBody EnrollmentReqDto enrollmentReqDto) {
        return enrollmentService.insertEnrollment(enrollmentReqDto);
    }
    @PutMapping("/{enrollmentid}")
    public EnrollmentResDto updateEnrollment(@PathVariable("enrollmentid") Long enrollmentid,
                                     @RequestBody EnrollmentReqDto enrollmentReqDto){
        return enrollmentService.updateEnrollment(enrollmentid,enrollmentReqDto);
    }
    @DeleteMapping("/{enrollmentid}")
    public String deleteEnrollment(@PathVariable("enrollmentid") Long enrollmentid){
        enrollmentService.deleteEnrollment(enrollmentid);
        return "Delete enrollment id: "+enrollmentid.toString()+" berhasil.";
    }
}
