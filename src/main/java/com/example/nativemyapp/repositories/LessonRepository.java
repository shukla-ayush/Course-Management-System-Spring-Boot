package com.example.nativemyapp.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.nativemyapp.models.Lesson;

public interface LessonRepository extends CrudRepository<Lesson, Integer>{

}
