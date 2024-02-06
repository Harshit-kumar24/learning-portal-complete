package com.harshit.learningportalnew.service;

import java.util.List;

import com.harshit.learningportalnew.entity.CourseEntity;
import com.harshit.learningportalnew.entity.UserEntity;

public interface UserService {
	//ADMIN
	//get all users
	List<UserEntity> getAllUsers();

	//delete users
	void deleteUser(Long id);

	//add new users
	UserEntity addUser(UserEntity user);

	//LEARNER
	//get all courses
	List<CourseEntity> getAllCourses();

	//get all courses by category
	List<CourseEntity> getCoursesByCategory(CourseEntity.Category category);

	//login user
	UserEntity loginUser(String username, String password);

	//register user
	UserEntity registerUser(UserEntity user);

	//see purchased course
	List<CourseEntity> purchasedCourses(String username, String password);

	//purchase course
	CourseEntity purchaseCourse(Long courseId);

	//Favorite course
	CourseEntity favouriteCourse(Long registrationId);

	//see favorite courses
	List<CourseEntity> seeFavouriteCourses(String username, String password);

}
