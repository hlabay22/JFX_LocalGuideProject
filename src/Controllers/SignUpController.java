package Controllers;

import java.sql.Date;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

import Exceptions.comboBoxNotSelected;
import Model.Gender;
import Model.Language;
import Model.LocalGuide;
import Model.SystemGuide4u;
import Model.TravelStyle;
import Model.Traveller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class SignUpController {

    @FXML
    private ImageView imgBackground;

    @FXML
    private Pane paneLogin;

    @FXML
    private Label lblSignUp;

    @FXML
    private TextField txtEmail;

    @FXML
    private Label lblEmail;

    @FXML
    private Label lblPassword;

    @FXML
    private Button btnSignIn;

    @FXML
    private ComboBox<String> comBoxUserType;

    @FXML
    private Label lblUserType;

    @FXML
    private Label lblFirstName;

    @FXML
    private PasswordField txtPassword;

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
    private CheckBox checkBoxEmailNots;

    @FXML
    private Button btnExit;

    @FXML
    private Label lblLogo;
    SystemGuide4u system= SystemGuide4u.getInstance();
    
    
    
    
    
    @FXML
    public void initialize() {
    	comBoxUserType.getItems().setAll("Local Guide", "Traveller", "Traveller and Local Guide");
    	system.initCountryComBox(this.comBoxCountry);
    	system.initLanguageComBox(this.comBoxLang1);
    	system.initLanguageComBox(this.comBoxLang2);
    	system.initLanguageComBox(this.comBoxLang3);
    	
    }
    @FXML
    void btnExitClick(ActionEvent event) {
    	System.exit(0);

    }
    

    @FXML
    void btnSignInClick(ActionEvent event) throws comboBoxNotSelected {
    	if((system.checkPassword(txtPassword)) 
    	&& (system.checkValidateEmail(txtEmail.getText()))
    	&& (system.checkFirstName(txtFirstName.getText()))){
    		
		    	LocalDate localDate = comBoxDOB.getValue();
//		    	Instant instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
//		    	Date date = (Date) Date.from(instant);
		    	Language language;
		    	TravelStyle travelStyle;
		    	boolean emailNotes=false;
		    	if(checkBoxEmailNots.equals(true))
		    		emailNotes=true;
		    	//String date2 = comBoxDOB.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		    	
		    	if(comBoxLang1.getValue()!=null) {
				     language=new Language(comBoxLang1.getValue().toString());
		    	}
		    	else throw new comboBoxNotSelected();
		    	
		    	if(comBoxTravelStyle1.getValue()!=null) {
				    travelStyle= new TravelStyle(comBoxTravelStyle1.getValue().toString());
		    	}
		    	else throw new comboBoxNotSelected();
		    	
			    Gender gender= Gender.Female;
			    
			    if(comBoxGender.getValue().equals("Male"))
			    	gender=Gender.Male;
			    
		    	
				LocalGuide localGuide = new LocalGuide(txtEmail.getText(),
							 txtPassword.getText(),
							 txtFirstName.getText(), 
							 txtLastName.getText(),
							 localDate, 
							 gender,
							 txtCity.getText(),
							 comBoxCountry.getValue().toString(),
							 Integer.parseInt(txtPhone.getText()), 
							 language,
							 travelStyle, 
							 txtAboutMe.getText(), 
							 emailNotes);
				Traveller traveller= new Traveller(txtEmail.getText(),
						 txtPassword.getText(),
						 txtFirstName.getText(), 
						 txtLastName.getText(),
						 localDate, 
						 gender,
						 txtCity.getText(),
						 comBoxCountry.getValue().toString(),
						 Integer.parseInt(txtPhone.getText()), 
						 language,
						 travelStyle, 
						 txtAboutMe.getText(), 
						 emailNotes);
		    	
				if(comBoxUserType.getValue().equals("Local Guide")) 
					 system.addGuide(localGuide);
	
		    	if(comBoxUserType.getValue().equals("Traveller"))
			       system.addTraveller(traveller);
		    	if(comBoxUserType.getValue().equals("Traveller and Local Guide"))	
		    	   system.addGuide(localGuide);system.addTraveller(traveller);}
		    	else throw new comboBoxNotSelected();////���� ������ �� ����� ��
    	
    	    
		
    	
    }

}

