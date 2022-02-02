package com.zee.zee5app.service.impl;

import java.io.IOException;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.zee.zee5app.dto.Login;
import com.zee.zee5app.dto.ROLE;
import com.zee.zee5app.dto.Register;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidEmailException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.InvalidNameException;
import com.zee.zee5app.exception.InvalidPasswordException;
import com.zee.zee5app.repository.LoginRepository;
import com.zee.zee5app.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {
	
//	private static LoginService loginService;
	private  LoginRepository loginRepository;

//	private LoginServiceImpl() throws IOException {
//		loginRepository = LoginRepositoryImpl.getInstance();
//	}

//	public static LoginService getInstance() throws IOException {
//		if (loginService == null) {
//			loginService = new LoginServiceImpl();
//		}
//		return loginService;
//	}

	@Override
	public String addCredentials(Login login) {
		// TODO Auto-generated method stub
		Login login2 = loginRepository.save(login);
		// TODO Auto-generated method stub
		if(login2 != null) {
			return "success";
		}
		else {
			return "fail";
		}
	}

	@Override
	public String deleteCredentials(String userName) throws IdNotFoundException {
		// TODO Auto-generated method stub
		try {
			Optional<Login> optional = loginRepository.findById(userName);
			if(optional.isEmpty()) {
				throw new IdNotFoundException("record not found");
			}
			else {
				loginRepository.deleteById(userName);
				return "success";
			}
		}catch(IdNotFoundException e) {
			e.printStackTrace();
			throw new IdNotFoundException(e.getLocalizedMessage());
		}
	}

	@Override
	public String changePassword(String userName, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String changeRole(String userName, ROLE role) {
		// TODO Auto-generated method stub
		return null;
	}

}
