package com.fashionworld.major.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.fashionworld.major.model.CustomUserDetail;
import com.fashionworld.major.model.User;
import com.fashionworld.major.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	UserRepository userRepository;
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		// TOptional<T>-generated method stub
		Optional<User> user=userRepository.findUserByEmail(email);
		user.orElseThrow(()-> new UsernameNotFoundException("User not Found"));
		return user.map(CustomUserDetail::new).get();
		
	}

}
