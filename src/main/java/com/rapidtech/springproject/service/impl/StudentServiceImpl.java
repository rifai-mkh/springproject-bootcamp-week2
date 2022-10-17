package com.rapidtech.springproject.service.impl;

import com.rapidtech.springproject.dto.StudentReqDto;
import com.rapidtech.springproject.dto.StudentResDto;
import com.rapidtech.springproject.model.Student;
import com.rapidtech.springproject.repository.StudentRepository;
import com.rapidtech.springproject.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<StudentResDto> getAllStudent() {
        List<Student> students = studentRepository.findAll();
        List<StudentResDto> studentResDtoList = new ArrayList<>();
        for(Student student : students){
            studentResDtoList.add(StudentResDto.builder()
                    .id(student.getId()).firstmidname(student.getFirstmidname())
                    .lastname(student.getLastname()).enrollmentdate(student.getEnrollmentdate())
                    .build());
        }
        return studentResDtoList;
    }

    @Override
    public StudentResDto getStudentById(Long id) {
        Student student = studentRepository.findById(id).get();
        return StudentResDto.builder().id(student.getId()).firstmidname(student.getFirstmidname())
                .lastname(student.getLastname()).enrollmentdate(student.getEnrollmentdate())
                .build();
    }

    @Override
    public StudentResDto insertStudent(StudentReqDto studentReqDto) {
        Student newStudent = Student.builder().firstmidname(studentReqDto.getFirstmidname())
                .lastname(studentReqDto.getLastname()).enrollmentdate(studentReqDto.getEnrollmentdate())
                .build();
        Student result = studentRepository.save(newStudent);
        return StudentResDto.builder().id(result.getId()).firstmidname(result.getFirstmidname())
                .lastname(result.getLastname()).enrollmentdate(result.getEnrollmentdate())
                .build();
    }
    @Override
    public StudentResDto updateStudent(Long id, StudentReqDto studentReqDto) {
        Optional<Student> updateStudent = studentRepository.findById(id);
        Student result = new Student();
        if(updateStudent.isPresent()){
            Student student = updateStudent.get();
            student.setFirstmidname(studentReqDto.getFirstmidname());
            student.setLastname(studentReqDto.getLastname());
            student.setEnrollmentdate(studentReqDto.getEnrollmentdate());
            result = studentRepository.save(student);
        }

        return StudentResDto.builder().id(result.getId())
                .firstmidname(result.getFirstmidname()).lastname(result.getLastname())
                .enrollmentdate(result.getEnrollmentdate()).build();
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}
