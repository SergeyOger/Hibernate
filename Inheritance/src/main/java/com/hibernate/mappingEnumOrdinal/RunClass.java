package com.hibernate.mappingEnumOrdinal;

public class RunClass {

	public static void main(String[] args) {

		Phone phone = new Phone();
		phone.setId(1L);
		phone.setPhoneNumber("21541653313213");
		phone.setPhoneType(PhoneType.MOBILE);
	}

	/*
	 * INSERT INTO Phone (phone_number, phone_type, id) VALUES
	 * ('123-456-78990','MOBILE', 1)
	 */

}
