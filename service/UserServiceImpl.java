package com.registration.service;

import java.util.Arrays;

import org.springframework.stereotype.Service;
import com.registration.controller.dto.UserRegistrationDto;
import com.registration.model.Role;
import com.registration.model.User;
import com.registration.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	private UserRepository userRepository;
	
	
	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public User save(UserRegistrationDto registrationDto) {
		User user=new User(registrationDto.getFirstName(),registrationDto.getLastName(),registrationDto.getEmail(),registrationDto.getPassword(),Arrays.asList(new Role("ROLE_USER")));
		return userRepository.save(user);
	}

	
}

