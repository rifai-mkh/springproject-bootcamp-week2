package com.rapidtech.springproject.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.print.attribute.standard.DateTimeAtCreation;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String lastname;
    private String firstmidname;
    private Date enrollmentdate;

    @OneToMany(mappedBy = "student",fetch = FetchType.LAZY)
    private List<Enrollment> enrollments = new ArrayList<Enrollment>();
}
