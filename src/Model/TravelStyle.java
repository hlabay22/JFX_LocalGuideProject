package Model;

public class TravelStyle {
	
	// Attributes
	
	protected String travelStyle1;
	protected String travelStyle2;
	protected String travelStyle3;
	
	

	
	// C'tor 
	
	public TravelStyle(String travelStyle1, String travelStyle2, String travelStyle3) {
		this.travelStyle1 = travelStyle1;
		this.travelStyle2 = travelStyle2;
		this.travelStyle3 = travelStyle3;
	}
	
	public TravelStyle(String travelStyle1, String travelStyle2) {
		this.travelStyle1 = travelStyle1;
		this.travelStyle2 = travelStyle2;
	}
	
	public TravelStyle(String travelStyle1) {
		this.travelStyle1 = travelStyle1;
	}

	// Getters 
	
	public String getTravelStyle1() {
		return travelStyle1;
	}

	public String getTravelStyle2() {
		return travelStyle2;
	}

	public String getTravelStyle3() {
		return travelStyle3;
	}


	
	// Setters 
	
	public void setTravelStyle1(String travelStyle1) {
		this.travelStyle1 = travelStyle1;
	}

	public void setTravelStyle2(String travelStyle2) {
		this.travelStyle2 = travelStyle2;
	}

	public void setTravelStyle3(String travelStyle3) {
		this.travelStyle3 = travelStyle3;
	}
	
	
	
	

}
