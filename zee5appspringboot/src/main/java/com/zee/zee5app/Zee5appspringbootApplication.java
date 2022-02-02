package com.zee.zee5app;

import java.io.IOException;
import java.math.BigDecimal;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.zee.zee5app.dto.Register;
import com.zee.zee5app.exception.InvalidEmailException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.InvalidNameException;
import com.zee.zee5app.exception.InvalidPasswordException;
import com.zee.zee5app.repository.UserRepository;
import com.zee.zee5app.service.UserService;
import com.zee.zee5app.service.impl.UserServiceImpl;

@SpringBootApplication
public class Zee5appspringbootApplication {

	public static void main(String[] args) throws InvalidNameException, InvalidEmailException, InvalidPasswordException {
		ConfigurableApplicationContext applicationContext =
		SpringApplication.run(Zee5appspringbootApplication.class, args);
	
//	DataSource dataSource = applicationContext.getBean(DataSource.class);
//System.out.println(dataSource!=null);
//	
	
	UserRepository userRepository = applicationContext.getBean(UserRepository.class);
    UserServiceImpl service = applicationContext.getBean(UserServiceImpl.class);
	
	try {
		Register register = new Register("ab00009", "dvsprakash", "venkatasai", "dvsprak@gmail.com", "34553323",new BigDecimal("9235567814"));
		
		System.out.println(service.addUser(register));
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	applicationContext.close();
	}

}
