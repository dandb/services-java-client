package com.dandb.api.test;

import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.POST;

import com.dandb.api.UserService;
import com.dandb.api.dto.ResponseSuccess;
import com.dandb.api.exceptions.UserAuthException;
import com.dandb.dto.UserToken;

public class UserServiceStub implements UserService{

	@POST("/v1/user/accept-tos")
	public ResponseSuccess acceptTermsOfService() throws UserAuthException{
		return ResponseSuccess.init(true);
	}
	
	@FormUrlEncoded
	@POST("/v1/user/token")
	public UserToken login(@Field("email") String username, @Field("password") String password) throws UserAuthException{
		return UserToken.init();
	}

}
