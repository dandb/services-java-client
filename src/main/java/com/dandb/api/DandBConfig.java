package com.dandb.api;

import retrofit.RestAdapter.LogLevel;

public class DandBConfig {

	private String clientId;
	private String clientSecret;
	private String accessToken;
	private String endpoint;
	private boolean testMode;
	private LogLevel logLevel = LogLevel.BASIC;

	private DandBConfig(String clientId, String clientSecret,
			String accessToken, String endpoint, boolean testMode, LogLevel logLevel) {
		this.clientId = clientId;
		this.clientSecret = clientSecret;
		this.accessToken = accessToken;
		this.logLevel = logLevel;
		this.endpoint = endpoint;
		this.testMode = testMode;
	}
	
	public String getClientId() {
		return clientId;
	}

	public String getClientSecret() {
		return clientSecret;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public LogLevel getLogLevel() {
		return logLevel;
	}

	public String getEndpoint() {
		return endpoint;
	}
	
	public boolean ready(){
		return accessToken != null || (clientId != null && clientSecret != null);
	}

	public boolean isTestMode() {
		return testMode;
	}

	public static class Builder {
		private String clientId;
		private String clientSecret;
		private String accessToken;
		private String endpoint;
		private boolean testMode;
		private LogLevel logLevel = LogLevel.BASIC;

		public Builder setLogLevel(LogLevel logLevel) {
			if (logLevel == null) {
				throw new NullPointerException("Log level may not be null.");
			}
			this.logLevel = logLevel;
			return this;
		}
		
		public Builder setClientId(String clientId) {
			if (clientId == null) {
				throw new NullPointerException("Log level may not be null.");
			}
			this.clientId = clientId;
			return this;
		}
		
		public Builder setClientSecret(String clientSecret) {
			if (clientSecret == null) {
				throw new NullPointerException("Log level may not be null.");
			}
			this.clientSecret = clientSecret;
			return this;
		}
		
		public Builder setAccessToken(String accessToken) {
			this.accessToken = accessToken;
			return this;
		}
		
		public Builder setEndpoint(String endpoint) {
			if (endpoint == null) {
				throw new NullPointerException("Log level may not be null.");
			}
			this.endpoint = endpoint;
			return this;
		}
		
		public Builder setTestMode(boolean testMode){
			this.testMode = testMode;
			return this;
		}
		
		public DandBConfig build(){
			return new DandBConfig(clientId, clientSecret, accessToken, endpoint, testMode, logLevel);
		}

	}

}
