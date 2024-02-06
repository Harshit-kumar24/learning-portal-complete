package com.harshit.learningportalnew.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.harshit.learningportalnew.entity.RegisteredCourseEntity;

public interface FavouriteCourseRepository extends JpaRepository<FavouriteCourseRepository, Long> {
	@Query("SELECT f FROM FavouriteCourseEntity F WHERE f.registeredCourse.id IN:registeredCourseIds")
	List<RegisteredCourseEntity> findByRegId(Long userId);
}
