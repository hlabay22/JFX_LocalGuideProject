package Model;

public class Language implements java.io.Serializable {
	
	// Attributes 
	
	protected String language1;
	protected String language2;
	protected String language3;
	
	// C'Tor 
	
	public Language(String language1,String language2,String language3) {
		
		this.language1=language1;
		this.language2=language2;
		this.language3=language3;
		
	}
	
	public Language(String language1,String language2) {
		this.language1=language1;
		this.language2=language2;
	}
	
	public Language(String language1) {
		this.language1=language1;
		
	}
	
	// Getters 
	
	
	public String getLanguage1() {
		return language1;
	}

	public String getLanguage2() {
		return language2;
	}

	public String getLanguage3() {
		return language3;
	}
	
	// Setters
	
	public void setLanguage1(String language1) {
		this.language1 = language1;
	}
	
	public void setLanguage2(String language2) {
		this.language2 = language2;
	}

	public void setLanguage3(String language3) {
		this.language3 = language3;
	}
	
	

}
