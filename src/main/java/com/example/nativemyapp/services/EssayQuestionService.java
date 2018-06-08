package com.example.nativemyapp.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.nativemyapp.models.EssayQuestion;
import com.example.nativemyapp.models.Exam;
import com.example.nativemyapp.repositories.EssayQuestionRepository;
import com.example.nativemyapp.repositories.ExamRepository;

@RestController
@CrossOrigin(origins = "*")
public class EssayQuestionService {

	@Autowired
	ExamRepository examRepository;
	@Autowired
	EssayQuestionRepository essayRepository;
	
	
	@PostMapping("/api/exam/{examId}/essay")
	public void saveEssayForExam(@RequestBody
			EssayQuestion essayQuestion,
			@PathVariable("examId") int examId) {
		Optional<Exam> data = examRepository.findById(examId);
		if(data.isPresent()) {
			Exam exam = data.get();
			essayQuestion.setExam(exam);
			essayRepository.save(essayQuestion);
		}
	}
	
	
	@PutMapping("/api/essay/{questionId}")
	public EssayQuestion updateEssay(
			@PathVariable("questionId") int questionId, 
			@RequestBody EssayQuestion eQuestion) {
		
		Optional<EssayQuestion> data = essayRepository.findById(questionId);
		
		if(data.isPresent()) {
			EssayQuestion neweQuestion = data.get();
			neweQuestion.setTitle(eQuestion.getTitle());
			neweQuestion.setDescription(eQuestion.getDescription());
			neweQuestion.setPoints(eQuestion.getPoints());
			return essayRepository.save(neweQuestion);
		}
		
		return null;
	}

	
	@DeleteMapping("/api/essay/{questionId}")
	public void deleteEssay(@PathVariable("questionId") int id) {
		essayRepository.deleteById(id);
	}
	
}
