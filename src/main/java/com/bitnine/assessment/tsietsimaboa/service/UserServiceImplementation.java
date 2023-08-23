package com.bitnine.assessment.tsietsimaboa.service;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.bitnine.assessment.tsietsimaboa.controller.dto.UserRegistrationDto;
import com.bitnine.assessment.tsietsimaboa.model.Role;
import com.bitnine.assessment.tsietsimaboa.model.User;
import com.bitnine.assessment.tsietsimaboa.repository.UserRepository;

@Service
public class UserServiceImplementation implements UserService {

	@Autowired
	private UserRepository user_repository;
	
	@Autowired
	private BCryptPasswordEncoder password_encoder;
	
	public UserServiceImplementation() {
		
	}
	
	public UserServiceImplementation(UserRepository userRepository) {
		super();
		this.user_repository = userRepository;
	}
	
	@Override
	public User saveUser(UserRegistrationDto registration_dto) {
		User user = new User(registration_dto.getFirstname(), registration_dto.getLastname(), registration_dto.getTelephone(), registration_dto.getEmail(), registration_dto.getUsername(), password_encoder.encode(registration_dto.getPassword()), Arrays.asList(new Role("USER_ROLE")));
		
		return user_repository.save(user);
	}
	
	private static Collection<? extends GrantedAuthority> getAuthorities(User user) {
		String[] user_roles = user.getUsertypes().stream().map((role) -> role.getUsertype()).toArray(String[]::new);
		Collection<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList(user_roles);
		
		return authorities;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = user_repository.findByUsername(username);
		
		if (user == null) {
			throw new UsernameNotFoundException("Could not find user.");
		}
		
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getAuthorities(user));
	}
}
