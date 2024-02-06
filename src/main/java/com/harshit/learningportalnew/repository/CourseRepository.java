package com.harshit.learningportalnew.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.harshit.learningportalnew.entity.CourseEntity;

public interface CourseRepository extends JpaRepository<CourseEntity, Long> {

}
