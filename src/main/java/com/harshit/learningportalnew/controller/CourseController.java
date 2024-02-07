package com.harshit.learningportalnew.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.harshit.learningportalnew.entity.CourseEntity;
import com.harshit.learningportalnew.service.CourseService;

@RestController
@RequestMapping("/courses")
public class CourseController {

	private final CourseService courseService;

	public CourseController(CourseService courseService) {
		this.courseService = courseService;
	}

	//GET COURSES
	@GetMapping
	public List<CourseEntity> getAllCourses() {
		return courseService.getAllCourses();
	}//WORKING

	//ADD COURSES
	@PostMapping
	public CourseEntity addCourse(@RequestBody CourseEntity course) {
		return courseService.addCourse(course);
	}//WORKING

	//DELETE COURSES
	@DeleteMapping("{id}")
	public void deleteCourse(@PathVariable Long id) {
		courseService.deleteCourse(id);
	}//WORKING

	//UPDATE COURSES
	@PutMapping
	public CourseEntity updateCourse(CourseEntity course) {
		return courseService.updateCourse(course);
	}//SAVING THE COURSE
}
