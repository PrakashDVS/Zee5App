package com.zee.zee5app;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.zee.zee5app.dto.Movie;
import com.zee.zee5app.dto.Register;
import com.zee.zee5app.dto.Role;
import com.zee.zee5app.dto.Subscription;
import com.zee.zee5app.exception.AlreadyExistsException;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidAmountException;
import com.zee.zee5app.exception.InvalidEmailException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.InvalidNameException;
import com.zee.zee5app.exception.InvalidPasswordException;
import com.zee.zee5app.repository.RoleRepository;
import com.zee.zee5app.repository.UserRepository;
import com.zee.zee5app.service.RoleService;
import com.zee.zee5app.service.Subservice2;
import com.zee.zee5app.service.UserService;
import com.zee.zee5app.service.impl.MovieServiceimpl;
import com.zee.zee5app.service.impl.SeriesServiceimpl;
import com.zee.zee5app.service.impl.Subserviceimpl;
import com.zee.zee5app.service.impl.UserServiceImpl;

@SpringBootApplication
public class Zee5appspringbootApplication {

	public static void main(String[] args) {
		 ConfigurableApplicationContext applicationContext=SpringApplication.run(Zee5appspringbootApplication.class, args);
		 
//		 DataSource dataSource=applicationContext.getBean(DataSource.class);
//		 
//		 System.out.println(dataSource!=null);
//		 Role role=new Role();
//		 role.setRoleName(EROLE.ROLE_ADMIN);
//		 
//		 Role role2=new Role();
//		 role2.setRoleName(EROLE.ROLE_USER);
//		 
		 RoleService roleservice=applicationContext.getBean(RoleService.class);
		 RoleRepository roleRepository=applicationContext.getBean(RoleRepository.class);
//		 System.out.println(roleservice.addRole(role));
//		 System.out.println(roleservice.addRole(role2));
		 
		 UserServiceImpl service=applicationContext.getBean(UserServiceImpl.class);
		 Register register = new Register("shannu33","shanmukh","narra","shannu33@gmail.com","S123456",null, null, null, null);
		register.setContactNumber(new BigDecimal(981123));

		 Set<Role> roles=new HashSet<>();
		 roles.add(roleRepository.findById(1).get());
		 roles.add(roleRepository.findById(2).get());
		 register.setRoles(roles);
		try {
			System.out.println(service.addUser(register));
		} catch (AlreadyExistsException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 
//		Register register2=new Register("vamsi12345","narra","vamsi","vamsi12345@gmail.com","vamsi@123");
//		try {
//			System.out.println(service.addUser(register2));
//		} catch (AlreadyExistsException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		try {
//			System.out.println(service.updateUser("vamsi05"));
//		} catch (IdNotFoundException | InvalidNameException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		try {
//			System.out.println(service.deleteUserById("vamsi05"));
//		} catch (IdNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		service.addUser(register2);
//		try {
//			System.out.println(service.getAllUserDetails());
//		} catch (InvalidEmailException | InvalidIdLengthException | InvalidNameException | InvalidPasswordException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		try {
//			System.out.println(service.getAllUsers());
//		} catch (InvalidEmailException | InvalidIdLengthException | InvalidNameException | InvalidPasswordException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		UserRepository userRepository=applicationContext.getBean(UserRepository.class);
//		System.out.println(userRepository.existsByEmailAndFirstName("vamsi123@gmail.com","narra"));
		
//		//Movie
//		Movieserviceimpl service2=applicationContext.getBean(Movieserviceimpl.class);
//		Movie movie = new Movie("mov003","antim","action","2021-11-26","salman",160,"hindi","");
//		System.out.println(service2.addMovie(movie));
//		Movie movie2= new Movie("mov001","varudukavalenu","comedy","2022-1-10","salman",145,"telugu","");
//		System.out.println(service2.addMovie(movie2));
//		Movierepo movierepo=applicationContext.getBean(Movierepo.class);
//		System.out.println(movierepo.findByMname("varudukavalenu"));
//		System.out.println(movierepo.findByMnameAndMdor("antim","2021-11-26"));
//		System.out.println(movierepo.findByMcast("salman"));
		applicationContext.close();
	}

}
