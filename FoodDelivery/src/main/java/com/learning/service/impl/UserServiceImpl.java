package com.learning.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.entity.Login;
import com.learning.entity.Register;
import com.learning.exception.AlreadyExistsException;
import com.learning.exception.IdNotFoundException;
import com.learning.exception.InvalidPasswordException;
import com.learning.repository.LoginRepository;
import com.learning.repository.UserRepository;
import com.learning.service.LoginService;
import com.learning.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository repository;
	@Autowired
	private LoginService service;
	@Autowired
	private LoginRepository loginRepository;
	
	@Override
	@org.springframework.transaction.annotation.Transactional(rollbackFor = AlreadyExistsException.class)
	public Register addUser(Register register) throws AlreadyExistsException {
		// TODO Auto-generated method stub
		boolean status = repository.existsByEmailAndPassword(register.getEmail(), register.getPassword()) ;
		if(status) {
			throw new AlreadyExistsException("this record already exists");
		}
		Register register2 = repository.save(register);
		if (register2 != null) {
			Login login = new Login(register2.getEmail(), register2.getPassword());
			String result = service.addCredentials(login);
			if(result == "success") {
					//return "record added in register and login";
				return register2;
			}
			else {
				return null;
			}
		}	
		else {
			return null;
		}
	}

	
	@Override
	public Register getUserById(int id) throws IdNotFoundException, InvalidPasswordException {
		// TODO Auto-generated method stub
		Optional<Register> optional =  repository.findById(id);
		if(optional.isEmpty()) {
			throw new IdNotFoundException("id does not exists");
		}
		else {
			return optional.get();
		}
	}

	@Override
	public Register[] getAllUsers()
			throws  InvalidPasswordException {
		// TODO Auto-generated method stub
		List<Register> list = repository.findAll();
		Register[] array = new Register[list.size()];
		return list.toArray(array);	}

	@Override
	public String deleteUserById(int id) throws IdNotFoundException, InvalidPasswordException {
		// TODO Auto-generated method stub
		Register optional;
		try {
			optional = this.getUserById(id);
			if(optional==null) {
				throw new IdNotFoundException("record not found");
			}
			else {
				repository.deleteById(id);
				return "register record deleted";
			}
		} catch (IdNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new IdNotFoundException(e.getMessage());
		}
	}

	@Override
	public Optional<List<Register>> getAllUserDetails()
			throws InvalidPasswordException {
		// TODO Auto-generated method stub
		return Optional.ofNullable(repository.findAll());

	}

	


	@Override
	public String authenticate(String email, String password) {
		// TODO Auto-generated method stub
		boolean status = repository.existsByEmailAndPassword(email, password) ;
		if(status) {
			return "success";
		}
	
		return "fail"; 

	}

	@Override
	public Register updateUser(int id, Register register) throws IdNotFoundException {
		// TODO Auto-generated method stub
		if(!this.repository.existsById(id))
			throw new IdNotFoundException("invalid id");
		
		return repository.save(register);
	}

}
