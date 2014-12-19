package com.dandb.api.exceptions;

import com.dandb.dto.MetaErrorWrapper;
import com.google.gson.JsonParseException;

public class DandBError extends JsonParseException{

	private static final long serialVersionUID = 4303281009152448007L;

	public MetaErrorWrapper metaErrorWrapper;

	public DandBError(String msg, MetaErrorWrapper metaErrorWrapper) {
		super(msg);
		this.metaErrorWrapper = metaErrorWrapper;
	}

	public DandBError(String string) {
		super(string);
	}
}
