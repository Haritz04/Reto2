package pojos;

import java.util.Objects;

public class FlightPair {
	
	private int    id           = 0;
	private Flight goFlight     = null;
	private Flight returnFlight = null;
	private Travel travel       = null;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Flight getGoFlight() {
		return goFlight;
	}
	public void setGoFlight(Flight goFlight) {
		this.goFlight = goFlight;
	}
	public Flight getReturnFlight() {
		return returnFlight;
	}
	public void setReturnFlight(Flight returnFlight) {
		this.returnFlight = returnFlight;
	}
	public Travel getTravel() {
		return travel;
	}
	public void setTravel(Travel travel) {
		this.travel = travel;
	}
	@Override
	public int hashCode() {
		return Objects.hash(goFlight, id, returnFlight, travel);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FlightPair other = (FlightPair) obj;
		return Objects.equals(goFlight, other.goFlight) && id == other.id
				&& Objects.equals(returnFlight, other.returnFlight) && Objects.equals(travel, other.travel);
	}
	@Override
	public String toString() {
		return "FlightPair [id=" + id + ", goFlight=" + goFlight + ", returnFlight=" + returnFlight + ", travel="
				+ travel + "]";
	}
}
