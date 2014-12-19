package com.dandb.api.exceptions;

import java.util.List;

public class ClientAuthException extends DandBApiException{

	public ClientAuthException(List<String> errors) {
		super(errors);
	}

	private static final long serialVersionUID = 7742982453403590326L;

}
