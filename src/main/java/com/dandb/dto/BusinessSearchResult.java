package com.dandb.dto;

import java.io.Serializable;

public class BusinessSearchResult implements Serializable{

	private static final long serialVersionUID = 6509753369604474439L;
	
	public String duns;
	public String name;
	public String address;
	public String city;
	public String state;
	public String zip;
	public Integer branch_indicator;
	public String location_type;
	public String phone;
	
	public static BusinessSearchResult init(){
		BusinessSearchResult businessSearchResult = new BusinessSearchResult();
		businessSearchResult.duns = "000000020";
		return businessSearchResult;
	}
	
}