package com.learning.service;

import com.learning.entity.Login;
import com.learning.exception.IdNotFoundException;

public interface LoginService {
	public String addCredentials(Login login);

	public String deleteCredentials(String userName) throws IdNotFoundException;

	public String changePassword(String userName,String password);
}
