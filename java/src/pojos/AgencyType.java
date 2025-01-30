package pojos;

import java.util.Objects;
import java.util.ArrayList;

public class AgencyType {
	
	private int     id   = 0;
	private String  aid  = null;
	private String  name = null;
	
	private ArrayList<Agency> agencies = null;

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

	public ArrayList<Agency> getAgencies() {
		return agencies;
	}

	public void setAgencies(ArrayList<Agency> agencies) {
		this.agencies = agencies;
	}

	@Override
	public int hashCode() {
		return Objects.hash(agencies, aid, id, name);
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
		return Objects.equals(agencies, other.agencies) && Objects.equals(aid, other.aid) && id == other.id
				&& Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "AgencyType [id=" + id + ", aid=" + aid + ", name=" + name + ", agencies=" + agencies + "]";
	}

}
