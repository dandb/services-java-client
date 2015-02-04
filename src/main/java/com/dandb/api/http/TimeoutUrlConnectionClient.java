package com.dandb.api.http;

import java.io.IOException;
import java.net.HttpURLConnection;

import retrofit.client.Request;
import retrofit.client.UrlConnectionClient;

public class TimeoutUrlConnectionClient extends UrlConnectionClient{
	
	private int timeout;

	public TimeoutUrlConnectionClient(int timeout) {
		super();
		this.timeout = timeout;
	}
	
	@Override
	protected HttpURLConnection openConnection(Request request)
			throws IOException {
		HttpURLConnection openConnection = super.openConnection(request);
		openConnection.setReadTimeout(timeout);
		return openConnection;
	}
	

}
