package Model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class Travel {
	
	protected static final AtomicInteger cnt = new AtomicInteger(9999);
	protected final Integer travelID;
	protected LocalGuide localGuide;
	protected Traveller traveller;
	protected Date date;
	protected ArrayList<Place> placesInTravel= new ArrayList<Place>(); 
	
	public Travel(Integer travelID, LocalGuide localGuide, Traveller traveller, Date date, Integer id,
			ArrayList<Place> placesInTravel) {
		this.travelID = cnt.incrementAndGet();
		this.localGuide = localGuide;
		this.traveller = traveller;
		this.date = date;
		this.placesInTravel=placesInTravel;
	}


	
}
