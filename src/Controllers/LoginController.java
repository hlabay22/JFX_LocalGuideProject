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
import javafx.scene.layout.Pane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.net.URL;
import java.util.ResourceBundle;

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
	    private Label lblSignUp;
	    

	    @FXML
	    private Label lblLogo;

	    @FXML
	    private Button btnExit;


	    @FXML
	    void btnExitClick(ActionEvent event) {
	    	
	    	System.exit(0);

	    }

	    @FXML
	    void btnSignInClick(ActionEvent event) {
	    	
	    	loadTravellerDashboad();

	    }


	    @FXML
	    void lblSignUpClick(MouseEvent event) {
	    	loadSignUpPage();
	    	this.btnSignIn.getScene().getWindow().hide();

	    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
		
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
	
	public void loadTravellerDashboad() {
		
		
		try {
			stage=new Stage();
			Parent root = FXMLLoader.load(Main.class.getResource("/FXML/TravellerDashboard.fxml"));
			int screenWidth = (int) Screen.getPrimary().getVisualBounds().getWidth();
			int screenHeight = (int) Screen.getPrimary().getVisualBounds().getHeight();
			Scene scene = new Scene(root,screenWidth,screenHeight);
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			stage.setScene(scene);
			stage.setTitle("Guide4U - Traveller Dashboard");
			stage.show();
			stage.setFullScreen(true);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	// Heelllooooooo!!!!!

}
