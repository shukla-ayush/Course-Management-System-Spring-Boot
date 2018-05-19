package com.example.myapp.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.myapp.models.Course;

public interface CourseRepository extends CrudRepository<Course, Integer>{

}
