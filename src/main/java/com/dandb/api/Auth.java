package com.dandb.api;

import retrofit.http.Body;
import retrofit.http.Header;
import retrofit.http.Headers;
import retrofit.http.POST;

import com.dandb.dto.AccessToken;
import com.dandb.dto.OAuthRequest;

public interface Auth {

	@Headers("Content-Type: application/json")
	@POST("/v1/oauth/token")
	public AccessToken authenticate(@Body OAuthRequest oauthRequest);

}

