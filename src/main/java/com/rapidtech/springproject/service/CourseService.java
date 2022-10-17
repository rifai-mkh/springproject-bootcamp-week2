package com.rapidtech.springproject.service;

import com.rapidtech.springproject.dto.CourseReqDto;
import com.rapidtech.springproject.dto.CourseResDto;
import com.rapidtech.springproject.dto.StudentReqDto;
import com.rapidtech.springproject.dto.StudentResDto;

import java.util.List;

public interface CourseService {
    List<CourseResDto> getAllCourse();
    CourseResDto insertStudent(CourseReqDto courseReqDto);
    CourseResDto updateCourse(Long courseid, CourseReqDto courseReqDto);
}
