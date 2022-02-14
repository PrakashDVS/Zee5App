package com.zee.zee5app.app;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.zee.zee5app.Zee5appspringbootApplication;
import com.zee.zee5app.dto.ERole;
import com.zee.zee5app.dto.Episodes;
import com.zee.zee5app.dto.Movie;
import com.zee.zee5app.dto.User;
import com.zee.zee5app.dto.Role;
import com.zee.zee5app.dto.Series;
import com.zee.zee5app.exception.AlreadyExistsException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.InvalidNameException;
import com.zee.zee5app.repository.MovieRepository;
import com.zee.zee5app.repository.RoleRepository;
import com.zee.zee5app.repository.UserRepository;
import com.zee.zee5app.service.EpisodeService;
import com.zee.zee5app.service.MovieService2;
import com.zee.zee5app.service.RoleService;
import com.zee.zee5app.service.SeriesService2;
import com.zee.zee5app.service.Subservice2;
import com.zee.zee5app.service.UserService;
import com.zee.zee5app.service.impl.UserServiceImpl;
@SpringBootApplication
public class Main2 {

	public static void main(String[] args) throws AlreadyExistsException, InvalidNameException, InvalidIdLengthException {
		ConfigurableApplicationContext applicationContext = SpringApplication.run(Zee5appspringbootApplication.class,
				args);
////		Role role = new Role();
////		role.setRoleName(ERole.ROLE_ADMIN);
////		
////		Role role2 = new Role();
////		role2.setRoleName(ERole.ROLE_USER); 
////		
//		RoleService roleService = applicationContext.getBean(RoleService.class);
//		RoleRepository roleRepository = applicationContext.getBean(RoleRepository.class);
////		System.out.println(roleService.addRole(role));
////		System.out.println(roleService.addRole(role2));
////		
////		UserServiceImpl service = applicationContext.getBean(UserServiceImpl.class);
////		Register register;
////		register = new Register("ab000129", "priya", "sharma", "abhi888883@gmail.com", "Ji2ed3443", null, null);
////		register.setContactNumber(new BigDecimal("9813973123"));
////		Set<Role> roles = new HashSet<>();
////		roles.add(roleRepository.findById(1).get());
////		roles.add(roleRepository.findById(2).get());
////		register.setRoles(roles);
////		System.out.println(service.addUser(register));
//		
////		UserService userService = applicationContext.getBean(UserService.class);
////		Subservice2 episodeService = applicationContext.getBean(Subservice2.class);
////		Series series1 = new Series("ser0001","SeriesName1",0, "romance","2029-7-3","google-series", 0, null, null, 0);
////		Series series2 = new Series("ser0002","SeriesName2",1, "romance","2029-7-3","google-series", 0, null, null, 0);
////		
////		Episodes episode = new Episodes("epi0001","episodename1", "ganesh", 0, "drive", "youtube", series2);
////		episodeService.addEpisode(episode);
//		MovieService2 movieService = applicationContext.getBean(MovieService2.class);	
//		Movie movie=new Movie();
//		movie.setId("movie4");
//		movie.setAgeLimit(10);
//		movie.setCast("MM,NN");
//		movie.setGenre("Action");
//		movie.setLanguage("English");
//		movie.setLength(new BigDecimal(123456789));
//		movie.setMovieName("mavie4");
//		movie.setReleaseDate(new Date(12-01-2022));
//		FileInputStream fileInputStream = null;
//		FileOutputStream fileOutputStream = null;
//		
//		try {
//			fileInputStream= new FileInputStream("C:\\Users\\donepudi.prakash\\Downloads\\Pushpa.mp4");
//			File file = new File("C:\\Users\\donepudi.prakash\\Downloads\\Pushpa.mp4");
//			long fileSize=file.length();
//			byte[] allBytes = new byte[(int) fileSize];
//			
//			fileInputStream.read(allBytes);
//			movie.setTrailer("C:\\Users\\donepudi.prakash\\Downloads\\movieStore\\"+file.getName());
//			
////			System.out.println(movieService.addMovie(movie));
//			String result =  movieService.addMovie(movie);
//			movie.setReleaseDate(new Date(12-01-2022));
//			if(result.equals("success")) {
//		    	   
//		    	   fileOutputStream = new FileOutputStream("C:\\Users\\donepudi.prakash\\Downloads\\movieStore\\"+file.getName());
//		    	   
//		    	   byte[] data = new byte[(int) file.length()];
//		    	   
//		    	   fileInputStream.read(data);
//		    	   fileOutputStream.write(data);
//		    	   
//
//			}
//		}
//			catch (FileNotFoundException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();}
//	catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		
//		finally {
//			try {
//				fileInputStream.close();
//				fileOutputStream.close();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//		applicationContext.close();
	}
}
