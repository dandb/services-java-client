package com.dandb.api.exceptions;

import java.util.List;

public class DandBApiException extends Exception{

	private static final long serialVersionUID = 6832048385352023972L;

	public DandBApiException(String message) {
		super(message);
	}

	public DandBApiException(List<String> errors){
		super(errors.toString());
	}

}
