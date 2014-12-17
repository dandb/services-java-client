package com.dandb.api;

import retrofit.http.Body;
import retrofit.http.Headers;
import retrofit.http.POST;

import com.dandb.dto.AccessToken;
import com.dandb.dto.UserAuthRequest;
import com.dandb.dto.UserToken;

public interface UserAuth {

	@Headers("Content-Type: application/json")
	@POST("/v1/user/token")
	public UserToken authenticate(@Body UserAuthRequest oauthRequest);

}
