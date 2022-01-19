package service.impl;
import repository.Subrepo;
import repository.impl.Subrepoimpl;
import dto.Subscription;
import repository.Subrepo2;
import service.Subservice2;

public class Subserviceimpl implements Subservice2 {
   private Subserviceimpl() {
		
	}
	private static Subservice2 service4;
	public static Subservice2 getInstance() {
    	if(service4==null) {
    		service4=new Subserviceimpl();
    	}
    	return service4;
    }
	
	Subrepo2 userRepository = Subrepoimpl.getInstance();
	@Override
	public String addSubscription(Subscription subscription) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateSubscription(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Subscription getSubscriptionById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Subscription[] getAllSubscription() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteSubscriptionById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
