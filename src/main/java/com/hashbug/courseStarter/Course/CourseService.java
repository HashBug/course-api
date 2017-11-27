package com.hashbug.courseStarter.Course;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

	@Autowired
	private CourseRepository courseRepository;
	
	public List<Course> findAllCourses(String topicId) {
		return (List<Course>) courseRepository.findByTopicId(topicId);
	}

	public Course find(String id) {
		return courseRepository.findOne(id);
	}

	public void save(Course course) {
		courseRepository.save(course);
	}

	public void update(Course course) {
		courseRepository.save(course);
	}

	public void deleteCourse(String id) {
		courseRepository.delete(id);
	}

}
