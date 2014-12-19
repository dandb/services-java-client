package com.dandb.api;

public class VerifyCodeRequest {
	
	public String verification_code;
	public String verification_type;

	public VerifyCodeRequest(String verificationCode, String verificationType) {
		this.verification_code = verificationCode;
		this.verification_type = verificationType;
	}
	
}
