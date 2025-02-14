package pojos;

import java.sql.Date;
import java.util.Objects;

public class Accommodation {
	
	private int      id        = 0;
	private double   price     = 0.0;
	private String   name      = null;
	private Date     enterDate = null;
	private Date     exitDate  = null;
	private Travel   travel    = null;
	private City     city      = null;
	private RoomType roomType  = null;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Travel getTravel() {
		return travel;
	}

	public void setTravel(Travel travel) {
		this.travel = travel;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public RoomType getRoomType() {
		return roomType;
	}

	public void setRoomType(RoomType roomType) {
		this.roomType = roomType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Date getEnterDate() {
		return enterDate;
	}

	public void setEnterDate(Date enterDate) {
		this.enterDate = enterDate;
	}

	public Date getExitDate() {
		return exitDate;
	}

	public void setExitDate(Date exitDate) {
		this.exitDate = exitDate;
	}

	@Override
	public int hashCode() {
		return Objects.hash(city, id, name, price, roomType, travel);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Accommodation other = (Accommodation) obj;
		return Objects.equals(city, other.city) && Objects.equals(id, other.id) && Objects.equals(name, other.name)
				&& Objects.equals(price, other.price) && Objects.equals(roomType, other.roomType)
				&& Objects.equals(travel, other.travel);
	}

	@Override
	public String toString() {
		return "AccommodationTrip [id=" + id + ", trip=" + travel + ", city=" + city + ", roomType=" + roomType
				+ ", name=" + name + ", price=" + price + "]";
	}
}
