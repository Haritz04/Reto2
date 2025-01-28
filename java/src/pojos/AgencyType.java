package pojos;

import java.util.Objects;
import java.util.ArrayList;

public class AgencyType {
	
	private int     id   = 0;
	private String  name = null;
	
	private ArrayList<Agency> agencies = null;

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

	public ArrayList<Agency> getagencies() {
		return agencies;
	}

	public void setagencies(ArrayList<Agency> agencies) {
		this.agencies = agencies;
	}

	@Override
	public int hashCode() {
		return Objects.hash(agencies, id, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AgencyType other = (AgencyType) obj;
		return Objects.equals(agencies, other.agencies) && id == other.id && Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "AgencyType [id=" + id + ", name=" + name + ", agencies=" + agencies + "]";
	}
}
