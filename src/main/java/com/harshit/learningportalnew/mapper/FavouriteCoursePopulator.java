package com.harshit.learningportalnew.mapper;

import org.mapstruct.factory.Mappers;

import com.harshit.learningportalnew.dto.FavouriteCourseDTO;
import com.harshit.learningportalnew.entity.FavouriteCourseEntity;

public interface FavouriteCoursePopulator {
	FavouriteCoursePopulator INSTANCE = Mappers.getMapper(FavouriteCoursePopulator.class);

	FavouriteCourseEntity populateFavouriteCourse(FavouriteCourseDTO favouriteCourseDTO);

	FavouriteCourseDTO favCourseEntitytoDTO(FavouriteCourseEntity favCourse);
}
