package com.zee.zee5app.app;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import com.zee.zee5app.dto.Movie;
import com.zee.zee5app.dto.Role;
import com.zee.zee5app.dto.Register;
import com.zee.zee5app.dto.Series;
import com.zee.zee5app.dto.Subscription;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidAmountException;
import com.zee.zee5app.exception.InvalidEmailException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.InvalidNameException;
import com.zee.zee5app.exception.InvalidPasswordException;
import com.zee.zee5app.exception.NameNotFoundException;
import com.zee.zee5app.service.LoginService;
import com.zee.zee5app.service.MovieService2;
import com.zee.zee5app.service.Movieservice;
import com.zee.zee5app.service.SeriesService2;
import com.zee.zee5app.service.Seriesservice;
import com.zee.zee5app.service.Subservice;
import com.zee.zee5app.service.Subservice2;
import com.zee.zee5app.service.UserService;
import com.zee.zee5app.service.impl.LoginServiceImpl;
import com.zee.zee5app.service.impl.MovieServiceimpl;
import com.zee.zee5app.service.impl.SeriesServiceimpl;
import com.zee.zee5app.service.impl.Subserviceimpl;
import com.zee.zee5app.service.impl.UserServiceImpl;
import com.zee.zee5app.utils.PasswordUtils;

import lombok.Data;
import lombok.Data;
@Data
public class Main {

