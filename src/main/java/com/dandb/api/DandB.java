package com.dandb.api;

import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.RestAdapter.LogLevel;
import retrofit.converter.GsonConverter;
import serial.MetaDeserializer;

import com.dandb.dto.AccessToken;
import com.dandb.dto.BusinessSearchResults;
import com.dandb.dto.MetaWrapper;
import com.dandb.dto.OAuthRequest;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class DandB {
	
	private Auth authService;
	
	private RestAdapter restAdapter;

	Gson gson = new GsonBuilder()
	    .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
	    .registerTypeAdapter(BusinessSearchResults.class, new MetaDeserializer<BusinessSearchResults>())
	    .create();

	protected AccessToken accessToken = new AccessToken();
	
	public DandB() {
		this.authService = this.getRestAdapterForAuth().create(Auth.class);
		this.restAdapter = this.getRestAdapter();
	}

	private RestAdapter getRestAdapter() {
		return new RestAdapter.Builder()
			.setEndpoint("https://api-qa.malibucoding.com")
			.setRequestInterceptor(requestInterceptor)
			.setLogLevel(LogLevel.FULL)
			.setConverter(new GsonConverter(gson))
			.build();
	}
	
	private RestAdapter getRestAdapterForAuth() {
		return new RestAdapter.Builder()
			.setEndpoint("https://api-qa.malibucoding.com")
			.build();
	}
	
	private RequestInterceptor requestInterceptor = new RequestInterceptor() {
		  public void intercept(RequestFacade request) {
			  if(accessToken.access_token == null){
				  accessToken = authService.authenticate(new OAuthRequest("cmayfield", ""));
			  }
			  request.addHeader("access-token", accessToken.access_token);
		  }
	};
	
	public Verified verified(){
		return restAdapter.create(Verified.class);
	}
	
}
