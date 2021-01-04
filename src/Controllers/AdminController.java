package Controllers;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.Map.Entry;

import Model.Gender;
import Model.LocalGuide;
import Model.SystemGuide4u;
import Model.Traveller;
import Model.User;
import application.Main;
import application.SqlTest;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class AdminController implements Initializable {

    @FXML
    private Group headerGroup;

    @FXML
    private Label lblDashboard;

    @FXML
    private Button btnLogOut;

    @FXML
    private Label lblUserName;

    @FXML
    private TabPane tabPanelTraveller;

    @FXML
    private Tab tabHome;

    @FXML
    private Tab tabFindAGuide;

    @FXML
    private TableView<LocalGuide> tableLocalGuide;

    @FXML
    private TableColumn<LocalGuide, String> c1_firstName;

    @FXML
    private TableColumn<LocalGuide, String> c2_lastName;

    @FXML
    private TableColumn<LocalGuide, Date> c3_dateOfBirth;

    @FXML
    private TableColumn<LocalGuide, Gender> c4_gender;

    @FXML
    private TableColumn<LocalGuide, String> c5_city;

    @FXML
    private TableColumn<LocalGuide, String> c6_country;

    @FXML
    private TableColumn<LocalGuide, String> c7_language;

    @FXML
    private TableColumn<LocalGuide, String> c8_travelStyle;

    @FXML
    private TableColumn<LocalGuide, Double> c9_rating;

    @FXML
    private TableColumn<LocalGuide, String> c10_email;

    @FXML
    private TableColumn<LocalGuide, Integer> c11_phone;
    @FXML
    private TableView<Traveller> TableTravellers;
    @FXML
    private TableColumn<Traveller, String> d1_firstName;

    @FXML
    private TableColumn<Traveller, String> d2_lastName;

    @FXML
    private TableColumn<Traveller, Date> d3_dateOfBirth;

    @FXML
    private TableColumn<Traveller, Gender> d4_gender;

    @FXML
    private TableColumn<Traveller, String> d5_city;

    @FXML
    private TableColumn<Traveller, String> d6_country;

    @FXML
    private TableColumn<Traveller, String> d7_language;

    @FXML
    private TableColumn<Traveller, String> d8_travelStyle;



    @FXML
    private TableColumn<Traveller, String> d10_email;

    @FXML
    private TableColumn<Traveller, Integer> d11_phoneNumber;


    @FXML
    private Button btnAddLocalGuide;

    @FXML
    private Button btnRemoveLocalGuide;


    @FXML
    private Tab tabAbout;
    
    @FXML
    private Button btnAddTraveller;

    @FXML
    private Button btnRemoveTraveller;
    
    private final ObservableList<LocalGuide> localGuideData =
            FXCollections.observableArrayList();
    private final ObservableList<Traveller> travellerData =
            FXCollections.observableArrayList();
    SystemGuide4u system=Main.system;
    
	public ObservableList<LocalGuide> getLocalGuideData() {
			
			return localGuideData;
		}
	public ObservableList<Traveller> getTravellerData() {
		
		return travellerData;
	}
		
	FilteredList<LocalGuide> filterdData;
	
	static SqlTest sql = new SqlTest();
		
		
	public void initLocalGuideTable() {
			
			this.tableLocalGuide.setItems(localGuideData);
			this.tableLocalGuide.setStyle("-fx-text-inner-color: black;");
			this.c1_firstName.setCellValueFactory(new PropertyValueFactory<LocalGuide, String>("firstName"));
			this.c2_lastName.setCellValueFactory(new PropertyValueFactory<LocalGuide, String>("lastName"));
			this.c3_dateOfBirth.setCellValueFactory(new PropertyValueFactory<LocalGuide, Date>("dateOfBirthForTable"));
			this.c4_gender.setCellValueFactory(new PropertyValueFactory<LocalGuide, Gender>("gender"));
			this.c5_city.setCellValueFactory(new PropertyValueFactory<LocalGuide, String>("city"));
			this.c6_country.setCellValueFactory(new PropertyValueFactory<LocalGuide, String>("country"));
			this.c7_language.setCellValueFactory(new PropertyValueFactory<LocalGuide, String>("languageForTable"));
			this.c8_travelStyle.setCellValueFactory(new PropertyValueFactory<LocalGuide, String>("travelStyleForTable"));
			this.c9_rating.setCellValueFactory(new PropertyValueFactory<LocalGuide, Double>("rating"));
			this.c10_email.setCellValueFactory(new PropertyValueFactory<LocalGuide, String>("email"));
			this.c11_phone.setCellValueFactory(new PropertyValueFactory<LocalGuide, Integer>("phoneNumber"));

			
			  for (Entry<String, LocalGuide> value : this.system.getLocalGuidesList().entrySet()) {
				  LocalGuide localGuide = value.getValue(); 
				  localGuideData.add(localGuide);
	 
			  }
			  
		}
	public void initTravellerTable() {
		
		this.TableTravellers.setItems(travellerData);
		this.tableLocalGuide.setStyle("-fx-text-inner-color: black;");
		this.d1_firstName.setCellValueFactory(new PropertyValueFactory<Traveller, String>("firstName"));
		this.d2_lastName.setCellValueFactory(new PropertyValueFactory<Traveller, String>("lastName"));
		this.d3_dateOfBirth.setCellValueFactory(new PropertyValueFactory<Traveller, Date>("dateOfBirthForTable"));
		this.d4_gender.setCellValueFactory(new PropertyValueFactory<Traveller, Gender>("gender"));
		this.d5_city.setCellValueFactory(new PropertyValueFactory<Traveller, String>("city"));
		this.d6_country.setCellValueFactory(new PropertyValueFactory<Traveller, String>("country"));
		this.d7_language.setCellValueFactory(new PropertyValueFactory<Traveller, String>("languageForTable"));
		this.d8_travelStyle.setCellValueFactory(new PropertyValueFactory<Traveller, String>("travelStyleForTable"));
		this.d10_email.setCellValueFactory(new PropertyValueFactory<Traveller, String>("email"));
		this.d11_phoneNumber.setCellValueFactory(new PropertyValueFactory<Traveller, Integer>("phoneNumber"));

		
		  for (Entry<String, Traveller> value : this.system.getTravellersList().entrySet()) {
			  Traveller traveller = value.getValue(); 
			  travellerData.add(traveller);
 
		  }
		  
	}
  
    @FXML
    void btnRemoveLocalGuide(ActionEvent event) {
    	try {
	    	LocalGuide localGuide = this.tableLocalGuide.getSelectionModel().getSelectedItem();
	    	sql.removeLocalGuideFromSQL(localGuide);
	    	sql.initLocalGuide();
	    	getLocalGuideData().remove(localGuide);
	    	system.removeLocalGuide(localGuide);
	    	System.out.println("REMOVED!!!!!!!!!!!!!!!");
//	    	Main.serialize("guide4u.ser");
//		    Main.deserialize();
    	} catch (Exception e) {
    		e.getMessage();
    		//system.popUpRemoveError();
    	}
    }

    @FXML
    void btnRemoveTraveller(ActionEvent event) {
    	try {
	    	Traveller traveller = this.TableTravellers.getSelectionModel().getSelectedItem();
	    	sql.removeTravellerFromSQL(traveller);
	    	sql.initTravellers();
	    	getTravellerData().remove(traveller);
	    	system.removeTraveller(traveller);
//	    	Main.serialize("guide4u.ser");
//		    Main.deserialize();
    	} catch (Exception e) {
    		e.getMessage();
    		//system.popUpRemoveError();
    	}
    }
    @FXML
    void btnAddLocalGuide(ActionEvent event) {
    	loadSignUpPage();
    	//btnAddLocalGuide.getScene().getWindow().hide();
    }

    @FXML
    void btnAddTraveller(ActionEvent event) {
    	loadSignUpPage();
    	//btnAddTraveller.getScene().getWindow().hide();
    }
    
    @FXML
    void btnLogOutClick(ActionEvent event) {
    	
    	btnLogOut.getScene().getWindow().hide();
    	system.reloadLoginPage();

    }

    
    
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
	//	this.system = SystemGuide4u.getInstance();
		system=Main.system;
		tableClickDetect();
		btnRemoveTraveller.disableProperty().bind(Bindings.isEmpty(TableTravellers.getSelectionModel().getSelectedItems()));
		btnRemoveLocalGuide.disableProperty().bind(Bindings.isEmpty(tableLocalGuide.getSelectionModel().getSelectedItems()));

		//initLocalGuideTable();
		//removeTraveller.disableProperty().bind(Bindings.isEmpty(tableLocalGuide.getSelectionModel().getSelectedItems()));

    }
	
