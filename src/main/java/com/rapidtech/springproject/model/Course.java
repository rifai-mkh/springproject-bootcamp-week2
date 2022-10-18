package com.rapidtech.springproject.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.mapping.IdentifierCollection;
import org.hibernate.mapping.IndexedCollection;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseid;

    private String title;
    private int credits;

    @OneToMany(mappedBy = "course",fetch = FetchType.LAZY)
    private List<Enrollment> enrollments = new ArrayList<Enrollment>();
}
