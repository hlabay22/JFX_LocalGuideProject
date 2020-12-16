package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class SignUpController {

    @FXML
    private ImageView imgBackground;

    @FXML
    private Pane paneLogin;

    @FXML
    private Label lblSignUp;

    @FXML
    private TextField txtEmail;

    @FXML
    private Label lblEmail;

    @FXML
    private Label lblPassword;

    @FXML
    private Button btnSignIn;

    @FXML
    private ComboBox<?> comBoxUserType;

    @FXML
    private Label lblUserType;

    @FXML
    private Label lblFirstName;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private TextField txtFirstName;

    @FXML
    private Label lblLastName;

    @FXML
    private TextField txtLastName;

    @FXML
    private Label lblDOB;

    @FXML
    private DatePicker comBoxDOB;

    @FXML
    private Label lblGender;

    @FXML
    private ComboBox<?> comBoxGender;

    @FXML
    private Label lblPhone;

    @FXML
    private TextField txtPhone;

    @FXML
    private TextField txtCity;

    @FXML
    private Label lblCity;

    @FXML
    private ComboBox<?> comBoxCountry;

    @FXML
    private Label lblCountry;

    @FXML
    private ComboBox<?> comBoxLang1;

    @FXML
    private Label lblLang1;

    @FXML
    private ComboBox<?> comBoxLang2;

    @FXML
    private Label lblLang2;

    @FXML
    private ComboBox<?> comBoxLang3;

    @FXML
    private Label lblLang3;

    @FXML
    private ComboBox<?> comBoxTravelStyle1;

    @FXML
    private Label lblTravelStyle1;

    @FXML
    private ComboBox<?> comBoxTravelStyle2;

    @FXML
    private Label lblTravelStyle2;

    @FXML
    private ComboBox<?> comBoxTravelStyle3;

    @FXML
    private Label lblTravelStyle3;

    @FXML
    private ComboBox<?> comBoxTransportType;

    @FXML
    private Label lblTransportType;

    @FXML
    private Label lblAboutMe;

    @FXML
    private TextArea txtAboutMe;

    @FXML
    private CheckBox checkBoxEmailNots;

    @FXML
    private Button btnExit;

    @FXML
    private Label lblLogo;

    @FXML
    void btnExitClick(ActionEvent event) {
    	System.exit(0);

    }

    @FXML
    void btnSignInClick(ActionEvent event) {

    }

}

