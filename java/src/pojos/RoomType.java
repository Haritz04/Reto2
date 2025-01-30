package pojos;

import java.util.ArrayList;
import java.util.Objects;

public class RoomType {

	private int    id   = 0;
	private String aid  = null;
	private String name = null;

	private ArrayList<Accommodation> accommodations = null;

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

	public ArrayList<Accommodation> getAccommodations() {
		return accommodations;
	}

	public void setAccommodations(ArrayList<Accommodation> accommodations) {
		this.accommodations = accommodations;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(accommodations, aid, id, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RoomType other = (RoomType) obj;
		return Objects.equals(accommodations, other.accommodations) && Objects.equals(aid, other.aid) && id == other.id
				&& Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "RoomType [id=" + id + ", aid=" + aid + ", name=" + name + ", accommodations=" + accommodations + "]";
	}
	
}
