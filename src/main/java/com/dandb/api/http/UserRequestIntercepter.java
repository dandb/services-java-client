package com.dandb.api.http;

public class UserRequestIntercepter extends AuthRequestIntercepter {

	String userToken;
	
	public UserRequestIntercepter(String accessToken, String userToken) {
		super(accessToken);
		this.userToken = userToken;
	}
	
	public void intercept(RequestFacade request) {
		super.intercept(request);
		request.addQueryParam("user_token", userToken);
	}

}
