package com.harshit.learningportalnew.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.harshit.learningportalnew.entity.CourseEntity;
import com.harshit.learningportalnew.entity.CourseEntity.Category;
import com.harshit.learningportalnew.entity.FavouriteCourseEntity;
import com.harshit.learningportalnew.entity.RegisteredCourseEntity;
import com.harshit.learningportalnew.entity.UserEntity;
import com.harshit.learningportalnew.repository.CourseRepository;
import com.harshit.learningportalnew.repository.FavouriteCourseRepository;
import com.harshit.learningportalnew.repository.RegisteredCourseRepository;
import com.harshit.learningportalnew.repository.UserRepository;
import com.harshit.learningportalnew.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;
	private final CourseRepository courseRepository;
	private final RegisteredCourseRepository registeredCourseRepository;
	private final FavouriteCourseRepository favouriteCourseRepository;

	public UserServiceImpl(UserRepository userRepository, RegisteredCourseRepository registeredCourseRepository,
			CourseRepository courseRepository, FavouriteCourseRepository favouriteCourseRepository) {
		this.userRepository = userRepository;
		this.registeredCourseRepository = registeredCourseRepository;
		this.courseRepository = courseRepository;
		this.favouriteCourseRepository = favouriteCourseRepository;
	}

	//get all users
	@Override
	public List<UserEntity> getAllUsers() {
		return userRepository.findAll();
	}

	//deleting an user
	@Override
	public void deleteUser(Long id) {
		userRepository.deleteById(id);

	}

	//adding and user by a admin
	@Override
	public UserEntity addUser(UserEntity user) {
		return userRepository.save(user);
	}

	//get courses by category
	@Override
	public List<CourseEntity> getCoursesByCategory(Category category) {
		return courseRepository.findByCategory(category);
	}

	//logging in an user
	@Override
	public Optional<UserEntity> loginUser(Long userId) {
		return userRepository.findById(userId);
	}

	//registering an user
	@Override
	public UserEntity registerUser(UserEntity user) {
		return userRepository.save(user);
	}

	//see all purchased courses
	@Override
	public List<RegisteredCourseEntity> purchasedCourses(Long userId) {
		return registeredCourseRepository.findByUserId(userId);
	}

	//purchasing a course 
	@Override
	public RegisteredCourseEntity purchaseCourse(Long courseId, Long userId) {

		Optional<CourseEntity> optionalCourse = courseRepository.findById(courseId);

		if (optionalCourse.isPresent()) {
			CourseEntity course = optionalCourse.get();

			Optional<UserEntity> optionalUser = userRepository.findById(userId);
			if (optionalUser.isPresent()) {
				UserEntity user = optionalUser.get();

				RegisteredCourseEntity registeredCourse = new RegisteredCourseEntity();
				registeredCourse.setCourse(course);
				registeredCourse.setUser(user);

				return registeredCourse;
			}
		}
		RegisteredCourseEntity nullRegisteredCourse = null;
		return nullRegisteredCourse;
	}

	@Override
	public FavouriteCourseEntity favouriteCourse(Long registrationId) {
		Optional<RegisteredCourseEntity> regCourse = registeredCourseRepository.findById(registrationId);

		if (regCourse.isPresent()) {
			RegisteredCourseEntity reigisteredCourse = regCourse.get();
			FavouriteCourseEntity favouriteCourse = new FavouriteCourseEntity();
			favouriteCourse.setRegisteredCourse(reigisteredCourse);

			return favouriteCourseRepository.save(favouriteCourse);
		}
		return null;
	}

	@Override
	public List<FavouriteCourseEntity> seeFavouriteCourses(Long userId) {
		List<RegisteredCourseEntity> registeredCourses = registeredCourseRepository.findByUserId(userId);

		// Extract IDs of registered courses
		List<Long> registeredCoursesIds = registeredCourses.stream().map(RegisteredCourseEntity::getRegistrationId)
				.collect(Collectors.toList());

		// Find favorite courses for the registered courses
		List<FavouriteCourseEntity> favouriteCourses = new ArrayList<>();
		for (Long id : registeredCoursesIds) {
			FavouriteCourseEntity favouriteCourse = (FavouriteCourseEntity) favouriteCourseRepository.findByRegId(id);
			favouriteCourses.add(favouriteCourse);
		}

		return favouriteCourses;

	}

}
