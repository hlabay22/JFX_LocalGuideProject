package Controllers;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import Exceptions.GeneralErrorException;
import Model.*;
import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
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
    
    SystemGuide4u system=Main.system;

    @FXML
    void btnExitClick(ActionEvent event) {
    	
    	btnExit.getScene().getWindow().hide();

    }

    @FXML
    void btnSubmit(ActionEvent event) {
//    	String city = null;String country = null;String reviewText = null;Double appRating = null;
//    	LocalDate date = this.datePickDate.getValue();
//    	if(this.txtCity.getText()!=null) {
//    		city = this.txtCity.getText();
//    	}
//    	
//    	if(this.comBoxCountry.getValue() != null) {
//    		country = this.comBoxCountry.getValue();
//    	}
//    	
//    	if(this.txtReveiwText.getText() != null) {
//    		reviewText = this.txtReveiwText.getText();
//    	}
//    	
//    	if(this.txtRating.getText() != null) {
//    		Double rating = Double.parseDouble(this.txtRating.getText());
//    		if(rating > 0 && rating <=10) {
//    			appRating = rating;
//    		}
//    	}
//    	
//    	try {
//    		if(date !=null &&  city != null && country != null && reviewText!= null && appRating != null) {
//    			Review review = new Review(this.localGuide, date, this.traveller, city, country, reviewText , appRating);
//    			system.getReviewsList().add(review);
//    			Alert a = new Alert(AlertType.INFORMATION);
//    			a.setTitle("Review Sent!");
//    			a.setHeaderText("Review Sent!");
//    			a.setContentText("Review was sent! Thank You");
//    			a.show();
//    			
//    			
//    		}else throw new Exception();
//    		
//    	}catch(Exception e) {
//    		
////			Alert a = new Alert(AlertType.ERROR);
////			a.setTitle("Error!");
////			a.setHeaderText("Error!");
////			a.setContentText("Error Occoured - Please Try Again");
////			a.show();
//    		
//    	}
    	
    	Review review = new Review();
    	
    	LocalDate date = this.datePickDate.getValue();
    	Traveller t = this.traveller;
    	LocalGuide lg = this.localGuide;
    	String city = this.txtCity.getText();
    	String country = this.comBoxCountry.getValue();
    	String reviewText = this.txtReveiwText.getText();
    	Double rating = Double.parseDouble(this.txtRating.getText());
    	
    	try {
    		if (date != null) {
    			review.setDate(date);
    		}else throw new GeneralErrorException();
    		
    		if (t !=null) {
    			review.setTraveller(t);
    		}else throw new GeneralErrorException();
    		
    		if (lg != null) {
    			review.setLocalGuide(lg);
    		}else throw new GeneralErrorException();
    		
    		if (city !=null) {
    			review.setCity(city);
    		}else throw new GeneralErrorException();
    		
    		if (country !=null) {
    			review.setCountry(country);
    		}else throw new GeneralErrorException();
    		
    		if (reviewText !=null) {
    			review.setReviewText(reviewText);
    		}else throw new GeneralErrorException();
    		
    		if (rating !=null) {
    			if(rating > 0 && rating <= 10) {
    				review.setRating(rating);
    			}else throw new GeneralErrorException();
    		}else throw new GeneralErrorException();
    		
			system.getReviewsList().add(review);
			Alert a = new Alert(AlertType.INFORMATION);
			a.setTitle("Review Sent!");
			a.setHeaderText("Review Sent!");
			a.setContentText("Review was sent! Thank You");
			a.show();
    		
    		
    	}catch (GeneralErrorException e) {
    		
		Alert a = new Alert(AlertType.ERROR);
		a.setTitle("Error!");
		a.setHeaderText("Error!");
		a.setContentText("Error Occoured - Please Try Again");
		a.show();
		
    		
    	}
    	
    	Main.serialize("guide4u.ser");
    	Main.deserialize();
    	


    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		system = Main.system;
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
