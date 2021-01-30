package com.example.secdemo.security;

import java.util.HashSet;
import java.util.Set;
import javax.annotation.PostConstruct;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import com.example.secdemo.domain.Authority;
import com.example.secdemo.domain.User;
import com.example.secdemo.repository.AuthorityRepository;
import com.example.secdemo.repository.UserRepository;

@Component
public class LoadUserConfig {

	private UserRepository userRepository;
	private AuthorityRepository authorityRepository;
	private final PasswordEncoder passwordEncoder;
	
	public LoadUserConfig(UserRepository userRepository,  AuthorityRepository authorityRepository, PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
		this.authorityRepository = authorityRepository;
	}

	@PostConstruct
	public void loadUser() {
	
		User u1 = new User("Poonam", this.passwordEncoder.encode("123test"));
		this.userRepository.save(u1);
		
		Authority a1 = new Authority();
		Authority a2 = new Authority();
		a1.setAuthority("ROLE_USER");
		a2.setAuthority("ROLE_ADMIN");
		a1.setUser(u1);
		a2.setUser(u1);
		this.authorityRepository.save(a1);
		this.authorityRepository.save(a2);
		
		Set<Authority> au = new HashSet<>();
		au.add(a1);
		au.add(a2);
		
	    u1.setAuthorities(au);
		this.userRepository.save(u1);
	}
}
