package Model;
import java.util.Date;

public class LocalGuide extends User {

	public LocalGuide(String email, String password, String firstName, String lastName, Date dateOfBirth, Gender gender,
			String city, String country, Integer phoneNumber, Language language, TravelStyle travelStyle,
			String aboutMe, boolean emailNotifacations) {
		super(email, password, firstName, lastName, dateOfBirth, gender, city, country, phoneNumber, language, travelStyle,
				aboutMe, emailNotifacations);
		
	}
	public String returnCityAndCountry () {
		return country+", "+city;
	}
	
	public String returnEmailandPassWord() {
		return this.email+","+this.password;
		
	}

}
