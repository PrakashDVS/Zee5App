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
	public void deleteRole(int roleId);
}
