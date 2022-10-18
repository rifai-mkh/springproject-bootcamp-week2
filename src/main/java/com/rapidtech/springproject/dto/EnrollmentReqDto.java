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

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EnrollmentReqDto {

    private Long courseid;
    private Long studentid;

    @Enumerated(EnumType.ORDINAL)
    private Grade grade;
}
