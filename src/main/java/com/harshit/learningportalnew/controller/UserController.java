package com.harshit.learningportalnew.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.harshit.learningportalnew.entity.CourseEntity;
import com.harshit.learningportalnew.entity.CourseEntity.Category;
import com.harshit.learningportalnew.entity.FavouriteCourseEntity;
import com.harshit.learningportalnew.entity.RegisteredCourseEntity;
import com.harshit.learningportalnew.entity.UserEntity;
import com.harshit.learningportalnew.service.CourseService;
import com.harshit.learningportalnew.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	private final UserService userService;
	private final CourseService courseService;

	private static final Logger log = LoggerFactory.getLogger(CourseController.class);

	public UserController(UserService userService, CourseService courseService) {
		this.userService = userService;
		this.courseService = courseService;
	}

	//GET ALL USERS
	@GetMapping
	public List<UserEntity> getAllUser() {
		return userService.getAllUsers();
	}//WORKING

	//DELETE USERS
	@DeleteMapping("{id}")
	public void deleteUser(@PathVariable Long id) {
		userService.deleteUser(id);
	}//WORKING

	//GET ALL COURSES BY CATEGORY
	@GetMapping("/categories")
	public List<CourseEntity> getByCategory(@RequestHeader Category category) {
		return userService.getCoursesByCategory(category);
	}//WORKING

	//LOGIN USER
	@GetMapping("{id}")
	public Optional<UserEntity> loginUser(@PathVariable Long id) {
		return userService.loginUser(id);
	}//WORKING

	//REGISTER USER
	@PostMapping
	public UserEntity registerUser(@RequestBody UserEntity user) {
		return userService.registerUser(user);
	}//WORKING

	//PURCHASE COURSE
	@PostMapping("/purchase/{courseId}")
	public RegisteredCourseEntity purchaseCourse(@RequestHeader Long userId, @PathVariable Long courseId) {

		return userService.purchaseCourse(courseId, userId);

	}//WORKING																																																	//ADDING A FAVOURITE COURSE

	@PostMapping("/favourite/{registrationId}")
	public FavouriteCourseEntity addFavouriteCourse(@PathVariable Long registrationId) {
		return userService.favouriteCourse(registrationId);
	}

	//SEE FAVOURITE COURSE
	@GetMapping("/favourite/seeAll/{userId}")
	public List<FavouriteCourseEntity> seeAllFavourite(@PathVariable Long userId) {
		return userService.seeFavouriteCourses(userId);
	}

}
