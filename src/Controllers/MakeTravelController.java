package Controllers;

import java.time.LocalDate;
import java.util.ArrayList;

import Model.LocalGuide;
import Model.Place;
import Model.SystemGuide4u;
import Model.Travel;
import Model.Traveller;
import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class MakeTravelController {

    @FXML
    private ImageView imgBackground;

    @FXML
    private Pane paneLogin;

    @FXML
    private Label lblTitle;

    @FXML
    private Label lblLogo;

    @FXML
    private Label lblTravelTitle;

    @FXML
    private Label lblPLACE1;

    @FXML
    private Label lblPLACE2;

    @FXML
    private Label lblPLACE3;

    @FXML
    private Label lblDateTitle;

    @FXML
    private Label lblDate;

    @FXML
    private Label lblfirstplace;

    @FXML
    private Button btnMakeTravel;

    @FXML
    private Separator horizSep;

    @FXML
    private Label lblNote;

    @FXML
    private ComboBox<String> comboBoxFirstPlace;

    @FXML
    private Label lblsecondplace;

    @FXML
    private ComboBox<String> comboBoxSecondPlace;

    @FXML
    private Label lblthirdplace;

    @FXML
    private ComboBox<String> comboBoxThirdPlace;

    @FXML
    private Label lblTravelStyle11;

    @FXML
    private Label lblTravelStyle111;

    @FXML
    private Label lblTravelStyle112;

    @FXML
    private ImageView img1;

    @FXML
    private ImageView img3;

    @FXML
    private ImageView img2;
    @FXML
    private ImageView img4;

    @FXML
    private ImageView img5;
    @FXML
    private Label lblLocalTitle1;

    @FXML
    private Label lblLocal;
    
    SystemGuide4u system=Main.system;
    Traveller traveller;
    LocalDate date;
	LocalGuide localGuide;
	 ArrayList<Place> placesInTravel= new ArrayList<Place>(); 
    @FXML
    private Button btnExit;
    Place place1=new Place("Metzada", "Ein-Bokek", "israel");
    Place place2=new Place("Mactesh-Ramon", "Mitzpe-Ramon", "Israel");
    Place place3=new Place("Nachal-Tzelim", "Arad", "Israel");
    Place place4=new Place("Azriely-Mall", "Tel-Aviv", "Israel");
    Place place5=new Place("Hacotel", "Jerusalem", "Israel");
    

    @FXML
    void btnExitClick(ActionEvent event) {

    }

    @FXML
    void btnMakeTravel(ActionEvent event) {
    	lblPLACE1.setText(comboBoxFirstPlace.getValue().toString());
    	lblPLACE2.setText(comboBoxSecondPlace.getValue().toString());
    	lblPLACE3.setText(comboBoxThirdPlace.getValue().toString());
    	
    	if(lblPLACE1.getText().equals("Metzada") || lblPLACE2.getText().equals("Metzada") || lblPLACE3.getText().equals("Metzada")) {
    		placesInTravel.add(place1);}
    	if(lblPLACE1.getText().equals("Mactesh-Ramon") || lblPLACE2.getText().equals("Mactesh-Ramon") || lblPLACE3.getText().equals("Mactesh-Ramon")) {
    		placesInTravel.add(place2);}
    	if(lblPLACE1.getText().equals("Azriely-Mall") || lblPLACE2.getText().equals("Azriely-Mall") || lblPLACE3.getText().equals("Azriely-Mall")) {
    		placesInTravel.add(place4);}
    	if(lblPLACE1.getText().equals("Nachal-Tzelim") || lblPLACE2.getText().equals("Nachal-Tzelim") || lblPLACE3.getText().equals("Nachal-Tzelim")) {
    		placesInTravel.add(place3);}
    	if(lblPLACE1.getText().equals("Hacotel") || lblPLACE2.getText().equals("Hacotel") || lblPLACE3.getText().equals("Hacotel")) {
    		placesInTravel.add(place5);}
    	
        Travel travel=new Travel(localGuide, traveller, date, placesInTravel);
      
        system.addTravel(travel);
        Main.serialize("guide4u");
        Main.deserialize();
    	showHideResult(true);
    }
    @FXML
    public void initialize() {
    
    	comboBoxFirstPlace.getItems().setAll("Metzada","Mactesh-Ramon","Hacotel","Nachal-Tzelim","Azriely-Mall");
    	comboBoxSecondPlace.getItems().setAll("Metzada","Mactesh-Ramon","Hacotel","Nachal-Tzelim","Azriely-Mall");
    	comboBoxThirdPlace.getItems().setAll("Metzada","Mactesh-Ramon","Hacotel","Nachal-Tzelim","Azriely-Mall");
    	showHideResult(false);

    }
	public void showHideResult(boolean value) {
		lblDate.setVisible(value);
		lblDateTitle.setVisible(value);
		lblPLACE2.setVisible(value);
		lblPLACE1.setVisible(value);
		lblPLACE3.setVisible(value);
		lblLocalTitle1.setVisible(value);
		lblLocal.setVisible(value);
		lblTravelTitle.setVisible(value);
		lblTravelStyle11.setVisible(value);
		lblTravelStyle111.setVisible(value);
		lblTravelStyle112.setVisible(value);


	}
    public void setDetails( LocalGuide guide, LocalDate date, Traveller traveller) {
    	lblDate.setText(date.toString());
    	lblLocal.setText(guide.getFirstName()+" "+guide.getLastName());
    	
    	this.localGuide=guide;
    	this.traveller=traveller;
    	this.date=date;
    }
}

