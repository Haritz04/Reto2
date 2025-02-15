package pojos;

import java.sql.Date;
import java.util.Objects;
import java.util.ArrayList;

public class Travel {
	
	private int        id                     = 0;
	private int        duration               = 0;
	private String     name                   = null;
	private String     description            = null;
	private String     descServiceNotIncluded = null;
	private Date       travelDate             = null;
	private TravelType travelType             = null;
	private Agency     agency                 = null;

	private ArrayList<Flight>        flights             = null;
	private ArrayList<Accommodation> accommodations		 = null;
	private ArrayList<Other>         others              = null;
	
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
	public Date getTravelDate() {
		return travelDate;
	}
	public void setTravelDate(Date travelDate) {
		this.travelDate = travelDate;
	}
	public TravelType getTravelType() {
		return travelType;
	}
	public void setTravelType(TravelType travelType) {
		this.travelType = travelType;
	}
	public Agency getAgency() {
		return agency;
	}
	public void setAgency(Agency agency) {
		this.agency = agency;
	}
	public ArrayList<Flight> getFlights() {
		return flights;
	}
	public void setFlights(ArrayList<Flight> flights) {
		this.flights = flights;
	}
	public ArrayList<Accommodation> getAccommodations() {
		return accommodations;
	}
	public void setAccommodations(ArrayList<Accommodation> accommodations) {
		this.accommodations = accommodations;
	}
	public ArrayList<Other> getOthers() {
		return others;
	}
	public void setOthers(ArrayList<Other> others) {
		this.others = others;
	}
	@Override
	public int hashCode() {
		return Objects.hash(accommodations, agency, descServiceNotIncluded, description, duration, flights, id,
				name, others, travelType, travelDate);
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
		return Objects.equals(accommodations, other.accommodations) && Objects.equals(agency, other.agency)
				&& Objects.equals(descServiceNotIncluded, other.descServiceNotIncluded)
				&& Objects.equals(description, other.description) && duration == other.duration
				&& Objects.equals(flights, other.flights) && id == other.id && Objects.equals(name, other.name)
				&& Objects.equals(others, other.others) && Objects.equals(travelType, other.travelType)
				&& Objects.equals(travelDate, other.travelDate);
	}
	@Override
	public String toString() {
		return "Travel [id=" + id + ", duration=" + duration + ", name=" + name + ", description=" + description
				+ ", descServiceNotIncluded=" + descServiceNotIncluded + ", tripDate=" + travelDate + ", travelType="
				+ travelType + ", agency=" + agency + ", flights=" + flights + ", accommodations="
				+ accommodations + ", others=" + others + "]";
	}

	
}
