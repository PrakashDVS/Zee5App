package com.zee.zee5app.dto;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

import com.zee.zee5app.exception.InvalidEmailException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.InvalidNameException;
import com.zee.zee5app.exception.InvalidPasswordException;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name="register")
public class Register implements Comparable<Register>
{
	
	

    @Id
    @Column(name="regId")
    @Length(min = 6)
	private String id;
	// it should have min length of 6.
	// we have to write a code to validate the length and 
	// then assign the value.
//	@Setter(value = AccessLevel.NONE)
    @Size(max=50)
//    @NotNull
    @NotBlank
	private String firstName;
//	@Setter(value = AccessLevel.NONE)
    @Size(max=50)
    @NotBlank
	private String lastName;
//	@Setter(value = AccessLevel.NONE)
    @Size(max=50)
//    @NotNull
	private String email;
//	@Setter(value = AccessLevel.NONE)
    @Size(max=100)
//    @NotNull
	private String password;
    @NotNull
	private BigInteger contactNumber;
//	public Register(String id, String firstName, String lastName, String email, String password , BigDecimal contactNumber)
//			throws InvalidIdLengthException, InvalidNameException, InvalidEmailException , InvalidPasswordException {
//		super();
//		this.setId(id);
//		this.setFirstName(firstName);
//		this.setLastName(lastName);
//		this.email = email;
//		this.password = password;
//		this.contactNumber = contactNumber;
//	}
//	
//	public Register() {
//		// EDC
//		// any kind of customization during the initialization of object
//		// then its better to introduce EDC or PC or both as per the need.
//		
//		System.out.println("hello ");
//	}

	public void setFirstName(String firstName) throws InvalidNameException {
		
		if(firstName==null || firstName=="" || firstName.length()<2) {
			throw new InvalidNameException("firstname is not valid");
		}
		this.firstName = firstName;
	}
	public void setLastName(String lastName) throws InvalidNameException {
		if(lastName==null || lastName=="" || lastName.length()<2) {
			throw new InvalidNameException("firstname is not valid");		
		}
		this.lastName = lastName;
	}
	public void setId(String id) throws InvalidIdLengthException {
		// throws : it will provide the list of exceptions may be raised
		// it will hold the list of checked exceptions.
		
		
		if(id.length()<6) {
			// it should raise the InvalidIdExcetpion
			// exception object is created by JVM .
			
			// user defined exception object must be raised 
			// by us
			throw new InvalidIdLengthException
			("id length is lessthan or eq to 6");
			// throw : it will throw the exception 
		}
		this.id = id;
	}

//	@Override
//	public int hashCode() {
//		return Objects.hash(email, firstName, id, lastName, password);
//	}

//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Register other = (Register) obj;
//		return Objects.equals(email, other.email) && Objects.equals(firstName, other.firstName)
//				&& Objects.equals(id, other.id) && Objects.equals(lastName, other.lastName)
//				&& Objects.equals(password, other.password);
//	}
	public void setEmail(String email) throws InvalidEmailException {
		//check for email ending with and @
		if(email.endsWith(".com")==false || email.indexOf("@")==-1)
			throw new InvalidEmailException("email invalid");
		this.email = email;
	}

	public void setPassword(String password) throws InvalidPasswordException {
		if(password.matches("[A-Za-z0-9]+") == false || !(Character.isUpperCase(password.charAt(0))))
			throw new InvalidPasswordException("password should only contain alphanumeric characters and first letter uppercase");
		this.password = password;
	}

	
	
	// private stuff will be accessible only inside the class.
	
	// setter : is used to set the value for a particular field.
	// getter : to get/return the value of a specific field

	
	@ManyToMany
	@JoinTable(name = "user_roles",joinColumns = @JoinColumn(name = "regId"),
	inverseJoinColumns = @JoinColumn(name = "roleId"))
	private Set<Role> roles = new HashSet<Role>();
	@OneToOne(mappedBy = "register", cascade = CascadeType.ALL)
	private Subscription subscription;
	@OneToOne(mappedBy = "register", cascade = CascadeType.ALL)
	private Login login;
//	@OneToOne(mappedBy = "register", cascade = CascadeType.ALL)
//	private Subscription subscription;
    
//	@OneToOne(mappedBy = "register", cascade = CascadeType.ALL)
//	private Login login;
	@Override
	public int compareTo(Register o) {
		// TODO Auto-generated method stub
		return o.id.compareTo(this.id);
	}
	public void setContactNumber(BigDecimal bigDecimal) {
		// TODO Auto-generated method stub
		
	}
}