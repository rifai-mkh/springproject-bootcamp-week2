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

@Service
public class EnrollmentServiceImpl implements EnrollmentService {
    @Autowired
    private EnrollmentRepository enrollmentRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private StudentRepository studentRepository;

    /* List<CourseResDto> courseResDtoList = new ArrayList<>();
        List<Course> courseList = courseRepository.findAll();
        for(Course course : courseList){
            courseResDtoList.add(CourseResDto.builder()
                    .courseid(course.getCourseid())
                    .title(course.getTitle())
                    .credits(course.getCredits())
                    .build());
        }
        return courseResDtoList;*/
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
}
