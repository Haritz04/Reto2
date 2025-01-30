package pojos;

import java.util.ArrayList;
import java.util.Objects;

public class MaxEmployees {

	private int     id           = 0;
	private String  aid          = null;
	private int     maxEmployees = 0;
	private String  message      = null;
	
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

	public int getMaxEmployees() {
		return maxEmployees;
	}

	public void setMaxEmployees(int maxEmployees) {
		this.maxEmployees = maxEmployees;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ArrayList<Agency> getAgencies() {
		return agencies;
	}

	public void setAgencies(ArrayList<Agency> agencies) {
		this.agencies = agencies;
	}

	@Override
	public int hashCode() {
		return Objects.hash(agencies, aid, id, maxEmployees, message);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MaxEmployees other = (MaxEmployees) obj;
		return Objects.equals(agencies, other.agencies) && Objects.equals(aid, other.aid) && id == other.id
				&& maxEmployees == other.maxEmployees && Objects.equals(message, other.message);
	}

	@Override
	public String toString() {
		return "MaxEmployees [id=" + id + ", aid=" + aid + ", maxEmployees=" + maxEmployees + ", message=" + message
				+ ", agencies=" + agencies + "]";
	}

}
