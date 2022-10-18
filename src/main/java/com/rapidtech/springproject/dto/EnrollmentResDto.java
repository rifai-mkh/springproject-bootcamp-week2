package com.rapidtech.springproject.dto;

//import com.rapidtech.springproject.model.Grade;
import com.rapidtech.springproject.model.Grade;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table
public class EnrollmentResDto {
    private Long enrollmentid;
    private Long courseid;
    private Long studentid;

    @Enumerated(EnumType.ORDINAL)
    private Grade grade;
}
