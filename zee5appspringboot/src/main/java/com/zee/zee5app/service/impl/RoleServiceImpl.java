package com.zee.zee5app.service.impl;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zee.zee5app.dto.ERole;
import com.zee.zee5app.dto.Role;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.NameNotFoundException;
import com.zee.zee5app.repository.RoleRepository;
import com.zee.zee5app.service.RoleService;
@Service
public class RoleServiceImpl implements RoleService {
	@Autowired
	RoleRepository roleRepository ;
	
	
	@Override
	@Transactional(rollbackFor = Exception.class)
	public String addRole(Role role) {
		// TODO Auto-generated method stub
		Role role2 = roleRepository.save(role);
		if(role2 != null) {
			return "success";
		}else {
			return "fail";
		}
	}

	@Override
	public void deleteRole(int roleId) {
		// TODO Auto-generated method stub
		
	}

}