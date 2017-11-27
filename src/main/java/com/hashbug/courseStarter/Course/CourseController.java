package com.hashbug.courseStarter.Course;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hashbug.courseStarter.Topic.Topic;

@RestController
public class CourseController {

		@Autowired
		private CourseService courseService;
		
		@RequestMapping("/topics/{topicId}/courses")
		public List<Course> showAll(@PathVariable String topicId){
			return courseService.findAllCourses(topicId);
		}
		
		@RequestMapping("/topics/{topicId}/courses/{id}")
		public Course findCourse(@PathVariable String id) {
			return courseService.find(id);
		}
		
		@RequestMapping(method=RequestMethod.POST,value="/topics/{topicId}/courses")
		public void saveCourse(@RequestBody Course course,@PathVariable String topicId) {
			course.setTopic(new Topic(topicId,"",""));
			courseService.save(course);
		}
		
		@RequestMapping(method=RequestMethod.PUT,value="/topics/{topicId}/courses/{id}")
		public void updateCourse(@RequestBody Course course,@PathVariable String id) {
			courseService.update(course);
		}
		
		@RequestMapping(method=RequestMethod.DELETE,value="/topics/{topicId}/courses/{id}")
		public void deleteCourse(@PathVariable String id) {
			courseService.deleteCourse(id);
		}
}
