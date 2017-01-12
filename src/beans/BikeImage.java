package beans;

import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class BikeImage {
	@Id
	@GeneratedValue
	int bikeId;
	byte[] bikePhoto;
	Date bikePhotoDate;
	
}
