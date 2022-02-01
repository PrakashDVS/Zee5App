package com.zee.zee5app.service;

import com.zee.zee5app.dto.Subscription;
import com.zee.zee5app.repository.Subrepo;

import lombok.Data;

@Data
public class Subservice {
private Subrepo repository = Subrepo.getInstance();
	
	private static Subservice service = null;
	
	public static Subservice getInstance() {
		if (service ==null)
			service = new Subservice();
		return service;
	}
	
	public String addSubscription(Subscription subscription) {
		return this.repository.addSubscription(subscription);
	}
	
	public Subscription getSubscriptionById(String id) {
		return this.repository.getSubscriptionById(id);
	}
	
	public Subscription[] getAllSubscriptions() {
		return repository.getAllSubscription();
	}
	

}