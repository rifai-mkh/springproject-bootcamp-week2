package com.rapidtech.springproject.dto;

import com.rapidtech.springproject.model.Grade;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table
public class EnrollmentWithCourseDto {

    @Enumerated(EnumType.ORDINAL)
    private Grade grade;

    private CourseReqDto courseReqDto;
}
