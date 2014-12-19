package com.dandb.api.dto;

public class ResponseSuccess {

	public Boolean success;
	
	public static ResponseSuccess init(Boolean success){
		ResponseSuccess responseSuccess = new ResponseSuccess();
		responseSuccess.success = true;
		return responseSuccess;
	}
	
}
