package com.learning.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learning.entity.Register;



@Repository
public interface UserRepository extends JpaRepository<Register, Long> {
	Optional<Register> findByuserName(String userName);
	Boolean existsByuserName(String userName);
	
	Boolean existsByEmail(String email);
}
