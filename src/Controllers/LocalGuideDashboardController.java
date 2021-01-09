package Controllers;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.Map.Entry;

import Model.*;
import application.Main;
import application.SqlTest;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class LocalGuideDashboardController implements Initializable {

    @FXML
    private Label lblTitle;

    @FXML
    private Button btnLogOut;

    @FXML
    private Label lblUserName;

    @FXML
    private TabPane tabPaneLocalGuide;

    @FXML
    private Tab tabHome;

    @FXML
    private Tab tabLocalGuideProfile;

    @FXML
    private TextField txtEmail;

    @FXML
    private Label lblEmail;

    @FXML
    private Label lblFirstName;

    @FXML
    private TextField txtFirstName;

    @FXML
    private Label lblLastName;

    @FXML
    private TextField txtLastName;

    @FXML
    private Label lblDOB;

    @FXML
    private DatePicker comBoxDOB;

    @FXML
    private Label lblGender;

    @FXML
    private ComboBox<String> comBoxGender;

    @FXML
    private Label lblPhone;

    @FXML
    private TextField txtPhone;

    @FXML
    private TextField txtCity;

    @FXML
    private Label lblCity;

    @FXML
    private ComboBox<String> comBoxCountry;

    @FXML
    private Label lblCountry;

    @FXML
    private ComboBox<String> comBoxLang1;

    @FXML
    private Label lblLang1;

    @FXML
    private ComboBox<String> comBoxLang2;

    @FXML
    private Label lblLang2;

    @FXML
    private ComboBox<String> comBoxLang3;

    @FXML
    private Label lblLang3;

    @FXML
    private ComboBox<String> comBoxTravelStyle1;

    @FXML
    private Label lblTravelStyle1;

    @FXML
    private ComboBox<String> comBoxTravelStyle2;

    @FXML
    private Label lblTravelStyle2;

    @FXML
    private ComboBox<String> comBoxTravelStyle3;

    @FXML
    private Label lblTravelStyle3;

    @FXML
    private ComboBox<String> comBoxTransportType;

    @FXML
    private Label lblTransportType;

    @FXML
    private Label lblAboutMe;

    @FXML
    private TextArea txtAboutMe;

    @FXML
    private Tab tabAbout;
    
    @FXML
    private Group groupDetails;
    
    @FXML
    private Button btnEdit;
    

    @FXML
    private Button btnSaveEdit;
    
    @FXML
    private TableView<Review> tableReview;

    @FXML
    private TableColumn<Review, LocalDate> c1_Date;

    @FXML
    private TableColumn<Review, String> c2_travellerName;

    @FXML
    private TableColumn<Review, String> c3_city;

    @FXML
    private TableColumn<Review, String> c4_country;

    @FXML
    private TableColumn<Review, String> c5_reviewText;

    @FXML
    private TableColumn<Review, Double> c6_rating;

    @FXML
    private Label lblMangeAvailibilty;

    @FXML
    private DatePicker datePickAvailbilty;

    @FXML
    private Button btnUpdateAvailibilty;

    @FXML
    private Label lblNoteAvailibilty;
    
    @FXML
    private Label lblRating;

    @FXML
    private Label valueRating;
    
    @FXML
    private Button btnGoToMyPlacesAndTravels;

    @FXML
    private Label lblPlacesAndTravels;
 
    LocalGuide localGuide;

    SystemGuide4u system=Main.system; 
    
    static SqlTest sql = new SqlTest();
    
	private final ObservableList<Review> reviewData =
            FXCollections.observableArrayList();
    
    public LocalGuide getLocalGuide() {
		return localGuide;
	}

	public void setLocalGuide(LocalGuide localGuide) {
		this.localGuide = localGuide;
		this.lblUserName.setText(localGuide.getFirstName()+" "+localGuide.getLastName());
	}

	@FXML
    void btnLogOut(ActionEvent event) {
	   
	    	
	    	btnLogOut.getScene().getWindow().hide();
	    	system.reloadLoginPage();

	    
    }
	
    @FXML
    void btnEditClick(ActionEvent event) {
    	
    	setDataEditable(true);
    	initViewComboBox();
//    	initData();
    	
    	this.btnEdit.setVisible(false);
    	this.btnSaveEdit.setVisible(true);

    }
    

    @FXML
    void btnSaveEdit(ActionEvent event) {
    	
    	
    	updateChangesSQL();
    	setDataEditable(false);
    	initViewComboBox();
    	initData();
    	btnSaveEdit.setVisible(false);
    	btnEdit.setVisible(true);
    	
    	

    }
    //this.localGuide.getUnavailableDates().contains(date)
    @FXML
    void btnUpdateAvailibiltyClick(ActionEvent event) {
    	
    	LocalDate date = this.datePickAvailbilty.getValue();
    	
    	if(date != null) {
    		if(!system.getLocalGuidesList().get(this.localGuide.getEmail()).getUnavailableDates().contains(date)) {
    			sql.addLocalGuideUnavailibleDateToSQL(this.localGuide, date);
    			sql.initUnavailbleDates();
//    			this.localGuide.getUnavailableDates().add(date);
    			this.lblNoteAvailibilty.setText("** "+date+" Was Successfully set as Unavailable Date! **");
    			
    		}else {
    			this.lblNoteAvailibilty.setText("** "+date+" Is alreay set as Unavailable Date! **");
    		}
    	}

    }
    
    @FXML
    void btnGoToMyPlacesAndTravelsClick(ActionEvent event) {
    	loadPlacesAndTravels(this.localGuide);
    }
    
    public void loadPlacesAndTravels(LocalGuide localGuide2) {
		try {

			Stage stage=new Stage();
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/LocalGuidePlacesAndTravels.fxml"));
			Parent root = loader.load();
			Scene scene = new Scene(root);
			LocalGuidePlacesAndTravelsController placesAndTravelsController = loader.<LocalGuidePlacesAndTravelsController>getController();
			placesAndTravelsController.setLocalGuide(localGuide);
			placesAndTravelsController.initTablesData();
			placesAndTravelsController.setProfileData();
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			stage.setScene(scene);
			stage.setTitle("Guide4U - Local Guide Places & Travel Options");
			stage.initStyle(StageStyle.UNDECORATED);
			stage.show();
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
    
    public void updateChangesSQL() {
    	
    	LocalGuide edited = new LocalGuide();
    	edited.setPassword(this.localGuide.getPassword());
    	System.out.println("XXXXXXXXXXXXXXX");
    	
		try {
			String email=this.txtEmail.getText();
			if(system.checkValidateEmail(email)) {
				edited.setEmail(email);
			}
			
			String firstName = this.txtFirstName.getText();
			if(SystemGuide4u.checkFirstName(firstName)) {
				edited.setFirstName(firstName);
				
				
			}
			
			String lastName = this.txtLastName.getText();
			if(SystemGuide4u.checkFirstName(lastName)) {
				edited.setLastName(lastName);
			}
			

			Gender gender= Gender.Female;
			
		    if(comBoxGender.getValue().equals("Male")) {
		    	gender=Gender.Male;
		    	 edited.setGender(gender);
		    }
		    edited.setGender(gender);
			
		    
		    String city = this.txtCity.getText();
		    edited.setCity(city);
		    
		    String country = (String) this.comBoxCountry.getValue();
		    edited.setCountry(country);
		    
		    
		    String lang1 = (String) this.comBoxLang1.getValue();
		    edited.getLanguage().setLanguage1(lang1);
		    
		    String lang2 = (String) this.comBoxLang2.getValue();
		    edited.getLanguage().setLanguage1(lang2);
		    
		    String lang3 = (String) this.comBoxLang3.getValue();
		    edited.getLanguage().setLanguage1(lang3);
		    
		    
		    String travelStyle1 = (String) this.comBoxTravelStyle1.getValue();
		    edited.getTravelStyle().setTravelStyle1(travelStyle1);
		    
		    String travelStyle2 = (String) this.comBoxTravelStyle2.getValue();
		    edited.getTravelStyle().setTravelStyle1(travelStyle1);
		    
		    String travelStyle3 = (String) this.comBoxTravelStyle3.getValue();
		    edited.getTravelStyle().setTravelStyle1(travelStyle1);
		    
//		    String transportType = this.comBoxTransportType.getValue();

		    
		    String aboutMe = this.txtAboutMe.getText();
		    edited.setAboutMe(aboutMe);
		    System.out.println("GOOOOOOOOT THIS FAAAAAAAAARRRRRRRRRRRRRRRRRRRRRRRRRRR");
		    
		    sql.updateLocalGuide(edited);
		    
		    sql.initLocalGuide();
		    setLocalGuide(system.getGuideByEmail(email));

			
		}catch(Exception e) {
			system.popUpLoginError("Error While Saving Changes - Try Again");
	    	setDataEditable(true);
	    	this.btnEdit.setVisible(false);
	    	this.btnSaveEdit.setVisible(true);
			
		}
    	
    	
    	
    }
	
	
	
	public void updateChanges() {
		
		
		

		try {
			String email=this.txtEmail.getText();
			if(system.checkValidateEmail(email)) {
				system.getGuideByEmail(this.localGuide.getEmail()).setEmail(email);
			}
			
			String firstName = this.txtFirstName.getText();
			if(SystemGuide4u.checkFirstName(firstName)) {
				system.getGuideByEmail(this.localGuide.getEmail()).setFirstName(firstName);
				
			}
			
			String lastName = this.txtLastName.getText();
			if(SystemGuide4u.checkFirstName(lastName)) {
				system.getGuideByEmail(this.localGuide.getEmail()).setLastName(lastName);
			}
			

			Gender gender= Gender.Female;
			
		    if(comBoxGender.getValue().equals("Male")) {
		    	gender=Gender.Male;
		    	 system.getGuideByEmail(this.localGuide.getEmail()).setGender(gender);
		    }
		    system.getGuideByEmail(this.localGuide.getEmail()).setGender(gender);
			
		    
		    String city = this.txtCity.getText();
		    system.getGuideByEmail(this.localGuide.getEmail()).setCity(city);
		    
		    String country = (String) this.comBoxCountry.getValue();
		    system.getGuideByEmail(this.localGuide.getEmail()).setCountry(country);
		    
		    
		    String lang1 = (String) this.comBoxLang1.getValue();
		    system.getGuideByEmail(this.localGuide.getEmail()).getLanguage().setLanguage1(lang1);
		    
		    String lang2 = (String) this.comBoxLang2.getValue();
		    system.getGuideByEmail(this.localGuide.getEmail()).getLanguage().setLanguage2(lang2);
		    
		    String lang3 = (String) this.comBoxLang3.getValue();
		    system.getGuideByEmail(this.localGuide.getEmail()).getLanguage().setLanguage3(lang3);
		    
		    
		    String travelStyle1 = (String) this.comBoxTravelStyle1.getValue();
		    system.getGuideByEmail(this.localGuide.getEmail()).getTravelStyle().setTravelStyle1(travelStyle1);
		    
		    String travelStyle2 = (String) this.comBoxTravelStyle2.getValue();
		    system.getGuideByEmail(this.localGuide.getEmail()).getTravelStyle().setTravelStyle2(travelStyle2);
		    
		    String travelStyle3 = (String) this.comBoxTravelStyle3.getValue();
		    system.getGuideByEmail(this.localGuide.getEmail()).getTravelStyle().setTravelStyle3(travelStyle3);
		    
//		    String transportType = this.comBoxTransportType.getValue();
//		    system.getGuideByEmail(this.localGuide.getEmail())
		    
		    String aboutMe = this.txtAboutMe.getText();
		    system.getGuideByEmail(this.localGuide.getEmail()).setAboutMe(aboutMe);
		    
		    setLocalGuide(system.getGuideByEmail(email));

			
		}catch(Exception e) {
			system.popUpLoginError("Error While Saving Changes - Try Again");
	    	setDataEditable(true);
	    	this.btnEdit.setVisible(false);
	    	this.btnSaveEdit.setVisible(true);
			
		}
		

	    
		
	}
	
	public void initViewComboBox() {
		
		system.initCountryComBox(this.comBoxCountry);
		system.initLanguageComBox(this.comBoxLang1);
		system.initLanguageComBox(this.comBoxLang2);
		system.initLanguageComBox(this.comBoxLang3);
		system.initTravelStyleComBox(this.comBoxTravelStyle1);
		system.initTravelStyleComBox(this.comBoxTravelStyle2);
		system.initTravelStyleComBox(this.comBoxTravelStyle3);
		system.initGenderComBox(this.comBoxGender);
		system.initTransportTypeComBox(this.comBoxTransportType);
	}

	public void initData() {

		this.btnSaveEdit.setVisible(false);
		
		this.txtEmail.setText(this.localGuide.getEmail());
		this.txtFirstName.setText(this.localGuide.getFirstName());
		this.txtLastName.setText(this.localGuide.getLastName());
		this.comBoxGender.setValue(this.localGuide.getGender().toString());
		this.comBoxDOB.setValue(this.localGuide.getDateOfBirth());
		this.txtPhone.setText(this.localGuide.getPhoneNumber().toString());
		this.txtCity.setText(this.localGuide.getCity());
		this.comBoxCountry.setValue(this.localGuide.getCountry());
		this.comBoxLang1.setValue(this.localGuide.getLanguage().getLanguage1());
		this.comBoxLang2.setValue(this.localGuide.getLanguage().getLanguage2());
		this.comBoxLang3.setValue(this.localGuide.getLanguage().getLanguage3());
		this.comBoxTravelStyle1.setValue(this.localGuide.getTravelStyle().getTravelStyle1());
		this.comBoxTravelStyle2.setValue(this.localGuide.getTravelStyle().getTravelStyle2());
		this.comBoxTravelStyle3.setValue(this.localGuide.getTravelStyle().getTravelStyle3());
		//this.comBoxTransportType.setPromptText();
		this.txtAboutMe.setText(this.localGuide.getAboutMe());
		this.valueRating.setText(this.localGuide.getRatingAsString());

		
	}
	
	public void setDataEditable(boolean value) {
		
//		this.txtEmail.setEditable(value);
		this.txtFirstName.setEditable(value);
		this.txtLastName.setEditable(value);
		this.comBoxGender.setEditable(value);
		this.comBoxDOB.setEditable(value);
		this.txtPhone.setEditable(value);
		this.txtCity.setEditable(value);
		this.comBoxCountry.setEditable(value);
		this.comBoxLang1.setEditable(value);
		this.comBoxLang2.setEditable(value);
		this.comBoxLang3.setEditable(value);
		this.comBoxTravelStyle1.setEditable(value);
		this.comBoxTravelStyle2.setEditable(value);
		this.comBoxTravelStyle3.setEditable(value);
		//this.comBoxTransportType.setEditable(value);
		this.txtAboutMe.setEditable(value);
		
	}
	
	
	public void initReviewTableData() {
		
		Double sumForRating = 0.0; 
		int cntForRating = 0;
		System.out.println(system.getReviewsList().size());
		for (Entry<Integer, Review> value : this.system.getReviewsList().entrySet()) {
			  Review rev = value.getValue();

			  if(rev.getLocalGuideEmail().equals(this.localGuide.getEmail())) {
				  reviewData.add(rev);
				  if(rev.getRating()!=null) {
					  sumForRating = sumForRating + rev.getRating();
					  cntForRating++;
				  }
				  
				  
			  }else {
				  System.out.println("No Match!");
			  }
			  
 
		  }
		  
		 Double rating= sumForRating/cntForRating;
		 system.getGuideByEmail(this.localGuide.getEmail()).setRating(rating);
		
		this.tableReview.setItems(reviewData);
		this.c1_Date.setCellValueFactory(new PropertyValueFactory<Review, LocalDate>("date"));
		this.c2_travellerName.setCellValueFactory(new PropertyValueFactory<Review, String>("traveller"));
		this.c3_city.setCellValueFactory(new PropertyValueFactory<Review, String>("city"));
		this.c4_country.setCellValueFactory(new PropertyValueFactory<Review, String>("country"));
		this.c5_reviewText.setCellValueFactory(new PropertyValueFactory<Review, String>("reviewText"));
		this.c6_rating.setCellValueFactory(new PropertyValueFactory<Review, Double>("rating"));

			
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		system =Main.system;
		// Disable Picking Past Dates On The availability datePicker.
		this.datePickAvailbilty.setDayCellFactory(picker -> new DateCell() {
	        public void updateItem(LocalDate date, boolean empty) {
	            super.updateItem(date, empty);
	            LocalDate today = LocalDate.now();
	            setDisable(empty || date.compareTo(today) < 0 );
	        }
	    });
		
		
		
	}

}
