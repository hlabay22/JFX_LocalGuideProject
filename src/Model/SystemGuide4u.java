package Model;

import java.awt.List;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.regex.Pattern;

import application.Main;

import java.util.ArrayList;
import java.util.Arrays;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


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
		LocalGuide lg1 = new LocalGuide("xxx@gmail.com", "asd123", "Shim", "Metz", LocalDate.of(1992,2,5), Gender.Male, "Haifa", "Israel", 503309824 , new Language("Hebrew"), new TravelStyle("Hiking"), "I Love Food", true);
		lg1.setRating(7.8);
		this.localGuidesList.put(lg1.getEmail(), lg1);
		System.out.println("Populated LocalGuides");
		
	}
	
	public void populateTravellerExample() {
		Traveller t1 = new Traveller("har@gmail.com", "asd123", "Haron", "Labay", LocalDate.of(1992,2,5), Gender.Male, "Haifa", "Israel", 503309824 , new Language("Hebrew"), new TravelStyle("Hiking"), "I Love Food", true);
		this.travellersList.put(t1.getEmail(), t1);
		System.out.println("Populated Travellers");
		
	}
	

	public void printAllData() {
		for(String mail: this.localGuidesList.keySet()) {
			LocalGuide temp=this.localGuidesList.get(mail);
			//System.out.println(temp.toString());
			System.out.print(temp.firstName+", ");
			System.out.println(temp.email);
			}
		for(String mail: this.travellersList.keySet()) {
			Traveller temp=this.travellersList.get(mail);
			//System.out.println(temp.toString());
			System.out.print(temp.firstName+", ");
			System.out.println(temp.email);
			}
		}
	
	
    public <T> void initCountryComBox(ComboBox<T> comBox) {
    	
    	ObservableList<String> countries = FXCollections.observableArrayList();
    	 String[] locales1 = Locale.getISOCountries();
         for (String countrylist : locales1) {
             Locale obj = new Locale("", countrylist);
             String[] city = { obj.getDisplayCountry() };
             for (int x = 0; x < city.length; x++) {
                 countries.add(obj.getDisplayCountry());
             }
         }
         comBox.setItems((ObservableList<T>) countries);
    }
    
//    public <T> void initLanguageComBox(ComboBox <T> comBox) {
//    	
//    	
//    	
//    	ObservableList<String> languages = FXCollections.observableArrayList();
//    	 String[] locales1 = Locale.getISOLanguages();
//         for (String languagelist : locales1) {
//             Locale obj = new Locale("", languagelist);
//             String[] lang = { obj.getDisplayLanguage() };
//             for (int x = 0; x < lang.length; x++) {
//            	 languages.add(obj.getDisplayLanguage());
//             }
//         }
//         comBox.setItems((ObservableList<T>) languages);
//         
//    }
    
    public <T> void initLanguageComBox(ComboBox <T> comBox) {
    	
        SortedSet<String> allLanguages = new TreeSet<String>();
        String[] languages = Locale.getISOLanguages();
        for (int i = 0; i < languages.length; i++){
            Locale loc = new Locale(languages[i]);
            allLanguages.add(loc.getDisplayLanguage());
        }
    	
    	ObservableList<String> languagesX = FXCollections.observableArrayList(allLanguages);
        comBox.setItems((ObservableList<T>) languagesX);
         
    }
    
    public void reloadLoginPage() {
    	try {
    		Stage primaryStage = new Stage();
			Parent root = FXMLLoader.load(Main.class.getResource("/FXML/Login.fxml"));
			Scene scene = new Scene(root,1130,725);
			scene.getStylesheets().add(Main.class.getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Guide4U - Login");
			primaryStage.initStyle(StageStyle.UNDECORATED);
			primaryStage.show();
			primaryStage.setResizable(false);
			
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
    }
    
    

    
 
    
    
	
	
}
	
