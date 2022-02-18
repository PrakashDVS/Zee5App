package com.learning.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learning.entity.Login;


@Repository
public interface LoginRepository extends JpaRepository<Login, String> {
	Boolean existsByuserName(String userName);
}