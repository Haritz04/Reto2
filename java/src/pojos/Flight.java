package pojos;

import java.sql.Timestamp;
import java.util.Objects;

public class Flight {

	private int       id           = 0;
	private int       duration     = 0;
	private double    price        = 0.0;
	private String    code         = null;
	private Airline   airline      = null;
	private Timestamp startMoment  = null;
	private Travel    travel       = null;
	private Airport   airportStart = null;
	private Airport   airportEnd   = null;

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

	public Airline getAirline() {
		return airline;
	}

	public void setAirline(Airline airline) {
		this.airline = airline;
	}

	public Timestamp getStartMoment() {
		return startMoment;
	}

	public void setStartMoment(Timestamp startMoment) {
		this.startMoment = startMoment;
	}

	public Travel getTravel() {
		return travel;
	}

	public void setTravel(Travel travel) {
		this.travel = travel;
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

	@Override
	public int hashCode() {
		return Objects.hash(airline, airportEnd, airportStart, code, duration, id, price, startMoment, travel);
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
		return Objects.equals(airline, other.airline) && Objects.equals(airportEnd, other.airportEnd)
				&& Objects.equals(airportStart, other.airportStart) && Objects.equals(code, other.code)
				&& duration == other.duration && id == other.id
				&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price)
				&& Objects.equals(startMoment, other.startMoment) && Objects.equals(travel, other.travel);
	}

	@Override
	public String toString() {
		return "Flight [id=" + id + ", duration=" + duration + ", price=" + price + ", code=" + code + ", airline="
				+ airline + ", startMoment=" + startMoment + ", travel=" + travel + ", airportStart=" + airportStart
				+ ", airportEnd=" + airportEnd + "]";
	}
	
}
