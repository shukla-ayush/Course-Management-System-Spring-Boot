package com.example.nativemyapp.models.exam.single;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceSingle {
	@Autowired
	BaseQuestionRepositorySingle baseRepo;
	@Autowired
	FillInTheBlankQuestionRepositorySingle fillRepo;
	@Autowired
	TrueOrFalseQuestionRepositorySingle trueRepo;
	
	@GetMapping("/api/inheritance/single/base")
	public BaseQuestionSingle createBaseQuestion() {
		BaseQuestionSingle q = new BaseQuestionSingle();
		q.setDescription("descriptions 123");
		q.setInstructions("instructions 123");
		q.setPoints(123);
		q.setTitle("title 123");
		return baseRepo.save(q);
	}
	@GetMapping("/api/inheritance/single/fill")
	public FillInTheBlankQuestionSingle createFillQuestion() {
		FillInTheBlankQuestionSingle q = new FillInTheBlankQuestionSingle();
		q.setDescription("descriptions 234");
		q.setInstructions("instructions 234");
		q.setPoints(234);
		q.setTitle("title 234");
		q.setVariables("variables 234");
		return fillRepo.save(q);
	}
	@GetMapping("/api/inheritance/single/true")
	public TrueOrFalseQuestionSingle createTrueQuestion() {
		TrueOrFalseQuestionSingle q = new TrueOrFalseQuestionSingle();
		q.setDescription("descriptions 345");
		q.setInstructions("instructions 345");
		q.setPoints(345);
		q.setTitle("title 345");
		q.setIsTrue(true);
		return trueRepo.save(q);
	}
}
