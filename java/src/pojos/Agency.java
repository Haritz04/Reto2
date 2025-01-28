package pojos;

import java.util.Objects;
import java.util.ArrayList;

public class Agency {
	
	private int        id           = 0;
	private int        maxEmployees = 0;
	private String     name         = null;
	private String     logo         = null;
	private String     color        = null;
	private AgencyType agencyType   = null;

	private ArrayList<Travel> travels = null;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMaxEmployees() {
		return maxEmployees;
	}

	public void setMaxEmployees(int maxEmployees) {
		this.maxEmployees = maxEmployees;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public AgencyType getAgencyType() {
		return agencyType;
	}

	public void setAgencyType(AgencyType agencyType) {
		this.agencyType = agencyType;
	}

	public ArrayList<Travel> getTravels() {
		return travels;
	}

	public void setTravels(ArrayList<Travel> travels) {
		this.travels = travels;
	}

	@Override
	public int hashCode() {
		return Objects.hash(agencyType, color, id, logo, maxEmployees, name, travels);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Agency other = (Agency) obj;
		return Objects.equals(agencyType, other.agencyType) && Objects.equals(color, other.color) && id == other.id
				&& Objects.equals(logo, other.logo) && maxEmployees == other.maxEmployees
				&& Objects.equals(name, other.name) && Objects.equals(travels, other.travels);
	}

	@Override
	public String toString() {
		return "Agency [id=" + id + ", maxEmployees=" + maxEmployees + ", name=" + name + ", logo=" + logo + ", color="
				+ color + ", agencyType=" + agencyType + ", travels=" + travels + "]";
	}
}
