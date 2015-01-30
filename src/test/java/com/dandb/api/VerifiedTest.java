package com.dandb.api;

import org.junit.Test;

import com.dandb.api.exceptions.ClientAuthException;
import com.dandb.api.exceptions.DandBApiException;
import com.dandb.api.exceptions.VerificationException;
import com.dandb.dto.PhoneRequest;
import com.dandb.dto.VerifiedBusinessSearchResults;
import com.dandb.dto.verified.VerifiedBusiness;

public class VerifiedTest extends ServiceTest {

	@Test
	public void testSearch() throws ClientAuthException {
		dandb.verified().searchBusinesses("Google");
	}
	
	@Test
	public void testFetch() throws ClientAuthException, VerificationException {
		VerifiedBusinessSearchResults searchBusinesses = dandb.verified().searchBusinesses("Google");
		VerifiedBusiness fetchBusinessProfile = dandb.verified().fetchBusinessProfile(searchBusinesses.results.get(0).business_id);
		fetchBusinessProfile.isVerifiedOrPending();
	}
	
 	@Test
	public void testVerifyByPhone() throws DandBApiException {
 		String userToken = dandb.userLogin("test@test.com", "password").user_token;
		VerifiedBusinessSearchResults searchBusinesses = dandb.verified().searchBusinesses("Google");
		VerifiedBusiness fetchBusinessProfile = dandb.verified().fetchBusinessProfile(searchBusinesses.results.get(0).business_id);
		dandb.verified(userToken).phoneVerification(new PhoneRequest(fetchBusinessProfile._source.business.phone.local_phone.value), fetchBusinessProfile._id);
		dandb.verified(userToken).verifyCompany(new VerifyCodeRequest("111111", "PHONE"), fetchBusinessProfile._id);
	}

}
