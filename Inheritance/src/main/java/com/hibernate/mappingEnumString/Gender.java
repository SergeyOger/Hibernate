package com.hibernate.mappingEnumString;

public enum Gender {
	MALE('M'), FEMAIL('F');

	private final char code;

	private Gender(char code) {
		this.code = code;
	}

	public static Gender fromCode(char code) {
		if (code == 'M' || code == 'm') {
			return MALE;
		}
		if (code == 'F' || code == 'f') {
			return FEMAIL;
		}
		throw new UnsupportedOperationException("The code " + code + " is not supported");
	}

	public char getCode() {
		return code;
	}

}