	public static void main(String[] args) throws InvalidEmailException, InvalidIdLengthException, InvalidNameException, InvalidPasswordException  {
		// TODO Auto-generated method stub
//        UserService service;
//		try {
//			service = UserServiceImpl.getInstance();
//			Optional<List<Register>> optional = service.getAllUserDetails();
//			if(optional.isEmpty()) {
//				System.out.println("there are no records");
//			}
//			else {
//				optional.get().forEach(e->System.out.println(e));
//			}
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//		try {
//			Register register = new Register("ab000007", "abhi", "chivate", "abhi@gmail.com","12345");
//			
//			
//			register.setContactNumber(new BigDecimal("984989898"));
//			UserService service = UserServiceImpl.getInstance();
//			
//			String result = service.addUser(register);
//			System.out.println(result);
//			
//		} catch (InvalidIdLengthException | InvalidNameException | InvalidPasswordException | InvalidEmailException | IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//}
//		
////		UserService2 service;
////		try {
////			service = UserServiceimpl.getInstance();
////			Optional<Register> register = service.getUserById("ab000001");
////			System.out.println(register.get());
////		} catch (IOException | IdNotFoundException | InvalidIdLengthException | InvalidNameException | InvalidEmailException | InvalidPasswordException e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
////		}
//      try {
//			UserService service2=UserServiceImpl.getInstance();
//			String result=service2.deleteUserById("ab000001");
//		} catch (IOException | IdNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//   }
//	 String myPassword = "myPassword123";
//     
//     // Generate Salt. The generated value can be stored in DB. 
//     String salt = PasswordUtils.getSalt(30);
//     
//     // Protect user's password. The generated value can be stored in DB.
//     String mySecurePassword = PasswordUtils.generateSecurePassword(myPassword, salt);
//     
//     // Print out protected password 
//     System.out.println("My secure password = " + mySecurePassword);
//     System.out.println("Salt value = " + salt);
//
//
//   }
//}
		


//public class Main {
//
//
//		public static void main(String[] args) throws 
//		InvalidIdLengthException, InvalidNameException, InvalidAmountException, IdNotFoundException, InvalidEmailException, InvalidPasswordException {
//			// TODO Auto-generated method stub
//			
//			
//			
//			//String result1  = service.addUser(register);
//			//System.out.println(result1+"checkpoint1");
//			
//			//System.out.println(service.getUserById("rg00001").get()+"checkpoint2");
//			
//			
//			
//			// we dont introduce private here to make it accessible
//			//now this line can connect to different files with UserServiceImpl2 and so on
//			
//			// main is consuming the service
//			// if we even call this 100 times it will create only 1 object now
//			
//			// now only id part in register will not be show other
//			UserService service5;
//			try{
//				service5 = UserServiceImpl.getInstance();
//				Optional<List<Register>> optional = service5.getAllUserDetails();
//				if(optional.isEmpty()) {
//					System.out.println("there are no records");
//				}
//				else {
//					optional.get().forEach(e->System.out.println(e));
//				}
//			}
//			catch(IOException e) {
//				e.printStackTrace();
//			}
//			catch(InvalidIdLengthException e) {
//				e.printStackTrace();
//				
//			}
//
//			try {
//				UserService service = UserServiceImpl.getInstance();
//				Optional<Register> register = service.getUserById("ab000001");
//				System.out.println(register.get());
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (IdNotFoundException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (InvalidIdLengthException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (InvalidNameException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			System.out.println("\n  SUBSCRIPTION\n");
//				
//				
//			Subservice2 service2 = Subserviceimpl.getInstance();
//			
//			for(int i =1; i<=3;i++) {
//				Subscription subscription = new Subscription();
//				try {
//				subscription.setId("sub00"+i);
//				}
//				catch (InvalidIdLengthException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//				subscription.setAutoRenewal(null);
//				subscription.setDateOfPurchase(null);
//				subscription.setExpiryDate(null);
//				try {
//					subscription.setAmount(1500);
//				} catch (InvalidAmountException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//				subscription.setPaymentMode(null);
//				subscription.setStatus(null);
//				subscription.setType(null);
//				
//				String result = service2.addSubscription(subscription);
//				//System.out.println(result);
//				
//			}
//
//			
//			for (Subscription subscription : service2.getAllSubscription()) {
//				if(subscription!=null)
//				    System.out.println(subscription);
//						
//			}
//			
//			try {
//				Optional<Subscription> optional = service2.getSubscriptionById("sub001");
//				System.out.println(optional);
//			} catch (IdNotFoundException e) {
//				// TODO Auto-generated catch block
//				System.out.println("id not found");
//				e.printStackTrace();
//			}
//			
//			try {
//				service2.deleteSubscription("sub001");
//			} catch (IdNotFoundException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
//			
//			System.out.println("\n MOVIES\n");
//			
//			MovieService2 service3 = MovieServiceimpl.getInstance();
//			for(int i =1; i<=5;i++) {
//				Movie movie = new Movie();
//				try {
//				movie.setId("mov00"+i);
//				}
//				catch (InvalidIdLengthException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//				try {
//					movie.setMovieName("abc"+i);
//				} catch (NameNotFoundException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//				movie.setAgeLimit(null);
//				movie.setCast(new String[] {"hrk","abt","tdc","sdf"});
//				movie.setGenre("action"+i);
//				movie.setLength(null);
//				movie.setReleaseDate(null);
//				movie.setTrailer(null);
//				String result = service3.addMovie(movie);
//				//System.out.println(result);
//				
//			}
//			
//			for (Movie movie : service3.getAllMovie()) {
//				if(movie!=null)
//				 System.out.println(movie);
//						
//			}
//			
//			try {
//				Optional<Movie> optional = service3.getMovieById("mov001");
//				System.out.println(optional);
//			} catch (IdNotFoundException e) {
//				// TODO Auto-generated catch block
//				System.out.println("id not found");
//				e.printStackTrace();
//			}
//			
//			try {
//				service3.deleteMovie("mov001");
//			} catch (IdNotFoundException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
//			
//			System.out.println("\n SERIES\n");
//			
//			SeriesService2 service4 = SeriesServiceimpl.getInstance();
//			for(int i =1; i<=7;i++) {
//				Series series = new Series();
//				series.setId("sr000"+i);
//				try {
//					series.setSeriesName("xyz"+i);
//				} catch (NameNotFoundException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//				series.setAgeLimit(null);
//				series.setCast(new String[] {"ytd","efd","gfh","trd"});
//				series.setGenre("thriller"+i);
//				series.setLength(null);
//				series.setReleaseDate(null);
//				series.setTrailer(null);
//				String result = service4.addSeries(series);
//				//System.out.println(result);
//				
//			}
//			
//			for (Series series : service4.getAllSeries()) {
//				if(series!=null)
//				 System.out.println(series);
//						
//			}
//			
//			
//			try {
//				Optional<Series> optional = service4.getSeriesById("sr0001");
//				System.out.println(optional);
//			} catch (IdNotFoundException e) {
//				// TODO Auto-generated catch block
//				System.out.println("id not found");
//				e.printStackTrace();
//			}
//			
//			try {
//				service4.deleteSeries("sr0001");
//			} catch (IdNotFoundException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
//			
//			System.out.println("\nAfter updatig the series");
//			
//			try {
//				Series series5 = new Series("sr0012","xyz12",null,null,null,null,null,null);
//				service4.modifySeries("sr0002", series5);
//			} catch (NameNotFoundException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			} catch (InvalidIdLengthException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
//			
//			//this gives an error now coz its an interface thing
//			//UserRepository repository = new UserRepository();
//			
//			//UserRepository repository = null;
//		    
//			service4.getAllSeries().forEach(e->System.out.println(e));
//
//		}
//
//	}
//
//		try {
//			LoginService loginService = LoginServiceImpl.getInstance();
//			System.out.println(loginService.changeRole("dvsp@gmail.com", ROLE.ROLE_ADMIN));
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
}