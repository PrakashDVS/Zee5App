package com.learning.controller;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.entity.Food;
import com.learning.entity.Register;
import com.learning.exception.AlreadyExistsException;
import com.learning.exception.IdNotFoundException;
import com.learning.exception.InvalidEmailException;
import com.learning.exception.InvalidIdLengthException;
import com.learning.exception.InvalidNameException;
import com.learning.exception.InvalidPasswordException;
import com.learning.service.FoodService;
import com.learning.service.UserService;
import com.learning.service.impl.UserServiceImpl;

@RestController
@RequestMapping("/users")
public class UserController {

		@Autowired
		UserService userService;
		
		@Autowired
		FoodService foodService;

		@PostMapping("/register")
	public ResponseEntity<?> addUser(@Valid@RequestBody Register register) {
		try {
			Register result = userService.addUser(register);
			System.out.println(result);
			return ResponseEntity.status(201).body(result);
		} catch (AlreadyExistsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		Map<String, String> hashMap = new HashMap<>();
		hashMap.put("message", "record already exists");
		return ResponseEntity.badRequest().body(hashMap);
		}
	}
	
		
		
	@GetMapping("{id}")
		public ResponseEntity<?> getUserById(@PathVariable("id") int id) throws IdNotFoundException, InvalidIdLengthException, InvalidNameException, InvalidEmailException, InvalidPasswordException{
			Register result = userService.getUserById(id);
			return ResponseEntity.status(201).body(result);
		}
	//return null;
	@PostMapping("/authenticate")
	public ResponseEntity<?> authenticate(String email , String password){
		String result = userService.authenticate(email, password);
		return ResponseEntity.status(201).body(result);
		
	}

	  @DeleteMapping("/delete/{id}")
		public ResponseEntity<?> deleteUserById(@PathVariable("id")int id) throws IdNotFoundException, InvalidPasswordException{
			String result=userService.deleteUserById(id);
			HashMap<String, String> map=new HashMap<>();
			map.put("messeage", "delete");
			return ResponseEntity.status(201).body(map);
		}
	@GetMapping
	public ResponseEntity<?> getAllUserDetails() throws InvalidEmailException, InvalidIdLengthException, InvalidNameException, InvalidPasswordException{
		Optional<List<Register>> optional = userService.getAllUserDetails();
		if(optional.isEmpty()) {
		Map<String, String> map = new HashMap<>();
//		map.put("message", "no record found");
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(map);
		}
	return ResponseEntity.ok(optional.get());
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateUser(@PathVariable("id") int id, @RequestBody Register register) throws IdNotFoundException
	{
		Register result = userService.updateUser(id, register);
		Map<String, String> map = new HashMap<>();
		map.put("message", "success updated");
		return ResponseEntity.status(201).body(result);
	}
	

	
	//add record
	@PostMapping("/addFood")
	public ResponseEntity<?> addFood(@Valid @RequestBody Food food) throws AlreadyExistsException {
		
	
		Food result = foodService.addFood(food);
		return ResponseEntity.status(201).body(result);
		
		}
	
	//retrieve single record
	@GetMapping("/food{foodId}")
	public ResponseEntity<?> getFoodById(@PathVariable("foodId") String foodId) throws IdNotFoundException{
		Food result = foodService.getFoodById(foodId);
		return ResponseEntity.ok(result);	
		
	}
	
	//retrieve all records
	@GetMapping("/all")
	public ResponseEntity<?> getAllFoodDetails(){
		Optional<List<Food>> optional = foodService.getAllFoodDetails();
		if(optional.isEmpty()) {
			Map<String, String> map = new HashMap<>();
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(map);
		}
		return ResponseEntity.ok(optional.get());	
		
	}
	
	@DeleteMapping("/delete/food{foodId}")
	public ResponseEntity<?> deleteFoodById(@PathVariable("foodId") String foodId) throws IdNotFoundException, SQLException
	{
		String result = foodService.deleteFoodById(foodId);
		Map<String, String> map = new HashMap<>();
		map.put("message", "success deleted");
		return ResponseEntity.status(201).body(result);
	}
	
	@PutMapping("/update/food{foodId}")
	public ResponseEntity<?> updateFood(@PathVariable("foodId") String foodId, @RequestBody Food food) throws IdNotFoundException
	{
		Food result = foodService.updateFood(foodId, food);
		Map<String, String> map = new HashMap<>();
		map.put("message", "success updated");
		return ResponseEntity.status(201).body(result);
	}
	
	}