package service.impl;

import java.io.IOException;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

import dto.Register;
import exception.IdNotFoundException;
import exception.InvalidEmailException;
import exception.InvalidIdLengthException;
import exception.InvalidNameException;
import exception.InvalidPasswordException;
import repository.UserRepository;
import repository.impl.UserRepositoryImpl;
import service.UserService;
@Service
public class UserServiceImpl implements UserService {
	
//	private UserServiceImpl()  throws IOException {
//		// TODO Auto-generated constructor stub
//	}
//	
//	private static UserService service;
//	
//	
//	public static UserService getInstance() throws IOException {
//		
//		if(service==null) {
//			service = new UserServiceImpl();
//		}
//		
//		return service;
//	}
	
	//UserRepository userRepository ;

	private static UserRepository userRepository;
	@Override
	public String addUser(Register register) {
		// TODO Auto-generated method stub
		return userRepository.addUser(register);
	}

	@Override
	public String updateUser(String id, Register register) throws IdNotFoundException {
		// TODO Auto-generated method stub
		return userRepository.updateUser(id, register);
	}

	@Override
	public Optional<Register> getUserById(String id) throws IdNotFoundException, InvalidIdLengthException, InvalidNameException, InvalidEmailException, InvalidPasswordException {
		// TODO Auto-generated method stub
		return userRepository.getUserById(id);
	}

	@Override
	public Register[] getAllUsers() throws InvalidEmailException, InvalidIdLengthException, InvalidNameException, InvalidPasswordException {
		// TODO Auto-generated method stub
		return userRepository.getAllUsers();
	}

	@Override
	public String deleteUserById(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		return userRepository.deleteUserById(id);
	}

	@Override
	public Optional<List<Register>> getAllUserDetails() throws InvalidEmailException, InvalidPasswordException, InvalidIdLengthException, InvalidNameException {
		// TODO Auto-generated method stub
		return userRepository.getAllUserDetails();
	}
	
}