package com.rapidtech.springproject.service;

import com.rapidtech.springproject.dto.StudentReqDto;
import com.rapidtech.springproject.dto.StudentResDto;

import java.util.List;

public interface StudentService {
    List<StudentResDto> getAllStudent();
    StudentResDto getStudentById(Long id);
    StudentResDto insertStudent(StudentReqDto studentReqDto);
    StudentResDto updateStudent(Long id, StudentReqDto studentReqDto);
    void deleteStudent(Long id);
}
