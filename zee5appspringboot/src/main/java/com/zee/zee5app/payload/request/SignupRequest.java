package com.zee.zee5app.payload.request;
import java.util.Set;

import javax.validation.constraints.*;

import lombok.Data;
@Data
public class SignupRequest {

	  @NotBlank
	  @Size(min = 3, max = 20)
	  private String username;

	  @Size(min=3,max=50)
	  @NotBlank
	  private String firstName;
	  
	  @Size(max=50)
	  @NotBlank
	  private String lastName; 
		
	  @Size(max = 50)
	  @Email
	  private String email;

	  private Set<String> roles;

	  @NotBlank
	  @Size(min = 6, max = 40)
	  private String password;
}