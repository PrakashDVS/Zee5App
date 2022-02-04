package com.zee.zee5app.service;

import java.util.List;
import java.util.Optional;

import com.zee.zee5app.dto.ERole;
import com.zee.zee5app.dto.Role;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.NameNotFoundException;

public interface RoleService {
	public String addRole(Role role); 
	public String deleteRole(int roleId) throws IdNotFoundException, NameNotFoundException;
	public String modifyRole(int roleId, Role role) throws IdNotFoundException, InvalidIdLengthException, NameNotFoundException;
	public Optional<Role> getRoleById(int roleId) throws IdNotFoundException, InvalidIdLengthException, NameNotFoundException;
	public Optional<List<Role>> getAllRoles() throws InvalidIdLengthException, NameNotFoundException;
}
