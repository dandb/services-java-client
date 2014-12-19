package com.dandb.api.http;

import retrofit.RequestInterceptor;

public class AuthRequestIntercepter implements RequestInterceptor {

	protected String accessToken;

	public AuthRequestIntercepter(String accessToken) {
		this.accessToken = accessToken;
	}

	public void intercept(RequestFacade request) {
		request.addHeader("access-token", accessToken);
	}

}
