package com.learning.controller;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.entity.EROLE;
import com.learning.entity.Food;
import com.learning.entity.Register;
import com.learning.entity.Role;
import com.learning.exception.AlreadyExistsException;
import com.learning.exception.IdNotFoundException;
import com.learning.exception.InvalidEmailException;
import com.learning.exception.InvalidIdLengthException;
import com.learning.exception.InvalidNameException;
import com.learning.exception.InvalidPasswordException;
import com.learning.payload.request.LoginRequest;
import com.learning.payload.request.SignupRequest;
import com.learning.payload.response.JwtResponse;
import com.learning.payload.response.MessageResponse;
import com.learning.repository.LoginRepository;
import com.learning.repository.RoleRepository;
import com.learning.repository.UserRepository;
import com.learning.security.jwt.JwtUtils;
import com.learning.security.services.UserDetailsImpl;
import com.learning.service.FoodService;
import com.learning.service.LoginService;
import com.learning.service.UserService;
import com.learning.service.impl.UserServiceImpl;


@RestController
@RequestMapping("/api/auth")
public class UserController {
	@Autowired
	UserService userService;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	LoginRepository loginRepository;
	
	@Autowired
	LoginService loginService;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	JwtUtils jwtUtils;
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest){
		
		Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getuserName(),
						loginRequest.getPassword()));
		
		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateToken(authentication);
		UserDetailsImpl userDetailsImpl = (UserDetailsImpl) authentication.getPrincipal();
		List<String> roles = userDetailsImpl.getAuthorities()
				.stream()
				.map(i->i.getAuthority())
				.collect(Collectors.toList());
		
		return ResponseEntity.ok(new JwtResponse(jwt,
				userDetailsImpl.getId(),
				userDetailsImpl.getEmail(),
				userDetailsImpl.getName(), roles));
	}
	
	
	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signupRequest){
		
		if(userRepository.existsByuserName(signupRequest.getUserName())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Username is already taken!"));
		}
		
		if(userRepository.existsByEmail(signupRequest.getEmail())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Email is already use!"));
		}
		
		Register user=new Register(signupRequest.getUserName(), signupRequest.getName(), 
				signupRequest.getEmail(), signupRequest.getPassword(), signupRequest.getAddress());
			
		Set<String> strRoles=signupRequest.getRoles();
		
		Set<Role> roles=new HashSet<>();
		
		if(strRoles==null) {
			Role userRole=roleRepository.findByRoleName(EROLE.ROLE_USER)
					.orElseThrow(()->new RuntimeException("Error:role not found"));
		}
		else {
			strRoles.forEach(e->{
				switch(e) {
				 
				case "admin":
					Role roleAdmin = roleRepository.findByRoleName(EROLE.ROLE_ADMIN)
					                 .orElseThrow(()->new RuntimeException("Error:role not found"));
					roles.add(roleAdmin);
				    break;
					
					
						
				default:
					Role userRole = roleRepository.findByRoleName(EROLE.ROLE_USER)
	                 .orElseThrow(()->new RuntimeException("Error:role not found"));
	                 roles.add(userRole);
                     
				}
			});
			
			
		}System.out.println(user);
		user.setRole(roles);
		userRepository.save(user);
		return ResponseEntity.status(201).body(new MessageResponse("user created sucessfully"));
		
	}
	
	

		
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
	
		
		
//		POST request for adding food item
		@PostMapping("/addFood")
		@PreAuthorize("hasRole('ADMIN')")
		public ResponseEntity<?> addFood(@RequestBody Food food) throws AlreadyExistsException {
			Food result = foodService.addFood(food);
			return ResponseEntity.status(201).body(result);
		}
		
//		GET request for retrieving food item by id
		@GetMapping("/{foodId}")
		@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
		public ResponseEntity<?> getFoodById(@PathVariable("foodId") Long foodId) throws IdNotFoundException {
			Food result = foodService.getFoodById(foodId);
			return ResponseEntity.ok(result);
		}
		
//		PUT request for updating food item by id
		@PutMapping("/{foodId}")
		@PreAuthorize("hasRole('ADMIN')")
		public ResponseEntity<?> updateFood(@RequestBody @PathVariable("foodId") Long foodId,  Food food) throws IdNotFoundException {
			Food result = foodService.updateFood(foodId, food);
			return ResponseEntity.status(200).body(result);
		}
		
//		GET request for retrieving all food items
		@GetMapping("/all")
		@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
		public ResponseEntity<?> getAllFood() {
			Optional<List<Food>> optional = foodService.getAllFoodDetails();
			if (optional.isEmpty()) {
				Map<String, String> map = new HashMap<String, String>();
				map.put("message", "No record found");
				return ResponseEntity.status(HttpStatus.NO_CONTENT).body(map);
			}
			return ResponseEntity.ok(optional.get());
		}
		
////		GET request for retrieving food item by food type
//		@GetMapping("/foodType/{foodType}")
//		@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
//		public ResponseEntity<?> getFoodByType(@PathVariable("foodType") FoodType foodType) {
//			Optional<List<Food>> optional = foodService.getByFoodType(foodType);
//			if (optional.isEmpty()) {
//				Map<String, String> map = new HashMap<String, String>();
//				map.put("message", "Sorry Food Not Found");
//				return ResponseEntity.status(HttpStatus.NO_CONTENT).body(map);
//			}
//			return ResponseEntity.ok(optional.get());
//		}
		
//		DELETE request for deleting food item by id
		@DeleteMapping("/{foodId}")
		@PreAuthorize("hasRole('ADMIN')")
		public ResponseEntity<?> deleteFoodById(@PathVariable("foodId") Long foodId) throws IdNotFoundException {
			foodService.deleteFoodById(foodId);
			Map<String, String> map = new HashMap<String, String>();
			map.put("message", "Food item deleted");
			return ResponseEntity.status(200).body(map);
		}

	}
	
	