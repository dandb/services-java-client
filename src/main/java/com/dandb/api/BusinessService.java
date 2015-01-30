package com.dandb.api;

import retrofit.http.GET;
import retrofit.http.Query;

import com.dandb.dto.BusinessSearchResults;

public interface BusinessService {

	@GET("/v1/business/search")
	public BusinessSearchResults searchBusinesses(@Query("name") String name, @Query("address") String address, @Query("state") String state, @Query("city") String city, @Query("zip") String zip);
	
}
