package com.example.myapp.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.myapp.models.Lesson;

public interface LessonRepository extends CrudRepository<Lesson, Integer>{

}
