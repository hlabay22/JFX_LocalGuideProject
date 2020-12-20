package Controllers;

import java.net.URL;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Map.Entry;

import Model.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class MatchmakerSearchController implements Initializable{

    @FXML
    private ImageView imgBackground;

    @FXML
    private Pane paneLogin;

    @FXML
    private Label lblTitle;

    @FXML
    private Label lblFullName;

    @FXML
    private Button btnContact;

    @FXML
    private Label lblCity;

    @FXML
    private Label lblCountry;

    @FXML
    private ImageView imgProfileImage;

    @FXML
    private Label lblLogo;

    @FXML
    private Label lblLangTitle;

    @FXML
    private Label lblLang1;

    @FXML
    private Label lblLang2;

    @FXML
    private Label lblTravelStyleTitle;

    @FXML
    private Label lblTravelStyle1;

    @FXML
    private Label lblTravelStyle2;

    @FXML
    private Label lblLang3;

    @FXML
    private Label lblTravelStyle3;

    @FXML
    private Label lblAboutTitle;

    @FXML
    private Label lblAbout;

    @FXML
    private Label lblRating;

    @FXML
    private Label lblOfTen;

    @FXML
    private Button btnMoreOffers;

    @FXML
    private Label lblCitySearch;

    @FXML
    private Label lblCountrySearch;

    @FXML
    private Label lblDateSearch;

    @FXML
    private TextField txtCity;

    @FXML
    private DatePicker datePick;

    @FXML
    private Button btnSearch;

    @FXML
    private Label lblNote;

    @FXML
    private ComboBox<String> comBoxCountry;

    @FXML
    private Button btnExit;
    
    @FXML
    private Separator horizSep;
    
    Traveller traveller;
    

	LocalGuide localGuide;
	
	SystemGuide4u system;

    @FXML
    void btnContactClick(ActionEvent event) {

    }

    @FXML
    void btnExitClick(ActionEvent event) {
    	
    	btnExit.getScene().getWindow().hide();

    }

    @FXML
    void btnMoreOffersClick(ActionEvent event) {

    }

    @FXML
    void btnSearchClick(ActionEvent event) {
    	
    	showHideResult(true);
    	//matchmakerSearchAlgorithem();

    }
    
    public void matchmakerSearchAlgorithem() {
    	
    	String city = this.txtCity.getText();
    	String country = this.comBoxCountry.getSelectionModel().getSelectedItem();
    	LocalDate localDate = this.datePick.getValue();
    	
    	
    	for (Entry<String, LocalGuide> value : this.system.getLocalGuidesList().entrySet()) {
			  LocalGuide localGuide = value.getValue(); 
			  
    	// The very first condition is the date , if its available then we can carry on to match other conditions
    	
			  
    	
    	
    	}
    	
    	

    	
    	
    }
    

    
    public Traveller getTraveller() {
		return traveller;
	}

	public void setTraveller(Traveller traveller) {
		this.traveller = traveller;
	}

	public LocalGuide getLocalGuide() {
		return localGuide;
	}

	public void setLocalGuide(LocalGuide localGuide) {
		this.localGuide = localGuide;
	}
	
	public void showHideResult(boolean value) {
		
		this.lblNote.setVisible(value);
		this.horizSep.setVisible(value);
		this.lblTravelStyleTitle.setVisible(value);
		this.lblLangTitle.setVisible(value);
		this.lblAboutTitle.setVisible(value);
		this.lblFullName.setVisible(value);
		this.imgProfileImage.setVisible(value);
		this.lblCity.setVisible(value);
		this.lblCountry.setVisible(value);
		this.lblLang1.setVisible(value);
		this.lblLang2.setVisible(value);
		this.lblLang3.setVisible(value);
		this.lblTravelStyle1.setVisible(value);
		this.lblTravelStyle2.setVisible(value);
		this.lblTravelStyle3.setVisible(value);
		this.lblAbout.setVisible(value);
		this.lblRating.setVisible(value);
		this.lblOfTen.setVisible(value);
		this.btnMoreOffers.setVisible(value);
		this.btnContact.setVisible(value);
		
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		this.system = SystemGuide4u.getInstance();
		system.initCountryComBox(this.comBoxCountry);
	}

}
