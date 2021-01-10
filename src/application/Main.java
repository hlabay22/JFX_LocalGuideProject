package application;
	
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Date;
import java.util.HashMap;
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
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	
	
    // Attributes set up.
	public static SystemGuide4u system= SystemGuide4u.getInstance();
    static SqlTest sql = new SqlTest();
    
    // Import from txt file - Unused on final version.
	private static void importDataFromTxtFile() throws ParseException {
        try {
            
            FileReader reader = new FileReader("guide4u.txt");
            Scanner in = new Scanner(reader);
            while (in.hasNextLine()) {
            	String line=in.nextLine();
            	String[] lineArray = line.split(",");
                System.out.println(lineArray.length);
                System.out.println(lineArray[1]);
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
                    if(lineArray[11]!=null) {
                    	language=new Language(lineArray[10], lineArray[11]);
                    	if(lineArray[12]!=null) {
                    		language=new Language(lineArray[10], lineArray[11], lineArray[12]);
                    	}
                    }
                    
                    TravelStyle travelStyle= new TravelStyle(lineArray[13]);
                    if(lineArray[14]!=null) {
                    	travelStyle=new TravelStyle(lineArray[13], lineArray[14]);
                    	if(lineArray[15]!=null) {
                    		travelStyle=new TravelStyle(lineArray[13], lineArray[14], lineArray[15]);
                    	}
                    }
                    
                    String aboutMe=lineArray[16];
                    boolean emailNotifacations=lineArray[17].equalsIgnoreCase("yes");
                    
                    if (lineArray[0].equalsIgnoreCase("Local Guide")) {
                    system.addGuide(new LocalGuide(email, password, firstName,
                    							lastName, date, gender, city,
                    							country, phone, language, travelStyle,
                    							aboutMe, emailNotifacations));
                    }
                    else if (lineArray[0].equalsIgnoreCase("Traveller")) {
                    	system.addTraveller(new Traveller(email, password, firstName,
    							lastName, date, gender, city,
    							country, phone, language, travelStyle,
    							aboutMe, emailNotifacations));
                    }
                    else if (lineArray[0].equalsIgnoreCase("Both")) {
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
	
	// Serialization method - Unused on final version.
	public static void serialize(String fileName) {
        
        try {
            
            FileOutputStream fileOut = 
                    new FileOutputStream(fileName);
            
            ObjectOutputStream out =
                    new ObjectOutputStream(fileOut);
        
    
            out.writeObject(system);
            System.out.println("Serialized Data is saved");

            out.close();
            fileOut.close();
            
        } catch (IOException e) {
            
            System.out.println(e.getMessage());
            
        }

    }
	
	// Serialization method - Unused on final version.
	public static void deserialize() {
		try {
			FileInputStream fileIn = new FileInputStream("guide4u.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			system= (SystemGuide4u) in.readObject();
			in.close();
			fileIn.close();
			System.out.println("The Object is deseriazble my friend!");
		} catch (IOException i) {
			i.printStackTrace();
		} catch (ClassNotFoundException c) {
			c.printStackTrace();
		}
	}
	


	@Override
	public void start(Stage primaryStage) {
		try {
			system.populateLocalGuideExample();
			system.populateTravellerExample();
			//system.populateReviewsExample();
			Parent root = FXMLLoader.load(Main.class.getResource("/FXML/Login.fxml"));
			Scene scene = new Scene(root,1130,725);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Guide4U - Login");
			Image icon = new Image(getClass().getResourceAsStream("/img/g_logo.png"));
			primaryStage.getIcons().add(icon);
			primaryStage.initStyle(StageStyle.UNDECORATED);
			primaryStage.show();
			primaryStage.setResizable(false);
			
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws ParseException {

		// Establish SQL connection an initialize the data from Database.
//		sql.conectTo();
		sql.initLocalGuide();
		sql.initTravellers();
		sql.initReviews();
		sql.initUnavailbleDates();
		sql.initPlaces();
		launch(args);
	}
}
