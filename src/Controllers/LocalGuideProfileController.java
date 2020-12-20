package Controllers;

import java.net.URL;
import java.util.ResourceBundle;
import Model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class LocalGuideProfileController implements Initializable {

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
    private ImageView imgProfileImage;

    @FXML
    private Button btnReviewRate;

    @FXML
    private Button btnExit;
    
    LocalGuide localGuide;



	@FXML
    void btnContactClick(ActionEvent event) {

    }

    @FXML
    void btnExitClick(ActionEvent event) {
    	
    	btnExit.getScene().getWindow().hide();

    }

    @FXML
    void btnReviewRateClick(ActionEvent event) {

    }
    
    public LocalGuide getLocalGuide() {
		return localGuide;
	}

	public void setLocalGuide(LocalGuide localGuide) {
		this.localGuide = localGuide;
	}
	
	public void setProfileData() {
		this.lblFullName.setText(this.localGuide.getFirstName()+" "+this.localGuide.getLastName());
		this.lblCity.setText(this.localGuide.getCity());
		this.lblCountry.setText(this.localGuide.getCountry());
		setLangData();
		setTravelStyleData();
		this.lblAbout.setText(this.localGuide.getAboutMe());
		this.lblRating.setText(this.localGuide.getRatingAsString());
		

	}
	
	public void setLangData() {
		if ((this.localGuide.getLanguage().getLanguage2()==null) && (this.localGuide.getLanguage().getLanguage3()==null)) {
			this.lblLang1.setText(this.localGuide.getLanguage().getLanguage1());
			this.lblLang2.setText("");
			this.lblLang3.setText("");
		}
	
	else if (this.localGuide.getLanguage().getLanguage3()==null) {
			this.lblLang1.setText(this.localGuide.getLanguage().getLanguage1());
			this.lblLang2.setText(this.localGuide.getLanguage().getLanguage2());
			this.lblLang3.setText("");
		
		}
	else {
			this.lblLang1.setText(this.localGuide.getLanguage().getLanguage1());
			this.lblLang2.setText(this.localGuide.getLanguage().getLanguage2());
			this.lblLang3.setText(this.localGuide.getLanguage().getLanguage3());
		}
	}
	
	public void setTravelStyleData() {
		if ((this.localGuide.getTravelStyle().getTravelStyle2()==null) && (this.localGuide.getTravelStyle().getTravelStyle3()==null)) {
			this.lblTravelStyle1.setText(this.localGuide.getTravelStyle().getTravelStyle1());
			this.lblTravelStyle2.setText("");
			this.lblTravelStyle3.setText("");
		}
	
	else if (this.localGuide.getTravelStyle().getTravelStyle3()==null) {
			this.lblTravelStyle1.setText(this.localGuide.getTravelStyle().getTravelStyle1());
			this.lblTravelStyle2.setText(this.localGuide.getTravelStyle().getTravelStyle2());
			this.lblTravelStyle3.setText("");
		
		}
	else {
			this.lblTravelStyle1.setText(this.localGuide.getTravelStyle().getTravelStyle1());
			this.lblTravelStyle2.setText(this.localGuide.getTravelStyle().getTravelStyle2());
			this.lblTravelStyle3.setText(this.localGuide.getTravelStyle().getTravelStyle3());
		}
	}
    
    

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}
