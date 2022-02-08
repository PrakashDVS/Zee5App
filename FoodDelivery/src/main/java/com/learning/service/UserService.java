package com.learning.service;

import java.util.List;
import java.util.Optional;

import com.learning.entity.Register;
import com.learning.exception.AlreadyExistsException;
import com.learning.exception.IdNotFoundException;
import com.learning.exception.InvalidEmailException;
import com.learning.exception.InvalidIdLengthException;
import com.learning.exception.InvalidNameException;
import com.learning.exception.InvalidPasswordException;



public interface UserService {
	public Register addUser(Register register) throws AlreadyExistsException;
	public Register updateUser(int id, Register register) throws IdNotFoundException;
	public Register getUserById(int id) throws IdNotFoundException, InvalidPasswordException;
	public Register[] getAllUsers() throws   InvalidPasswordException;
	public String deleteUserById(int id) throws IdNotFoundException, InvalidPasswordException;
	public Optional<List<Register>> getAllUserDetails() throws  InvalidPasswordException;
	public String authenticate(String email , String password);
}