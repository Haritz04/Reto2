package pojos;

import java.sql.Date;
import java.util.Objects;
import java.util.ArrayList;

public class Travel {
	
	private int           id                     = 0;
	private int           duration               = 0;
	private String        name                   = null;
	private String        description            = null;
	private String        descServiceNotIncluded = null;
	private Date          tripDate               = null;
	private TravelType      travelType               = null;
	private Agency        agency                 = null;
	private Accommodation accommodationTravel    = null;
	private Other         others                 = null;

	private ArrayList<Flight> flights = null;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescServiceNotIncluded() {
		return descServiceNotIncluded;
	}

	public void setDescServiceNotIncluded(String descServiceNotIncluded) {
		this.descServiceNotIncluded = descServiceNotIncluded;
	}

	public Date getTripDate() {
		return tripDate;
	}

	public void setTripDate(Date tripDate) {
		this.tripDate = tripDate;
	}

	public TravelType getTripType() {
		return travelType;
	}

	public void setTripType(TravelType travelType) {
		this.travelType = travelType;
	}

	public Agency getAgency() {
		return agency;
	}

	public void setAgency(Agency agency) {
		this.agency = agency;
	}

	public Accommodation getAccommodationTravel() {
		return accommodationTravel;
	}

	public void setAccommodationTravel(Accommodation accommodationTravel) {
		this.accommodationTravel = accommodationTravel;
	}

	public Other getOthers() {
		return others;
	}

	public void setOthers(Other others) {
		this.others = others;
	}

	public ArrayList<Flight> getFlights() {
		return flights;
	}

	public void setFlights(ArrayList<Flight> flights) {
		this.flights = flights;
	}

	@Override
	public int hashCode() {
		return Objects.hash(accommodationTravel, agency, descServiceNotIncluded, description, duration, flights, id,
				name, tripDate, travelType);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Travel other = (Travel) obj;
		return Objects.equals(accommodationTravel, other.accommodationTravel) && Objects.equals(agency, other.agency)
				&& Objects.equals(descServiceNotIncluded, other.descServiceNotIncluded)
				&& Objects.equals(description, other.description) && duration == other.duration
				&& Objects.equals(flights, other.flights) && id == other.id && Objects.equals(name, other.name)
				&& Objects.equals(tripDate, other.tripDate) && Objects.equals(travelType, other.travelType);
	}

	@Override
	public String toString() {
		return "Trip [id=" + id + ", duration=" + duration + ", name=" + name + ", description=" + description
				+ ", descServiceNotIncluded=" + descServiceNotIncluded + ", tripDate=" + tripDate + ", tripType="
				+ travelType + ", agency=" + agency + ", accommodationTravel=" + accommodationTravel + ", flights="
				+ flights + "]";
	}

}
