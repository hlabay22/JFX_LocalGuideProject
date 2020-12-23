package Exceptions;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class GeneralErrorException extends Exception {
	
	public GeneralErrorException() {
		Alert a = new Alert(AlertType.ERROR);
		a.setTitle("Error!");
		a.setHeaderText("Error!");
		a.setContentText("Error Occoured - Please Try Again");
		a.show();
		
	}

}