public void loadSignUpPage() {
		

		try {
			Stage stage=new Stage();
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/SignUp.fxml"));
			Parent root = loader.load();
//			int screenWidth = (int) Screen.getPrimary().getVisualBounds().getWidth();
//			int screenHeight = (int) Screen.getPrimary().getVisualBounds().getHeight();
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			SignUpController signUpController = loader.<SignUpController>getController();
			//SignUpController.initLocalGuideTable();
			signUpController.setFlag(true);
			stage.setScene(scene);
			stage.initStyle(StageStyle.UNDECORATED);
			stage.setTitle("Guide4U -Guide4U - Sign Up");
			stage.show();
			

		} catch(Exception e) {
			e.printStackTrace();
		}
}
	public void tableClickDetect() {
		this.tableLocalGuide.setRowFactory( tv -> {
		    TableRow<LocalGuide> row = new TableRow<>();
		    row.setOnMouseClicked(event -> {
		        if (event.getClickCount() == 2 && (! row.isEmpty()) ) {
		        	LocalGuide localGuide = row.getItem();
		        	loadLocalGuideInfoPage(localGuide);
	
		        }
		    });
		    return row ;
		});
		this.TableTravellers.setRowFactory( tv -> {
		    TableRow<Traveller> row = new TableRow<>();
		    row.setOnMouseClicked(event -> {
		        if (event.getClickCount() == 2 && (! row.isEmpty()) ) {
		        	Traveller traveller = row.getItem();
		        	loadTravellerInfoPage(traveller);
	
		        }
		    });
		    return row ;
		});
	}
