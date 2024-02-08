package com.harshit.learningportalnew.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.harshit.learningportalnew.dto.CourseDTO;
import com.harshit.learningportalnew.entity.CourseEntity;

@Mapper
public interface CoursePopulator {
	CoursePopulator INSTANCE = Mappers.getMapper(CoursePopulator.class);

	CourseEntity populateCourse(CourseDTO courseDTO);

	CourseDTO courseEntityToDTO(CourseEntity course);
}
