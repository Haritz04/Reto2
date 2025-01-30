package pojos;

import java.util.ArrayList;
import java.util.Objects;

public class Country {

	private int    id   = 0;
	private String aid  = null;
	private String name = null;
	
	private ArrayList<City> cities = null;

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

	public ArrayList<City> getCities() {
		return cities;
	}

	public void setCities(ArrayList<City> cities) {
		this.cities = cities;
	}

	@Override
	public int hashCode() {
		return Objects.hash(aid, cities, id, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Country other = (Country) obj;
		return Objects.equals(aid, other.aid) && Objects.equals(cities, other.cities) && id == other.id
				&& Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "Country [id=" + id + ", aid=" + aid + ", name=" + name + ", cities=" + cities + "]";
	}
	
}
