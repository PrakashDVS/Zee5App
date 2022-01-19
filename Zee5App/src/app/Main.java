package app;

import service.impl.MovieServiceimpl;
import service.impl.SeriesServiceimpl;
import service.impl.Subserviceimpl;
import dto.Movie;
import dto.Series;
import dto.Subscription;
import service.MovieService2;
import service.Movieservice;
import service.SeriesService2;
import service.Seriesservice;
import service.Subservice;
import service.Subservice2;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       Subservice service1=Subservice.getInstance();
       Movieservice service2=Movieservice.getInstance();
       Seriesservice service3=Seriesservice.getInstance();
       
	    for(int i=1;i<=10;i++) {
	      Subscription subscription2=new Subscription();
	      subscription2.setId("sm03"+i);
	      subscription2.setType("premium"+i);
	      subscription2.setDop("05-08-2021"+i);
	      subscription2.setStatus("Active"+i);
	      subscription2.setCountry("India"+i);
	      subscription2.setPaymentmode("UPI"+i);
	      subscription2.setAutorenewal("INActive"+i);
	      subscription2.setDoe("04-08-2022"+i);
	      String result=service1.addSubscription(subscription2);
	      System.out.println(result);
	    
	    }
	    
	    for(int i=1;i<=10;i++) {
		      Movie movie2=new Movie();
		      movie2.setMid("m03"+i);
		      movie2.setMcat("Action"+i);
		      movie2.setMdor("09-08-2021"+i);
		      movie2.setMname("SLN"+i);
		      movie2.setMlanguage("Telugu"+i);
		      movie2.setMlength("2hrs"+i);
		      movie2.setMtrailer("www.youtube.com"+i);
		      movie2.setMcast("hero"+i);
		      String result=service2.addMovie(movie2);
		      System.out.println(result);
		    
		    }
	    for(int i=1;i<=10;i++) {
	    	  Series series2=new Series();
	    	  series2.setSid("s03"+i);
	    	  series2.setScat("comedy"+i);
	    	  series2.setSdor("26-04-2021"+i);
	    	  series2.setSname("Baker&Beauty"+i);
	    	  series2.setSlanguage("Telugu"+i);
	    	  series2.setSlength("1hrs"+i);
	    	  series2.setStrailer("www.youtube.com"+i);
	    	  series2.setScast("heroine"+i);
		      String result=service3.addSeries(series2);
		      System.out.println(result);
		    
		    }
	    
	    
	    for(Subscription subscription3:service1.getAllsubscription()) {
	    	if(subscription3!=null)
	    	 System.out.println(subscription3);
	    }
	    System.out.println(service1.updateSubscription("sm031"));
	    System.out.println(service1.getSubscriptionById("sm031"));
	    System.out.println(service1.deleteSubscription("sm031"));
	    System.out.println(service1.getSubscriptionById("sm031"));
	    
	    for(Movie movie3:service2.getAllMovies()) {
	    	if(movie3!=null)
	    	 System.out.println(movie3);
	    }
	    System.out.println(service2.updateMovie("m031"));
	    System.out.println(service2.getMovieById("m031"));
	    System.out.println(service2.deleteMovie("m031"));
	    System.out.println(service2.getMovieById("m031"));
	    
	    for(Series series3:service3.getAllSeries()) {
	    	if(series3!=null)
	    	 System.out.println(series3);
	    }
	    System.out.println(service3.updateSeries("s031"));
	    System.out.println(service3.getSeriesById("s031"));
	    System.out.println(service3.deleteSeries("s031"));
	    System.out.println(service3.getSeriesById("s031"));
	}
	Subservice2 service = Subserviceimpl.getInstance();
	MovieService2 service2 = MovieServiceimpl.getInstance();
	SeriesService2 service3 = SeriesServiceimpl.getInstance();
	

}
