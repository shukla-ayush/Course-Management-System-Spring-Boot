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

import com.example.nativemyapp.models.Exam;
import com.example.nativemyapp.models.FillInTheBlankQuestion;
import com.example.nativemyapp.repositories.ExamRepository;
import com.example.nativemyapp.repositories.FillInTheBlankQuestionRepository;

@RestController
@CrossOrigin(origins = "*")
public class FillInTheBlankQuestionService {

	@Autowired
	ExamRepository examRepository;
	
	@Autowired
	FillInTheBlankQuestionRepository fbRepository;
	
	
	@PostMapping("/api/exam/{examId}/blanks")
	public void saveFillInTheBlankForExam(@RequestBody
			FillInTheBlankQuestion fbQuestion,
			@PathVariable("examId") int examId) {
		
		Optional<Exam> data = examRepository.findById(examId);
		
		if(data.isPresent()) {
			Exam exam = data.get();
			fbQuestion.setExam(exam);
			fbRepository.save(fbQuestion);
		}
	}

	
	@PutMapping("/api/blanks/{questionId}")
	public FillInTheBlankQuestion updateFillInTheBlank(
			@PathVariable("questionId") int questionId, 
			@RequestBody FillInTheBlankQuestion fbQuestion) {
		
		Optional<FillInTheBlankQuestion> data = fbRepository.findById(questionId);
		
		if(data.isPresent()) {
			FillInTheBlankQuestion newFBQuestion = data.get();
			newFBQuestion.setTitle(fbQuestion.getTitle());
			newFBQuestion.setDescription(fbQuestion.getDescription());
			newFBQuestion.setPoints(fbQuestion.getPoints());
			newFBQuestion.setVariables(fbQuestion.getVariables());
			newFBQuestion.setQuestionText(fbQuestion.getQuestionText());
			return fbRepository.save(newFBQuestion);
		}
		
		return null;
	}
	
	
	@DeleteMapping("/api/blanks/{questionId}")
	public void deleteFillInTheBlank(@PathVariable("questionId") int id) {
		fbRepository.deleteById(id);
	}
}
