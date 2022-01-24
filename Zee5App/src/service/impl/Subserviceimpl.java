package service.impl;
import repository.Subrepo;
import repository.impl.Subrepoimpl;

import java.util.List;
import java.util.Optional;

import dto.Subscription;
import exception.IdNotFoundException;
import exception.InvalidAmountException;
import repository.Subrepo2;
import service.Subservice2;

public class Subserviceimpl implements Subservice2 {
	private Subrepo2 repository = Subrepoimpl.getInstance();
	private static Subservice2 service;	
	
	public static Subservice2 getInstance() {
		if(service == null)
			service = new Subserviceimpl();
		return service;
	}
	
    private Subserviceimpl() {
		
	}

	@Override
	public String addSubscription(Subscription subscription) throws InvalidAmountException {
		// TODO Auto-generated method stub
		return this.repository.addSubscription(subscription);
	}

	@Override
	public String deleteSubscription(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		return this.repository.deleteSubscription(id);
	}

	@Override
	public String modifySubscription(String id, Subscription subscription) {
		// TODO Auto-generated method stub
		return this.repository.modifySubscription(id, subscription);
	}

	@Override
	public Optional<Subscription> getSubscriptionById(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		return this.repository.getSubscriptionById(id);
	}

	@Override
	public List<Subscription> getAllSubscription() {
		// TODO Auto-generated method stub
		return this.repository.getAllSubscription();
	}
	
//	@Override
//	public String addSubscription(Subscription subscription) {
//		// TODO Auto-generated method stub
//		return this.repository.addSubscription(subscription);
//	}
//
//	@Override
//	public Subscription getSubscriptionById(String id) {
//		// TODO Auto-generated method stub
//		return this.repository.getSubscriptionById(id);
//	}
//
//	@Override
//	public Subscription[] getAllSubscriptions() {
//		// TODO Auto-generated method stub
//		return repository.getAllSubscription();
//	}

}