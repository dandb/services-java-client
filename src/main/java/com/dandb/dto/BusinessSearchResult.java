package com.dandb.dto;

import java.math.BigInteger;
import java.util.Random;

public class BusinessSearchResult {

	public BigInteger business_id;
	public String phone_number;
	public String duns_number;
	public String country;
	public String address_line_1;
	public String address_line_2;
	public String company_name;
	public String postal_code;
	public String state;
	public String city;
	
	public static BusinessSearchResult init(){
		BusinessSearchResult businessSearchResult = new BusinessSearchResult();
		businessSearchResult.business_id = BusinessSearchResult.randomBigInt(BigInteger.valueOf(10000000));
		return businessSearchResult;
	}
	
	public static BigInteger randomBigInt(BigInteger max){
		Random rnd = new Random();
		int nlen = max.bitLength();
		BigInteger nm1 = max.subtract(BigInteger.ONE);
		BigInteger r, s;
		do {
		    s = new BigInteger(nlen + 100, rnd);
		    r = s.mod(max);
		} while (s.subtract(r).add(nm1).bitLength() >= nlen + 100);
		return s;
	}
	
}
