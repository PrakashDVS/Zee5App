package service;

import java.util.List;
import java.util.Optional;

import dto.Register;
import exception.IdNotFoundException;
import exception.InvalidEmailException;
import exception.InvalidIdLengthException;
import exception.InvalidNameException;
import exception.InvalidPasswordException;

public interface UserService {

	public String addUser(Register register);
	public String updateUser(String id, Register register) throws IdNotFoundException;
	public Optional<Register> getUserById(String id) throws IdNotFoundException, InvalidIdLengthException, InvalidNameException, InvalidEmailException, InvalidPasswordException;
	public Register[] getAllUsers() throws InvalidEmailException, InvalidIdLengthException, InvalidNameException, InvalidPasswordException;
	public String deleteUserById(String id) throws IdNotFoundException;
	public Optional<List<Register>> getAllUserDetails() throws InvalidEmailException, InvalidIdLengthException, InvalidNameException, InvalidPasswordException;
}