package com.harshit.learningportalnew.entity;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {

	public enum Role {
		ADMIN, AUTHOR, LEARNER
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_Id")
	private Long userId;

	@Column(name = "registration_Date_Time")
	private LocalDateTime registrationDateTime;

	@Column(name = "username")
	private Long username;

	@Column(name = "password")
	private Long password;

	@Column(name = "user_Role")
	private Role role;

	//adding one to many relation
	@OneToMany(mappedBy = "user")
	private Set<RegisteredCourseEntity> registeredCourses = new HashSet<>();

}
