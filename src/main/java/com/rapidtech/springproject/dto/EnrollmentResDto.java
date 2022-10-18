package com.rapidtech.springproject.dto;

import com.rapidtech.springproject.model.Grade;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EnrollmentResDto {
    private Long enrollmentid;
    private Long studentid;
    private Long courseid;

    @Enumerated(EnumType.ORDINAL)
    private Grade grade;
}
