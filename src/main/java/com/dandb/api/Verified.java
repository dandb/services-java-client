package com.dandb.api;

import java.math.BigInteger;

import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Path;
import retrofit.http.Query;

import com.dandb.dto.BusinessSearchResults;
import com.dandb.dto.verified.VerifiedBusiness;

public interface Verified {

	@GET("/v1/verified/search")
	public BusinessSearchResults searchBusinesses(@Query("keywords") String keywords);
	
	@GET("/v1/verified/{id}")
	public VerifiedBusiness fetchBusinessProfile(@Path("id") BigInteger businessId);
	
	@POST("/v1/verified/{id}/phone")
	public VerifiedBusiness phoneVerification(@Body BigInteger businessId);

}

