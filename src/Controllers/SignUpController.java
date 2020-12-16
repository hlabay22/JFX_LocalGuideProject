package Controllers;

import java.sql.Date;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

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
    private ComboBox<?> comBoxUserType;

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
    private ComboBox<?> comBoxGender;

    @FXML
    private Label lblPhone;

    @FXML
    private TextField txtPhone;

    @FXML
    private TextField txtCity;

    @FXML
    private Label lblCity;

    @FXML
    private ComboBox<?> comBoxCountry;

    @FXML
    private Label lblCountry;

    @FXML
    private ComboBox<?> comBoxLang1;

    @FXML
    private Label lblLang1;

    @FXML
    private ComboBox<?> comBoxLang2;

    @FXML
    private Label lblLang2;

    @FXML
    private ComboBox<?> comBoxLang3;

    @FXML
    private Label lblLang3;

    @FXML
    private ComboBox<?> comBoxTravelStyle1;

    @FXML
    private Label lblTravelStyle1;

    @FXML
    private ComboBox<?> comBoxTravelStyle2;

    @FXML
    private Label lblTravelStyle2;

    @FXML
    private ComboBox<?> comBoxTravelStyle3;

    @FXML
    private Label lblTravelStyle3;

    @FXML
    private ComboBox<?> comBoxTransportType;

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
    void btnExitClick(ActionEvent event) {
    	System.exit(0);

    }

    @FXML
    void btnSignInClick(ActionEvent event) {
    	LocalDate localDate = comBoxDOB.getValue();
    	Instant instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
    	Date date = (Date) Date.from(instant);
    	boolean emailNotes=false;
    	if(checkBoxEmailNots.equals(true))
    		emailNotes=true;
    	//String date2 = comBoxDOB.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
	    Language language=new Language(comBoxLang1.getValue().toString());
	    TravelStyle travelStyle= new TravelStyle(comBoxTravelStyle1.getValue().toString());
	    Gender gender= Gender.Female;
	    if(comBoxGender.getValue().equals("Male"))
	    	gender=Gender.Male;
    	if(comBoxUserType.getValue().equals("Local guide")) {
			 LocalGuide localGuide = new LocalGuide(txtEmail.getText(),
					 txtPassword.getText(),
					 txtFirstName.getText(), 
					 txtLastName.getText(),
					 date, 
					 gender,
					 txtCity.getText(),
					 comBoxCountry.getValue().toString(),
					 Integer.parseInt(txtPhone.getText()), 
					 language,
					 travelStyle, 
					 txtAboutMe.getText(), 
					 emailNotes);
	
			 system.addGuide(localGuide);

    	}
    	else {
    		Traveller traveller= new Traveller(txtEmail.getText(),
					 txtPassword.getText(),
					 txtFirstName.getText(), 
					 txtLastName.getText(),
					 date, 
					 gender,
					 txtCity.getText(),
					 comBoxCountry.getValue().toString(),
					 Integer.parseInt(txtPhone.getText()), 
					 language,
					 travelStyle, 
					 txtAboutMe.getText(), 
					 emailNotes);
	       system.addTraveller(traveller);
    		
    	}
    }

    }



