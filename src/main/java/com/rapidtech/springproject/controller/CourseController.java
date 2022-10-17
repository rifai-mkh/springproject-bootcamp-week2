package com.rapidtech.springproject.controller;

import com.rapidtech.springproject.dto.CourseReqDto;
import com.rapidtech.springproject.dto.CourseResDto;
import com.rapidtech.springproject.dto.StudentReqDto;
import com.rapidtech.springproject.dto.StudentResDto;
import com.rapidtech.springproject.service.CourseService;
import com.rapidtech.springproject.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/courses")
@RestController
public class CourseController {
    @Autowired
    private CourseService courseService;

    @GetMapping
    public List<CourseResDto> getAllCourse(){
        return courseService.getAllCourse();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CourseResDto insertCourse(@RequestBody CourseReqDto courseReqDto){
        return courseService.insertStudent(courseReqDto);
    }

    @PutMapping("/{courseid}")
    public CourseResDto updateStudent(@PathVariable("courseid") Long courseid,
                                       @RequestBody CourseReqDto courseReqDto){
        return courseService.updateCourse(courseid,courseReqDto);
    }
    @DeleteMapping("/{courseid}")
    public String deleteCourse(@PathVariable("courseid") Long courseid){
        courseService.deleteCourse(courseid);
        return "Delete course id: "+courseid.toString()+" berhasil.";
    }
}
