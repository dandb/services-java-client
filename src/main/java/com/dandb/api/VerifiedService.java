package com.dandb.api;

import java.math.BigInteger;

import retrofit.http.Body;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.Headers;
import retrofit.http.POST;
import retrofit.http.PUT;
import retrofit.http.Path;
import retrofit.http.Query;

import com.dandb.api.dto.ResponseSuccess;
import com.dandb.api.exceptions.VerificationException;
import com.dandb.dto.VerifiedBusinessSearchResults;
import com.dandb.dto.PhoneRequest;
import com.dandb.dto.verified.VerifiedBusiness;

public interface VerifiedService {

	@GET("/v1/verified/search")
	public VerifiedBusinessSearchResults searchBusinesses(@Query("keywords") String keywords);
	
	@GET("/v2/verified/{id}")
	public VerifiedBusiness fetchBusinessProfile(@Path("id") BigInteger businessId) throws VerificationException;
	
	@Headers("Content-Type: application/json")
	@POST("/v1/verified/{id}/phone")
	public ResponseSuccess phoneVerification(@Body PhoneRequest phoneRequest, @Path("id") BigInteger businessId) throws VerificationException;
	
	@Headers("Content-Type: application/json")
	@POST("/v1/verified/{id}/verify")
	public ResponseSuccess verifyCompany(@Body VerifyCodeRequest verifyCodeRequest, @Path("id") BigInteger businessId) throws VerificationException;

	@PUT("/v1/verified/{id}")
	@FormUrlEncoded
	public ResponseSuccess updatePhoneNumber(@Field("phone_number") String phoneNumber, @Path("id") BigInteger businessId) throws VerificationException;
	
}
