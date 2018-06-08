package com.example.nativemyapp.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.nativemyapp.models.Exam;
import com.example.nativemyapp.models.Lesson;
import com.example.nativemyapp.models.Question;
import com.example.nativemyapp.models.Widget;
import com.example.nativemyapp.repositories.EssayQuestionRepository;
import com.example.nativemyapp.repositories.ExamRepository;
import com.example.nativemyapp.repositories.FillInTheBlankQuestionRepository;
import com.example.nativemyapp.repositories.LessonRepository;
import com.example.nativemyapp.repositories.MultipleChoicesQuestionRepository;
import com.example.nativemyapp.repositories.TrueFalseQuestionRepository;


@RestController
@CrossOrigin(origins = "*")
public class ExamService {
	@Autowired
	ExamRepository examRepository;
	@Autowired
	LessonRepository lessonRepository;
	@Autowired
	TrueFalseQuestionRepository trueFalseRepository;
	@Autowired
	EssayQuestionRepository essayRepository;
	@Autowired
	FillInTheBlankQuestionRepository fbRepository;
	@Autowired
	MultipleChoicesQuestionRepository multiRepo;
	
	@GetMapping("/api/exam/{examId}/question")
	public List<Question> findAllQuestionsForExam(@PathVariable("examId") int examId) {
		Optional<Exam> optionalExam = examRepository.findById(examId);
		if(optionalExam.isPresent()) {
			Exam exam = optionalExam.get();
			List<Question> questions = exam.getQuestions();
			int count = questions.size();
			return questions;
		}
		return null;
	}
	
	@GetMapping("/api/lesson/{lessonId}/exam")
	public Iterable<Exam> findAllAssignmentForLesson(@PathVariable("lessonId") int lessonId) {
		Optional<Lesson> data = lessonRepository.findById(lessonId);
		if(data.isPresent()) {
			Lesson lesson = data.get();
			List<Exam> examList = new ArrayList<Exam>(); 
			List<Widget> widgetList = lesson.getWidgets();
			for (Widget widget: widgetList) {
				if (widget.getWidgetType() == "Exam")
				{
					examList.add((Exam) widget);
				}
			}
			return examList;
		}
		return null;	
	}
	
	@DeleteMapping("/api/exam/{examId}")
	public void deleteExam(@PathVariable("examId") int examId) {
		examRepository.deleteById(examId);
	}
}