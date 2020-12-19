package application;
	
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Date;
import java.util.Scanner;

import Model.Gender;
import Model.Language;
import Model.LocalGuide;
import Model.SystemGuide4u;
import Model.TravelStyle;
import Model.Traveller;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	public static SystemGuide4u system= SystemGuide4u.getInstance();

	private static void importDataFromTxtFile() throws ParseException {
        try {
            
            FileReader reader = new FileReader("guide4u.txt");
            Scanner in = new Scanner(reader);
            while (in.hasNextLine()) {
            	String line=in.nextLine();
                String[] lineArray = line.split(",");
                    String firstName = lineArray[1];
                    String lastName = lineArray[2];
                    String email=lineArray[3];
                    String password=lineArray[4];
                    DateTimeFormatter df = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                    LocalDate date = LocalDate.parse(lineArray[5],df);
                    Gender gender= Gender.Female;
                    if( lineArray[6].equalsIgnoreCase("Male")) {
                    	gender= Gender.Male;
                    }
                    String country=lineArray[7];
                    String city=lineArray[8];
                    Integer phone=Integer.parseInt(lineArray[9]);
                    Language language=new Language(lineArray[10]);
                    TravelStyle travelStyle= new TravelStyle(lineArray[11]);
                    String aboutMe=lineArray[12];
                    boolean emailNotifacations=lineArray[13].equalsIgnoreCase("yes");
                    
                    if (lineArray[0].equalsIgnoreCase("LocalGuide")) {
                    system.addGuide(new LocalGuide(email, password, firstName,
                    							lastName, date, gender, city,
                    							country, phone, language, travelStyle,
                    							aboutMe, emailNotifacations));
                    }
                    else if (lineArray[0].equalsIgnoreCase("traveller")) {
                    	system.addTraveller(new Traveller(email, password, firstName,
    							lastName, date, gender, city,
    							country, phone, language, travelStyle,
    							aboutMe, emailNotifacations));
                    }
                    else if (lineArray[0].equalsIgnoreCase("both")) {
                    	system.addTraveller(new Traveller(email, password, firstName,
    							lastName, date, gender, city,
    							country, phone, language, travelStyle,
    							aboutMe, emailNotifacations));
                    	 system.addGuide(new LocalGuide(email, password, firstName,
     							lastName, date, gender, city,
     							country, phone, language, travelStyle,
     							aboutMe, emailNotifacations));
                    }
}
            
            in.close();
            reader.close();

            

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(Main.class.getResource("/FXML/Login.fxml"));
			Scene scene = new Scene(root,1130,725);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Guide4U - Login");
			primaryStage.initStyle(StageStyle.UNDECORATED);
			primaryStage.show();
			primaryStage.setResizable(false);
			
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws ParseException {
		importDataFromTxtFile();
		launch(args);
	}
}
