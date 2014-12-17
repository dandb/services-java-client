package com.dandb.dto;

public class UserAuthRequest {

	public String email;
	public String password;
	
	public UserAuthRequest(String email, String password){
		this.email = email;
		this.password = password;
	}
}
