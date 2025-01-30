package pojos;

import java.util.ArrayList;
import java.util.Objects;

public class Airline {

	private int     id   = 0;
	private String  aid  = null;
	private String  name = null;
	
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
	public ArrayList<Flight> getFlights() {
		return flights;
	}
	public void setFlights(ArrayList<Flight> flights) {
		this.flights = flights;
	}
	@Override
	public int hashCode() {
		return Objects.hash(flights, aid, id, name);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Airline other = (Airline) obj;
		return Objects.equals(flights, other.flights) && Objects.equals(aid, other.aid)
				&& id == other.id && Objects.equals(name, other.name);
	}
	@Override
	public String toString() {
		return "Airline [id=" + id + ", aid=" + aid + ", name=" + name + ", Flights=" + flights + "]";
	}

}
