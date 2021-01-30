package com.example.secdemo.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PassEncoderImpl extends BCryptPasswordEncoder { }
