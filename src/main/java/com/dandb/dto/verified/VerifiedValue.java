package com.dandb.dto.verified;

public class VerifiedValue {

    public String timestamp;
    public String verification_timestamp;
    public String verification_status;
    public String value;
    
    public static VerifiedValue init(){
    	return new VerifiedValue();
    }
    
    public String getValueOrNA(){
    	return hasValue() ? value : "N/A";
    }

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
    
    public boolean isNotVerifiedOrPending(){
    	return !this.isVerified() && !this.isPending();
    }
} 