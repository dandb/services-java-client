package com.dandb.dto;

import com.google.gson.annotations.SerializedName;

public class OAuthRequest {

	@SerializedName("client_id")
	public String client_id;
	@SerializedName("client_secret")
	public String client_secret;
	@SerializedName("grant_type")
	public String grant_type;
	
	public OAuthRequest(String clientId, String clientSecret){
		this.client_id = clientId;
		this.client_secret = clientSecret;
		this.grant_type = "client_credentials";
	}
	
}

