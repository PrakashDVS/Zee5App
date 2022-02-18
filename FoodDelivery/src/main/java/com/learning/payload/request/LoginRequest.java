package com.learning.payload.request;

import javax.validation.constraints.*;


public class LoginRequest {
	   @NotBlank
	   private String userName;

		@NotBlank
		private String password;

		public String getuserName() {
			return userName;
		}

		public void setuserName(String userName) {
			this.userName = userName;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
         }
}