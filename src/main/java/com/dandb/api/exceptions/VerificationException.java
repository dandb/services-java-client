package com.dandb.api.exceptions;

import java.util.List;

public class VerificationException extends DandBApiException{

	private static final long serialVersionUID = 7742982453403590326L;

	public VerificationException(List<String> errors){
		super(errors);
	}
	
}
