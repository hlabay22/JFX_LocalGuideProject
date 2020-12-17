package Model;

import java.util.Date;
import java.util.HashMap;
import java.util.regex.Pattern;
import javafx.scene.control.TextField;


public class SystemGuide4u {
	protected HashMap<String, LocalGuide > localGuidesList;
	protected HashMap<String, Traveller > travellersList;
	protected static SystemGuide4u instance = new SystemGuide4u();


	public SystemGuide4u() {
		super();
		this.localGuidesList = new HashMap<String, LocalGuide>();
		this.travellersList = new HashMap<String, Traveller>();
	}
	public HashMap<String, LocalGuide> getLocalGuidesList() {
		return localGuidesList;
	}
	public void setLocalGuidesList(HashMap<String, LocalGuide> localGuidesList) {
		this.localGuidesList = localGuidesList;
	}
	public HashMap<String, Traveller> getTravellersList() {
		return travellersList;
	}
	public void setTravellersList(HashMap<String, Traveller> travellersList) {
		this.travellersList = travellersList;
	}
	public static SystemGuide4u getInstance() {
		return instance;
	}
	public static void setInstance(SystemGuide4u instance) {
		SystemGuide4u.instance = instance;
	}
    ///add
	public void addGuide(LocalGuide guide) {
		this.localGuidesList.put(guide.getEmail(), guide);
	}
	public void addTraveller(Traveller traveller) {
		this.travellersList.put(traveller.getEmail(), traveller);
	}
	//////rgx
	public boolean checkID(TextField id) {
		String regEx = "^[0-9]{9}$";
		if(id.getText().matches(regEx)) {
			return true;
		}
		return false;
	}
	
	public boolean checkPassword(TextField password) {
		String regEx = "^[a-z]{3}[0-9]{3}$";
		if(password.getText().matches(regEx)) {
			return true;
		}
		return false;
	}
	public boolean checkValidateEmail(String email){
		  return Pattern.matches("[_a-zA-Z1-9]+(\\.[A-Za-z0-9]*)*@[A-Za-z0-9]+\\.[A-Za-z0-9]+(\\.[A-Za-z0-9]*)*", email);
		}
	   public static boolean checkFirstName( String firstName ) {
	      return firstName.matches( "[A-Z][a-z]*" );
	   }
	   public static boolean checkLastName( String lastName ) {
	      return lastName.matches( "[A-Z]+([ '-][a-zA-Z]+)*" );
	   }
	   
	   ///get by email
	public LocalGuide getGuideByEmail(String mail) {
		LocalGuide localGuide = this.localGuidesList.get(mail);
		return localGuide;
	}
	public Traveller getTravellerByMail(String mail) {
		Traveller traveller=this.travellersList.get(mail);
		return traveller;
	}
	
	public boolean checkPasswordAndEmailGuide(String email, String password) {
		return password.equals(this.localGuidesList.get(email).password);
	}
	
	public boolean checkPasswordAndEmailTraveller(String email, String password) {
		return password.equals(this.travellersList.get(email).password);
	}
	
	// populate methods
	
	public void populateLocalGuideExample() {
		LocalGuide lg1 = new LocalGuide("xxx@gmail.com", "asd123", "Shim", "Metz", new Date(1992,2,5), Gender.Male, "Haifa", "Israel", 503309824 , new Language("Hebrew"), new TravelStyle("Hiking"), "I Love Food", true);
		lg1.setRating(7.8);
		this.localGuidesList.put(lg1.getEmail(), lg1);
		System.out.println("Populated");
		
	}
	
	public void populateTravellerExample() {
		Traveller t1 = new Traveller("har@gmail.com", "asd123", "Haron", "Labay", new Date(1992,2,5), Gender.Male, "Haifa", "Israel", 503309824 , new Language("Hebrew"), new TravelStyle("Hiking"), "I Love Food", true);
		this.travellersList.put(t1.getEmail(), t1);
		System.out.println("Populated Travellers");
		
	}
	
}
