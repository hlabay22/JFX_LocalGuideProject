package Controllers;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.Map.Entry;

import Model.LocalGuide;
import Model.Place;
import Model.Review;
import Model.SystemGuide4u;
import Model.Travel;
import Model.TravelOption;
import Model.Traveller;
import application.Main;
import application.SqlTest;
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
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class LocalGuidePlacesAndTravelsController implements Initializable{

    @FXML
    private ImageView imgBackground;

    @FXML
    private Pane paneLogin;

    @FXML
    private Label lblTitle;

    @FXML
    private Label lblFullName;

    @FXML
    private Label lblCity;

    @FXML
    private Label lblCountry;

    @FXML
    private ImageView imgProfileImage;

    @FXML
    private Label lblLogo;

    @FXML
    private Label lblPlaces;

    @FXML
    private Label lblTravelStyleTitle;

    @FXML
    private Button btnRemoveTravelOption;

    @FXML
    private Button btnAddTravelOption;

    @FXML
    private TableView<Place> tablePlaces;

    @FXML
    private TableColumn<Place, LocalGuide> c1_tablePlaces_name;

    @FXML
    private TableColumn<Place, LocalGuide> c2_tablePlaces_city;

    @FXML
    private TableColumn<Place, LocalGuide> c3_tablePlaces_info;

    @FXML
    private TableView<TravelOption> tableTravels;

    @FXML
    private TableColumn<TravelOption, LocalGuide> c1_tableTravels_name;

    @FXML
    private TableColumn<TravelOption, Double> c2_tableTravels_duration;

    @FXML
    private TableColumn<TravelOption, LocalGuide> c3_tableTravels_info;

    @FXML
    private Button btnRemovePlace;

    @FXML
    private Button btnAddPlace;

    @FXML
    private Button btnExit;
    
    LocalGuide localGuide;
    
    SystemGuide4u system=Main.system; 
    
	static SqlTest sql = new SqlTest();
    
	private final ObservableList<Place> placesData =
            FXCollections.observableArrayList();
	






	private final ObservableList<TravelOption> travelsData =
            FXCollections.observableArrayList();
    

    @FXML
    void btnAddPlaceClick(ActionEvent event) {
    	loadAddPlace();

    }

    @FXML
    void btnAddTravelOptionClick(ActionEvent event) {

    }

    @FXML
    void btnExitClick(ActionEvent event) {
    	btnExit.getScene().getWindow().hide();

    }

    @FXML
    void btnRemovePlaceClick(ActionEvent event) {
    	
       	try {
	    	Place place = this.tablePlaces.getSelectionModel().getSelectedItem();
	    	sql.removePlaceFromSQL(place);
	    	sql.initPlaces();
	    	getPlacesData().remove(place);
//	    	Main.serialize("guide4u.ser");
//		    Main.deserialize();
    	} catch (Exception e) {
    		e.getMessage();
    		//system.popUpRemoveError();
    	}

    }

    @FXML
    void btnRemoveTravelOptionClick(ActionEvent event) {

    }
    
    @FXML
    void OnMouseEnteredPlacesTable(MouseEvent event) {
    	
    	this.tablePlaces.getColumns().get(0).setVisible(false);
    	this.tablePlaces.getColumns().get(0).setVisible(true);
    }
    
    
    
    public void setLocalGuide(LocalGuide localGuide) {
    	this.localGuide = localGuide;
    }
    
    
	public void setProfileData() {
		this.lblFullName.setText(this.localGuide.getFirstName()+" "+this.localGuide.getLastName());
		this.lblCity.setText(this.localGuide.getCity());
		this.lblCountry.setText(this.localGuide.getCountry());
		
	}
	
	public void initTablesData() {
		initPlacesTable();
		initTravelsTable();
	}
	
	public void initPlacesTable() {
		this.tablePlaces.setItems(placesData);
		this.c1_tablePlaces_name.setCellValueFactory(new PropertyValueFactory<Place, LocalGuide>("name"));
		this.c2_tablePlaces_city.setCellValueFactory(new PropertyValueFactory<Place, LocalGuide>("city"));
		this.c3_tablePlaces_info.setCellValueFactory(new PropertyValueFactory<Place, LocalGuide>("info"));

		
		for (Entry<Integer, Place> value : system.getPlaceList().entrySet()) {
			  Place place = value.getValue();
			  placesData.add(place);
			  
		}
	}
	
	public void initTravelsTable() {
		this.tableTravels.setItems(travelsData);
		this.c1_tableTravels_name.setCellValueFactory(new PropertyValueFactory<TravelOption, LocalGuide>("travelOptionName"));
		this.c2_tableTravels_duration.setCellValueFactory(new PropertyValueFactory<TravelOption, Double>("duration"));
		this.c3_tableTravels_info.setCellValueFactory(new PropertyValueFactory<TravelOption, LocalGuide>("travelOptionInfo"));

		
		for (TravelOption travelOption : this.localGuide.getLocalGuideTravels()) {
			travelsData.add(travelOption);
		}
	}
	
	public void hideButtons() {
		this.btnAddPlace.setVisible(false);
		this.btnRemovePlace.setVisible(false);
		this.btnAddTravelOption.setVisible(false);
		this.btnRemoveTravelOption.setVisible(false);
		
	}
	
	
	public void loadAddPlace() {
		
		try {

			Stage stage=new Stage();
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/LocalGuideAddNewPlace.fxml"));
			Parent root = loader.load();
			Scene scene = new Scene(root);
			LocalGuideAddNewPlaceController addPlaceController = loader.<LocalGuideAddNewPlaceController>getController();
			addPlaceController.setLocalGuide(localGuide);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			stage.setScene(scene);
			stage.setTitle("Guide4U - Local Guide Add New Place");
			stage.initStyle(StageStyle.UNDECORATED);
			stage.show();
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void loadAddTravel() {
		
	}
	
	
	
	
	public ObservableList<Place> getPlacesData() {
		return placesData;
	}


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}