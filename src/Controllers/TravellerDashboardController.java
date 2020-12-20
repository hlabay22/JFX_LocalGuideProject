package Controllers;

import java.beans.EventHandler;
import java.net.URL;
import java.util.Date;
import java.util.Map.Entry;
import java.util.ResourceBundle;
import Model.Gender;
import Model.Language;
import Model.LocalGuide;
import Model.SystemGuide4u;
import Model.TravelStyle;
import Model.Traveller;
import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;



public class TravellerDashboardController implements Initializable {

    @FXML
    private Group headerGroup;

    @FXML
    private Label lblDashboard;

    @FXML
    private Button btnLogOut;

    @FXML
    public Label lblUserName;

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
    private TextField txtSearchBox;

    @FXML
    private Label lblSearch;

    @FXML
    private Button btnMatchmakerSearch;

    @FXML
    private Tab tabAbout;
  
	private final ObservableList<LocalGuide> localGuideData =
            FXCollections.observableArrayList();
	
    SystemGuide4u system=Main.system;
	
	Traveller traveller;
    


	public ObservableList<LocalGuide> getLocalGuideData() {
		
		return localGuideData;
	}
	
	FilteredList<LocalGuide> filterdData;

    @FXML
    void btnLogOutClick(ActionEvent event) {
    	
    	btnLogOut.getScene().getWindow().hide();
    	system.reloadLoginPage();

    }



	@FXML
    void btnMatchmakerSearchClick(ActionEvent event) {
    	
    	try {

			Stage stage=new Stage();
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/MatchmakerSearch.fxml"));
			Parent root = loader.load();
			Scene scene = new Scene(root);
			MatchmakerSearchController MSController = loader.<MatchmakerSearchController>getController();
			MSController.setTraveller(this.traveller);
			MSController.showHideResult(false);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			stage.setScene(scene);
			stage.setTitle("Guide4U - Matchmaker Search");
			stage.initStyle(StageStyle.UNDECORATED);
			stage.show();
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}

    }
    
    
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
	
	public void filterdSearchInit() {
		
		filterdData = new FilteredList<>(localGuideData, b -> true);
		txtSearchBox.textProperty().addListener((observable,oldValue,newValue) -> {
			filterdData.setPredicate(localGuide -> {
				
				// if filter is empty, display all local guides.
				if(newValue == null || newValue.isEmpty()) {
					return true;
				}
				
				//Compare firstName , lastName, city , country, language and travelstyle of every local guide with filter text
				String lowerCaseFilter = newValue.toLowerCase();
				
				if(localGuide.getFirstName().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true;
				}
				else if(localGuide.getLastName().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true;
				}
				else if(localGuide.getCity().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true;
				}
				else if(localGuide.getCountry().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true;
				}
				else if(localGuide.getLanguageForTable().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true;
				}
				else if(localGuide.getTravelStyleForTable().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true;
				} else {
					return false;
				}
				
			});
			
		});
		
		SortedList<LocalGuide> sortedData = new SortedList<>(filterdData);
		
		sortedData.comparatorProperty().bind(tableLocalGuide.comparatorProperty());
		
		tableLocalGuide.setItems(sortedData);
	
			
			  
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
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			stage.setScene(scene);
			stage.setTitle("Guide4U - Local Guide Profile");
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
		this.lblUserName.setText(traveller.getFirstName()+" "+traveller.getLastName());
		
	}
	



	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		this.system = SystemGuide4u.getInstance();
		initLocalGuideTable();
		filterdSearchInit();
		tableClickDetect();
		
	}
}