package com.harshit.learningportalnew.dto;

import java.time.LocalDateTime;

import com.harshit.learningportalnew.entity.UserEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

	private Long userId;
	private LocalDateTime registrationDateTime;
	private String username;
	private String password;
	private UserEntity.Role role;

}
