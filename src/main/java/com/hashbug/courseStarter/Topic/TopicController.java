package com.hashbug.courseStarter.Topic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {
	
		@Autowired
		private TopicService topicService;
		
		@RequestMapping("/topics")
		public List<Topic> showAll() {
			return topicService.getAll();
		}
		
		@RequestMapping("/topics/{id}")
		public Topic getTopic(@PathVariable String id) {
			return topicService.getTopic(id);
		}
		
		@RequestMapping(method=RequestMethod.POST,value="/topics")
		public void saveTopic(@RequestBody Topic topic) {
			topicService.addTopic(topic);
		}
		
		@RequestMapping(method=RequestMethod.PUT,value="/topics/{id}")
		public void update(@RequestBody Topic topic, @PathVariable String id) {
			topicService.updateTopic(topic);
		}
		
		@RequestMapping(method=RequestMethod.DELETE, value="/topics/{id}")
		public void deleteTopic(@PathVariable String id) {
			topicService.deleteTopic(id);
		}
}