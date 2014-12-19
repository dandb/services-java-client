package com.dandb.api;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.dandb.api.dto.ResponseSuccess;
import com.dandb.api.exceptions.ClientAuthException;
import com.dandb.api.exceptions.DandBApiException;
import com.dandb.api.exceptions.UserAuthException;
import com.dandb.dto.UserToken;

public class UserAuthTest {

	DandB dandb;
	
	@Before
	public void setUp() throws DandBApiException{
		dandb = new DandB(
					new DandBConfig.Builder()
						.setClientId("client")
						.setClientSecret("secret")
						.setEndpoint("localhost")
						.setTestMode(true)
						.build()
				);
	}
	
	@Test
	public void testAuth() throws UserAuthException, ClientAuthException {
		UserToken userToken = dandb.userLogin("test@yopmail.com", "Password");
	}
	
	@Test
	public void testAuthAcceptTOS() throws UserAuthException, ClientAuthException {
		String token = dandb.userLogin("test@yopmail.com", "Password").user_token;
		ResponseSuccess response = dandb.users(token).acceptTermsOfService();
		Assert.assertTrue(response.success);
	}

}
