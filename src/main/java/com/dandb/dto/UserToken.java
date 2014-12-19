package com.dandb.dto;


public class UserToken {
    public String user_token;
    public String expires_in;
    public String token_type;
    public String scope;
    public String refresh_token;
    
	public static UserToken init() {
		UserToken userToken = new UserToken();
		userToken.user_token = "someusertoken";
		return userToken;
	}
}
