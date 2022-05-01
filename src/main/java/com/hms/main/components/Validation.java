package com.hms.main.components;

public class Validation {
	public boolean isNull(String str) {
		if(str.length() == 0) {
			return true;
		} return false;
	}
	
	public boolean validateSSN(String ssn) {
		if(ssn.length() == 9) return true;
		return false;
	}
	
	public boolean validateZipCode(String zip) {
		if(zip.length() == 5) return true;
		return false;
	}
	
	public boolean validInsurance(String insurance) {
		if(insurance.length() == 12) return true;
		return false;
	}
}
