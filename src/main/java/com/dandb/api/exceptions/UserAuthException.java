package com.dandb.api.exceptions;

import java.util.List;

public class UserAuthException extends DandBApiException{

	public UserAuthException(List<String> errors) {
		super(errors);
	}

	private static final long serialVersionUID = 7742982453403590326L;

}
