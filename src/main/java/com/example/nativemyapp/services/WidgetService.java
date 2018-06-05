package com.example.nativemyapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.nativemyapp.models.Lesson;
import com.example.nativemyapp.models.Widget;
import com.example.nativemyapp.repositories.LessonRepository;
import com.example.nativemyapp.repositories.WidgetRepository;



@RestController
@CrossOrigin(origins = "*")
public class WidgetService {
	@Autowired
	WidgetRepository repository;
	@Autowired
	LessonRepository lessonRepository;
	
	@GetMapping("/api/lesson/{lessonId}/widget")
	public List<Widget> findAllWidgetsForLesson(@PathVariable("lessonId") int lessonId) {
		Optional<Lesson> optionalLesson = lessonRepository.findById(lessonId);
		if(optionalLesson.isPresent()) {
			Lesson lesson = optionalLesson.get();
			return lesson.getWidgets();
		}
		return null;
	}
	
	@PostMapping("/api/widget/save")
	public void saveAllWidgets(@RequestBody
			List<Widget> widgets) {
		repository.deleteAll();
		for(Widget widget: widgets) {
			repository.save(widget);
		}
	}
	
	@GetMapping("/api/widget")
	public List<Widget> findAllWidgets() {
		return (List<Widget>) repository.findAll();
	}
}

//
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.example.nativemyapp.models.Topic;
//import com.example.nativemyapp.models.Widget;
//import com.example.nativemyapp.repositories.TopicRepository;
//import com.example.nativemyapp.repositories.WidgetRepository;
//
//import java.util.Optional;
//
//@RestController
//@CrossOrigin(origins = "*", maxAge=3600)
//public class WidgetService {
//
//	@Autowired
//	WidgetRepository repository;
//	
//	@Autowired
//	TopicRepository topicRepository;
//	
//	@GetMapping("/api/widget")
//	public List<Widget> findAllWidgets(){
//		return (List<Widget>) repository.findAll();
//	}
//	
//	
//	@PostMapping("/api/widget/save/{topicId}")
//	public void saveAllWidgets(@RequestBody List<Widget> widgets,
//								@PathVariable("topicId") int topicId) {
//		Optional<Topic> data = topicRepository.findById(topicId);
//		
//		if(data.isPresent()) {
//			Topic topic = data.get();
//			for(Widget widget: topic.getWidgets()) {
//				repository.delete(widget);
//			}
//			for(Widget widget: widgets) {
//				widget.setLesson(lesson);
//				repository.save(widget);
//			}
//		}
//	}
//	
//	@GetMapping("/api/widget/{topicId}")
//	public List<Widget> findAllWidgetsForTopic(@PathVariable("topicId") int topicId){
//		Optional<Topic> data = topicRepository.findById(topicId);
//		
//		if(data.isPresent()) {
//			Topic topic = data.get();
//			return topic.getWidgets();
//		}
//		return null;
//	}
//	
//	
//	
//}
