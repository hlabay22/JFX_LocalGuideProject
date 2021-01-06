package Controllers;
import java.net.URL;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.Map.Entry;

import Model.*;
import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class LocalGuideShowReviewsController implements Initializable {

    @FXML
    private ImageView imgBackground;

    @FXML
    private Pane paneLogin;

    @FXML
    private Label lblTitle;

    @FXML
    private Label lblFullName;

    @FXML
    private Button btnAddReview;

    @FXML
    private Label lblCity;

    @FXML
    private Label lblCountry;

    @FXML
    private ImageView imgProfileImage;

    @FXML
    private Label lblLogo;

    @FXML
    private Label lblReviewsTitle;

    @FXML
    private Label lblRating;

    @FXML
    private Label lblOfTen;

    @FXML
    private TableView<Review> tableReview;

    @FXML
    private TableColumn<Review, LocalDate> c1_Date;

    @FXML
    private TableColumn<Review, String> c2_travellerName;

    @FXML
    private TableColumn<Review, String> c3_city;

    @FXML
    private TableColumn<Review, String> c4_country;

    @FXML
    private TableColumn<Review, String> c5_reviewText;

    @FXML
    private TableColumn<Review, Double> c6_rating;

    @FXML
    private Button btnExit;
    
    LocalGuide localGuide;
    
    Traveller traveller;
    


	SystemGuide4u system; 
    
	private final ObservableList<Review> reviewData =
            FXCollections.observableArrayList();
    
  
    
    // Methods
    
    
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

	@FXML
    void btnAddReviewClick(ActionEvent event) {
		
		loadLocalGuideReviewRate(this.localGuide, this.traveller);

    }

    @FXML
    void btnExitClick(ActionEvent event) {
    	
    	btnExit.getScene().getWindow().hide();

    }
    
	public void setProfileData() {
		this.lblFullName.setText(this.localGuide.getFirstName()+" "+this.localGuide.getLastName());
		this.lblCity.setText(this.localGuide.getCity());
		this.lblCountry.setText(this.localGuide.getCountry());
		this.lblRating.setText(new DecimalFormat("##.##").format(this.localGuide.getRating()));
		
	}
    
	public void initReviewTableData() {
		
		Double sumForRating = 0.0; 
		int cntForRating = 0;
		for (Entry<Integer, Review> value : this.system.getReviewsList().entrySet()) {
			  Review rev = value.getValue();
			  if(rev.getLocalGuideEmail().equals(this.localGuide.getEmail())) {
				  reviewData.add(rev);
				  if(rev.getRating()!=null) {
					  sumForRating = sumForRating + rev.getRating();
					  cntForRating++;
				  }
			 				  
			  }else {
				  System.out.println("No Match!");
			  }
		  }
		  
		 Double rating= sumForRating/cntForRating;
		 system.getGuideByEmail(this.localGuide.getEmail()).setRating(rating);
		
		this.tableReview.setItems(reviewData);
		this.c1_Date.setCellValueFactory(new PropertyValueFactory<Review, LocalDate>("date"));
		this.c2_travellerName.setCellValueFactory(new PropertyValueFactory<Review, String>("traveller"));
		this.c3_city.setCellValueFactory(new PropertyValueFactory<Review, String>("city"));
		this.c4_country.setCellValueFactory(new PropertyValueFactory<Review, String>("country"));
		this.c5_reviewText.setCellValueFactory(new PropertyValueFactory<Review, String>("reviewText"));
		this.c6_rating.setCellValueFactory(new PropertyValueFactory<Review, Double>("rating"));

			
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

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		system = Main.system;
		
	}

}
