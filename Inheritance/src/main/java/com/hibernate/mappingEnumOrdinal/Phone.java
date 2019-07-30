package com.hibernate.mappingEnumOrdinal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

@Entity(name = "Phone")
public class Phone {

	@Id
	private long id;

	@Column(name = "phone_number")
	private String phoneNumber;

	@Enumerated(EnumType.ORDINAL)
	@Column(name = "phone_type")
	private PhoneType phoneType;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public PhoneType getPhoneType() {
		return phoneType;
	}

	public void setPhoneType(PhoneType phoneType) {
		this.phoneType = phoneType;
	}

}
