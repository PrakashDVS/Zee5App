package com.learning.payload.request;

import java.util.Set;

import javax.validation.constraints.*;

import lombok.Data;

@Data
public class SignupRequest {

	  @NotBlank
	  @Size(min = 3, max = 20)
	  private String userName;
	  
	  @NotBlank
	  @Size(min = 3, max = 20)
	  private String name;
	  
	  @Size(min=3,max=50)
	  private String address;
	  

	  @NotBlank
	  @Size(max = 50)
	  @Email
	  private String email;

	  private Set<String> roles;

	  @NotBlank
	  @Size(min = 6, max = 40)
	  private String password;
}
