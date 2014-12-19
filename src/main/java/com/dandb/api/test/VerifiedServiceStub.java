package com.dandb.api.test;

import java.math.BigInteger;

import retrofit.http.Body;
import retrofit.http.Field;
import retrofit.http.Path;
import retrofit.http.Query;

import com.dandb.api.VerifiedService;
import com.dandb.api.VerifyCodeRequest;
import com.dandb.api.dto.ResponseSuccess;
import com.dandb.api.exceptions.VerificationException;
import com.dandb.dto.BusinessSearchResults;
import com.dandb.dto.PhoneRequest;
import com.dandb.dto.verified.VerifiedBusiness;

public class VerifiedServiceStub implements VerifiedService{

	public BusinessSearchResults searchBusinesses(@Query("keywords") String keywords){
		return BusinessSearchResults.init();
	}
	
	public VerifiedBusiness fetchBusinessProfile(@Path("id") BigInteger businessId) throws VerificationException{
		return VerifiedBusiness.init();
	}
	
	public ResponseSuccess phoneVerification(@Body PhoneRequest phoneRequest, @Path("id") BigInteger businessId) throws VerificationException{
		return ResponseSuccess.init(true);
	}
	
	public ResponseSuccess verifyCompany(@Body VerifyCodeRequest verifyCodeRequest, @Path("id") BigInteger businessId) throws VerificationException{
		return ResponseSuccess.init(true);
	}

	public ResponseSuccess updatePhoneNumber(@Field("phone_number") String phoneNumber, @Path("id") BigInteger businessId) throws VerificationException{
		
		return ResponseSuccess.init(true);
	}
	
}
