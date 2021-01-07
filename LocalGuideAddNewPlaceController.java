package Controllers;
import java.rmi.server.LoaderHandler;

import Model.*;
import application.Main;
import application.SqlTest;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class LocalGuideAddNewPlaceController {

    @FXML
    private Label lblLogo;

    @FXML
    private Button btnExit;

    @FXML
    private Label lblPlaceName;

    @FXML
    private Label lblCity;

    @FXML
    private Label lblTitle;

    @FXML
    private Label lblCountry;

    @FXML
    private Label txtCountry;

    @FXML
    private TextField txtPlaceName;

    @FXML
    private TextField txtCity;

    @FXML
    private Label lblInfo;

    @FXML
    private TextArea txtInfo;

    @FXML
    private Button btnAddNewPlace;
    
    LocalGuide localGuide;
    
    static SqlTest sql = new SqlTest();
    


	@FXML
    void btnAddNewPlaceClick(ActionEvent event) {
		
		try {
			
			String localGuideEmail = this.localGuide.getEmail();
			String name = this.txtPlaceName.getText();
			String city = this.txtCity.getText();
			String country = this.localGuide.getCountry();
			String info = this.txtInfo.getText();
			Place newPlace = new Place(localGuideEmail,name, city, country);
			newPlace.setInfo(info);
			System.out.println(newPlace.getInfo());
			sql.addNewPlaceToSQL(newPlace);
			Alert a = new Alert(AlertType.INFORMATION);
			a.setTitle("Place Added!");
			a.setHeaderText("Place Added!");
			a.setContentText("New Place was Added ! Thank You");
			a.show();
			btnAddNewPlace.getScene().getWindow().hide();
			
			
			
		}catch (Exception e) {
			
			Alert a = new Alert(AlertType.ERROR);
			a.setTitle("Error!");
			a.setHeaderText("Error!");
			a.setContentText("Error Occoured - Please Try Again");
			a.show();
			this.lblPlaceName.setText("");
			this.lblCity.setText("");
			this.txtInfo.setText("");
			
		}
		

    }

    @FXML
    void btnExitClick(ActionEvent event) {
    	btnExit.getScene().getWindow().hide();

    }
    
    
    public void setLocalGuide(LocalGuide localGuide) {
		this.localGuide = localGuide;
		this.txtCountry.setText(this.localGuide.getCountry());
	}
    


}
