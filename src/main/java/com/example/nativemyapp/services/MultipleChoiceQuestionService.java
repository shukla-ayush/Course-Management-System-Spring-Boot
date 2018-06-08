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
import com.example.nativemyapp.models.MultipleChoiceQuestion;
import com.example.nativemyapp.repositories.ExamRepository;
import com.example.nativemyapp.repositories.MultipleChoicesQuestionRepository;

@RestController
@CrossOrigin(origins = "*")
public class MultipleChoiceQuestionService {

	@Autowired
	ExamRepository examRepository;
	
	@Autowired
	MultipleChoicesQuestionRepository multiRepo;
	
	@GetMapping("/api/multi/{questionId}")
	public MultipleChoiceQuestion findMultiQuestionById(
			@PathVariable("questionId") int questionId) {
		
		Optional<MultipleChoiceQuestion> optional = multiRepo.findById(questionId);
		if(optional.isPresent()) {
			return optional.get();
		}
		
		return null;
	}
	
	@PostMapping("/api/exam/{examId}/choice")
	public void saveMultiChoiceForExam(
			@RequestBody MultipleChoiceQuestion multiQuestion,
			@PathVariable("examId") int examId) {
		
		Optional<Exam> data = examRepository.findById(examId);
		
		if(data.isPresent()) {
			Exam exam = data.get();
			multiQuestion.setExam(exam);
			multiRepo.save(multiQuestion);
		}
	}
	
	
	@PutMapping("/api/choice/{questionId}")
	public MultipleChoiceQuestion updateMultiChoice(
			@PathVariable("questionId") int questionId, 
			@RequestBody MultipleChoiceQuestion mcQuestion) {
		
		Optional<MultipleChoiceQuestion> data = multiRepo.findById(questionId);
		
		if(data.isPresent()) {
			MultipleChoiceQuestion newMultiQuestion = data.get();
			newMultiQuestion.setTitle(mcQuestion.getTitle());
			newMultiQuestion.setDescription(mcQuestion.getDescription());
			newMultiQuestion.setPoints(mcQuestion.getPoints());
			newMultiQuestion.setOptions(mcQuestion.getOptions());
			newMultiQuestion.setCorrectOption(mcQuestion.getCorrectOption());
			return multiRepo.save(newMultiQuestion);
		}
		
		return null;
	}
	
	
	@DeleteMapping("/api/choice/{questionId}")
	public void deleteMultiChoice(@PathVariable("questionId") int id) {
		multiRepo.deleteById(id);
	}
}
