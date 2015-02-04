package com.dandb.api;

import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.Headers;
import retrofit.http.POST;
import retrofit.http.Path;
import retrofit.http.Query;

import com.dandb.api.dto.ResponseSuccess;
import com.dandb.dto.BusinessSearchResults;
import com.dandb.dto.TradeReferenceRequest;

public interface BusinessService {

	@GET("/v1/business/search")
	public BusinessSearchResults searchBusinesses(@Query("name") String name, @Query("address") String address, @Query("state") String state, @Query("city") String city, @Query("zip") String zip);
	
	@GET("/v1/business/search")
	public void searchBusinessesAsync(@Query("name") String name, @Query("address") String address, @Query("state") String state, @Query("city") String city, @Query("zip") String zip, Callback<BusinessSearchResults> callback);

	@Headers("Content-Type: application/json")
	@POST("/v1/business/{duns}/trade")
	public ResponseSuccess addTradeReference(@Path("duns") String duns, @Body TradeReferenceRequest tradeReferenceRequest);
	
	@Headers("Content-Type: application/json")
	@POST("/v1/business/{duns}/trade")
	public void addTradeReferenceAsync(@Path("duns") String duns, @Body TradeReferenceRequest tradeReferenceRequest, Callback<ResponseSuccess> callback);
	
}
