package com.rapidtech.springproject.controller;

import com.rapidtech.springproject.dto.CourseReqDto;
import com.rapidtech.springproject.dto.CourseResDto;
import com.rapidtech.springproject.dto.EnrollmentReqDto;
import com.rapidtech.springproject.dto.EnrollmentResDto;
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
    public List<EnrollmentResDto> getAllEnrollments(){
        return enrollmentService.getAllEnrollments();
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
