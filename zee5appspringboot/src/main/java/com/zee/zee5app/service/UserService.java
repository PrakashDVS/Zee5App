package com.zee.zee5app.service;

import java.util.List;
import java.util.Optional;

import com.zee.zee5app.dto.Register;
import com.zee.zee5app.exception.AlreadyExistsException;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidEmailException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.InvalidNameException;
import com.zee.zee5app.exception.InvalidPasswordException;

public interface UserService {

	public Register addUser(Register register) throws AlreadyExistsException;
	public String updateUser(String id, Register register) throws IdNotFoundException;
	public Register getUserById(String id) throws IdNotFoundException, InvalidIdLengthException, InvalidNameException, InvalidEmailException, InvalidPasswordException;
	public Register[] getAllUsers() throws InvalidEmailException, InvalidIdLengthException, InvalidNameException, InvalidPasswordException;
	public String deleteUserById(String id) throws IdNotFoundException;
	public Optional<List<Register>> getAllUserDetails() throws InvalidEmailException, InvalidIdLengthException, InvalidNameException, InvalidPasswordException;
}