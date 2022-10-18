package com.rapidtech.springproject.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EnrollmentDto {
    private Long enrollmentid;
    private Long courseid;
    private Long studentid;
}
