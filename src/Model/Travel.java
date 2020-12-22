package Model;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class Travel implements java.io.Serializable {
	
	protected static final AtomicInteger cnt = new AtomicInteger(9999);
	protected final Integer travelID;
	protected LocalGuide localGuide;
	protected Traveller traveller;
	protected LocalDate date;
	protected ArrayList<Place> placesInTravel= new ArrayList<Place>(); 
	
	public Travel(LocalGuide localGuide, Traveller traveller, LocalDate date, 
			ArrayList<Place> placesInTravel) {
		this.travelID = cnt.incrementAndGet();
		this.localGuide = localGuide;
		this.traveller = traveller;
		this.date = date;
		this.placesInTravel=placesInTravel;
		
		
	}


	
}
