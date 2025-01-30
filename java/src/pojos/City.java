package pojos;

import java.util.ArrayList;
import java.util.Objects;

public class City {

	private int     id      = 0;
	private String  name    = null;
	private Country country = null;
	
	private ArrayList<Accommodation> accommodations = null;
	private ArrayList<Airport>       airports       = null;
	
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
	public ArrayList<Airport> getAirports() {
		return airports;
	}
	public void setAirports(ArrayList<Airport> airports) {
		this.airports = airports;
	}
	@Override
	public int hashCode() {
		return Objects.hash(accommodations, airports, country, id, name);
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
		return Objects.equals(accommodations, other.accommodations) && Objects.equals(airports, other.airports)
				&& Objects.equals(country, other.country) && id == other.id && Objects.equals(name, other.name);
	}
	@Override
	public String toString() {
		return "City [id=" + id + ", name=" + name + ", country=" + country + ", accommodations=" + accommodations
				+ ", airports=" + airports + "]";
	}
	
}
