package com.rapidtech.springproject.controller;

import com.rapidtech.springproject.dto.StudentReqDto;
import com.rapidtech.springproject.dto.StudentResDto;
import com.rapidtech.springproject.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/students")
@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping
    public List<StudentResDto> getAllStudent(){
        return studentService.getAllStudent();
    }

    @GetMapping("/{id}")
    public StudentResDto getById(@PathVariable("id") Long id){
        return studentService.getStudentById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public StudentResDto insertStudent(@RequestBody StudentReqDto studentReqDto){
        return studentService.insertStudent(studentReqDto);
    }

    @PutMapping("/{id}")
    public StudentResDto updateStudent(@PathVariable("id") Long id,
                                       @RequestBody StudentReqDto studentReqDto){
        return studentService.updateStudent(id,studentReqDto);
    }

    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable("id") Long id){
        studentService.deleteStudent(id);
        return "Delete student id: "+id.toString()+" berhasil";
    }
}
