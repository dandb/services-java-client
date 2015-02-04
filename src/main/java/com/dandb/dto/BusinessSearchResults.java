package com.dandb.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class BusinessSearchResults implements Serializable{

	private static final long serialVersionUID = -4810405371590268897L;

	public List<BusinessSearchResult> results;
	
	public static BusinessSearchResults init(){
		BusinessSearchResults businessSearchResults = new BusinessSearchResults();
		businessSearchResults.results = new ArrayList<BusinessSearchResult>();
		businessSearchResults.results.add(BusinessSearchResult.init());
		return businessSearchResults;
	}
	
}
