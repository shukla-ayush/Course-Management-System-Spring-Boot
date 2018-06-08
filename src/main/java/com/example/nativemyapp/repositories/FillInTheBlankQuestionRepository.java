package com.example.nativemyapp.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.nativemyapp.models.FillInTheBlankQuestion;


public interface FillInTheBlankQuestionRepository extends CrudRepository<FillInTheBlankQuestion, Integer> {
	
}