package Controllers;

import java.net.URL;
import java.util.ResourceBundle;
import Model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
    private Tab tabAbout;
    
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

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		system = SystemGuide4u.getInstance();
		
	}

}
