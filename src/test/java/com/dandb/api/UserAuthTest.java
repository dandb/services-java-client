package com.dandb.api;

import org.junit.Before;
import org.junit.Test;

import com.dandb.dto.AccessToken;
import com.dandb.dto.BusinessSearchResults;
import com.dandb.dto.UserAuthRequest;
import com.dandb.dto.UserToken;
import com.dandb.dto.verified.VerifiedBusiness;

public class UserAuthTest {

	DandB dandb;
	
	@Before
	public void setUp(){
		dandb = new DandB();
	}
	
	@Test
	public void testAuth() {
		UserToken searchBusinesses = dandb.userAuth().authenticate(new UserAuthRequest("cmayfield1@yopmail.com", ""));
		String test = searchBusinesses.user_token;
	}

}
