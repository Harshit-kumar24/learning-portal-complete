package com.harshit.learningportalnew.mapper;

import org.mapstruct.factory.Mappers;

import com.harshit.learningportalnew.dto.UserDTO;
import com.harshit.learningportalnew.entity.UserEntity;

public interface UserPopulator {
	UserPopulator INSTANCE = Mappers.getMapper(UserPopulator.class);

	UserEntity populateUser(UserDTO userDTO);

	UserDTO userEntitytoDTO(UserEntity user);
}
