package Controllers;

import java.net.URL;
import java.util.ResourceBundle;
import Model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

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
    
    
    
    LocalGuide localGuide;

    SystemGuide4u system; 
    
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
    	
    	initViewComboBox();
    	setDataEditable(true);
    	this.btnEdit.setVisible(false);
    	this.btnSaveEdit.setVisible(true);

    }
    

    @FXML
    void btnSaveEdit(ActionEvent event) {
    	
    	
    	updateChanges();
    	initData();
    	btnSaveEdit.setVisible(false);
    	btnEdit.setVisible(true);
    	setDataEditable(false);
    	

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

		
	}
	
	public void setDataEditable(boolean value) {
		
		this.txtEmail.setEditable(value);
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
	


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		system = SystemGuide4u.getInstance();
		
		
	}

}
