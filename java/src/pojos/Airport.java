package pojos;

import java.util.ArrayList;
import java.util.Objects;

public class Airport {

	private int    id   = 0;
	private String aid  = null;
	private String name = null;
	private City   city = null;

	private ArrayList<Flight> flights = null;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAid() {
		return aid;
	}

	public void setAid(String aid) {
		this.aid = aid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public ArrayList<Flight> getFlights() {
		return flights;
	}

	public void setFlights(ArrayList<Flight> flights) {
		this.flights = flights;
	}

	@Override
	public int hashCode() {
		return Objects.hash(aid, city, flights, id, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Airport other = (Airport) obj;
		return Objects.equals(aid, other.aid) && Objects.equals(city, other.city)
				&& Objects.equals(flights, other.flights) && id == other.id && Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "Airport [id=" + id + ", aid=" + aid + ", name=" + name + ", city=" + city + ", flights=" + flights
				+ "]";
	}

}
