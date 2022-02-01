package com.zee.zee5app.service.impl;
import org.springframework.stereotype.Service;

import com.zee.zee5app.dto.Subscription;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidAmountException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.repository.Subrepo;
import com.zee.zee5app.repository.Subrepo2;
import com.zee.zee5app.repository.impl.Subrepoimpl;
import com.zee.zee5app.service.Subservice2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class Subserviceimpl implements Subservice2 {
	private Subrepo2 repository ;
//	private static Subservice2 service;	
//	
//	public static Subservice2 getInstance() throws IOException {
//		if(service == null)
//			service = new Subserviceimpl();
//		return service;
//	}
//	
//    private Subserviceimpl() throws IOException {
//		repository = Subrepoimpl.getInstance();
//	}

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
	public Optional<Subscription> getSubscriptionById(String id) throws IdNotFoundException, InvalidIdLengthException, InvalidAmountException {
		// TODO Auto-generated method stub
		return this.repository.getSubscriptionById(id);
	}

	@Override
	public Optional<ArrayList<Subscription>> getAllSubscription() throws InvalidIdLengthException, InvalidAmountException {
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