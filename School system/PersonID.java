package dev.m3s.programming2.homework3;
import java.util.Scanner;
public class PersonID {
	private String birthDate = ConstantValues.NO_BIRTHDATE;
	
	public String getBirthDate() {
		return this.birthDate;
	}

	private boolean checkPersonIDNumber(final String IDNumber) {
	if (IDNumber != null && IDNumber.length() == 11) {
		if (IDNumber.charAt(6) == '+' || IDNumber.charAt(6) == '-' || IDNumber.charAt(6) == 'A') {
			return true;
		}
	}
	return false;
	}
	
	private boolean checkLeapYear(int year) {
		return year % 4 == 0 && (year % 100 != 0 || year % 400 == 0);
}

	    
	private boolean checkValidCharacter(final String personID){
		String characters = "0123456789ABCDEFHJKLMNPRSTUVWXY";
		String num = personID.substring(0,6);
		num += personID.substring(7,10);
		int number = Integer.parseInt(num);
		int res = number % 31;
		return (characters.charAt(res) == personID.charAt(10));
	}
	
	private boolean checkBirthDate(final String date) {
		boolean valid = true;
		Scanner scanner = new Scanner(date);
		Scanner s = scanner.useDelimiter("\\.");
		int day = s.nextInt();
		int month = s.nextInt();
		int year = s.nextInt();
		s.close();
		if (year < 0 || month < 1 || month > 12 || day < 1 || day > 31) {
			valid = false;
		}
		else {
			switch(month){
				case 4:
				case 6:
				case 9:
				case 11:
					if (day == 31)
						valid = false;
					break;
				case 2:
					if (day > 29)
						valid = false;
					if (day == 29)
						valid = checkLeapYear(year);
					break;
			}
		}
		scanner.close();
		return valid;
	}
	
	public String setPersonID(final String personID) {
		String Validity = ConstantValues.INVALID_BIRTHDAY;
		String birthDate;
		if (checkPersonIDNumber(personID)) {
			String day = personID.substring(0,2);
		    String month = personID.substring(2, 4);
		    String year = personID.substring(4,6);
		    switch (personID.charAt(6)) {
	        case 'A':
	            year = "20" + personID.substring(4, 6);
	            break;
	        case '-':
	            year = "19" + personID.substring(4, 6);
	            break;
	        case '+':
	            year = "18" + personID.substring(4, 6);
	            break;
		    }
		    birthDate = day + "." + month + "." + year;
		    if (checkBirthDate(birthDate)) {
		    	if (checkPersonIDNumber(personID)) {
		    		Validity = ConstantValues.INCORRECT_CHECKMARK;
		    		if (checkValidCharacter(personID)) {
		    			this.birthDate = birthDate;
		    			Validity = "Ok";
		    		}
		    	}
		    }
		}
		return Validity;
	}
	
}
