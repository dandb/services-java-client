package com.dandb.dto.verified;

public class VerifiedValue {

    public String timestamp;
    public String verification_timestamp;
    public String verification_status;
    public String value;

    public boolean hasValue(){
    	return value != null && !value.isEmpty();
    }
    
    public String verificationStatus(){
    	if(verification_status != null){
			if (this.isVerified()) {
				return "Verified";
			} else if (this.isPending()) {
				return "Pending";
			}
    	}
		return "Not Verified";
    }
    
    public boolean isVerified(){
    	return verification_status != null && verification_status.equals("VERIFIED");
    }
    
    public boolean isPending(){
    	return verification_status != null && verification_status.equals("PENDING");
    }
    
    public boolean isNotVerified(){
    	return !this.isVerified() || !this.isPending();
    }
} 