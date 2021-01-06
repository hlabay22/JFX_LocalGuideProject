package Model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicInteger;

import application.Main;

public class Review implements Serializable {
	
	// Attributes 
	
	protected static final AtomicInteger cnt = new AtomicInteger(9999);
	protected final Integer reviewID;
	protected String localGuideEmail;
	protected LocalDate date;
	protected String travellerEmail;
	protected String city;
	protected String country;
	protected String reviewText;
	protected Double rating;
	
	SystemGuide4u system = Main.system;
	
	// C'tor 
	
	public Review(String localGuideEmail, LocalDate date, String travellerEmail, String city, String country,
			String reviewText, Double rating) {
		super();
		this.reviewID = cnt.incrementAndGet();
		this.localGuideEmail = localGuideEmail;
		this.date = date;
		this.travellerEmail = travellerEmail;
		this.city = city;
		this.country = country;
		this.reviewText = reviewText;
		this.rating = rating;
	}
	
	public Review() {
		this.reviewID = cnt.incrementAndGet();
	}


	// Getters 
	
	public Integer getReviewID() {
		return reviewID;
	}
	
	
	public String getLocalGuideEmail() {
		return localGuideEmail;
	}

	public LocalDate getDate() {
		return date;
	}

	public String getTravellerEmail() {
		return travellerEmail;
	}
	
	public String getTraveller() {
		String travellerName = system.getTravellerByMail(travellerEmail).getFirstName()+" "+system.getTravellerByMail(travellerEmail).getLastName();
		return travellerName;
	}

	public String getCity() {
		return city;
	}

	public String getCountry() {
		return country;
	}

	public String getReviewText() {
		return reviewText;
	}

	public Double getRating() {
		return rating;
	}
	

	
	



	
	
	// Setters 
	
	public void setLocalGuideEmail(String localGuideEmail) {
		this.localGuideEmail = localGuideEmail;
	}


	public void setDate(LocalDate date) {
		this.date = date;
	}


	public void setTravellerEmail(String travellerEmail) {
		this.travellerEmail = travellerEmail;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public void setReviewText(String reviewText) {
		this.reviewText = reviewText;
	}


	public void setRating(Double rating) {
		this.rating = rating;

	}
	
	
	

}
