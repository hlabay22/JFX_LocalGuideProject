package Model;

import java.time.LocalDate;

public class Review {
	
	// Attributes 
	
	LocalGuide localGuide;
	LocalDate date;
	Traveller traveller;
	String city;
	String country;
	String reviewText;
	Double rating;
	
	// C'tor 
	
	public Review(LocalGuide localGuide, LocalDate date, Traveller traveller, String city, String country,
			String reviewText, Double rating) {
		super();
		this.localGuide = localGuide;
		this.date = date;
		this.traveller = traveller;
		this.city = city;
		this.country = country;
		this.reviewText = reviewText;
		this.rating = rating;
	}


	// Getters 
	
	
	public LocalGuide getLocalGuide() {
		return localGuide;
	}

	public LocalDate getDate() {
		return date;
	}

	public Traveller getTraveller() {
		return traveller;
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
	
	public String getTravellerName() {
		return this.traveller.getFirstName()+" "+this.traveller.getLastName();
	}
	
	



	
	
	// Setters 
	
	public void setLocalGuide(LocalGuide localGuide) {
		this.localGuide = localGuide;
	}


	public void setDate(LocalDate date) {
		this.date = date;
	}


	public void setTraveller(Traveller traveller) {
		this.traveller = traveller;
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
		this.localGuide.calcRating(rating);
	}
	
	
	

}
