package Model;

import java.util.concurrent.atomic.AtomicInteger;

public class Place implements java.io.Serializable{
	protected String localGuideEmail;
	protected String name;
	protected String city;
	protected String country;
	protected String info;
	protected static final AtomicInteger cnt = new AtomicInteger(9999);
	protected final Integer placeID;

	public Place(String localGuideEmail,String name, String city, String country) {
		this.placeID = cnt.incrementAndGet();
		this.localGuideEmail = localGuideEmail;
		this.name = name;
		this.city = city;
		this.country = country;
	}
	
	
	// Getters 

	public String getName() {
		return name;
	}
	
	public String getCity() {
		return city;
	}
	
	public String getCountry() {
		return country;
	}
	
	public String getInfo() {
		return info;
	}
	
	public Integer getPlaceID() {
		return placeID;
	}
	
	public String getLocalGuideEmail() {
		return localGuideEmail;
	}




	
	// Setters 

	public void setName(String name) {
		this.name = name;
	}

	

	public void setCity(String city) {
		this.city = city;
	}



	public void setCountry(String country) {
		this.country = country;
	}



	public void setInfo(String info) {
		this.info = info;
	}
	
	public void setLocalGuideEmail(String localGuideEmail) {
		this.localGuideEmail = localGuideEmail;
	}
	




	
	
}
