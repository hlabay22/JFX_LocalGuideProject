package Controllers;

import java.io.IOException;
import java.sql.Date;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.awt.Color;

import Exceptions.LoginException;
import Exceptions.comboBoxNotSelected;
import Model.Gender;
import Model.Language;
import Model.LocalGuide;
import Model.SystemGuide4u;
import Model.TravelStyle;
import Model.Traveller;
import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

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
    //SystemGuide4u system=Main.system;

    
    
    
    
    @FXML
    public void initialize() {
    	comBoxUserType.getItems().setAll("Local Guide", "Traveller", "Traveller and Local Guide");
    	comBoxTravelStyle1.getItems().setAll("Art","Sport","Shoping","Adventure", "Entertaiment", "Local Culture", "Nature");
    	comBoxTravelStyle2.getItems().setAll("Art","Sport","Shoping","Adventure", "Entertaiment", "Local Culture", "Nature");
    	comBoxTravelStyle3.getItems().setAll("Art","Sport","Shoping","Adventure", "Entertaiment", "Local Culture", "Nature");
        comBoxLang1.setPromptText("Required");
        comBoxLang2.setPromptText("Optional");
        comBoxLang3.setPromptText("Optional");
        comBoxTransportType.getItems().setAll("Privat Vehicle","Public Transportation");

    	comBoxGender.getItems().setAll("Male","Female","Other");
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
    	try {
    	if((system.checkPassword(txtPassword)) 
    	&& (system.checkValidateEmail(txtEmail.getText()))
    	&& (system.checkFirstName(txtFirstName.getText()))){
		    	LocalDate localDate = comBoxDOB.getValue();
//		    	Instant instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
//		    	Date date = (Date) Date.from(instant);
		    	Language language=new Language("");
		    	TravelStyle travelStyle=new TravelStyle("");
		    	boolean emailNotes=false;
		    	if(checkBoxEmailNots.equals(true))
		    		emailNotes=true;
		    	//String date2 = comBoxDOB.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		    	try {
		    	if(comBoxLang1.getValue()!=null) {
				     language.setLanguage1(comBoxLang1.getValue().toString());
		    	}
		    	else throw new comboBoxNotSelected();
		    	
		    	if(comBoxTravelStyle1.getValue()!=null) {
				    travelStyle.setTravelStyle1(comBoxTravelStyle1.getValue().toString());
		    	}
		    	else throw new comboBoxNotSelected();
		    	
		    	if(comBoxUserType.getValue()==null) {
		    		throw new comboBoxNotSelected();
		    	}
		    	}catch(comboBoxNotSelected e){
		    		e.printStackTrace();
		    		 popUpComboError();
		    		 if(comBoxLang1.getValue()==null) 
		    			 comBoxLang1.setStyle("-fx-background-color:red;");
		    		 if(comBoxTravelStyle1.getValue()==null) 
		    			 comBoxTravelStyle1.setStyle("-fx-background-color:red;");
		    		 if(comBoxUserType.getValue()==null) 
		    			 comBoxUserType.setStyle("-fx-background-color:red;");
		    		
		    	}
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
		    	
				if(comBoxUserType.getValue().equals("Local Guide")) {
					 system.addGuide(localGuide);
					 System.out.println("local add");
				}
				if(comBoxUserType.getValue().equals("Traveller")) {
			       system.addTraveller(traveller);
					 System.out.println("trav add");

				}
				if(comBoxUserType.getValue().equals("Traveller and Local Guide")) {
					system.addGuide(localGuide);system.addTraveller(traveller);
					 System.out.println("both add");

				}
        		system.printAllData();

		    	}
		    	//else throw new comboBoxNotSelected();
    	else {throw new LoginException();}
    	}	catch(LoginException e) {
			e.printStackTrace();
			popUpLoginError();
			if(!system.checkPassword(txtPassword)) {
				this.txtPassword.clear();
                this.txtPassword.setStyle("-fx-text-box-border:#ec0606");
			}
	    	if (!system.checkValidateEmail(txtEmail.getText())) {
				this.txtEmail.clear();
				this.txtEmail.setStyle("-fx-text-box-border:#ec0606");
	    	}

	    	if (!system.checkFirstName(txtFirstName.getText())) {
				this.txtFirstName.setStyle("-fx-text-box-border:#ec0606");
				this.txtFirstName.clear();
	    	}
			
		}
    	
    }

	private void popUpComboError() {
        try {
        	Stage popUpLoginErr = new Stage();
        	FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/FXML/ComboNotSelected.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            Scene scene = new Scene(rootLayout);
	        scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
	        popUpLoginErr.setScene(scene);
	        popUpLoginErr.setTitle("Error");
	        popUpLoginErr.setResizable(false);
	        popUpLoginErr.show();
	        
	        
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
		
	}
	private void popUpLoginError() {
        try {
        	Stage popUpLoginErr = new Stage();
        	FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/FXML/popUpLoginError.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            Scene scene = new Scene(rootLayout);
	        scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
	        popUpLoginErr.setScene(scene);
	        popUpLoginErr.setTitle("Xademy - Login Error");
	        popUpLoginErr.setResizable(false);
	        popUpLoginErr.show();
	        
	        
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
		
	}

}

