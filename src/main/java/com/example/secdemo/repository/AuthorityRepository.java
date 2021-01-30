package com.example.secdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.secdemo.domain.Authority;

public interface  AuthorityRepository extends JpaRepository<Authority, Long> {

}
