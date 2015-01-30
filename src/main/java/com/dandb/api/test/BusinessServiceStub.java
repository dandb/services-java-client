package com.dandb.api.test;

import com.dandb.api.BusinessService;
import com.dandb.dto.BusinessSearchResults;

public class BusinessServiceStub implements BusinessService{

	public BusinessSearchResults searchBusinesses(String name, String address,
			String state, String city, String zip) {
		return BusinessSearchResults.init();
	}
	
}
