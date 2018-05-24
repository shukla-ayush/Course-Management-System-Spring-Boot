package com.example.myapp.services;

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

import com.example.myapp.models.Course;
import com.example.myapp.models.Lesson;
import com.example.myapp.models.Module;
import com.example.myapp.models.Topic;
import com.example.myapp.repositories.CourseRepository;
import com.example.myapp.repositories.LessonRepository;
import com.example.myapp.repositories.ModuleRepository;
import com.example.myapp.repositories.TopicRepository;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class TopicService {

	@Autowired
	CourseRepository courseRepository;
	
	@Autowired
	ModuleRepository moduleRepository;

	@Autowired
	LessonRepository lessonRepository;
	
	@Autowired
	TopicRepository topicRepository;

	@GetMapping("/api/course/{courseId}/module/{moduleId}/lesson/{lessonId}/topic")
	public List<Topic> findAllTopicsForLesson(
			@PathVariable("courseId") int courseId,
			@PathVariable("moduleId") int moduleId,
			@PathVariable("lessonId") int lessonId) {
		Optional<Course> data = courseRepository.findById(courseId);
		if(data.isPresent()) {
			
			Optional<Module> data2 = moduleRepository.findById(moduleId);
			if(data2.isPresent()) {
				
				Optional<Lesson> data3 = lessonRepository.findById(lessonId);
				if(data3.isPresent()) {
					Lesson lesson = data3.get();
					return lesson.getTopics();
				}
				return null;
			}
			return null;
		}
		return null;		
	}
	
	@PostMapping("/api/course/{courseId}/module/{moduleId}/lesson/{lessonId}/topic")
	public Topic createTopic(
			@PathVariable("courseId") int courseId,
			@PathVariable("moduleId") int moduleId,
			@PathVariable("lessonId") int lessonId,
			@RequestBody Topic newTopic) {
		Optional<Course> data = courseRepository.findById(courseId);
		if(data.isPresent()) {
			
			Optional<Module> data2 = moduleRepository.findById(moduleId);
			if(data2.isPresent()) {
				
				Optional<Lesson> data3 = lessonRepository.findById(lessonId);
				if(data3.isPresent()) {
					Lesson lesson = data3.get();
					newTopic.setLesson(lesson);
					return topicRepository.save(newTopic);
				}
				return null;
			}
			return null;
		}
		return null;		
	}
	
	@DeleteMapping("/api/topic/{topicId}")
	public void deleteTopic(
	  @PathVariable("topicId")
	    int topicId) {
		topicRepository.deleteById(topicId);
	}
	
	@GetMapping("/api/topic")
	public List<Topic> findAllLessons()
	{
		return (List<Topic>) topicRepository.findAll();
	}
	
}

