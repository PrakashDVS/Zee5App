package com.zee.zee5app.app;
import java.math.BigDecimal;

import javax.naming.InvalidNameException;
import javax.sql.DataSource;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.zee.zee5app.config.Config;
import com.zee.zee5app.dto.User;
import com.zee.zee5app.exception.InvalidEmailException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.InvalidPasswordException;
import com.zee.zee5app.repository.UserRepository;
public class MainSpring {
	public static void main(String[] args) throws  InvalidEmailException, InvalidPasswordException, com.zee.zee5app.exception.InvalidNameException {
		AbstractApplicationContext applicationContext = new AnnotationConfigApplicationContext(Config.class);
		DataSource dataSource = applicationContext.getBean("ds",DataSource.class);
		System.out.println(dataSource.hashCode());
		DataSource  dataSource2 = applicationContext.getBean("ds",DataSource.class);
		System.out.println(dataSource2.hashCode());
		System.out.println(dataSource.equals(dataSource2));
//		UserRepository repository = applicationContext.getBean(UserRepository.class);
//		System.out.println(repository);
//		
//		UserRepository repository2 = applicationContext.getBean(UserRepository.class);
//		System.out.println(repository2);
//		
//		System.out.println(repository.hashCode());
//		System.out.println(repository2.hashCode());
//		
//		System.out.println(repository.equals(repository2));
//		
//		DataSource dataSource = applicationContext.getBean("dataSource",DataSource.class);
//		System.out.println(dataSource != null);
//		
//		try {
//			Register register = new Register("prakash123", "dvsp", "venkata", "dvsp123@gmail.com", "343323",new BigDecimal("9235567814"));
//			System.out.println(repository.addUser(register));
//		} catch (InvalidIdLengthException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		applicationContext.close();

	}
}