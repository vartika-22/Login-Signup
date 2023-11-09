package com.registration.service;

import com.registration.controller.dto.UserRegistrationDto;
import com.registration.model.User;

public interface UserService {

	User save(UserRegistrationDto registrationDto);
}
