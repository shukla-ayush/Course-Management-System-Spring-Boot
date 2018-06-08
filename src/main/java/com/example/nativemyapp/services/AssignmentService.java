package com.example.nativemyapp.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.nativemyapp.models.Assignment;
import com.example.nativemyapp.models.Lesson;
import com.example.nativemyapp.models.Widget;
import com.example.nativemyapp.repositories.AssignmentRepository;
import com.example.nativemyapp.repositories.LessonRepository;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class AssignmentService {
	
	
	@Autowired
	AssignmentRepository assignmentRepository;
	
	
	@Autowired
	LessonRepository lessonRepository;
	
	
	@GetMapping("/api/assignment")
	public Iterable<Assignment> findAllAssignments() {
		return assignmentRepository.findAll(); 
	}

	
	@DeleteMapping("/api/assignment/{assignmentId}")
	public void deleteAssignment(
			@PathVariable("assignmentId") int id) {
		assignmentRepository.deleteById(id);
	}
	
	
	@GetMapping("/api/assignment/{assignmentId}")
	public Optional<Assignment> findAssignmentById(
			@PathVariable("assignmentId") int assignmentId) {
		return assignmentRepository.findById(assignmentId); 
	}

	
	@PutMapping("/api/assignment/{assignmentId}")
	public Assignment updateAssignment(
			@PathVariable("assignmentId") int assignmentId, 
			@RequestBody Assignment assignment) {
		
		Optional<Assignment> data = assignmentRepository.findById(assignmentId);
		
		if(data.isPresent()) {
			Assignment newAssignment = data.get();
			newAssignment.setDescription(assignment.getDescription());
			newAssignment.setPoints(assignment.getPoints());
			newAssignment.setTitle(assignment.getTitle());
			return assignmentRepository.save(newAssignment);
		}
		
		return null;
	}
	
	
	@GetMapping("/api/lesson/{lessonId}/assignment")
	public Iterable<Assignment> findAllAssignmentForLesson(
			@PathVariable("lessonId") int lessonId) {
		
		Optional<Lesson> data = lessonRepository.findById(lessonId);
		
		if(data.isPresent()) {
			Lesson lesson = data.get();
			List<Assignment> assignmentList = new ArrayList<Assignment>(); 
			List<Widget> widgetList = lesson.getWidgets();
			for (Widget widget: widgetList) {
				if (widget.getWidgetType() == "Assignment")
				{
					assignmentList.add((Assignment) widget);
				}
			}
			
			return assignmentList;
		}
		
		return null;	
	}
	
}
