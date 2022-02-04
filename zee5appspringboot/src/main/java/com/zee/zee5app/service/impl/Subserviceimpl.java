package com.zee.zee5app.service.impl;
import org.springframework.stereotype.Service;

import com.zee.zee5app.dto.Register;
import com.zee.zee5app.dto.Subscription;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidAmountException;
import com.zee.zee5app.exception.InvalidEmailException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.InvalidNameException;
import com.zee.zee5app.exception.InvalidPasswordException;
import com.zee.zee5app.repository.SubscriptionRepository;
import com.zee.zee5app.service.Subservice2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class Subserviceimpl implements Subservice2 {
	private SubscriptionRepository repository ;
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
		Subscription subscription2 = repository.save(subscription);
		// TODO Auto-generated method stub
		if(subscription2 != null) {
			return "success";
		}
		else {
			return "fail";
		}
	}

	@Override
	public String deleteSubscription(String id) throws IdNotFoundException, InvalidAmountException {
		try {
			Optional<Subscription> optional = this.getSubscriptionById(id);
			if(optional.isEmpty()) {
				throw new IdNotFoundException("record not found");
			}
			else {
				repository.deleteById(id);
				return "success";
			}
		}catch(IdNotFoundException | InvalidIdLengthException e) {
			e.printStackTrace();
			throw new IdNotFoundException(e.getLocalizedMessage());
		}
	}

	@Override
	public String modifySubscription(String id, Subscription subscription) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public  Optional<Subscription> getSubscriptionById(String id) throws IdNotFoundException, InvalidIdLengthException, InvalidAmountException {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}

	@Override
	public Optional<List<Subscription>> getAllSubscription() throws InvalidIdLengthException, InvalidAmountException {
		// TODO Auto-generated method stub
		return Optional.ofNullable(repository.findAll());

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