package Controllers;

import java.io.IOException;
import java.sql.Date;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.awt.Color;

import Exceptions.LoginException;
import Exceptions.comboBoxNotSelected;
import Model.Gender;
import Model.Language;
import Model.LocalGuide;
import Model.SystemGuide4u;
import Model.TravelStyle;
import Model.Traveller;
import Model.User;
import application.Main;
import application.SqlTest;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
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
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

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

    SystemGuide4u system=Main.system;
    
    static SqlTest sql = new SqlTest();
    
    boolean IsAdminSession=false;
    
    
    
    
    @FXML
    public void initialize() {
    	comBoxUserType.getItems().setAll("Local Guide", "Traveller", "Traveller and Local Guide");
//    	comBoxTravelStyle1.getItems().setAll("Art","Sport","Shoping","Adventure", "Entertaiment", "Local Culture", "Nature");
//    	comBoxTravelStyle2.getItems().setAll("Art","Sport","Shoping","Adventure", "Entertaiment", "Local Culture", "Nature");
//    	comBoxTravelStyle3.getItems().setAll("Art","Sport","Shoping","Adventure", "Entertaiment", "Local Culture", "Nature");
    	system.initTravelStyleComBox(this.comBoxTravelStyle1);
    	system.initTravelStyleComBox(this.comBoxTravelStyle2);
    	system.initTravelStyleComBox(this.comBoxTravelStyle3);
        comBoxLang1.setPromptText("Required");
        comBoxLang2.setPromptText("Optional");
        comBoxLang3.setPromptText("Optional");
//        comBoxTransportType.getItems().setAll("Privat Vehicle","Public Transportation");
//    	comBoxGender.getItems().setAll("Male","Female");
        system.initGenderComBox(this.comBoxGender);
        system.initTransportTypeComBox(this.comBoxTransportType);
    	system.initCountryComBox(this.comBoxCountry);
    	system.initLanguageComBox(this.comBoxLang1);
    	system.initLanguageComBox(this.comBoxLang2);
    	system.initLanguageComBox(this.comBoxLang3);
    	
    }
    @FXML
    void btnExitClick(ActionEvent event) {
    	if(IsAdminSession) {
        	system.loadAdminPage();
			this.btnSignIn.getScene().getWindow().hide();
    	}
    	else {
        	system.reloadLoginPage();
    	}

    }
    


    @FXML
    void btnSignInClick(ActionEvent event) throws comboBoxNotSelected {
    	try {
    	if((system.checkPassword(txtPassword)) 
    	&& (system.checkValidateEmail(txtEmail.getText()))
    	&& (system.checkFirstName(txtFirstName.getText())) 
    	&& (system.checkFirstName(txtLastName.getText()))
    	&& (system.checkPhone(txtPhone.getText())) && (system.checkFirstName(txtCity.getText()))){
    		
    		////combo boxes
    	
    			DateTimeFormatter df = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
		    	LocalDate localDate = comBoxDOB.getValue();
		    	Language language=new Language("");
		    	TravelStyle travelStyle=new TravelStyle("");
			    Gender gender= Gender.Female;
			    if(comBoxGender.getValue().equals("Male"))
			    	gender=Gender.Male;
		    	boolean emailNotes=false;
		    	if(checkBoxEmailNots.equals(true))
		    		emailNotes=true;
		    	//String date2 = comBoxDOB.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		    	try {
		    		String lang1=comBoxLang1.getValue().toString();
		    		if(comBoxLang2.getValue()!=null) 
		    		{
		    			String lang2=comBoxLang2.getValue().toString();
		    			language=new Language(lang1, lang2);
		    			if(comBoxLang3.getValue()!=null) 
		    			{
		    				String lang3=comBoxLang3.getValue().toString();
		    				language=new Language(lang1,lang2, lang3);
		    			}	
                    }
		    		
		    		String travel1=comBoxTravelStyle1.getValue().toString();
		    		if(comBoxTravelStyle2.getValue()!=null) 
		    		{ 
		    			String travel2=comBoxTravelStyle2.getValue().toString();
		    			travelStyle= new TravelStyle(travel1, travel2);
		    			if(comBoxTravelStyle3.getValue()!=null) 
		    			{
		    				String travel3=comBoxTravelStyle3.getValue().toString();
		    					travelStyle= new TravelStyle(travel1, travel2, travel3);
}

		

		    	if(comBoxLang1.getValue()!=null) {
				     language.setLanguage1(lang1);
		    	}
		    	else throw new comboBoxNotSelected();
		    	
		    	if(comBoxTravelStyle1.getValue()!=null) {
				    travelStyle.setTravelStyle1(comBoxTravelStyle1.getValue().toString());
		    	}
		    	else throw new comboBoxNotSelected();
		    	
		    	if(comBoxUserType.getValue()==null || comBoxGender.getValue()==null || comBoxDOB.getValue()==null ||
		    	   comBoxGender.getValue()==null || comBoxCountry.getValue()==null || comBoxCountry.getValue()==null) {
		    	 	throw new comboBoxNotSelected();
		    	}
		    
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
		    		 if(comBoxGender.getValue()==null) 
		    			 comBoxUserType.setStyle("-fx-background-color:red;");
		    		 if(comBoxCountry.getValue()==null) 
		    			 comBoxCountry.setStyle("-fx-background-color:red;");
		    		 if(comBoxTransportType.getValue()==null) 
		    			 comBoxTransportType.setStyle("-fx-background-color:red;");
		    		 if(comBoxDOB.getValue()==null) 
		    			 comBoxDOB.setStyle("-fx-background-color:red;");
		    	}
		    	
			    
		    	
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
					 //system.addGuide(localGuide);
					 sql.addLocalGuideToSQL(localGuide);
//					 System.out.println("local add");
					 sql.initLocalGuide();
//					 Main.serialize("guide4u.ser");
//				     Main.deserialize();
				     adminOrLoginPage(IsAdminSession,localGuide );
		        	 

				}
				
				if(comBoxUserType.getValue().equals("Traveller")) {
			         //system.addTraveller(traveller);
					 sql.addTravellerToSQL(traveller);
					 System.out.println("trav add");
					 sql.initTravellers();
//					 Main.serialize("guide4u.ser");
//				     Main.deserialize();
				     adminOrLoginPage(IsAdminSession,traveller);


				}
				if(comBoxUserType.getValue().equals("Traveller and Local Guide")) {
					//system.addGuide(localGuide);system.addTraveller(traveller);
					 sql.addLocalGuideToSQL(localGuide); sql.addTravellerToSQL(traveller);
					 System.out.println("both add");
					 sql.initLocalGuide(); sql.initTravellers();
//					 Main.serialize("guide4u.ser");
//				     Main.deserialize();
				     adminOrLoginPage(IsAdminSession,localGuide );


				}
				
        		system.printAllData();
//        		system.reloadLoginPage();
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
	    	if (!system.checkFirstName(txtLastName.getText())) {
				this.txtLastName.setStyle("-fx-text-box-border:#ec0606");
				this.txtLastName.clear();
	    	}
	    	if(!system.checkPhone(txtPhone.getText())) {
	    		this.txtPhone.setStyle("-fx-text-box-border:#ec0606");
				this.txtPhone.clear();
	    	}	
	    		
	    		if (!system.checkFirstName(txtCity.getText())) {
	    			this.txtCity.setStyle("-fx-text-box-border:#ec0606");
					this.txtCity.clear();
	    	}
		}
    	
    }
    public void adminOrLoginPage(boolean flag, User user) {
    	if(flag) {
    		system.loadAdminPage();
			this.btnSignIn.getScene().getWindow().hide();
    	}
    	else {
    		signUpSucssesfull(user);
    	}
    }
    public void signUpSucssesfull(User user) {
		try {
			
			Stage signUpSucssesfull = new Stage();
        	FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/FXML/SignUpSucsessController.fxml"));
            AnchorPane signUpLayout = (AnchorPane) loader.load();
            // Pass Student Object To StudentController
            SignUpSucsessController signUp = loader.getController();
            signUp.setUser(user);
            System.out.println(user.getFirstName());
	        // Show the scene containing the root layout.
	    	int screenWidth = (int) Screen.getPrimary().getVisualBounds().getWidth();
			int screenHeight = (int) Screen.getPrimary().getVisualBounds().getHeight();
	        Scene scene = new Scene(signUpLayout);
	        scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
	        signUpSucssesfull.setScene(scene);
	        signUpSucssesfull.setTitle("Sign Up Success");
	        signUpSucssesfull.show();
	        btnSignIn.getScene().getWindow().hide();
	        
	        
			
			
			
		} catch(Exception e) {
			e.printStackTrace();
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
		system.popUpLoginError("Login Error");
		
	}
	public void setFlag(boolean IsAdminSession) {
		this.IsAdminSession=IsAdminSession;
	}
}

