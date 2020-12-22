package Model;

import java.awt.image.BufferedImage;
import java.time.LocalDate;
import java.util.Date;

public class User implements java.io.Serializable{
	
	// Attributes 
	
	protected String email;
	protected String password;
	protected String firstName;
	protected String lastName;
	protected LocalDate dateOfBirth;
	protected Gender gender;
	protected String city;
	protected String country;
	protected Integer phoneNumber;
	protected Language language;
	protected TravelStyle travelStyle;
	protected String aboutMe;
	protected boolean emailNotifacations;
	
	
	// C'tor 
	
	public User(String email, String password, String firstName, String lastName, LocalDate dateOfBirth, Gender gender,
			String city, String country, Integer phoneNumber, Language language, TravelStyle travelStyle,
			String aboutMe, boolean emailNotifacations) {
		super();
		this.email = email;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.city = city;
		this.country = country;
		this.phoneNumber = phoneNumber;
		this.language = language;
		this.travelStyle = travelStyle;
		this.aboutMe = aboutMe;
		this.emailNotifacations = emailNotifacations;
	}
	
	// Getters 


	public String getEmail() {
		return email;
	}


	public String getPassword() {
		return password;
	}


	public String getFirstName() {
		return firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}


	public Gender getGender() {
		return gender;
	}


	public String getCity() {
		return city;
	}


	public String getCountry() {
		return country;
	}


	public Integer getPhoneNumber() {
		return phoneNumber;
	}


	public Language getLanguage() {
		return language;
	}


	public TravelStyle getTravelStyle() {
		return travelStyle;
	}


	public String getAboutMe() {
		return aboutMe;
	}


	public boolean isEmailNotifacations() {
		return emailNotifacations;
	}

	
	
	// Setters 
	
	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void setPhoneNumber(Integer phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

	public void setTravelStyle(TravelStyle travelStyle) {
		this.travelStyle = travelStyle;
	}

	public void setAboutMe(String aboutMe) {
		this.aboutMe = aboutMe;
	}

	public void setEmailNotifacations(boolean emailNotifacations) {
		this.emailNotifacations = emailNotifacations;
	}
	
	
	
	

	

}
