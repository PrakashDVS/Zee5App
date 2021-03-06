package dto;

import exception.InvalidAmountException;
import exception.InvalidIdLengthException;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//@Data
@Setter
@Getter
@EqualsAndHashCode
@ToString
public class Subscription implements Comparable<Subscription>{
	
	public Subscription(){
		
	}

	public Subscription(String id, String type, String status, String dateOfPurchase,int amount,
			String regId, String paymentMode, String autoRenewal, String expiryDate) 
			throws InvalidIdLengthException, InvalidAmountException 
	{
		
		super();
		this.setId(id);
		this.type = type;
		this.status = status;
		this.dateOfPurchase = dateOfPurchase;
		this.setAmount(amount);
		this.RegId = regId;
		this.paymentMode = paymentMode;
		this.autoRenewal = autoRenewal;
		this.expiryDate = expiryDate;
	}

	@Setter(value = AccessLevel.NONE)
	private String id;
	private String type;
    private String dateOfPurchase;
    private String paymentMode;
    
    @Setter(value = AccessLevel.NONE)
    private int amount;
    
    private String status;
    private String autoRenewal;
    private String expiryDate;
    private String RegId;



	@Override
	public int compareTo(Subscription o) {
		// TODO Auto-generated method stub
		return this.id.compareTo(o.getId());
	}

	public void setId(String id) throws InvalidIdLengthException {
		if(id.length()<6)
			throw new InvalidIdLengthException("Id length cannot be less than 6");
		this.id = id;

	}

	public void setAmount(int amount) throws InvalidAmountException {
		if(amount < 1000)
			throw new InvalidAmountException("Amount cannot be less than 1000");
		this.amount = amount;
	}

	


}