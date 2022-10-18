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
    public List<EnrollmentResDto> getAllEnrollments() {
        List<EnrollmentResDto> enrollmentResDtos = new ArrayList<>();
        List<Enrollment> enrollmentList = enrollmentRepository.findAll();
        for (Enrollment enrollment : enrollmentList){
            enrollmentResDtos.add(EnrollmentResDto.builder()
                    .enrollmentid(enrollment.getEnrollmentid())
                    .courseid(enrollment.getCourse().getCourseid())
                    .studentid(enrollment.getStudent().getId())
                    .grade(enrollment.getGrade()).build());
        }
        return enrollmentResDtos;
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

    /*Optional<Course> updateCourse = courseRepository.findById(courseid);
        Course result = new Course();
        if(updateCourse.isPresent()){
            Course course = updateCourse.get();
            course.setTitle(courseReqDto.getTitle());
            course.setCredits(courseReqDto.getCredits());
            result = courseRepository.save(course);
        }

        return CourseResDto.builder().courseid(result.getCourseid())
                .title(result.getTitle()).credits(result.getCredits()).build();
    */

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
                .build();
    }
}
