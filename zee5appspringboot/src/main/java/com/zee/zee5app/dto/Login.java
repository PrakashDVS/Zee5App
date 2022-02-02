package com.zee.zee5app.dto;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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
	private String userName;
	@NotBlank
	private String password;
	@NotBlank
	private String regId;
	@NotNull
	private ROLE role;
	
	@Override
	public int compareTo(Login o) {
		// TODO Auto-generated method stub
		return o.userName.compareTo(this.getUserName());
	}
}