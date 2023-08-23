package com.bitnine.assessment.tsietsimaboa.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.bitnine.assessment.tsietsimaboa.controller.dto.UserRegistrationDto;
import com.bitnine.assessment.tsietsimaboa.model.User;

public interface UserService extends UserDetailsService {

	User saveUser(UserRegistrationDto registration_dto);
}
