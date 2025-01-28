package pojos;

import java.sql.Date;
import java.util.Objects;

public class Other {

	private int    id          = 0;
	private Double price       = 0.0;
	private String name        = null;
	private String description = null;
	private Date   eventDate   = null;
	private Travel travel      = null;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
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
	public Date getEventDate() {
		return eventDate;
	}
	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}
	public Travel getTravel() {
		return travel;
	}
	public void setTravel(Travel travel) {
		this.travel = travel;
	}
	@Override
	public int hashCode() {
		return Objects.hash(description, eventDate, id, name, price, travel);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Other other = (Other) obj;
		return Objects.equals(description, other.description) && Objects.equals(eventDate, other.eventDate)
				&& id == other.id && Objects.equals(name, other.name) && Objects.equals(price, other.price)
				&& Objects.equals(travel, other.travel);
	}
	@Override
	public String toString() {
		return "Other [id=" + id + ", price=" + price + ", name=" + name + ", description=" + description
				+ ", eventDate=" + eventDate + ", travel=" + travel + "]";
	}
	
	
}
