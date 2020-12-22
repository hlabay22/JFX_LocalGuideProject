package Model;

import java.time.LocalDate;
import java.util.Date;

public class Traveller extends User implements java.io.Serializable{
	
	public Traveller(String email, String password,
			String firstName, String lastName, LocalDate dateOfBirth, 
			Gender gender,String city, String country, Integer phoneNumber,
			Language language, TravelStyle travelStyle,
			String aboutMe, boolean emailNotifacations) {
		
		
			super(email, password, firstName, lastName, dateOfBirth, 
				gender, city, country, phoneNumber, 
				language, travelStyle,aboutMe, emailNotifacations);
	}

}
