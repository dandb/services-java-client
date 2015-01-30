package com.dandb.dto;

import java.math.BigInteger;
import java.util.Random;

public class BusinessSearchResult {

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