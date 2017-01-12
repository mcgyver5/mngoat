package beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Bike {
	@Id
	@GeneratedValue
	int bikeId;
	
	
	
	// one bike has many images
	// one bike has many parts
	// one bike has one user.
	// one user has many bikes
	// one bike has zero to many events
	
	
	
	
	public int calculateReplacementCost(){
		
		return 0;
	}
}
