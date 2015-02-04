package com.dandb.dto;

public class TradeReferenceRequest {
	
	public String targetCompanyDuns;
	public String referenceFirstName;
	public String referenceLastName;
	public String referenceTitle;
	public String referenceContactPreference;
	public String accountNumber;
	public String referenceEmail;
	public String referencePhone;
	public String referenceMobile;
	public String referenceFax;
	public TradeReferenceRequest(String targetCompanyDuns,
			String referenceFirstName, String referenceLastName,
			String referenceTitle, String referenceContactPreference) {
		this.targetCompanyDuns = targetCompanyDuns;
		this.referenceFirstName = referenceFirstName;
		this.referenceLastName = referenceLastName;
		this.referenceTitle = referenceTitle;
		this.referenceContactPreference = referenceContactPreference;
	}
	
}
