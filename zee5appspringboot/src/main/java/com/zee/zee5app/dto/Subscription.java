package com.zee.zee5app.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.zee.zee5app.exception.InvalidAmountException;
import com.zee.zee5app.exception.InvalidIdLengthException;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//@Data
@Setter
@Getter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="subscription")
public class Subscription implements Comparable<Subscription>{
	
//	public Subscription(){
//		
//	}
//
//	public Subscription(String id, String type, String status, String dateOfPurchase,int amount,
//			String regId, String paymentMode, String autoRenewal, String expiryDate) 
//			throws InvalidIdLengthException, InvalidAmountException 
//	{
//		
//		super();
//		this.setId(id);
//		this.type = type;
//		this.status = status;
//		this.dateOfPurchase = dateOfPurchase;
//		this.setAmount(amount);
//		this.RegId = regId;
//		this.paymentMode = paymentMode;
//		this.autoRenewal = autoRenewal;
//		this.expiryDate = expiryDate;
//	}
	@Id
    @Column(name="id")
	private String id;
	private String type;
	@NotNull
    private String dateOfPurchase;
	@NotBlank
	@Size(max = 10)
    private String paymentMode;
    @Setter(value = AccessLevel.NONE)
    @NotNull
    private int amount;
    @NotBlank
    @Size(max=5)
    private String status;
    @NotBlank
    @Size(max=5)
    private String autoRenewal;
    @NotNull
    private String expiryDate;
//    @NotBlank
//    private String RegId;



	

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

	@OneToOne
	@JoinColumn(name = "regId")
	@JsonProperty(access = Access.WRITE_ONLY)
	private Register register;
	@Override
	public int compareTo(Subscription o) {
		// TODO Auto-generated method stub
		return this.id.compareTo(o.getId());
	}


}