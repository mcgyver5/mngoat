package beans;

import java.util.ArrayList;
// users have zero or one policy
// one policy has zero to many bikes
public class Policy {
	int policyId;
	PolicyApplication policyApplication;
	ArrayList<Bike> bikes;
	User user;
	
	void addBike(Bike bike){
		bikes.add(bike);
	}
	
}
