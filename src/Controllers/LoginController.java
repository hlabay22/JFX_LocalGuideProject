package Controllers;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.ResourceBundle;
import Exceptions.LoginException;
import Model.LocalGuide;
import Model.SystemGuide4u;
import Model.Traveller;
import application.Main;
import javafx.fxml.Initializable;

public class LoginController implements Initializable {
	
	Stage stage;
	
	
	 @FXML
	    private ImageView imgBackground;

	    @FXML
	    private Pane paneLogin;

	    @FXML
	    private Label lblLogin;

	    @FXML
	    private TextField txtEmail;

	    @FXML
	    private PasswordField txtPassword;

	    @FXML
	    private Label lblEmail;

	    @FXML
	    private Label lblPassword;

	    @FXML
	    private Button btnSignIn;

	    @FXML
	    private Button btnSignUp;
	    

	    @FXML
	    private Label lblLogo;

	    @FXML
	    private Button btnExit;

	   // static SystemGuide4u system;
	   SystemGuide4u system=Main.system;
	    @FXML
	    void btnExitClick(ActionEvent event) {
	    	
	    	System.exit(0);

	    }
	    
	    @FXML
	    void btnSignInClick(ActionEvent event) {
	    	if(txtEmail.getText().equals("admin") && (txtPassword.getText().equals("admin"))) {
	    		loadAdminPage();
	    	}
	    		else {
	    	  String email=txtEmail.getText();
		        if(!(system.checkValidateEmail(email) || (system.checkPassword(txtPassword)))){
		    		popUpLoginError();
		    		
		    		this.txtEmail.clear();
		    		this.txtPassword.clear();
		    		
		    	}
		        else {
		    		
		        	try {
		    
		    		if(system.getLocalGuidesList().containsKey(txtEmail.getText()) && 
		    				system.checkPasswordAndEmailGuide(email, txtPassword.getText()))
		    		{
		    				LocalGuide localGuide = system.getGuideByEmail(email);
		    				loadLocalGuideDashboad(localGuide);	    			
		    		}
		    		else if (system.getTravellersList().containsKey(email) && 
		    				system.checkPasswordAndEmailTraveller(email, txtPassword.getText())) {
		    			Traveller traveller=system.getTravellerByMail(email);
		    			loadTravellerDashboad(traveller);

		    		}
		    		else throw new LoginException();
		    		}
		    	
		    	catch(LoginException e) {
	    			e.printStackTrace();
	    			popUpLoginError();
	    			
	    			this.txtEmail.clear();
	    			this.txtPassword.clear();
	    		}

		    }
	    		}
	    }
	    

	    
	    @FXML
	    void btnSignUpClick(ActionEvent event) {
	    	loadSignUpPage();
	    	btnSignUp.getScene().getWindow().hide();

	    }





	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
		
	}
	

	public void loadSignUpPage() {
		
		try {
			stage=new Stage();
			Parent root = FXMLLoader.load(Main.class.getResource("/FXML/SignUp.fxml"));
			Scene scene = new Scene(root,1130,725);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			stage.setScene(scene);
			stage.setTitle("Guide4U - Sign Up");
			stage.initStyle(StageStyle.UNDECORATED);
			stage.show();
			stage.setResizable(false);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
public void loadAdminPage() {
		
		try {
			stage=new Stage();
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/Admin.fxml"));
			Parent root = loader.load();
			int screenWidth = (int) Screen.getPrimary().getVisualBounds().getWidth();
			int screenHeight = (int) Screen.getPrimary().getVisualBounds().getHeight();
			Scene scene = new Scene(root,screenWidth,screenHeight);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			AdminController adminController = loader.<AdminController>getController();
			adminController.initLocalGuideTable();
			stage.setScene(scene);
			stage.setTitle("Guide4U - Admin Dashboard");
			stage.show();
			this.btnSignIn.getScene().getWindow().hide();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void loadTravellerDashboad(Traveller traveller) {
		
		
		try {

			stage=new Stage();
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/TravellerDashboard.fxml"));
			Parent root = loader.load();
			int screenWidth = (int) Screen.getPrimary().getVisualBounds().getWidth();
			int screenHeight = (int) Screen.getPrimary().getVisualBounds().getHeight();
			Scene scene = new Scene(root,screenWidth,screenHeight);
			TravellerDashboardController TDashController = loader.<TravellerDashboardController>getController();
			TDashController.setTraveller(traveller);					
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			stage.setScene(scene);
			stage.setTitle("Guide4U - Traveller Dashboard");
			stage.show();
			this.btnSignIn.getScene().getWindow().hide();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	public void loadLocalGuideDashboad(LocalGuide localGuide) {
		
		try {

			stage=new Stage();
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/LocalGuideDashboard.fxml"));
			Parent root = loader.load();
			int screenWidth = (int) Screen.getPrimary().getVisualBounds().getWidth();
			int screenHeight = (int) Screen.getPrimary().getVisualBounds().getHeight();
			Scene scene = new Scene(root,screenWidth,screenHeight);
			LocalGuideDashboardController LGDashController = loader.<LocalGuideDashboardController>getController();
			LGDashController.setLocalGuide(localGuide);	
			LGDashController.initData();
			LGDashController.initReviewTableData();
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			stage.setScene(scene);
			stage.setTitle("Guide4U - Local Guide Dashboard");
			stage.show();
			this.btnSignIn.getScene().getWindow().hide();
			
		} catch(Exception e) {
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
//	public static  void deserialize() {
//		try {
//			FileInputStream fileIn = new FileInputStream("guide4u.ser");
//			ObjectInputStream in = new ObjectInputStream(fileIn);
//			system= (SystemGuide4u) in.readObject();
//			in.close();
//			fileIn.close();
//			System.out.println("Loaded!");
//		} catch (IOException i) {
//			i.printStackTrace();
//		} catch (ClassNotFoundException c) {
//			c.printStackTrace();
//		}
//	}

}