public void loadLocalGuideInfoPage(LocalGuide localGuide) {
	
	try {

		Stage stage=new Stage();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/LocalGuideProfile.fxml"));
		Parent root = loader.load();
		Scene scene = new Scene(root);
		LocalGuideProfileController lgProfileController = loader.<LocalGuideProfileController>getController();
		lgProfileController.setLocalGuide(localGuide);
		lgProfileController.setProfileData();
		lgProfileController.hidebtnReviewRate();
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		stage.setScene(scene);
		stage.setTitle("Guide4U - Local Guide Profile");
		stage.initStyle(StageStyle.UNDECORATED);
		stage.show();
		
		
	} catch(Exception e) {
		e.printStackTrace();
	}
}
	public void loadTravellerInfoPage(Traveller traveller) {
		
		try {

			Stage stage=new Stage();
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/LocalGuideProfile.fxml"));
			Parent root = loader.load();
			Scene scene = new Scene(root);
			LocalGuideProfileController lgProfileController = loader.<LocalGuideProfileController>getController();
			lgProfileController.setTravellerAsLocalguide(traveller);
			lgProfileController.setProfileData();
			lgProfileController.hidebtnReviewRate();
			lgProfileController.setTravellerAsLocalguide(traveller);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			stage.setScene(scene);
			stage.setTitle("Guide4U - traveller Profile");
			stage.initStyle(StageStyle.UNDECORATED);
			stage.show();
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	
}

}

