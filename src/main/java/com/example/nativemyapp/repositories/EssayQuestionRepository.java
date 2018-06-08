package com.example.nativemyapp.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.nativemyapp.models.EssayQuestion;

public interface EssayQuestionRepository
extends CrudRepository<EssayQuestion, Integer> {

}
