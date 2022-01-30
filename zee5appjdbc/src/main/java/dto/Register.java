package dto;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Objects;

import exception.InvalidEmailException;
import exception.InvalidIdLengthException;
import exception.InvalidNameException;
import exception.InvalidPasswordException;

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
@ToString
//@EqualsAndHashCode
//@NoArgsConstructor
//AllArgsConstructor
public class Register implements Comparable<Register>
{
	
	public Register(String id, String firstName, String lastName, String email, String password)
			throws InvalidIdLengthException, InvalidNameException, InvalidEmailException , InvalidPasswordException {
		super();
		this.setId(id);
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.email = email;
		this.password = password;
//		this.contactNumber = contactNumber;
	}
	@Setter(value = AccessLevel.NONE)
	private String id;
	// it should have min length of 6.
	// we have to write a code to validate the length and 
	// then assign the value.
	@Setter(value = AccessLevel.NONE)
	private String firstName;
	@Setter(value = AccessLevel.NONE)
	private String lastName;
	private String email;
	private String password;
	private BigDecimal contactNumber;
	
	public Register() {
		// EDC
		// any kind of customization during the initialization of object
		// then its better to introduce EDC or PC or both as per the need.
		
		System.out.println("hello ");
	}

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

	@Override
	public int hashCode() {
		return Objects.hash(email, firstName, id, lastName, password);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Register other = (Register) obj;
		return Objects.equals(email, other.email) && Objects.equals(firstName, other.firstName)
				&& Objects.equals(id, other.id) && Objects.equals(lastName, other.lastName)
				&& Objects.equals(password, other.password);
	}
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

	@Override
	public int compareTo(Register o) {
		// TODO Auto-generated method stub
		return o.id.compareTo(this.id);
	}
	
	// private stuff will be accessible only inside the class.
	
	// setter : is used to set the value for a particular field.
	// getter : to get/return the value of a specific field

}