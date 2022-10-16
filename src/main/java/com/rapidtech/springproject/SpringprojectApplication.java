package com.rapidtech.springproject;

import com.rapidtech.springproject.model.Course;
import com.rapidtech.springproject.model.Enrollment;
import com.rapidtech.springproject.model.Grade;
import com.rapidtech.springproject.model.Student;
import org.apache.commons.logging.Log;
import org.hibernate.Hibernate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class SpringprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringprojectApplication.class, args);
	}

}
