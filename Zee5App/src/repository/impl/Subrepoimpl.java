package repository.impl;

import dto.Subscription;
import repository.Subrepo2;

public class Subrepoimpl implements Subrepo2 {
   private Subrepoimpl() {
    	
    }
    private static Subrepo2 repository;
    public static Subrepo2 getInstance() {
    	if(repository==null) {
    		repository=new Subrepoimpl();
    	}
    	return repository;
    }
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
