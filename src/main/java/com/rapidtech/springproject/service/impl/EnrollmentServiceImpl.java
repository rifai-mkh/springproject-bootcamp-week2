package com.rapidtech.springproject.service.impl;

import com.rapidtech.springproject.dto.*;
import com.rapidtech.springproject.model.Course;
import com.rapidtech.springproject.model.Enrollment;
import com.rapidtech.springproject.model.Student;
import com.rapidtech.springproject.repository.CourseRepository;
import com.rapidtech.springproject.repository.EnrollmentRepository;
import com.rapidtech.springproject.repository.StudentRepository;
import com.rapidtech.springproject.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EnrollmentServiceImpl implements EnrollmentService {
    @Autowired
    private EnrollmentRepository enrollmentRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<EnrollmentDto> getAllEnrollments() {
        List<EnrollmentDto> enrollmentDtos = new ArrayList<>();
        List<Enrollment> enrollmentList = enrollmentRepository.findAll();
        for (Enrollment enrollment : enrollmentList){
            enrollmentDtos.add(EnrollmentDto.builder()
                    .enrollmentid(enrollment.getEnrollmentid())
                    .studentResDto(StudentResDto.builder()
                            .id(enrollment.getStudent().getId())
                            .firstmidname(enrollment.getStudent().getFirstmidname())
                            .lastname(enrollment.getStudent().getLastname())
                            .enrollmentdate(enrollment.getStudent().getEnrollmentdate())
                            .build())
                    .courseResDto(CourseResDto.builder()
                            .courseid(enrollment.getCourse().getCourseid())
                            .title(enrollment.getCourse().getTitle())
                            .credits(enrollment.getCourse().getCredits())
                            .build())
                            .grade(enrollment.getGrade())
                    .build());
        }
        return enrollmentDtos;
    }
    @Override
    public EnrollmentDto getEnrollmentId(Long enrollmentid) {
        Enrollment enrollment = enrollmentRepository.findById(enrollmentid).get();
        return  EnrollmentDto.builder().enrollmentid(enrollment.getEnrollmentid())
                .studentResDto(StudentResDto.builder()
                        .id(enrollment.getStudent().getId())
                        .firstmidname(enrollment.getStudent().getFirstmidname())
                        .lastname(enrollment.getStudent().getLastname())
                        .enrollmentdate(enrollment.getStudent().getEnrollmentdate())
                        .build())
                .courseResDto(CourseResDto.builder()
                        .courseid(enrollment.getCourse().getCourseid())
                        .title(enrollment.getCourse().getTitle())
                        .credits(enrollment.getCourse().getCredits())
                        .build())
                .grade(enrollment.getGrade())
                .build();
    }

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

    @Override
    public EnrollmentResDto updateEnrollment(Long enrollmentid, EnrollmentReqDto enrollmentReqDto) {
        Optional<Enrollment> updateEnrollment = enrollmentRepository.findById(enrollmentid);
        Enrollment result = new Enrollment();
        if(updateEnrollment.isPresent()){
            Enrollment enrollment = updateEnrollment.get();
            enrollment.getStudent().setId(enrollmentReqDto.getStudentid());
            enrollment.getCourse().setCourseid(enrollmentReqDto.getCourseid());
            enrollment.setGrade(enrollmentReqDto.getGrade());
            result = enrollmentRepository.save(enrollment);
        }
        return EnrollmentResDto.builder().enrollmentid(result.getEnrollmentid())
                .studentid(result.getStudent().getId())
                .courseid(result.getCourse().getCourseid())
                .grade(result.getGrade())
                .build();
    }
    @Override
    public void deleteEnrollment(Long enrollmentid) {
        enrollmentRepository.deleteById(enrollmentid);
    }
}
