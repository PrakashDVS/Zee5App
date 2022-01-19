package repository;



import dto.Subscription;

public interface Subrepo2 {
	public String addSubscription(Subscription subscription);
	public String updateSubscription(String id);
	public Subscription getSubscriptionById(String id);
	public Subscription[] getAllSubscription();
	public String deleteSubscriptionById(String id);
}
