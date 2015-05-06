package com.dandb.api;

import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.POST;

import com.dandb.api.dto.ResponseSuccess;
import com.dandb.api.exceptions.UserAuthException;
import com.dandb.dto.UserEntitlements;
import com.dandb.dto.UserToken;

public interface UserService {

	@POST("/v1/user/accept-tos")
	public ResponseSuccess acceptTermsOfService() throws UserAuthException;
	
	@FormUrlEncoded
	@POST("/v1/user/token")
	public UserToken login(@Field("email") String username, @Field("password") String password) throws UserAuthException;

	@GET("/v1/user/entitlements")
	public UserEntitlements getUserEntitlements() throws UserAuthException;
}
