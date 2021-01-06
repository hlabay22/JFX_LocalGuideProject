package Model;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map.Entry;

import application.Main;

public class LocalGuide extends User implements java.io.Serializable {
	
	protected Double rating;
	protected int raters=0;
	protected ArrayList<LocalDate> unavailableDates=new ArrayList<LocalDate>();
	protected ArrayList<Place> localGuidePlaces=new ArrayList<Place>();
	protected ArrayList<TravelOption> localGuideTravels=new ArrayList<TravelOption>();
	
	SystemGuide4u system = Main.system;




	public LocalGuide(String email, String password, String firstName, String lastName, LocalDate dateOfBirth, Gender gender,
			String city, String country, Integer phoneNumber, Language language, TravelStyle travelStyle,
			String aboutMe, boolean emailNotifacations) {
		super(email, password, firstName, lastName, dateOfBirth, gender, city, country, phoneNumber, language, travelStyle,
				aboutMe, emailNotifacations);
		
	}
	
	public Double getRating() {
//		this.setRating();
		return rating;
	}
	
	public String getRatingAsString() {
		if(rating == null)
			return "X.X";
		else 
			return rating.toString(this.rating);
	}

//	public void setRating(Double rating) {
//		this.rating = rating;
//	}
	
//	public void setRating() {
//
//		int cnt = 0;
//		double sumRating = 0;
//		for (Review r : system.getReviewsList() ) {
//			if(r.getLocalGuide().getEmail().equals(this.email)) {
//				sumRating = sumRating+r.getRating(); 
//				cnt++;
//			}
//		}
//		
//		Double newRating = sumRating/cnt;
//		setRating(newRating);
//	}
	
	public void setRating(Double rating) {
		this.rating = rating;
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
	

	public ArrayList<Place> getLocalGuidePlaces() {
		return localGuidePlaces;
	}

	public ArrayList<TravelOption> getLocalGuideTravels() {
		return localGuideTravels;
	}


	public void setUnavailableDates(ArrayList<LocalDate> unavailableDates) {
		this.unavailableDates = unavailableDates;
	}
	
	public void computeRating() {
		
		double sum=0.0;
		int cnt=0;
		
		for (Entry<Integer, Review> value : this.system.getReviewsList().entrySet()) {
			  Review rev = value.getValue();
			  
			  if(rev.getLocalGuideEmail().equalsIgnoreCase(this.getEmail())) {
				  sum=sum+rev.getRating();
				  cnt++;
			  }
		}
		
		Double rating = sum/cnt;
		this.setRating(rating);
		
	}
	

	
	
	


}
