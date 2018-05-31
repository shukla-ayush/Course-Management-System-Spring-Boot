package com.example.myapp.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.myapp.models.Topic;
import com.example.myapp.models.Widget;
import com.example.myapp.repositories.TopicRepository;
import com.example.myapp.repositories.WidgetRepository;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", maxAge=3600)
public class WidgetService {

	@Autowired
	WidgetRepository repository;
	
	@Autowired
	TopicRepository topicRepository;
	
	@GetMapping("/api/widget")
	public List<Widget> findAllWidgets(){
		return (List<Widget>) repository.findAll();
	}
	
	
	@PostMapping("/api/widget/save/{topicId}")
	public void saveAllWidgets(@RequestBody List<Widget> widgets,
								@PathVariable("topicId") int topicId) {
		Optional<Topic> data = topicRepository.findById(topicId);
		
		if(data.isPresent()) {
			Topic topic = data.get();
			for(Widget widget: topic.getWidgets()) {
				repository.delete(widget);
			}
			for(Widget widget: widgets) {
				widget.setTopic(topic);
				repository.save(widget);
			}
		}
	}
	
	@GetMapping("/api/widget/{topicId}")
	public List<Widget> findAllWidgetsForTopic(@PathVariable("topicId") int topicId){
		Optional<Topic> data = topicRepository.findById(topicId);
		
		if(data.isPresent()) {
			Topic topic = data.get();
			return topic.getWidgets();
		}
		return null;
	}
	
	
	
}
