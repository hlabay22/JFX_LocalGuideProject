package Controllers;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;
import Model.*;
import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

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
    private Button btnExit;
    
    @FXML
    private Button btnShowReviews;
    
    @FXML
    private Button btnPlacesAndTravels;
    
    LocalGuide localGuide;
    
    Traveller traveller;
     
    @FXML
    private Button btnReviewRate;

    SystemGuide4u system=Main.system;

	@FXML
    void btnContactClick(ActionEvent event) {
         system.loadContactLocalGuidePage(this.localGuide);
    }

    @FXML
    void btnExitClick(ActionEvent event) {
    	
    	btnExit.getScene().getWindow().hide();

    }

    @FXML
    void btnReviewRateClick(ActionEvent event) {
    	
    	loadLocalGuideReviewRate(this.localGuide,this.traveller);
    	
    	

    }
    
    @FXML
    void btnShowReviews(ActionEvent event) {
    	
    	loadLocalGuideShowReviews(this.localGuide);

    }
    
    @FXML
    void btnPlacesAndTravelsClick(ActionEvent event) {
    	
    	if(traveller == null) {
    		
    		loadPlacesAndTravels(this.localGuide);
    	}else {
    		loadPlacesAndTravelsViaTravellerView(this.localGuide);
    	}
    	
    }
    

	public LocalGuide getLocalGuide() {
		return localGuide;
	}

	public void setLocalGuide(LocalGuide localGuide) {
		this.localGuide = localGuide;
	}
	public void setTravellerAsLocalguide (Traveller traveller) {
		this.localGuide= system.transferTravellerToGuide(traveller);
		btnReviewRate.setVisible(false);;
		btnContact.setVisible(false);
		btnShowReviews.setVisible(false);
		lblTitle.setText("Traveller Profile");
	}
	public void setProfileData() {
		this.lblFullName.setText(this.localGuide.getFirstName()+" "+this.localGuide.getLastName());
		this.lblCity.setText(this.localGuide.getCity());
		this.lblCountry.setText(this.localGuide.getCountry());
		setLangData();
		setTravelStyleData();
		this.lblRating.setText(new DecimalFormat("##.##").format(this.localGuide.getRating()));
		this.lblAbout.setText(this.localGuide.getAboutMe());

		

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
	
	
    public void loadPlacesAndTravels(LocalGuide localGuide) {
		try {

			Stage stage=new Stage();
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/LocalGuidePlacesAndTravels.fxml"));
			Parent root = loader.load();
			Scene scene = new Scene(root);
			LocalGuidePlacesAndTravelsController placesAndTravelsController = loader.<LocalGuidePlacesAndTravelsController>getController();
			placesAndTravelsController.setLocalGuide(localGuide);
			placesAndTravelsController.initTablesData();
			placesAndTravelsController.setProfileData();
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			stage.setScene(scene);
			stage.setTitle("Guide4U - Local Guide Places & Travel Options");
			Image icon = new Image(getClass().getResourceAsStream("/img/g_logo.png"));
			stage.getIcons().add(icon);
			stage.initStyle(StageStyle.UNDECORATED);
			stage.show();
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
	
	
	
	
	public void loadLocalGuideShowReviews(LocalGuide localGuide) {
		
		try {

			Stage stage=new Stage();
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/LocalGuideShowReviews.fxml"));
			Parent root = loader.load();
			Scene scene = new Scene(root);
			LocalGuideShowReviewsController showRevController = loader.<LocalGuideShowReviewsController>getController();
			showRevController.setLocalGuide(localGuide);
			showRevController.setTraveller(traveller);
			showRevController.initReviewTableData();
			showRevController.setProfileData();
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			stage.setScene(scene);
			stage.setTitle("Guide4U - Local Guide Reviews");
			Image icon = new Image(getClass().getResourceAsStream("/img/g_logo.png"));
			stage.getIcons().add(icon);
			stage.initStyle(StageStyle.UNDECORATED);
			stage.show();
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	public void loadLocalGuideReviewRate(LocalGuide localGuide,Traveller traveller) {
		
		try {

			Stage stage=new Stage();
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/LocalGuideReviewRating.fxml"));
			Parent root = loader.load();
			Scene scene = new Scene(root);
			LocalGuideReviewRatingController reviewRatingController = loader.<LocalGuideReviewRatingController>getController();
			reviewRatingController.setLocalGuide(localGuide);
			reviewRatingController.setProfileData();
			reviewRatingController.setTraveller(traveller);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			stage.setScene(scene);
			stage.setTitle("Guide4U - Local Guide Reviews");
			Image icon = new Image(getClass().getResourceAsStream("/img/g_logo.png"));
			stage.getIcons().add(icon);
			stage.initStyle(StageStyle.UNDECORATED);
			stage.show();
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
    public void loadPlacesAndTravelsViaTravellerView(LocalGuide localGuide2) {
		try {

			Stage stage=new Stage();
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/LocalGuidePlacesAndTravels.fxml"));
			Parent root = loader.load();
			Scene scene = new Scene(root);
			LocalGuidePlacesAndTravelsController placesAndTravelsController = loader.<LocalGuidePlacesAndTravelsController>getController();
			placesAndTravelsController.setLocalGuide(localGuide);
			placesAndTravelsController.initTablesData();
			placesAndTravelsController.setProfileData();
			placesAndTravelsController.hideButtons();
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			stage.setScene(scene);
			stage.setTitle("Guide4U - Local Guide Places & Travel Options");
			stage.initStyle(StageStyle.UNDECORATED);
			stage.show();
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	public Traveller getTraveller() {
		return traveller;
	}

	public void setTraveller(Traveller traveller) {
		this.traveller = traveller;
	}
    
    public void hidebtnReviewRate() {
		this.btnReviewRate.setVisible(false);

    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}

}
