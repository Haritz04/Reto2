package pojos;

import java.util.Objects;
import java.util.ArrayList;

public class TravelType {

	private int     id          = 0;
	private String  aid         = null;
	private String  description = null;
	
	private ArrayList<Travel> travels = null;

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ArrayList<Travel> getTravels() {
		return travels;
	}

	public void setTravels(ArrayList<Travel> travels) {
		this.travels = travels;
	}

	@Override
	public int hashCode() {
		return Objects.hash(aid, description, id, travels);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TravelType other = (TravelType) obj;
		return Objects.equals(aid, other.aid) && Objects.equals(description, other.description) && id == other.id
				&& Objects.equals(travels, other.travels);
	}

	@Override
	public String toString() {
		return "TripType [id=" + id + ", aid=" + aid + ", description=" + description + ", travels=" + travels + "]";
	}
}
