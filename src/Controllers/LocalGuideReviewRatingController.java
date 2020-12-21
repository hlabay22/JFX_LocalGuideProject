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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class LocalGuideReviewRatingController implements Initializable {

    @FXML
    private ImageView imgBackground;

    @FXML
    private Pane paneLogin;

    @FXML
    private Label lblTitle;

    @FXML
    private Label lblFullName;

    @FXML
    private Button btnSubmit;

    @FXML
    private Label lblCity;

    @FXML
    private Label lblCountry;

    @FXML
    private ImageView imgProfileImage;

    @FXML
    private Label lblLogo;

    @FXML
    private Label lblTravelDetails;

    @FXML
    private Label lblDate;

    @FXML
    private Label lblCityDetails;

    @FXML
    private Label lblReview;

    @FXML
    private Label lblDescription;

    @FXML
    private Label lblRating;

    @FXML
    private Label lblCountryDetails;

    @FXML
    private Label lblOfTen;

    @FXML
    private DatePicker datePickDate;

    @FXML
    private TextField txtCity;

    @FXML
    private ComboBox<String> comBoxCountry;

    @FXML
    private TextField txtRating;

    @FXML
    private TextArea txtReveiwText;

    @FXML
    private Button btnExit;
    
    LocalGuide localGuide;
    
    Traveller traveller;
    
    SystemGuide4u system;

    @FXML
    void btnExitClick(ActionEvent event) {
    	
    	btnExit.getScene().getWindow().hide();

    }

    @FXML
    void btnSubmit(ActionEvent event) {

    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		system = SystemGuide4u.getInstance();
		system.initCountryComBox(this.comBoxCountry);
		this.txtRating.setPromptText(" [0-10] ");
		
	}
	
	public void setProfileData() {
		this.lblFullName.setText(this.localGuide.getFirstName()+" "+this.localGuide.getLastName());
		this.lblCity.setText(this.localGuide.getCity());
		this.lblCountry.setText(this.localGuide.getCountry());
		this.lblRating.setText(this.localGuide.getRatingAsString());
		
	}

	public LocalGuide getLocalGuide() {
		return localGuide;
	}

	public void setLocalGuide(LocalGuide localGuide) {
		this.localGuide = localGuide;
	}

	public Traveller getTraveller() {
		return traveller;
	}

	public void setTraveller(Traveller traveller) {
		this.traveller = traveller;
	}

}
