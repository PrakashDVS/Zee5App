package com.learning.entity;



import java.math.BigInteger;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

import com.learning.exception.InvalidPasswordException;


import lombok.AllArgsConstructor;
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
public class Register implements Comparable<Register> {
	   @Id
	    @Column(name="regId")
	    @GeneratedValue(strategy = GenerationType.AUTO)
		private int id;
		// it should have min length of 6.
		// we have to write a code to validate the length and 
		// then assign the value.
//		@Setter(value = AccessLevel.NONE)
	    @Size(max=50)
	    @NotNull
		private String name;

	    @Size(max=50)
	    @NotBlank
	    @Email
		private String email;
	    @Size(max=50)
	    @NotNull
		private String password;
	    @Size(max=100)
	    @NotBlank
	    private String address;



		
		public void setPassword(String password) throws InvalidPasswordException {
			if(password.matches("[A-Za-z0-9]+") == false || !(Character.isUpperCase(password.charAt(0))))
				throw new InvalidPasswordException("password should only contain alphanumeric characters and first letter uppercase");
			this.password = password;
		}

		
		
		// private stuff will be accessible only inside the class.
		
		// setter : is used to set the value for a particular field.
		// getter : to get/return the value of a specific field

		
	@Override
	public int compareTo(Register o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
