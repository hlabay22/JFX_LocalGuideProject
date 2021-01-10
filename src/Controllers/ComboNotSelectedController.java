package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/*
 * Controller for Error message popup - when comboBox value is not selected.
 * helps the user to locate and target the problem with data input.
 */
public class ComboNotSelectedController {

    @FXML
    private Label lblError;

    @FXML
    private Button btnOK;

    @FXML
    void btnOKclick(ActionEvent event) {
    	btnOK.getScene().getWindow().hide();
    }

}
