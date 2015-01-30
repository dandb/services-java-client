package com.dandb.api;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import retrofit.RestAdapter.LogLevel;

import com.dandb.api.exceptions.ClientAuthException;
import com.dandb.api.exceptions.DandBApiException;
import com.dandb.dto.BusinessSearchResults;

public class BusinessTest extends ServiceTest{

	@Test
	public void testSearch() throws ClientAuthException {
		BusinessService business = dandb.business();
		BusinessSearchResults searchBusinesses = business.searchBusinesses("Google", "", "CA", "", "");
		Assert.assertTrue(searchBusinesses.results.get(0).duns.length() == 9);
	}
	
}
