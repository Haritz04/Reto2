package pojos;

import java.sql.Date;
import java.util.Objects;

public class Flight {

	private int           id            = 0;
	private int           duration      = 0;
	private double        price         = 0.0;
	private String        code          = null;
	private Date          startDate     = null;
	private Date          startHour     = null;
	private Accommodation accommodation = null;
	private Airport       airportStart  = null;
	private Airport       airportEnd    = null;
	private Airline       airline       = null;
	private Other         other         = null;

	private Flight        returnflight  = null;

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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getStartHour() {
		return startHour;
	}

	public void setStartHour(Date startHour) {
		this.startHour = startHour;
	}

	public Accommodation getAccommodation() {
		return accommodation;
	}

	public void setAccommodation(Accommodation accommodation) {
		this.accommodation = accommodation;
	}

	public Airport getAirportStart() {
		return airportStart;
	}

	public void setAirportStart(Airport airportStart) {
		this.airportStart = airportStart;
	}

	public Airport getAirportEnd() {
		return airportEnd;
	}

	public void setAirportEnd(Airport airportEnd) {
		this.airportEnd = airportEnd;
	}

	public Airline getAirline() {
		return airline;
	}

	public void setAirline(Airline airline) {
		this.airline = airline;
	}

	public Other getOther() {
		return other;
	}

	public void setOther(Other other) {
		this.other = other;
	}

	public Flight getReturnflight() {
		return returnflight;
	}

	public void setReturnflight(Flight returnflight) {
		this.returnflight = returnflight;
	}

	@Override
	public int hashCode() {
		return Objects.hash(accommodation, airline, airportEnd, airportStart, code, duration, id, other, price,
				returnflight, startDate, startHour);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Flight other = (Flight) obj;
		return Objects.equals(accommodation, other.accommodation) && Objects.equals(airline, other.airline)
				&& Objects.equals(airportEnd, other.airportEnd) && Objects.equals(airportStart, other.airportStart)
				&& Objects.equals(code, other.code) && duration == other.duration && id == other.id
				&& Objects.equals(this.other, other.other)
				&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price)
				&& Objects.equals(returnflight, other.returnflight) && Objects.equals(startDate, other.startDate)
				&& Objects.equals(startHour, other.startHour);
	}

	@Override
	public String toString() {
		return "Flight [id=" + id + ", duration=" + duration + ", price=" + price + ", code=" + code + ", startDate="
				+ startDate + ", startHour=" + startHour + ", accommodation=" + accommodation + ", airportStart="
				+ airportStart + ", airportEnd=" + airportEnd + ", airline=" + airline + ", other=" + other
				+ ", returnflight=" + returnflight + "]";
	}
}
