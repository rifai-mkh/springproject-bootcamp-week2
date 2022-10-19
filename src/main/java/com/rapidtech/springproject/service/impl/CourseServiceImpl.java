package com.rapidtech.springproject.service.impl;

import com.rapidtech.springproject.dto.CourseReqDto;
import com.rapidtech.springproject.dto.CourseResDto;
import com.rapidtech.springproject.model.Course;
import com.rapidtech.springproject.repository.CourseRepository;
import com.rapidtech.springproject.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseRepository courseRepository;

    @Override
    public List<CourseResDto> getAllCourse() {
        List<CourseResDto> courseResDtoList = new ArrayList<>();
        List<Course> courseList = courseRepository.findAll();
        for(Course course : courseList){
            courseResDtoList.add(CourseResDto.builder()
                    .courseid(course.getCourseid())
                    .title(course.getTitle())
                    .credits(course.getCredits())
                    .build());
        }
        return courseResDtoList;
    }

    @Override
    public CourseResDto getCourseById(Long courseid) {
        Course course = courseRepository.findById(courseid).get();
        return  CourseResDto.builder().courseid(course.getCourseid())
                .title(course.getTitle())
                .credits(course.getCredits())
                .build();
    }

    @Override
    public CourseResDto insertStudent(CourseReqDto courseReqDto) {
        Course newCourse = Course.builder()
                .title(courseReqDto.getTitle())
                .credits(courseReqDto.getCredits())
                .build();
        Course result = courseRepository.save(newCourse);
        return CourseResDto.builder()
                .courseid(result.getCourseid())
                .title(result.getTitle())
                .credits(result.getCredits())
                .build();
    }

    @Override
    public CourseResDto updateCourse(Long courseid, CourseReqDto courseReqDto) {
        Optional<Course> updateCourse = courseRepository.findById(courseid);
        Course result = new Course();
        if(updateCourse.isPresent()){
            Course course = updateCourse.get();
            course.setTitle(courseReqDto.getTitle());
            course.setCredits(courseReqDto.getCredits());
            result = courseRepository.save(course);
        }

        return CourseResDto.builder().courseid(result.getCourseid())
                .title(result.getTitle()).credits(result.getCredits()).build();
    }

    @Override
    public void deleteCourse(Long courseid) {
        courseRepository.deleteById(courseid);
    }

}
