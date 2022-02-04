package com.zee.zee5app.app;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.zee.zee5app.Zee5appspringbootApplication;
import com.zee.zee5app.dto.ERole;
import com.zee.zee5app.dto.Episodes;
import com.zee.zee5app.dto.Register;
import com.zee.zee5app.dto.Role;
import com.zee.zee5app.dto.Series;
import com.zee.zee5app.exception.AlreadyExistsException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.InvalidNameException;
import com.zee.zee5app.repository.MovieRepository;
import com.zee.zee5app.repository.RoleRepository;
import com.zee.zee5app.repository.UserRepository;
import com.zee.zee5app.service.EpisodeService;
import com.zee.zee5app.service.RoleService;
import com.zee.zee5app.service.SeriesService2;
import com.zee.zee5app.service.UserService;
import com.zee.zee5app.service.impl.UserServiceImpl;
@SpringBootApplication
public class Main2 {

	public static void main(String[] args) throws AlreadyExistsException, InvalidNameException, InvalidIdLengthException {
		ConfigurableApplicationContext applicationContext = SpringApplication.run(Zee5appspringbootApplication.class,
				args);
//		Role role = new Role();
//		role.setRoleName(ERole.ROLE_ADMIN);
//		
//		Role role2 = new Role();
//		role2.setRoleName(ERole.ROLE_USER); 
//		
		RoleService roleService = applicationContext.getBean(RoleService.class);
		RoleRepository roleRepository = applicationContext.getBean(RoleRepository.class);
//		System.out.println(roleService.addRole(role));
//		System.out.println(roleService.addRole(role2));
//		
//		UserServiceImpl service = applicationContext.getBean(UserServiceImpl.class);
//		Register register;
//		register = new Register("ab000129", "priya", "sharma", "abhi888883@gmail.com", "Ji2ed3443", null, null);
//		register.setContactNumber(new BigDecimal("9813973123"));
//		Set<Role> roles = new HashSet<>();
//		roles.add(roleRepository.findById(1).get());
//		roles.add(roleRepository.findById(2).get());
//		register.setRoles(roles);
//		System.out.println(service.addUser(register));
		
		SeriesService2 seriesService = applicationContext.getBean(SeriesService2.class);
		EpisodeService episodeService = applicationContext.getBean(EpisodeService.class);
		Series series1 = new Series("ser0001","SeriesName1",0, "romance","2029-7-3","google-series", 0, null, null, 0);
		Series series2 = new Series("ser0002","SeriesName2",1, "romance","2029-7-3","google-series", 0, null, null, 0);
		
		Episodes episode = new Episodes("epi0001","episodename1", "ganesh", 0, "drive", "youtube", series2);
		episodeService.addEpisode(episode);
		applicationContext.close();
	}
}
