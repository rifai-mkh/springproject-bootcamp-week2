package com.rapidtech.springproject.service.impl;

import com.rapidtech.springproject.dto.EnrollmentReqDto;
import com.rapidtech.springproject.dto.EnrollmentResDto;
import com.rapidtech.springproject.model.Course;
import com.rapidtech.springproject.model.Enrollment;
import com.rapidtech.springproject.model.Student;
import com.rapidtech.springproject.repository.CourseRepository;
import com.rapidtech.springproject.repository.EnrollmentRepository;
import com.rapidtech.springproject.repository.StudentRepository;
import com.rapidtech.springproject.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnrollmentServiceImpl implements EnrollmentService {
    @Autowired
    private EnrollmentRepository enrollmentRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private StudentRepository studentRepository;


    @Override
    public EnrollmentResDto insertEnrollment(EnrollmentReqDto enrollmentReqDto) {
        Enrollment newEnrollment = new Enrollment();
        newEnrollment.setGrade(enrollmentReqDto.getGrade());

        newEnrollment.setCourse(
                Course.builder().courseid(enrollmentReqDto.getCourseid()).build());

        newEnrollment.setStudent(
                Student.builder().id(enrollmentReqDto.getStudentid()).build());

        Enrollment result = enrollmentRepository.save(newEnrollment);
        return EnrollmentResDto.builder().enrollmentid(result.getEnrollmentid())
                .courseid(result.getCourse().getCourseid()).studentid(result.getStudent().getId())
                .grade(result.getGrade()).build();
    }
}
