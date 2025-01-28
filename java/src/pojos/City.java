package pojos;

import java.util.ArrayList;
import java.util.Objects;

public class City {

	private int     id      = 0;
	private String  name    = null;
	private Country country = null;
	
	private ArrayList<Accommodation> accommodations = null;
	private ArrayList<Airline>       airlines       = null;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Country getCountry() {
		return country;
	}
	public void setCountry(Country country) {
		this.country = country;
	}
	public ArrayList<Accommodation> getAccommodations() {
		return accommodations;
	}
	public void setAccommodations(ArrayList<Accommodation> accommodations) {
		this.accommodations = accommodations;
	}
	public ArrayList<Airline> getAirlines() {
		return airlines;
	}
	public void setAirlines(ArrayList<Airline> airlines) {
		this.airlines = airlines;
	}
	@Override
	public int hashCode() {
		return Objects.hash(accommodations, airlines, id, name);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		City other = (City) obj;
		return Objects.equals(accommodations, other.accommodations) && Objects.equals(airlines, other.airlines)
				&& id == other.id && Objects.equals(name, other.name);
	}
	@Override
	public String toString() {
		return "City [id=" + id + ", name=" + name + ", accommodations=" + accommodations + ", airlines=" + airlines
				+ "]";
	}
	
}
