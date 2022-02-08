package com.zee.zee5app.dto;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name="login")
public class Login implements Comparable<Login> {
	@Id
    @Column(name="userName")
	@Email
	private String userName;
	@NotBlank
	private String password;
	@NotBlank
	private String regId;
//	@NotNull
//	private Role role;
	@OneToOne(fetch = FetchType.LAZY)
	@JsonIgnoreProperties(value = {"hibernateLazyInitializer","handler"})
	@JoinColumn(name="regId")
	@JsonProperty(access = Access.WRITE_ONLY)
	private Register register;
	
	@Override
	public int compareTo(Login o) {
		// TODO Auto-generated method stub
		return o.userName.compareTo(this.getUserName());
	}


	
}