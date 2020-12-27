package Controllers;
import java.net.URL;
import java.util.ResourceBundle;

import Model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ContactLocalGuideController implements Initializable {

    @FXML
    private Label lblContact;

    @FXML
    private Button btnOK;

    @FXML
    private Label lblLocalGuideName;

    @FXML
    private Label lblLocalGuideEmail;

    @FXML
    private Label lblLocalGuidePhone;

    @FXML
    private ImageView imgEmailIcon;

    @FXML
    private ImageView imgPhoneIcon;
    
    LocalGuide localGuide;

    public LocalGuide getLocalGuide() {
		return localGuide;
	}

	public void setLocalGuide(LocalGuide localGuide) {
		this.localGuide = localGuide;
	}

	@FXML
    void btnOKclick(ActionEvent event) {
		btnOK.getScene().getWindow().hide();

    }
	
	public void setData() {
		this.lblLocalGuideName.setText(this.localGuide.getFirstName()+" "+this.localGuide.getLastName());
		this.lblLocalGuideEmail.setText(this.localGuide.getEmail());
		this.lblLocalGuidePhone.setText(this.localGuide.getPhoneNumber().toString());
		
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		
	}



}
