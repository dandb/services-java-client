package com.dandb.dto.verified;

public class Address {

    public VerifiedValue address_line_1;
    public VerifiedValue postal_code;
    public VerifiedValue address_line_2;
    public VerifiedValue state;
    public VerifiedValue country;
    public VerifiedValue city;
	public static Address init() {
		Address address = new Address();
		address.address_line_1 = VerifiedValue.init();
		return address;
	}

}