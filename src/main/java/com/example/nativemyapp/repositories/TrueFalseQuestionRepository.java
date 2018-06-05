package com.example.nativemyapp.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.nativemyapp.models.TrueFalseQuestion;

public interface TrueFalseQuestionRepository
extends CrudRepository<TrueFalseQuestion, Integer> {

}