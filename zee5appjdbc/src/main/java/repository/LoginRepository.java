package repository;

import dto.Login;
import dto.ROLE;

public interface LoginRepository {
	
	public String addCredentials(Login login);

	public String deleteCredentials(String userName);

	public String changePassword(String userName,String password);

	public String changeRole(String userName,ROLE role);

}