package com.dandb.api.test;

import java.util.ArrayList;

import retrofit.Callback;
import retrofit.client.Header;
import retrofit.client.Response;

import com.dandb.api.BusinessService;
import com.dandb.api.dto.ResponseSuccess;
import com.dandb.dto.BusinessDetail;
import com.dandb.dto.BusinessSearchResults;
import com.dandb.dto.TradeReferenceRequest;

public class BusinessServiceStub implements BusinessService{

	public BusinessSearchResults searchBusinesses(String name, String address,
			String state, String city, String zip) {
		return BusinessSearchResults.init();
	}

	public void searchBusinessesAsync(String name, String address,
			String state, String city, String zip,
			Callback<BusinessSearchResults> callback) {
		callback.success(BusinessSearchResults.init(), new Response("url", 200, "reason", new ArrayList<Header>(), null));
	}

	public ResponseSuccess addTradeReference(String duns,
			TradeReferenceRequest tradeReferenceRequest) {
		return ResponseSuccess.init(true);
	}

	public void addTradeReferenceAsync(String duns,
			TradeReferenceRequest tradeReferenceRequest,
			Callback<ResponseSuccess> callback) {
		callback.success(ResponseSuccess.init(true), new Response("url", 200, "reason", new ArrayList<Header>(), null));
		
	}

    public BusinessDetail getBusinessDetails(String duns) {
        // TODO Auto-generated method stub
        return new BusinessDetail();
    }

	
}
