package dev.m3s.programming2.homework3;
import java.util.Random;

public abstract class Person extends PersonID {
	private String firstName = ConstantValues.NO_NAME;
	private String lastName = ConstantValues.NO_NAME;
	private String birthDate = ConstantValues.NOT_AVAILABLE;
	
	public Person(String lastName, String firstName) {
		if (firstName != null && lastName != null) {
			this.firstName = firstName;
			this.lastName = lastName;
		}
	}
	
	public void setFirstName(final String firstName) {
		if (firstName != null) {
			this.firstName = firstName;
		}
	}
	public String getFirstName() {
		if (firstName == null || firstName.isEmpty()) {
	        return ConstantValues.NO_NAME;
	    }
		return this.firstName;
	}
	
	public void setLastName(final String lastName) {
		if (lastName != null) {
			this.lastName = lastName;
		}
	}
	public String getLastName() {
		if (lastName == null || lastName.isEmpty()) {
	        return ConstantValues.NO_NAME;
	    }
		return this.lastName;
	}

	public String getBirthDate() {
		return this.birthDate;
	}
	
	public String setBirthDate(String personID) {
		String bd = "No change";
		final String personBd = getBirthDate();
		if (personID != null && setPersonID(personID) == "Ok") {
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
		}
		if (birthDate != personBd) {
			bd = this.birthDate;
	}
	return bd;
	}
	
	protected int getRandomId(final int min, final int max) {
	    Random random = new Random();
	    return random.nextInt(max - min + 1) + min;
	}
	
	abstract String getIdString();
}
