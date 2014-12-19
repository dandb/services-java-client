package com.dandb.dto.verified;

import java.math.BigInteger;
import java.text.MessageFormat;

public class VerifiedBusiness {
    public BusinessSource _source;
    public BigInteger _id;
    
    public static VerifiedBusiness init(){
    	//TODO add more test data
    	VerifiedBusiness verifiedBusiness = new VerifiedBusiness();
    	verifiedBusiness._source = BusinessSource.init();
    	verifiedBusiness._id = BigInteger.ONE;
		return verifiedBusiness;
    }
    
    public boolean isVerifiedOrPending(){
    	return isAddressVerifiedOrPending() || isEmailVerifiedOrPending() || isWebsiteVerifiedOrPending()
    			|| isCCVerifiedOrPending() || isPhoneVerifiedOrPending();
    }
    
    public Boolean isAddressVerifiedOrPending()
    {
        return !this._source.address.address_line_1.isNotVerifiedOrPending();
    }

    public Boolean isEmailVerifiedOrPending()
    {
        return !this._source.business.email_address.isNotVerifiedOrPending();
    }

    public Boolean isPhoneVerifiedOrPending()
    {
        return !this._source.business.phone.local_phone.isNotVerifiedOrPending();
    }

	public Boolean isWebsiteVerifiedOrPending()
    {
        return !this._source.business.website.isNotVerifiedOrPending();
    }

    public Boolean isCCVerifiedOrPending()
    {
        return !this._source.business.credit_card_verification_status.isNotVerifiedOrPending();
    }
    
    public String getPhoneNumber(){
    	String number = this._source.business.phone.local_phone.getValueOrNA();
		if(number.length() == 10){
			MessageFormat phoneFormat = new MessageFormat("({0})-{1}-{2}");
			String[] phoneNumArray={this._source.business.phone.local_phone.getValueOrNA().substring(0, 3),
					this._source.business.phone.local_phone.getValueOrNA().substring(3,6),
					this._source.business.phone.local_phone.getValueOrNA().substring(6)};
			return phoneFormat.format(phoneNumArray);
		} else {
			return number;
		}
    }
}
