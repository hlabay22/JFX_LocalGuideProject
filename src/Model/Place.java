package Model;

import java.util.concurrent.atomic.AtomicInteger;

public class Place {
	protected String name;
	protected String city;
	protected String country;		
	protected static final AtomicInteger cnt = new AtomicInteger(9999);
	protected final Integer placeID;

	public Place(String name, String city, String country) {
		this.placeID = cnt.incrementAndGet();
		this.name = name;
		this.city = city;
		this.country = country;
	}
}
