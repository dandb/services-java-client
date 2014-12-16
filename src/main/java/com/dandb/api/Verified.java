package com.dandb.api;

import java.math.BigInteger;

import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

import com.dandb.dto.BusinessProfile;
import com.dandb.dto.BusinessSearchResults;

public interface Verified {

	@GET("/v1/verified/search")
	public BusinessSearchResults searchBusinesses(@Query("keywords") String keywords);
	
	@GET("/v1/verified/{id}")
	public BusinessProfile fetchBusinessProfile(@Path("id") BigInteger businessId);

}

