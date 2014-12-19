package com.dandb.dto.verified;

public class Business {

    public VerifiedValue payment_methods;
    public VerifiedValue logo;
    public VerifiedValue services;
    public Phone phone;
    public VerifiedValue languages_spoken;
    public VerifiedValue photo1;
    public VerifiedValue website;
    public VerifiedValue hours_of_operation;
    public VerifiedValue score_indicator;
    public VerifiedValue award_certificates;
    public VerifiedValue video1;
    public VerifiedValue ownership_certificate;
    public VerifiedValue brands;
    public VerifiedValue credit_card_verification_status;
    public EntityType entity_type;
    public VerifiedValue products;
    public VerifiedValue award_certifications;
    public VerifiedValue year_established;
    public VerifiedValue email_address;
    public VerifiedValue tagline;
    public VerifiedValue qa_standards;
    public Localeze localeze;

    public Verified verified;
    public OwnerTypeStatus business_owner_type_status;
	public static Business init() {
		Business business = new Business();
		business.email_address = VerifiedValue.init();
		business.website = VerifiedValue.init();
		business.credit_card_verification_status = VerifiedValue.init();
		business.phone = Phone.init();
		return business;
	}

}