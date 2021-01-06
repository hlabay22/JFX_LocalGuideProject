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
import Model.Review;
import Model.SystemGuide4u;
import Model.TravelStyle;
import Model.Traveller;
import Model.User;

	public class SqlTest {
	    static SystemGuide4u system=Main.system;
	    static String connectionUrl = "jdbc:sqlserver://localhost;databaseName=guide4u;integratedSecurity=true;";
	    //static String connectionUrl = "jdbc:sqlserver://localhost/SQLEXPRESS01;databaseName=guide4u;Trusted_Connection=True";
		//static String connectionUrl ="Server=localhost\\SQLEXPRESS01;Database=master;Trusted_Connection=True;";
		static Connection con = null;  
		static Statement stmt = null;  
		static ResultSet rs = null;  
		static int choice;
		static int id;
		static int lawyer1,lawyer2;
		static Scanner in=new Scanner(System.in);
		
//		public static void main(String[] args) {  
//			conectTo();
//			showLocalGuides();
//			showTravellers();
//
//			
//	}
		
		public SqlTest() {
			conectTo();
		}
		
		
		////add local guides into hash
		public static void initLocalGuide() {
			try {  
				System.out.println("****************");
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
	                    
	                    System.out.println(lg.getEmail());
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
		
		////add travellers into hash
		public static void initTravellers() {
			try {  
				System.out.println("****************");
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
	                    
	                    System.out.println(t.getEmail());
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
		
		
		
		public static void initReviews() {
			try { 

				System.out.println("****************");
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
	                    System.out.println(rating);
	                    Review newReview = new Review(localGuide_email, date, traveller_email, city, country, reviewText, rating);
	                    system.addReview(newReview);
	                    System.out.println(system.getReviewsList().size());


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
		
		
		
		
		
		
		
		public void addToHash(User user) {
			if(user instanceof Traveller) {
				
			}
		}
		
		
	//checking the data as a demo query
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

			System.out.println("trav added!");  
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
	
	public void addLocalGuideToSQL(LocalGuide localGuide) {
		try {  
			String SQL = "insert into LocalGuides (first_name, last_name, email, password, dateOfBirth,"
					+ " gender, country, city, phoneNumber, language1, language2, language3, travelStyle1,"
					+ " travelStyle2, travelStyle3, about, mail) "
					+ "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)" + 
					"";  
			//conectTo();
			
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
			System.out.println(localGuide.getCountry());
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
			System.out.println("local guide added!");  
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
		
	
	
	
	
	
	private static void printMenu() {
	System.out.println("Choose from this options");
	System.out.println("press 1 if you want to use query 1");
	System.out.println("press 2  if you want to use query 2");
	System.out.println("press 3 if you want to use query 3");
	System.out.println("press 4 if you want to use query 4" );
	System.out.println("press 5 if you want to use query 5" );
	System.out.println("press 6 if you want to use query 6" );
	System.out.println("press 7 if you want to use query 7" );
	System.out.println("press 8 if you want to close" );

	System.out.println("choose here:");

	}


	private static void Menu(int choice) {

		switch(choice) {

		case 1:{
			query1();
			break;
		}

		case 2:{
			query2();
			break;
		}

		case 3:{
			query3();
			break;
		}
		case 4:{
			query4();



			break;
		}
		case 5:{
			query5();

			break;
		}
		case 6:{
			query6();

			break;
		}
		case 7:{
			q7();

			break;
		}

		default:
			close();
			System.out.println("thenks");


		}
	}
			
		



		public static void close() {
			if (con != null) 
				try { 
					con.close(); 
				} catch(Exception e) {
					e.printStackTrace();
				}  
		}

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

		public static void query1() {

			try {  
				System.out.println("show data");
				String SQL = "SELECT * FROM defn_not_verdict ";  
				stmt = con.createStatement();  
				rs = stmt.executeQuery(SQL);  

				//int n=1;
				while (rs.next()) {  
					//n++;
					System.out.println("\t" + rs.getString(1)+"\t"
							 + rs.getString(2)+"\t" + rs.getString(3)+"\t") ;
			
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

		public static void query2() {
			try {  
				System.out.println("Show Data");
				String SQL = "select t.lawyer_id\r\n" + 
						"from trial t join indictment i\r\n" + 
						"	 on i.lawyer_id= t.lawyer_id join indictmentServed icd\r\n" + 
						"	  on icd.indNum=i.indNum join judge j on j.id=t.judge_id join judgeTypes jt on jt.idNo=j.idNo\r\n" + 
						"where jt.type like 'Magistrate'\r\n" + 
						"group by t.lawyer_id\r\n" + 
						"having count(*)> (select count(*)\r\n" + 
						"		   from not_guilty_def ngf join indictmentServed isd\r\n" + 
						"   on isd.s_id=ngf.s_id join indictment i \r\n" + 
						"   on i.indNum=isd.indNum join trial t \r\n" + 
						"   on t.lawyer_id=i.lawyer_id \r\n" + 
						"		   group by t.lawyer_id)\r\n" + 
						"";  
				stmt = con.createStatement();  
				rs = stmt.executeQuery(SQL);  

				int n=1;
				while (rs.next()) {  
					n++;
					System.out.println("\t" + rs.getString(n)+"\t") ;
			
				}  	
				

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {  
				if (rs != null) try { rs.close(); } catch(Exception e) {}  
				if (stmt != null) try { stmt.close(); } catch(Exception e) {}
				System.out.println();
			}  
		}  

		public static void query3() {

			try {  
				System.out.println("Show data");
				String SQL = "select i.in_id,ips.[countCase],sum(inp.[percet of pro case])/count(ips.[countCase])\r\n" + 
								"from investigator i join investipercase ips on ips.in_id=i.in_id join  inc_percentagea  inp on inp.in_id=i.in_id\r\n" + 
								"group by i.in_id,ips.[countCase]\r\n" + 
								"";
				stmt = con.createStatement();  
				rs = stmt.executeQuery(SQL); 


				while (rs.next()) {  
				
					System.out.println("\t" + rs.getString(1)+"\t"
							 + rs.getString(2)+"\t" + rs.getString(3)+"\t") ;
			
				}  

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {  
				if (rs != null) try { rs.close(); } catch(Exception e) {}  
				if (stmt != null) try { stmt.close(); } catch(Exception e) {}
				System.out.println();
			}  
		}
		private static void query4() {
			try {  
				System.out.println("show data");
				
				String SQL = "\r\n" + 
						"select t.judge_id,avg(datediff(month,t.startdate,t.endDate)),\r\n" + 
						"cat=case when(avg(datediff(month,t.startdate,t.endDate))>avg(datediff(month,t.startdate,t.endDate))) then 'Effective judge'\r\n" + 
						"		else null\r\n" + 
						"		end\r\n" + 
						"		\r\n" + 
						"		\r\n" + 
						"from trial t join judge j on t.judge_id=j.id join judgeTypes jt on jt.idNo=j.idNo\r\n" + 
						"where year(t.endDate)<2017 and jt.type  in('Magistrate','Supreme','District')\r\n" + 
						"group by t.judge_id,t.code,jt.type\r\n" + 
						"";  
				stmt = con.createStatement();  
				rs = stmt.executeQuery(SQL);  
			
				while (rs.next()) {  
					//n++;
					System.out.println("\t" + rs.getString(1)+"\t" 
									+ rs.getString(2)+"\t"
									 + rs.getString(3)+"\t") ;
			
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
		

		private static void query5() {
			try {  
				System.out.println("Call defTillnow  Procedure");
				CallableStatement  cstmt = 
						con.prepareCall("{? =call defTillnow (?)}");
				cstmt.registerOutParameter( 1,java.sql.Types.INTEGER);
				System.out.println("enter the id for show the defened trail 9 digits");
				id=in.nextInt();
				cstmt.setInt(2, id);
				cstmt.execute();
				rs =cstmt.getResultSet();
				while (rs.next()) {  
				
					System.out.println("\t" + rs.getString(1)) ;
				}
			}catch (SQLException e) {
				e.printStackTrace();
			}

			finally {  
				if (rs != null) try { rs.close(); } catch(Exception e) {}  
				if (stmt != null) try { stmt.close(); } catch(Exception e) {}
				System.out.println();
			}  
			
		}

		public static void query6() {

			try {  
				System.out.println("Call replacelawyer Procedure");
				CallableStatement  cstmt = 
						con.prepareCall("{? =call replacelawyer(?,?,?)}");
				cstmt.registerOutParameter(1, java.sql.Types.INTEGER);
				System.out.println("please enter the first lawyer id <9 digits>");
				lawyer1=in.nextInt();
				cstmt.setInt(2, lawyer1);
				System.out.println("please enter the second lawyer id <9 digits>");
				lawyer2=in.nextInt();
				cstmt.setInt(3, lawyer2);
				cstmt.setInt(4, 2);
				
				int result = 0;
				cstmt.execute();
				result = cstmt.getInt(1);
				if (result==101)
					System.out.println("First laywer does not exist");
				else if (result==102)
					System.out.println("Second lawyer does not exist");
				else if (result==103)
					System.out.println("First or Second lawyer (or both) "
							+ "do not  in court the given trial");
				else
					System.out.println(result + " lawyer where replace!");
				
			}catch (SQLException e) {
				e.printStackTrace();
			}

			finally {  
				if (rs != null) try { rs.close(); } catch(Exception e) {}  
				if (stmt != null) try { stmt.close(); } catch(Exception e) {}
				System.out.println();
			}  
		}
		private static void q7() {
			try {  
				System.out.println("Call statusUpdate   Procedure");
				CallableStatement  cstmt = 
						con.
			 			prepareCall("{call statusUpdate}");
				
		
				int result = 0;
				cstmt.execute();
				cstmt.executeUpdate();
			result = cstmt.getUpdateCount();

				System.out.println(result + " row effected");
				
			}catch (SQLException e) {
				e.printStackTrace();
			}

			finally {  
				if (rs != null) try { rs.close(); } catch(Exception e) {}  
				if (stmt != null) try { stmt.close(); } catch(Exception e) {}
			
				System.out.println();
			}  
			
		}


		

	}


