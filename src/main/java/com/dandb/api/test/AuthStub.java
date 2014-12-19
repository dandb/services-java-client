package com.dandb.api.test;

import retrofit.http.Body;

import com.dandb.api.Auth;
import com.dandb.api.exceptions.ClientAuthException;
import com.dandb.dto.AccessToken;
import com.dandb.dto.OAuthRequest;

public class AuthStub implements Auth{

	public AccessToken authenticate(@Body OAuthRequest oauthRequest) throws ClientAuthException{
		return AccessToken.init();
	}

}

