package com.harshit.learningportalnew.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.harshit.learningportalnew.entity.RegisteredCourseEntity;

public interface RegisteredCourseRepository extends JpaRepository<RegisteredCourseEntity, Long> {

}
