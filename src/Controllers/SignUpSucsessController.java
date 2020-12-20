package Controllers;

import Model.SystemGuide4u;
import Model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class SignUpSucsessController {

    @FXML
    private Label lblError;

    @FXML
    private Button btnOK;

    @FXML
    private Label userName;
    SystemGuide4u system= SystemGuide4u.getInstance();

    @FXML
    void btnOKclick(ActionEvent event) {
    	system.reloadLoginPage();

    }
    
    public void setUser(User user) {
    	userName.setText(user.getFirstName());
    }

}

