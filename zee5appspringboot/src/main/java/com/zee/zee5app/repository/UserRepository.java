package com.zee.zee5app.repository;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zee.zee5app.dto.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	Boolean existsByEmail(String email);
	Boolean existsByEmailAndContactNumber(String email,BigInteger contactNumber);
	Boolean existsByUsername(String username);
	Optional<User> findByUsername(String username);
}
