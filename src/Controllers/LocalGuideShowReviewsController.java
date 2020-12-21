package Controllers;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import Model.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

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

	@FXML
    void btnAddReviewClick(ActionEvent event) {

    }

    @FXML
    void btnExitClick(ActionEvent event) {
    	
    	btnExit.getScene().getWindow().hide();

    }
    
	public void setProfileData() {
		this.lblFullName.setText(this.localGuide.getFirstName()+" "+this.localGuide.getLastName());
		this.lblCity.setText(this.localGuide.getCity());
		this.lblCountry.setText(this.localGuide.getCountry());
		this.lblRating.setText(this.localGuide.getRatingAsString());
		
	}
    
	public void initReviewTableData() {
		
		
		
		this.tableReview.setItems(reviewData);
		this.c1_Date.setCellValueFactory(new PropertyValueFactory<Review, LocalDate>("date"));
		this.c2_travellerName.setCellValueFactory(new PropertyValueFactory<Review, String>("travellerName"));
		this.c3_city.setCellValueFactory(new PropertyValueFactory<Review, String>("city"));
		this.c4_country.setCellValueFactory(new PropertyValueFactory<Review, String>("country"));
		this.c5_reviewText.setCellValueFactory(new PropertyValueFactory<Review, String>("reviewText"));
		this.c6_rating.setCellValueFactory(new PropertyValueFactory<Review, Double>("rating"));
		
		  for (Review rev : system.getReviewsList()) {
			  if(rev.getLocalGuide().getEmail().equals(this.localGuide.getEmail())) {
				  reviewData.add(rev);
			  }else {
				  System.out.println("No Match!");
			  }
			  
 
		  }
			
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		system = SystemGuide4u.getInstance();
		
	}

}
