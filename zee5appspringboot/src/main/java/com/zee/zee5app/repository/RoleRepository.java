package com.zee.zee5app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zee.zee5app.dto.ERole;
import com.zee.zee5app.dto.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role,Integer> {
//   Role findById(int roleId);
	Optional<Role> findByRoleName(ERole roleName);
}
