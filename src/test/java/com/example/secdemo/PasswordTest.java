package com.example.secdemo;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordTest {
  @Test
  public void encryptPassword() {
	  PasswordEncoder pe = new BCryptPasswordEncoder();
	  String encodedpass = pe.encode("test123");
	  
  }
}
