package service;

import dto.Subscription;
import lombok.Data;
import repository.Subrepo;

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