package com.dandb.dto;

import java.util.ArrayList;
import java.util.List;

public class BusinessSearchResults{

	public List<BusinessSearchResult> results;
	
	public static BusinessSearchResults init(){
	BusinessSearchResults businessSearchResults = new BusinessSearchResults();
		businessSearchResults.results = new ArrayList<BusinessSearchResult>();
		businessSearchResults.results.add(BusinessSearchResult.init());
		return businessSearchResults;
	}
	
}
