package repository;



import java.util.List;
import java.util.Optional;

import dto.Subscription;
import exception.IdNotFoundException;
import exception.InvalidAmountException;

public interface Subrepo2 {
	public String addSubscription(Subscription subscription) throws InvalidAmountException;
	public String deleteSubscription(String id) throws IdNotFoundException;
	public String modifySubscription(String id, Subscription subscription);
	public Optional<Subscription> getSubscriptionById(String id) throws IdNotFoundException;
	public List<Subscription> getAllSubscription();

}
