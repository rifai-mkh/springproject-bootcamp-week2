package com.rapidtech.springproject.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentReqDto {
    private String firstmidname;
    private String lastname;
    private Date enrollmentdate;
}
