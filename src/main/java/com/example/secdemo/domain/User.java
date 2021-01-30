package com.example.secdemo.domain;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
public class User implements  UserDetails {
	
 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;
  private String username;
  private String password;
  @OneToMany(fetch = FetchType.EAGER)
  private Set<Authority> authorities = new HashSet<>();
   
  
@Override
public Collection<? extends GrantedAuthority> getAuthorities() {
	return this.authorities;
}

public void setAuthorities(Set<Authority> authorities) {
	this.authorities = authorities;
}
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}

@Override
public boolean isAccountNonExpired() {
	return true;
}

@Override
public boolean isAccountNonLocked() {
	return true;
}

@Override
public boolean isCredentialsNonExpired() {
	return true;
}

@Override
public boolean isEnabled() {
	return true;
}

public User(String username, String password ) {
	super();
	this.username = username;
	this.password = password;
	
}

public User() {
}
  
}
