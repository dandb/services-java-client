package com.dandb.dto;

import java.util.List;

public class MetaErrorWrapper {
	
	public Meta meta;
	public List<String> error;

	public String getErrorCode(){
		return meta.error_code;
	}
	
	public List<String> getErrors(){
		return error;
	}
	
}
