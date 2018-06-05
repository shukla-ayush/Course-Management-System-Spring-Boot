package com.example.nativemyapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.nativemyapp.models.Course;
import com.example.nativemyapp.models.Lesson;
import com.example.nativemyapp.models.Module;
import com.example.nativemyapp.repositories.CourseRepository;
import com.example.nativemyapp.repositories.LessonRepository;
import com.example.nativemyapp.repositories.ModuleRepository;


@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class LessonService {

	@Autowired
	CourseRepository courseRepository;
	
	@Autowired
	ModuleRepository moduleRepository;

	@Autowired
	LessonRepository lessonRepository;

	@GetMapping("/api/course/{courseId}/module/{moduleId}/lesson")
	public List<Lesson> findAllLessonsForModule(
			@PathVariable("courseId") int courseId,
			@PathVariable("moduleId") int moduleId) {
		Optional<Course> data = courseRepository.findById(courseId);
		if(data.isPresent()) {
			
			Optional<Module> data2 = moduleRepository.findById(moduleId);
			if(data2.isPresent()) {
				Module module = data2.get();
				return module.getLessons();
			}
			return null;
		}
		return null;		
	}
	
	@PostMapping("/api/course/{courseId}/module/{moduleId}/lesson")
	public Lesson createLesson(
			@PathVariable("courseId") int courseId,
			@PathVariable("moduleId") int moduleId,
			@RequestBody Lesson newLesson) {
		Optional<Course> data = courseRepository.findById(courseId);
		if(data.isPresent()) {
			
			Optional<Module> data2 = moduleRepository.findById(moduleId);
			if(data2.isPresent()) {
				Module module = data2.get();
				newLesson.setModule(module);
				return lessonRepository.save(newLesson);
			}
		}
		return null;		
	}
	
	@DeleteMapping("/api/lesson/{lessonId}")
	public void deleteLesson(
	  @PathVariable("lessonId")
	    int lessonId) {
		lessonRepository.deleteById(lessonId);
	}
	
	@GetMapping("/api/lesson")
	public List<Lesson> findAllLessons()
	{
		return (List<Lesson>) lessonRepository.findAll();
	}
	
}
