package com.dandb.dto.verified;

public class Phone {

	public VerifiedValue fax;
	public VerifiedValue toll_free_number;
	public VerifiedValue local_phone;
	public static Phone init() {
		Phone phone = new Phone();
		phone.local_phone = VerifiedValue.init();
		return phone;
	}

}