package com.zee.zee5app.service.impl;

import java.io.IOException;

import org.springframework.stereotype.Service;

import com.zee.zee5app.dto.Login;
import com.zee.zee5app.dto.ROLE;
import com.zee.zee5app.repository.LoginRepository;
import com.zee.zee5app.repository.impl.LoginRepositoryImpl;
import com.zee.zee5app.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {
	
//	private static LoginService loginService;
	private static LoginRepository loginRepository = null;

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
		return loginRepository.addCredentials(login);
	}

	@Override
	public String deleteCredentials(String userName) {
		// TODO Auto-generated method stub
		return loginRepository.deleteCredentials(userName);
	}

	@Override
	public String changePassword(String userName, String password) {
		// TODO Auto-generated method stub
		return loginRepository.changePassword(userName, password);
	}

	@Override
	public String changeRole(String userName, ROLE role) {
		// TODO Auto-generated method stub
		return loginRepository.changeRole(userName, role);
	}

}
