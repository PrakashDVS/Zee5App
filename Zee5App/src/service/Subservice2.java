package service;

import dto.Subscription;

public interface Subservice2 {
	public String addSubscription(Subscription subscription);
	public String updateSubscription(String id);
	public Subscription getSubscriptionById(String id);
	public Subscription[] getAllSubscription();
	public String deleteSubscriptionById(String id);
}
