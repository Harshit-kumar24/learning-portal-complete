package com.harshit.learningportalnew.mapper;

import org.mapstruct.factory.Mappers;

import com.harshit.learningportalnew.dto.RegisteredCourseDTO;
import com.harshit.learningportalnew.entity.RegisteredCourseEntity;

public interface RegisteredCoursePopulator {
	RegisteredCoursePopulator INSTANCE = Mappers.getMapper(RegisteredCoursePopulator.class);

	RegisteredCourseEntity populateRegisteredCourse(RegisteredCourseDTO regCourseDTO);

	RegisteredCourseDTO regCourseEntitytoDTO(RegisteredCourseEntity regCourse);
}
