package com.example.nativemyapp.models.exam.perclass;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServicePerClass {
	@Autowired
	BaseQuestionRepositoryPerClass baseRepo;
	@Autowired
	FillInTheBlankQuestionRepositoryPerClass fillRepo;
	@Autowired
	TrueOrFalseQuestionRepositoryPerClass trueRepo;
	
	@GetMapping("/api/inheritance/perclass/base")
	public BaseQuestionPerClass createBaseQuestion() {
		BaseQuestionPerClass q = new BaseQuestionPerClass();
		q.setDescription("descriptions 123");
		q.setInstructions("instructions 123");
		q.setPoints(123);
		q.setTitle("title 123");
		return baseRepo.save(q);
	}
	@GetMapping("/api/inheritance/perclass/fill")
	public FillInTheBlankQuestionPerClass createFillQuestion() {
		FillInTheBlankQuestionPerClass q = new FillInTheBlankQuestionPerClass();
		q.setDescription("descriptions 234");
		q.setInstructions("instructions 234");
		q.setPoints(234);
		q.setTitle("title 234");
		q.setVariables("variables 234");
		return fillRepo.save(q);
	}
	@GetMapping("/api/inheritance/perclass/true")
	public TrueOrFalseQuestionPerClass createTrueQuestion() {
		TrueOrFalseQuestionPerClass q = new TrueOrFalseQuestionPerClass();
		q.setDescription("descriptions 345");
		q.setInstructions("instructions 345");
		q.setPoints(345);
		q.setTitle("title 345");
		q.setIsTrue(true);
		return trueRepo.save(q);
	}
}
