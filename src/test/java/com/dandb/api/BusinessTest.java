package com.dandb.api;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.RestAdapter.LogLevel;
import retrofit.client.Response;

import com.dandb.api.dto.ResponseSuccess;
import com.dandb.api.exceptions.ClientAuthException;
import com.dandb.api.exceptions.DandBApiException;
import com.dandb.api.exceptions.UserAuthException;
import com.dandb.dto.BusinessSearchResults;
import com.dandb.dto.TradeReferenceRequest;
import com.dandb.dto.UserToken;

public class BusinessTest extends ServiceTest{

	@Test
	public void testSearch() throws ClientAuthException {
		BusinessService business = dandb.business();
		BusinessSearchResults searchBusinesses = business.searchBusinesses("Google", "", "CA", "", "");
		Assert.assertTrue(searchBusinesses.results.get(0).duns.length() == 9);
	}
	
	@Test
	public void testSearchAsync() throws ClientAuthException {
		BusinessService business = dandb.business();
		business.searchBusinessesAsync("Google", "", "CA", "", "", new Callback<BusinessSearchResults>() {
			
			public void success(BusinessSearchResults t, Response response) {
				Assert.assertTrue(t.results.get(0).duns.length() == 9);
			}
			
			public void failure(RetrofitError error) {
				Assert.fail("Got a failure: " + error.getMessage());
			}
		});
	}
	
	@Test
	public void testAddTradeReferenceAsync() throws ClientAuthException, InterruptedException, UserAuthException {
		BusinessService business = dandb.business();
		TradeReferenceRequest request = new TradeReferenceRequest("123456789", "John", "Smith", "Principal", "PHONE");
		final CountDownLatch latch = new CountDownLatch(1);
		UserToken userToken = dandb.userLogin("cameronjmayfield@gmail.com", "Pass@123");
		UserService users = dandb.users(userToken.user_token);
		users.acceptTermsOfService();
		business = dandb.business(userToken.user_token);
		business.addTradeReferenceAsync("123456789", request, new Callback<ResponseSuccess>() {
			
			public void success(ResponseSuccess t, Response response) {
				Assert.assertTrue(t.success);
				latch.countDown();
			}
			
			public void failure(RetrofitError error) {
				Assert.fail("Got a failure: " + error.getMessage());
				latch.countDown();
			}
		});
		latch.await(10, TimeUnit.SECONDS);
	}
	
}
