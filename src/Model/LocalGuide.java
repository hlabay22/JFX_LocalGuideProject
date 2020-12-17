package Model;
import java.util.Date;

public class LocalGuide extends User {
	
	protected Integer rating;
	protected Integer raters=0;



	public LocalGuide(String email, String password, String firstName, String lastName, Date dateOfBirth, Gender gender,
			String city, String country, Integer phoneNumber, Language language, TravelStyle travelStyle,
			String aboutMe, boolean emailNotifacations) {
		super(email, password, firstName, lastName, dateOfBirth, gender, city, country, phoneNumber, language, travelStyle,
				aboutMe, emailNotifacations);
		
	}
	
	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}
	
	public void calcRating(Integer rating) {
		Integer newRating = (this.rating+rating)/++this.raters;
		setRating(newRating);
	}
	


}
