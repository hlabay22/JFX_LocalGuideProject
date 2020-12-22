package Model;

public enum TransportationType implements java.io.Serializable{
	
	PublicTransport("Public Transportation"),PrivateVehicle("Private Vehicle");
	
	protected String name;
	
	private TransportationType(String name) {
		this.name = name;
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}
