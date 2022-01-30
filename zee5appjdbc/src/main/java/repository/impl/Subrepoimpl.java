package repository.impl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import dto.Subscription;
import exception.IdNotFoundException;
import exception.InvalidAmountException;
import exception.InvalidIdLengthException;
import repository.Subrepo2;
import utils.DBUtils;

public class Subrepoimpl implements Subrepo2 {
private List<Subscription> set = new ArrayList<>();
	DBUtils dbUtils = null;
    private Subrepoimpl() throws IOException {
    	dbUtils = DBUtils.getInstance();
	}
	
	private static Subrepo2 subscriptionRepository;
	public static Subrepo2 getInstance() throws IOException {
		if(subscriptionRepository==null)
			subscriptionRepository = new Subrepoimpl();
		
		return subscriptionRepository;
	
	}
	@Override
	public String addSubscription(Subscription subscription) throws InvalidAmountException {
		// TODO Auto-generated method stub
		Connection connection = dbUtils.getConnection();
		PreparedStatement preparedStatement;

		String insertStatetment = "insert into subscription"
				+ "(id,dop,expiry,amount,paymentMode,status,type,autoRenewal,regId)" + "values(?,?,?,?,?,?,?,?,?)";

		try {
			preparedStatement = connection.prepareStatement(insertStatetment);

			preparedStatement.setString(1, subscription.getId());
			preparedStatement.setString(2, subscription.getDateOfPurchase());
			preparedStatement.setString(3, subscription.getExpiryDate());
			preparedStatement.setInt(4, subscription.getAmount());
			preparedStatement.setString(5, subscription.getPaymentMode());
			preparedStatement.setString(6, subscription.getStatus());
			preparedStatement.setString(7, subscription.getType());
			preparedStatement.setString(8, subscription.getAutoRenewal());
			preparedStatement.setString(9, subscription.getRegId());

			int result = preparedStatement.executeUpdate();
			
			if (result > 0) {
				connection.commit();
				return "success";
			} else {
				connection.rollback();
				return "fail";
			}
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {

				e1.printStackTrace();
			}
			e.printStackTrace();
			return "fail";
		}
		
	}
	
	@Override
	public String deleteSubscription(String id) throws IdNotFoundException {

		Connection connection = dbUtils.getConnection();
		PreparedStatement preparedStatement;
		String deleteStatetment = "delete from login where userName=?";
		connection = dbUtils.getConnection();

		try {
			preparedStatement = connection.prepareStatement(deleteStatetment);
			preparedStatement.setString(1, id);

			int result = preparedStatement.executeUpdate();

			if (result > 0) {
				connection.commit();
				return "success";
			} else {
				connection.rollback();
				return "fail";
			}
		} catch (SQLException e) {

			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
			return "fail";
		} finally {
			dbUtils.closeConnection(connection);
		}
	}
	
	@Override
	public String modifySubscription(String id, Subscription subscription) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Optional<Subscription> getSubscriptionById(String id) throws IdNotFoundException, InvalidIdLengthException, InvalidAmountException {
		// TODO Auto-generated method stub
		Connection connection = dbUtils.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		String selectStatement = "select * from subscription where id=?";

		try {
			preparedStatement = connection.prepareStatement(selectStatement);
			preparedStatement.setString(1, id);

			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {

				Subscription Sub = new Subscription();
				Sub.setId(resultSet.getString("id"));
				Sub.setDateOfPurchase(resultSet.getString("dop"));
				Sub.setExpiryDate(resultSet.getString("expiry"));
				Sub.setAmount(resultSet.getInt("amount"));
				Sub.setPaymentMode(resultSet.getString("paymentMode"));
				Sub.setStatus(resultSet.getString("status"));
				Sub.setType(resultSet.getString("type"));
				Sub.setAutoRenewal(resultSet.getString("autoRenewal"));
				Sub.setRegId(resultSet.getString("regId"));
				return Optional.of(Sub);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbUtils.closeConnection(connection);
		}

		return Optional.empty();
	}
	@Override
	public Optional<ArrayList<Subscription>> getAllSubscription() throws InvalidIdLengthException, InvalidAmountException {
		// TODO Auto-generated method stub
		Connection connection = dbUtils.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		ArrayList<Subscription> arrayList = new ArrayList<>();

		String selectStatement = "select * from subscription";

		try {
			preparedStatement = connection.prepareStatement(selectStatement);

			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				Subscription Sub = new Subscription();
				Sub.setId(resultSet.getString("id"));
				Sub.setDateOfPurchase(resultSet.getString("dop"));
				Sub.setExpiryDate(resultSet.getString("expiry"));
				Sub.setAmount(resultSet.getInt("amount"));
				Sub.setPaymentMode(resultSet.getString("paymentMode"));
				Sub.setStatus(resultSet.getString("status"));
				Sub.setType(resultSet.getString("type"));
				Sub.setAutoRenewal(resultSet.getString("autoRenewal"));
				Sub.setRegId(resultSet.getString("regId"));
				arrayList.add(Sub);

			}

			return Optional.ofNullable(arrayList); // since we are not 100% sure abt the outcome

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			dbUtils.closeConnection(connection);
		}

		return Optional.empty();
	}
	}
	
  
//	@Override
//	public String addSubscription(Subscription subscription) {
//		// TODO Auto-generated method stub
//		if(count == subscriptions.length-1) {
//			Subscription temp[] = new Subscription[subscriptions.length*4];
//		    System.arraycopy(subscription, 0, temp, 0, subscriptions.length);
//		    subscriptions = temp;
//		    subscriptions[++count] = subscription;
//		    
//		    return "success1";
//		}
//		subscriptions[++count] = subscription;
//	    return "success1";
//	}
//
//	@Override
//	public String deleteSubscription(String id) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public String modifySubscription(String id, Subscription subscription) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Subscription getSubscriptionById(String id) {
//		// TODO Auto-generated method stub
//		for (Subscription subscription : subscriptions) {
//			if(subscription!=null && subscription.getId().equals(id))
//				return subscription;		
//		}
//		return null;
//	}
//
//	@Override
//	public Subscription[] getAllSubscription() {
//		// TODO Auto-generated method stub
//		return subscriptions;
//	}


