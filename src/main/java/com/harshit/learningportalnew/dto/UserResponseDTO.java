package com.harshit.learningportalnew.dto;

import com.harshit.learningportalnew.entity.UserEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDTO {
	private String username;
	private UserEntity.Role role;
}
