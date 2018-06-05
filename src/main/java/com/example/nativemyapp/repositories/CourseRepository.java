package com.example.nativemyapp.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.nativemyapp.models.Course;

public interface CourseRepository extends CrudRepository<Course, Integer>{

}
