package com.example.secdemo.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.secdemo.domain.User;
import com.example.secdemo.repository.UserRepository;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
    
	private final UserRepository userrepository;
	
	public UserDetailServiceImpl(UserRepository userrepository) {
		this.userrepository = userrepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	  User user = this.userrepository.findByUsername(username);
	  if (user ==null)
		  throw new UsernameNotFoundException("username or password is incorrect");
	  
	return user;
	}

}
