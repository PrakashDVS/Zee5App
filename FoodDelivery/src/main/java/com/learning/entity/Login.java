package com.learning.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

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
	@Table(name="logins")
	public class Login implements Comparable<Login> {
		@Id
	    @Column(name="userName")
		private String userName;
		@NotBlank
		private String password;
		@NotBlank
//		private String regId;
//		@OneToOne(fetch = FetchType.LAZY)
//		@JsonIgnoreProperties(value = {"hibernateLazyInitializer","handler"})
//		@JoinColumn(name="regId")
//		@JsonProperty(access = Access.WRITE_ONLY)
//		private Register register;
		
		@Override
		public int compareTo(Login o) {
			// TODO Auto-generated method stub
			return o.userName.compareTo(this.getUserName());
		}

		 @OneToOne(fetch = FetchType.LAZY)
		  @JoinColumn(name="regId")
		  @JsonIgnoreProperties({"hibernateLazyIntializer","handler"})
		  @JsonProperty(access = Access.WRITE_ONLY)
		  private Register register;
		
	}

