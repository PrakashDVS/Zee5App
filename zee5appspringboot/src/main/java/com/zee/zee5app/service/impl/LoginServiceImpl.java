package com.zee.zee5app.service.impl;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zee.zee5app.dto.ERole;
import com.zee.zee5app.dto.Login;
import com.zee.zee5app.dto.Role;
import com.zee.zee5app.dto.User;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidEmailException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.InvalidNameException;
import com.zee.zee5app.exception.InvalidPasswordException;
import com.zee.zee5app.repository.LoginRepository;
import com.zee.zee5app.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {
	@Autowired
	private  LoginRepository LoginRepository;

	@Override
	public String addCredentials(Login login) {
		// TODO Auto-generated method stub
		Login login2 = LoginRepository.save(login);
		if(login2 != null) {
			return "success";
		}else {
			return "fail";
		}
	}

	@Override
	public String deleteCredentials(String userName) {
		// TODO Auto-generated method stub
		try {
			Optional<Login> optional = LoginRepository.findById(userName);
			if (optional.isEmpty()) {
				throw new IdNotFoundException("id not found!");
			} else {
				LoginRepository.deleteById(userName);
				return "success";
			}
		} catch (IdNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
//			throw new IdNotFoundException(e.getMessage());
			return "fail";
		}
	}

	@Override
	public String changePassword(String userName, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String changeRole(String userName, ERole role) {
		// TODO Auto-generated method stub
		return null;
	}


}
