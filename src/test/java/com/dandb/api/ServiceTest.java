package com.dandb.api;

import org.junit.Before;

import retrofit.RestAdapter.LogLevel;

import com.dandb.api.exceptions.DandBApiException;

public class ServiceTest {

	DandB dandb;
	
	@Before
	public void setUp() throws DandBApiException{
		dandb = new DandB(new DandBConfig.Builder()
		.setClientId("client")
		.setClientSecret("secret")
		.setTestMode(true)
		.setLogLevel(LogLevel.FULL)
		.setEndpoint("https://api-qa.malibucoding.com").build());
	}
	
}
