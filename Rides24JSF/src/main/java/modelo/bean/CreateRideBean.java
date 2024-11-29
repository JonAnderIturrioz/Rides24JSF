package modelo.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import businessLogic.BLFacade;
import businessLogic.BLFacadeImplementation;
import domain.Ride;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

@Named("createRide")
@SessionScoped
public class CreateRideBean implements Serializable{
	private static final long serialVersionUID = 1L;

	BLFacade bl = new BLFacadeImplementation();

	private Date date;

	private String departCity;
	private List<String> departCities;

	private String arrivalCity;
	private List<String> destinationCities;

	// private List<Ride> rides;
	// private Ride ride;

	public CreateRideBean() {
		departCities = bl.getDepartCities();
		departCity = departCities.get(0);
		destinationCities = bl.getDestinationCities(departCity);
		arrivalCity = destinationCities.get(0);
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDepartCity() {
		return departCity;
	}

	public void setDepartCity(String departCity) {
		this.departCity = departCity;
		this.destinationCities = bl.getDestinationCities(departCity);
	}

	public List<String> getDepartCities() {
		return departCities;
	}

	public void setDepartCities(List<String> departCities) {
		this.departCities = departCities;
	}

	public String getArrivalCity() {
		return arrivalCity;
	}

	public void setArrivalCity(String arrivalCity) {
		this.arrivalCity = arrivalCity;
	}

	public List<String> getDestinationCities() {
		return destinationCities;
	}

	public void setDestinationCities(List<String> destinationCities) {
		this.destinationCities = destinationCities;
	}
	
	/*
	 * public List<String> getRides() { List<String> rideNames = new
	 * ArrayList<String>(); for (Ride r : this.rides) rideNames.add(r.toString());
	 * 
	 * return rideNames; }
	 * 
	 * public void setRides(List<Ride> rides) { this.rides = rides; }
	 * 
	 * 
	 * public String getRide() { return ride.toString(); }
	 * 
	 * public void setRide(Ride ride) { this.ride = ride; }
	 */
}
