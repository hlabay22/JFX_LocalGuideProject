package Model;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class LocalGuide extends User {
	
	protected Double rating;
	protected int raters=0;
	protected ArrayList<LocalDate> unavailableDates=new ArrayList<LocalDate>();




	public LocalGuide(String email, String password, String firstName, String lastName, LocalDate dateOfBirth, Gender gender,
			String city, String country, Integer phoneNumber, Language language, TravelStyle travelStyle,
			String aboutMe, boolean emailNotifacations) {
		super(email, password, firstName, lastName, dateOfBirth, gender, city, country, phoneNumber, language, travelStyle,
				aboutMe, emailNotifacations);
		
	}
	
	public Double getRating() {
		return rating;
	}
	
	public String getRatingAsString() {
		if(rating == null)
			return "X.X";
		else 
			return rating.toString(this.rating);
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}
	
	public void calcRating(Double rating) {
		Double newRating = (this.rating+rating)/++this.raters;
		setRating(newRating);
	}
	
	public String getLanguageForTable() {
		
		if ((this.getLanguage().getLanguage2()==null) && (this.getLanguage().getLanguage3()==null)) {
			return this.getLanguage().getLanguage1();
		}
		
		else if (this.getLanguage().getLanguage3()==null) {
			return this.getLanguage().getLanguage1()+","+this.getLanguage().getLanguage2(); 
		}
		else {
			return this.getLanguage().getLanguage1()+","+this.getLanguage().getLanguage2()+","+this.getLanguage().getLanguage3();
		}

	}
	
	public String getTravelStyleForTable() {
		if ((this.getTravelStyle().getTravelStyle2()==null) && (this.getTravelStyle().getTravelStyle3()==null)) {
			return this.getTravelStyle().getTravelStyle1();
		}
		
		else if (this.getTravelStyle().getTravelStyle3()==null) {
			return this.getTravelStyle().getTravelStyle1()+","+this.getTravelStyle().getTravelStyle2(); 
		}
		else {
			return this.getTravelStyle().getTravelStyle1()+","+this.getTravelStyle().getTravelStyle2()+","+this.getTravelStyle().getTravelStyle3();
		}
	}
	
	public String getDateOfBirthForTable() {
		//return this.getDateOfBirth().getDay()+"/"+getDateOfBirth().getMonth()+"/"+getDateOfBirth().getYear();
		return this.dateOfBirth.toString();
	}
	

	public ArrayList<LocalDate> getUnavailableDates() {
		return unavailableDates;
	}

	public void setUnavailableDates(ArrayList<LocalDate> unavailableDates) {
		this.unavailableDates = unavailableDates;
	}
	
	
	


}
