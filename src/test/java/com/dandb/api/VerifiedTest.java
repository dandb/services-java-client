package com.dandb.api;

import org.junit.Before;
import org.junit.Test;

import com.dandb.dto.BusinessProfile;
import com.dandb.dto.BusinessSearchResults;

public class VerifiedTest {

	DandB dandb;
	
	@Before
	public void setUp(){
		dandb = new DandB();
	}
	
	@Test
	public void testSearch() {
		BusinessSearchResults searchBusinesses = dandb.verified().searchBusinesses("Google");
	}
	
	@Test
	public void testFetch() {
		BusinessSearchResults searchBusinesses = dandb.verified().searchBusinesses("Google");
		BusinessProfile fetchBusinessProfile = dandb.verified().fetchBusinessProfile(searchBusinesses.results.get(0).business_id);
	}

}
