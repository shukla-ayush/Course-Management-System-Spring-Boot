package com.example.nativemyapp.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.nativemyapp.models.Exam;
import com.example.nativemyapp.models.TrueFalseQuestion;
import com.example.nativemyapp.repositories.ExamRepository;
import com.example.nativemyapp.repositories.TrueFalseQuestionRepository;

@RestController
@CrossOrigin(origins = "*")
public class TrueFalseQuestionService {

	@Autowired
	ExamRepository examRepository;
	
	@Autowired
	TrueFalseQuestionRepository trueFalseRepository;
	
	@GetMapping("/api/truefalse/{questionId}")
	public TrueFalseQuestion findTrueFalseQuestionById(
			@PathVariable("questionId") int questionId) {
		
		Optional<TrueFalseQuestion> optional = trueFalseRepository.findById(questionId);
		
		if(optional.isPresent()) {
			return optional.get();
		}
		
		return null;
	}
	
	
	@PostMapping("/api/exam/{examId}/truefalse")
	public void saveTrueFalseForExam(
			@RequestBody TrueFalseQuestion tf,
			@PathVariable("examId") int examId) {
		
		Optional<Exam> data = examRepository.findById(examId);
		
		if(data.isPresent()) {
			Exam exam = data.get();
			tf.setExam(exam);
			trueFalseRepository.save(tf);
		}
	}
	
	
	@PutMapping("/api/truefalse/{questionId}")
	public TrueFalseQuestion updateTrueFalse(
			@PathVariable("questionId") int questionId, 
			@RequestBody TrueFalseQuestion tfQuestion) {
		
		Optional<TrueFalseQuestion> data = trueFalseRepository.findById(questionId);
		
		if(data.isPresent()) {
			TrueFalseQuestion newTFQuestion = data.get();
			newTFQuestion.setTitle(tfQuestion.getTitle());
			newTFQuestion.setDescription(tfQuestion.getDescription());
			newTFQuestion.setPoints(tfQuestion.getPoints());
			newTFQuestion.setTrue(tfQuestion.isTrue());
			return trueFalseRepository.save(newTFQuestion);
		}
		
		return null;
	}
	
	
	@DeleteMapping("/api/truefalse/{questionId}")
	public void deleteTrueFalse(@PathVariable("questionId") int id) {
		trueFalseRepository.deleteById(id);
	}
	
}
