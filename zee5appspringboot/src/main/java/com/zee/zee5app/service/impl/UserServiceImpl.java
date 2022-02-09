package com.zee.zee5app.service.impl;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zee.zee5app.dto.ERole;
import com.zee.zee5app.dto.Login;
import com.zee.zee5app.dto.Role;
import com.zee.zee5app.dto.Register;
import com.zee.zee5app.exception.AlreadyExistsException;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidEmailException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.InvalidNameException;
import com.zee.zee5app.exception.InvalidPasswordException;
import com.zee.zee5app.repository.LoginRepository;
import com.zee.zee5app.repository.UserRepository;
import com.zee.zee5app.service.LoginService;
//import com.zee.zee5app.repository.impl.UserRepositoryImpl;
import com.zee.zee5app.service.UserService;

import java.util.List;
import java.util.Optional;


	
	@Service
	public class UserServiceImpl implements UserService {
	   @Autowired
	   private UserRepository userRepository;
	   @Autowired
	   private LoginService service;
	   @Autowired
	   private LoginRepository loginRepository;
	   public UserServiceImpl() throws IOException{
			// TODO Auto-generated constructor stub
		}
		
		
		
		//UserRepository userRepository ;

		
		@Override
		@org.springframework.transaction.annotation.Transactional(rollbackFor = AlreadyExistsException.class)
		public Register addUser(Register register) throws AlreadyExistsException{
			// TODO Auto-generated method stub
			userRepository.findById(register.getId());
boolean status = userRepository.existsByEmailAndFirstName(register.getEmail(), register.getFirstName());
System.out.println("status"+status);
if(status) {
	throw new AlreadyExistsException("this record already exists");
}
			//			if(userRepository.existsByEmailAndFirstName(register.getEmail(),register.getFirstName()) == true) {
//				throw new AlreadyExistsException("this record already Exists");
//			}
Register register2=userRepository.save(register);
			System.out.println(register2);
			if(register2!=null) {
//				return register2;
//				Login login = new Login(register2.getEmail(),register2.getPassword(),register2);
//				if(loginRepository.existsByUserName(register2.getEmail())) {
//					throw new AlreadyExistsException("record exists");
//				}
//				//addCredential LoginService
//				String result=service.addCredentials(login);
//				if(result=="success") {
//					return "credentials added and user added";
//				}else {
//					return "fail";
//			}
				}
				
			return null;
		}
	        

		

//		@Override
//		public Optional<Register> getUserById(String id) throws IdNotFoundException, InvalidIdLengthException, InvalidNameException, InvalidEmailException, InvalidPasswordException {
//			// TODO Auto-generated method stub
//			return userRepository.findById(id);
//		}

		@Override
		public Register[] getAllUsers() throws InvalidEmailException, InvalidIdLengthException, InvalidNameException, InvalidPasswordException {
			// TODO Auto-generated method stub
			List<Register> list=userRepository.findAll();
			Register[] array=new Register[list.size()];
			return list.toArray(array);
		}

		@Override
		public String deleteUserById(String id) throws IdNotFoundException {
			// TODO Auto-generated method stub
//			Register optional;
			try {
				Register optional=this.getUserById(id);
				if(optional==null) {
					throw new IdNotFoundException("record not found");
				}else {
					userRepository.deleteById(id);
				}
				return "success";
			} catch (IdNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new IdNotFoundException(e.getMessage());
			}
			
			
		}

		@Override
		public Optional<List<Register>> getAllUserDetails() throws InvalidEmailException, InvalidIdLengthException, InvalidNameException, InvalidPasswordException {
			// TODO Auto-generated method stub
			return Optional.ofNullable(userRepository.findAll());
		}



		@Override
		public String updateUser(String id, Register register) throws com.zee.zee5app.exception.IdNotFoundException {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public Register getUserById(String id) throws IdNotFoundException{
			Optional<Register> optional = userRepository.findById(id);
			if(optional.isEmpty()) {
				throw new IdNotFoundException("id doesnot exists");
				
			}
			else {
				return optional.get();
			}
			
		}
	}
