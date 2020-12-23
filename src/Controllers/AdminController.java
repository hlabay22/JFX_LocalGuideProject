package Controllers;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.Map.Entry;

import Model.Gender;
import Model.LocalGuide;
import Model.SystemGuide4u;
import application.Main;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class AdminController {

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
    private Button btnRemove;

    @FXML
    private Button btnAdd;

    @FXML
    private Tab tabAbout;
    private final ObservableList<LocalGuide> localGuideData =
            FXCollections.observableArrayList();
    SystemGuide4u system=Main.system;
	public ObservableList<LocalGuide> getLocalGuideData() {
			
			return localGuideData;
		}
		
		FilteredList<LocalGuide> filterdData;
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
		
    @FXML
    void btnAdd(ActionEvent event) {
    	loadSignUpPage();
    	btnAdd.getScene().getWindow().hide();

    }

    @FXML
    void btnLogOutClick(ActionEvent event) {

    }

    @FXML
    void btnRemove(ActionEvent event) {
    	try {
	    	LocalGuide localGuide = this.tableLocalGuide.getSelectionModel().getSelectedItem();
	    	getLocalGuideData().remove(localGuide);
	    	system.removeLocalGuide(localGuide);
	    	//system.popUpRemoveSucces();
	    	
    	} catch (Exception e) {
    		e.getMessage();
    		//system.popUpRemoveError();
    	}

    }

    
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
	//	this.system = SystemGuide4u.getInstance();
		system=Main.system;
		initLocalGuideTable();
		btnRemove.disableProperty().bind(Bindings.isEmpty(tableLocalGuide.getSelectionModel().getSelectedItems()));

    }
public void loadSignUpPage() {
		
		try {
			Stage stage=new Stage();
			Parent root = FXMLLoader.load(Main.class.getResource("/FXML/SignUp.fxml"));
			Scene scene = new Scene(root,1130,725);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			stage.setScene(scene);
			stage.setTitle("Guide4U - Sign Up");
			stage.initStyle(StageStyle.UNDECORATED);
			stage.show();
			stage.setResizable(false);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}

