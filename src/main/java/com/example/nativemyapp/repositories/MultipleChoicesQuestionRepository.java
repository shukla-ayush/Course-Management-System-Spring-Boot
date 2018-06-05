package com.example.nativemyapp.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.nativemyapp.models.MultipleChoiceQuestion;


public interface MultipleChoicesQuestionRepository extends CrudRepository<MultipleChoiceQuestion, Integer> {
	
}
