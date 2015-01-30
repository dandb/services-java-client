package com.dandb.dto;

import java.util.ArrayList;
import java.util.List;

public class VerifiedBusinessSearchResults{

	public List<VerifiedBusinessSearchResult> results;
	
	public static VerifiedBusinessSearchResults init(){
	VerifiedBusinessSearchResults businessSearchResults = new VerifiedBusinessSearchResults();
		businessSearchResults.results = new ArrayList<VerifiedBusinessSearchResult>();
		businessSearchResults.results.add(VerifiedBusinessSearchResult.init());
		return businessSearchResults;
	}
	
}
