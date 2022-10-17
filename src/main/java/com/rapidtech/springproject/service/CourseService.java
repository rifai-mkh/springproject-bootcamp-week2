package com.rapidtech.springproject.service;

import com.rapidtech.springproject.dto.CourseReqDto;
import com.rapidtech.springproject.dto.CourseResDto;

import java.util.List;

public interface CourseService {
    List<CourseResDto> getAllCourse();
    CourseResDto insertStudent(CourseReqDto courseReqDto);
}
