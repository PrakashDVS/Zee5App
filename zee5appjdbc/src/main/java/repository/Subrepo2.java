package repository;



import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import dto.Subscription;
import exception.IdNotFoundException;
import exception.InvalidAmountException;
import exception.InvalidIdLengthException;

public interface Subrepo2 {
	public String addSubscription(Subscription subscription) throws InvalidAmountException;
	public String deleteSubscription(String id) throws IdNotFoundException;
	public String modifySubscription(String id, Subscription subscription);
	public Optional<Subscription> getSubscriptionById(String id) throws IdNotFoundException, InvalidIdLengthException, InvalidAmountException;
	public Optional<ArrayList<Subscription>> getAllSubscription() throws InvalidIdLengthException, InvalidAmountException;

}
