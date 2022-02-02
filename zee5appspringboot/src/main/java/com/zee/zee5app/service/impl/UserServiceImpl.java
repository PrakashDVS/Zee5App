package com.zee.zee5app.service.impl;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zee.zee5app.dto.Register;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidEmailException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.InvalidNameException;
import com.zee.zee5app.exception.InvalidPasswordException;
import com.zee.zee5app.repository.UserRepository;
//import com.zee.zee5app.repository.impl.UserRepositoryImpl;
import com.zee.zee5app.service.UserService;

import java.util.List;
import java.util.Optional;
@Service
public class UserServiceImpl implements UserService {
	
	public UserServiceImpl()  throws IOException {
		// TODO Auto-generated constructor stub
	}
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
    @Autowired
	private  UserRepository userRepository;
	@Override
	public String addUser(Register register) {
		Register register2 = userRepository.save(register);
		// TODO Auto-generated method stub
		if(register2 != null) {
			return "success";
		}
		else {
			return "fail";
		}
//		return userRepository.addUser(register2);
	}

	@Override
	public String updateUser(String id, Register register) throws IdNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Register> getUserById(String id) throws IdNotFoundException, InvalidIdLengthException, InvalidNameException, InvalidEmailException, InvalidPasswordException {
		// TODO Auto-generated method stub
		return userRepository.findById(id);
	}

	@Override
	public Register[] getAllUsers() throws InvalidEmailException, InvalidIdLengthException, InvalidNameException, InvalidPasswordException {
		// TODO Auto-generated method stub
		
		List<Register> list = userRepository.findAll();
		Register[] array = new Register[list.size()];
				return list.toArray(array);
	}

	@Override
	public String deleteUserById(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		try {
			Optional<Register> optional = this.getUserById(id);
			if(optional.isEmpty()) {
				throw new IdNotFoundException("record not found");
			}
			else {
				userRepository.deleteById(id);
				return "success";
			}
		}catch(InvalidNameException | IdNotFoundException | InvalidIdLengthException |InvalidEmailException | InvalidPasswordException e) {
			e.printStackTrace();
			throw new IdNotFoundException(e.getLocalizedMessage());
		}
		
	}

	@Override
	public Optional<List<Register>> getAllUserDetails() throws InvalidEmailException, InvalidPasswordException, InvalidIdLengthException, InvalidNameException {
		// TODO Auto-generated method stub
		return Optional.ofNullable(userRepository.findAll());
	}
	
}