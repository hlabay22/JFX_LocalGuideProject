package application;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.Map.Entry;
import Model.Gender;
import Model.Language;
import Model.LocalGuide;
import Model.Place;
import Model.Review;
import Model.SystemGuide4u;
import Model.TravelStyle;
import Model.Traveller;
import Model.User;

	/*
	 * SQL Class - Collection of all SQL Database related methods.
	 */

	public class SqlTest {
	    static SystemGuide4u system=Main.system;
	    static String connectionUrl = "jdbc:sqlserver://localhost;databaseName=guide4u;integratedSecurity=true;";
		static Connection con = null;  
		static Statement stmt = null;  
		static ResultSet rs = null;  


		public SqlTest() {
			conectTo();
		}
		
		
		// Initialize LocalGuide table from database - into HashMap so it can be used as Objects on program
		public static void initLocalGuide() {
			try {  
				
				String SQL = "SELECT * FROM LocalGuides ";  
				stmt = con.createStatement();  
				rs = stmt.executeQuery(SQL);  
				while (rs.next()) {  
					
					
	                    String firstName = rs.getString(1);
	                    String lastName =  rs.getString(2);
	                    String email= rs.getString(3);
	                    String password= rs.getString(4);
	                    DateTimeFormatter df = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
	                    LocalDate date = LocalDate.parse(rs.getString(5),df);
	                    Gender gender= Gender.Female;
	                    if( rs.getString(6).equalsIgnoreCase("Male")) {
	                    	gender= Gender.Male;
	                    }
	                    String country= rs.getString(7);
	                    String city= rs.getString(8);
	                    Integer phone=rs.getInt(9);
	                    Language language=new Language(rs.getString(10));
	                    if( rs.getString(11)!=null) {
	                    	language=new Language(rs.getString(10), rs.getString(11));
	                    	if(rs.getString(12)!=null) {
	                    		language=new Language(rs.getString(10), rs.getString(11), rs.getString(12));
	                    	}
	                    }
	                    
	                    TravelStyle travelStyle= new TravelStyle(rs.getString(13));
	                    if(rs.getString(14)!=null) {
	                    	travelStyle=new TravelStyle(rs.getString(13), rs.getString(14));
	                    	if(rs.getString(15)!=null) {
	                    		travelStyle=new TravelStyle(rs.getString(13), rs.getString(14), rs.getString(15));
	                    	}
	                    }
	                    
	                    String aboutMe=rs.getString(16);
	                    boolean emailNotifacations=rs.getString(17).equalsIgnoreCase("yes");
	                    
	                    LocalGuide lg = new LocalGuide(email, password, firstName,
    							lastName, date, gender, city,
    							country, phone, language, travelStyle,
    							aboutMe, emailNotifacations);
	                    
	                    system.addGuide(new LocalGuide(email, password, firstName,
    							lastName, date, gender, city,
    							country, phone, language, travelStyle,
    							aboutMe, emailNotifacations));
	                    
	                    
				}  
			}  
			catch (SQLException e) {
				e.printStackTrace();
			}

			finally {  
				if (rs != null) try { rs.close(); } catch(Exception e) {}  
				if (stmt != null) try { stmt.close(); } catch(Exception e) {}
				System.out.println();
			} 

		}
		
		// Initialize Travellers table from database - into HashMap so it can be used as Objects on program
		public static void initTravellers() {
			try {  
				String SQL = "SELECT * FROM Travellers "; 
				stmt = con.createStatement();  
				rs = stmt.executeQuery(SQL);  
				while (rs.next()) {  
					
					
	                    String firstName = rs.getString(1);
	                    String lastName =  rs.getString(2);
	                    String email= rs.getString(3);
	                    String password= rs.getString(4);
	                    DateTimeFormatter df = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
	                    LocalDate date = LocalDate.parse(rs.getString(5),df);
	                    Gender gender= Gender.Female;
	                    if(  rs.getString(6).equalsIgnoreCase("Male")) {
	                    	gender= Gender.Male;
	                    }
	                    String country= rs.getString(7);
	                    String city= rs.getString(8);
	                    Integer phone= rs.getInt(9);
	                    
	                    Language language=new Language( rs.getString(10));
	                    if( rs.getString(11)!=null) {
	                    	language=new Language(rs.getString(10), rs.getString(11));
	                    	if(rs.getString(12)!=null) {
	                    		language=new Language(rs.getString(10), rs.getString(11), rs.getString(12));
	                    	}
	                    }
	                    
	                    TravelStyle travelStyle= new TravelStyle(rs.getString(13));
	                    if(rs.getString(14)!=null) {
	                    	travelStyle=new TravelStyle(rs.getString(13), rs.getString(14));
	                    	if(rs.getString(15)!=null) {
	                    		travelStyle=new TravelStyle(rs.getString(13), rs.getString(14), rs.getString(15));
	                    	}
	                    }
	                    
	                    String aboutMe=rs.getString(16);
	                    boolean emailNotifacations=rs.getString(17).equalsIgnoreCase("yes");
	                    
	                    Traveller t = new Traveller(email, password, firstName,
    							lastName, date, gender, city,
    							country, phone, language, travelStyle,
    							aboutMe, emailNotifacations);
	                    
	                    system.addTraveller(new Traveller(email, password, firstName,
    							lastName, date, gender, city,
    							country, phone, language, travelStyle,
    							aboutMe, emailNotifacations));
	                    
	                
				}  
			}  
			catch (SQLException e) {
				e.printStackTrace();
			}

			finally {  
				if (rs != null) try { rs.close(); } catch(Exception e) {}  
				if (stmt != null) try { stmt.close(); } catch(Exception e) {}
				System.out.println();
			} 

		}
		
		
		// Initialize Reviews table from database - into HashMap so it can be used as Objects on program
		public static void initReviews() {
			try { 

				String SQL = "SELECT * FROM Reviews ";  
				stmt = con.createStatement();  
				rs = stmt.executeQuery(SQL);
				while (rs.next()) { 

	                    String localGuide_email = rs.getString(1);
	                    DateTimeFormatter df = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
	                    LocalDate date = LocalDate.parse(rs.getString(2),df);
	                    String traveller_email= rs.getString(3);
	                    String city= rs.getString(4);
	                    String country= rs.getString(5);
	                    String reviewText= rs.getString(6);
	                    Double rating =Double.parseDouble(rs.getString(7));
	                    Review newReview = new Review(localGuide_email, date, traveller_email, city, country, reviewText, rating);
	                    system.addReview(newReview);

				}  
			}  
			catch (SQLException e) {
				e.printStackTrace();
			}

			finally {  
				if (rs != null) try { rs.close(); } catch(Exception e) {}  
				if (stmt != null) try { stmt.close(); } catch(Exception e) {}
				System.out.println();
			} 

		}
		
		// Initialize Places table from database - into HashMap so it can be used as Objects on program
		public static void initPlaces() {
			try { 
	
				String SQL = "SELECT * FROM Places ";  
				stmt = con.createStatement();  
				rs = stmt.executeQuery(SQL);
				while (rs.next()) { 

	                    String localGuide_email = rs.getString(1);
	                    String place_name= rs.getString(2);
	                    String city= rs.getString(3);
	                    String country= rs.getString(4);
	                    String infoText= rs.getString(5);
	                    Place place = new Place(localGuide_email, place_name, city, country);
	                    place.setInfo(infoText);
	                    system.addPlace(place);

				}  
			}  
			catch (SQLException e) {
				e.printStackTrace();
			}

			finally {  
				if (rs != null) try { rs.close(); } catch(Exception e) {}  
				if (stmt != null) try { stmt.close(); } catch(Exception e) {}
				System.out.println();
			} 

		}
		
		// Initialize LocalGuideUnavailbleDates table from database - into HashMap so it can be used as Objects on program
		public static void initUnavailbleDates() {
			try { 

				String SQL = "SELECT * FROM LocalGuideUnavailibleDates ";  
				stmt = con.createStatement();  
				rs = stmt.executeQuery(SQL);
				while (rs.next()) { 

	                    String localGuide_email = rs.getString(1);
	                    DateTimeFormatter df = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
	                    LocalDate date = LocalDate.parse(rs.getString(2),df);
	                    system.addLocalGuideUnavailbleDate(localGuide_email, date);

				}  
			}  
			catch (SQLException e) {
				e.printStackTrace();
			}

			finally {  
				if (rs != null) try { rs.close(); } catch(Exception e) {}  
				if (stmt != null) try { stmt.close(); } catch(Exception e) {}
				System.out.println();
			} 

		}
		
		
		
		
	// Show Travellers table data - DEMO, Unused on final version.
	public static void showTravellers() {
		try {  
			System.out.println("show data");
			String SQL = "SELECT * FROM Travellers ";  
			stmt = con.createStatement();  
			rs = stmt.executeQuery(SQL);  

			int n=1;
			while (rs.next()) {  
				
				System.out.println("\t" + rs.getString(n)+"\t"+rs.getString(n+1)
				+"\t"+rs.getString(n+2));
			
			}  
		}  
		catch (SQLException e) {
			e.printStackTrace();
		}

		finally {  
			if (rs != null) try { rs.close(); } catch(Exception e) {}  
			if (stmt != null) try { stmt.close(); } catch(Exception e) {}
			System.out.println();
		} 

	}

	// Show LocalGuides table data - DEMO, Unused on final version.
	public static void showLocalGuides() {
		try {  
			System.out.println("show data");
			String SQL = "SELECT * FROM LocalGuides ";  
			stmt = con.createStatement();  
			rs = stmt.executeQuery(SQL);  

			int n=1;
			while (rs.next()) {  
				
				System.out.println("\t" + rs.getString(n)+"\t"+rs.getString(n+1)
				+"\t"+rs.getString(n+2));
			
			}  
		}  
		catch (SQLException e) {
			e.printStackTrace();
		}

		finally {  
			if (rs != null) try { rs.close(); } catch(Exception e) {}  
			if (stmt != null) try { stmt.close(); } catch(Exception e) {}
			System.out.println();
		} 

	}
	

	
	// Add Traveller To SQL table.
	public void addTravellerToSQL(Traveller traveller) {
		try {  
			String SQL = "insert into Travellers (first_name, last_name, email, password, dateOfBirth,"
					+ " gender, country, city, phoneNumber, language1, language2, language3, travelStyle1,"
					+ " travelStyle2, travelStyle3, about, mail) "
					+ "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)" + 
					"";  
			PreparedStatement pst = con.prepareStatement(SQL);  
			pst.setString(1, traveller.getFirstName());
			pst.setString(2, traveller.getLastName());
			pst.setString(3, traveller.getEmail());
			pst.setString(4, traveller.getPassword());
			DateTimeFormatter df = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
			String dob = traveller.getDateOfBirth().format(df);
			pst.setString(5, dob);
			pst.setString(6, traveller.getGenderForSQL());
			pst.setString(7, traveller.getCountry());
			pst.setString(8, traveller.getCity());
			pst.setString(9, traveller.getPhoneNumber().toString());
			pst.setString(10, traveller.getLanguage().getLanguage1());
			pst.setString(11, traveller.getLanguage().getLanguage2());
			pst.setString(12, traveller.getLanguage().getLanguage3());
			pst.setString(13, traveller.getTravelStyle().getTravelStyle1());
			pst.setString(14, traveller.getTravelStyle().getTravelStyle2());
			pst.setString(15, traveller.getTravelStyle().getTravelStyle3());
			pst.setString(16, traveller.getAboutMe());
			pst.setString(17, traveller.getIsEmailNotifacationsForSql());
			pst.executeUpdate();
 
		}  
		catch (SQLException e) {
			e.printStackTrace();
		}

		finally {  
			if (rs != null) try { rs.close(); } catch(Exception e) {}  
			if (stmt != null) try { stmt.close(); } catch(Exception e) {}
			System.out.println();
		} 
	}
	
	// Add LocalGuide To SQL table.
	public void addLocalGuideToSQL(LocalGuide localGuide) {
		try {  
			String SQL = "insert into LocalGuides (first_name, last_name, email, password, dateOfBirth,"
					+ " gender, country, city, phoneNumber, language1, language2, language3, travelStyle1,"
					+ " travelStyle2, travelStyle3, about, mail) "
					+ "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)" + 
					"";  
			
			PreparedStatement pst = con.prepareStatement(SQL);  
			pst.setString(1, localGuide.getFirstName());
			pst.setString(2, localGuide.getLastName());
			pst.setString(3, localGuide.getEmail());
			pst.setString(4, localGuide.getPassword());
			DateTimeFormatter df = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
			String dob = localGuide.getDateOfBirth().format(df);
			pst.setString(5, dob);
			pst.setString(6, localGuide.getGenderForSQL());
			pst.setString(7, localGuide.getCountry());
			pst.setString(8, localGuide.getCity());
			pst.setString(9, localGuide.getPhoneNumber().toString());
			pst.setString(10, localGuide.getLanguage().getLanguage1());
			pst.setString(11, localGuide.getLanguage().getLanguage2());
			pst.setString(12, localGuide.getLanguage().getLanguage3());
			pst.setString(13, localGuide.getTravelStyle().getTravelStyle1());
			pst.setString(14, localGuide.getTravelStyle().getTravelStyle2());
			pst.setString(15, localGuide.getTravelStyle().getTravelStyle3());
			pst.setString(16, localGuide.getAboutMe());
			pst.setString(17, localGuide.getIsEmailNotifacationsForSql());
			pst.executeUpdate();

		}  
		catch (SQLException e) {
			e.printStackTrace();
		}

		finally {  
			if (rs != null) try { rs.close(); } catch(Exception e) {}  
			if (stmt != null) try { stmt.close(); } catch(Exception e) {}
			System.out.println();
		} 
	}
	
	// Add Review To SQL table.
	public void addReviewToSQL(Review review) {
		try {  
			String SQL = "insert into Reviews (localGuide_email, date, traveller_email, city, country,"
					+ " reviewText, rating) "
					+ "values (?,?,?,?,?,?,?)" + 
					"";  
			PreparedStatement pst = con.prepareStatement(SQL);  
			pst.setString(1, review.getLocalGuideEmail());
			DateTimeFormatter df = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
			String date = review.getDate().format(df);
			pst.setString(2, date);
			pst.setString(3, review.getTravellerEmail());
			pst.setString(4, review.getCity());
			pst.setString(5, review.getCountry());
			pst.setString(6, review.getReviewText());
			pst.setString(7, review.getRating().toString());
			pst.executeUpdate();

			System.out.println("review added!");  
		}  
		catch (SQLException e) {
			e.printStackTrace();
		}

		finally {  
			if (rs != null) try { rs.close(); } catch(Exception e) {}  
			if (stmt != null) try { stmt.close(); } catch(Exception e) {}
			System.out.println();
		} 
	}
	
	// Add Place To SQL table.
	public void addNewPlaceToSQL(Place place) {
		try {  
			String SQL = "insert into Places (localGuide_email, place_name,city, country,infoText) "
					+ "values (?,?,?,?,?)" + 
					"";  
			PreparedStatement pst = con.prepareStatement(SQL);  
			pst.setString(1, place.getLocalGuideEmail());
			pst.setString(2, place.getName());
			pst.setString(3, place.getCity());
			pst.setString(4, place.getCountry());
			pst.setString(5, place.getInfo());
			pst.executeUpdate();

			System.out.println("Place added!");  
		}  
		catch (SQLException e) {
			e.printStackTrace();
		}

		finally {  
			if (rs != null) try { rs.close(); } catch(Exception e) {}  
			if (stmt != null) try { stmt.close(); } catch(Exception e) {}
			System.out.println();
		} 
	}
	
	// Add LocalGuide Unavailable Date To SQL table.
	public void addLocalGuideUnavailibleDateToSQL(LocalGuide localGuide, LocalDate date) {
		try {  
			String SQL = "insert into LocalGuideUnavailibleDates (localGuide_email, date) "
					+ "values (?,?)" + 
					"";  
			
			PreparedStatement pst = con.prepareStatement(SQL);  
			pst.setString(1, localGuide.getEmail());
			DateTimeFormatter df = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
			String unavailbleDate = date.format(df);
			pst.setString(2, unavailbleDate);
			pst.executeUpdate();

			System.out.println("Local Guide unavailble date added!");  
		}  
		catch (SQLException e) {
			e.printStackTrace();
		}

		finally {  
			if (rs != null) try { rs.close(); } catch(Exception e) {}  
			if (stmt != null) try { stmt.close(); } catch(Exception e) {}
			System.out.println();
		} 
	}
	
	// Remove LocalGuide from SQL table.
	public void removeLocalGuideFromSQL(LocalGuide localGuide) {
		
		try {
			String userEmail = localGuide.getEmail();
			String SQL = "DELETE FROM LocalGuides WHERE email = ?";  
			PreparedStatement pst = con.prepareStatement(SQL);
			pst.setString(1, userEmail);
			pst.executeUpdate();
			
		}  
		catch (SQLException e) {
			e.printStackTrace();
		}

		finally {  
			if (rs != null) try { rs.close(); } catch(Exception e) {}  
			if (stmt != null) try { stmt.close(); } catch(Exception e) {}
			System.out.println();
		} 
	}
	
	// Remove Traveller from SQL table.
	public void removeTravellerFromSQL(Traveller traveller) {
		
		try {
			String userEmail = traveller.getEmail();
			String SQL = "DELETE FROM Travellers WHERE email = ?";  
			PreparedStatement pst = con.prepareStatement(SQL);
			pst.setString(1, userEmail);
			pst.executeUpdate();
			
		}  
		catch (SQLException e) {
			e.printStackTrace();
		}

		finally {  
			if (rs != null) try { rs.close(); } catch(Exception e) {}  
			if (stmt != null) try { stmt.close(); } catch(Exception e) {}
			System.out.println();
		} 
	}
	
	// Remove Place from SQL table.
	public void removePlaceFromSQL(Place place) {
		
		try {
			String userEmail = place.getName();
			String SQL = "DELETE FROM Places WHERE place_name = ?";  
			PreparedStatement pst = con.prepareStatement(SQL);
			pst.setString(1, userEmail);
			pst.executeUpdate();
			
		}  
		catch (SQLException e) {
			e.printStackTrace();
		}

		finally {  
			if (rs != null) try { rs.close(); } catch(Exception e) {}  
			if (stmt != null) try { stmt.close(); } catch(Exception e) {}
			System.out.println();
		} 
	}
	

		// Update Local Guide on SQL table.
		public void updateLocalGuide(LocalGuide localGuide) {
			
			int cnt=0;
			
			try {  
				String SQL = "UPDATE LocalGuides "
						+"SET first_name = ?, last_name = ?, email = ?, dateOfBirth = ?,"
						+ " gender = ?, country = ?, city = ?, phoneNumber = ?, language1 = ?, language2 = ?, language3 = ?, travelStyle1 = ?,"
						+ " travelStyle2 = ?, travelStyle3 = ?, about = ?, mail = ? "
						+ "WHERE email = ?";  
				
				
				PreparedStatement pst = con.prepareStatement(SQL);
				System.out.println(cnt++);
				pst.setString(1, localGuide.getFirstName());System.out.println(cnt++);
				pst.setString(2, localGuide.getLastName());System.out.println(cnt++);
				pst.setString(3, localGuide.getEmail());System.out.println(cnt++);
				DateTimeFormatter df = DateTimeFormatter.ofPattern("dd-MMM-yyyy");System.out.println(cnt++);
				String dob = localGuide.getDateOfBirth().format(df);System.out.println(dob);System.out.println(cnt++);
				pst.setString(4, dob);System.out.println(cnt++);
				pst.setString(5, localGuide.getGenderForSQL());System.out.println(cnt++);
				pst.setString(6, localGuide.getCountry());System.out.println(cnt++);
				pst.setString(7, localGuide.getCity());System.out.println(cnt++);
				pst.setString(8, localGuide.getPhoneNumber().toString());System.out.println(cnt++);
				pst.setString(9, localGuide.getLanguage().getLanguage1());System.out.println(cnt++);
				pst.setString(10, localGuide.getLanguage().getLanguage2());System.out.println(cnt++);
				pst.setString(11, localGuide.getLanguage().getLanguage3());System.out.println(cnt++);
				pst.setString(12, localGuide.getTravelStyle().getTravelStyle1());System.out.println(cnt++);
				pst.setString(13, localGuide.getTravelStyle().getTravelStyle2());System.out.println(cnt++);
				pst.setString(14, localGuide.getTravelStyle().getTravelStyle3());System.out.println(cnt++);
				pst.setString(15, localGuide.getAboutMe());System.out.println(cnt++);
				pst.setString(16, localGuide.getIsEmailNotifacationsForSql());System.out.println(cnt++);
				pst.setString(17, localGuide.getEmail());System.out.println(cnt++);
				pst.executeUpdate();System.out.println(cnt++);
				System.out.println("local guide Updated!!");  
			}  
			catch (SQLException e) {
				e.printStackTrace();
			}

			finally {  
				if (rs != null) try { rs.close(); } catch(Exception e) {}  
				if (stmt != null) try { stmt.close(); } catch(Exception e) {}
				System.out.println();
			} 
			
			
		}
		
		// SQL Connection method 
		public static void conectTo() {

			try {  
				
				System.out.println("Trying to set a connectio  to sql server...");
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
				con = DriverManager.getConnection(connectionUrl);
				
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				System.exit(0);
			} catch (SQLException e) {
				e.printStackTrace();
				System.exit(0);
			}
			System.out.println("connection was set!\n");

		}
		
		// Close method 
		public static void close() {
			if (con != null) 
				try { 
					con.close(); 
				} catch(Exception e) {
					e.printStackTrace();
				}  
		}


		

	}


