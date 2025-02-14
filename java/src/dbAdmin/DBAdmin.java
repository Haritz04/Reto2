package dbAdmin;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import pojos.Accommodation;
import pojos.Agency;
import pojos.AgencyType;
import pojos.Airport;
import pojos.Airline;
import pojos.City;
import pojos.Country;
import pojos.Flight;
import pojos.FlightPair;
import pojos.MaxEmployees;
import pojos.Travel;
import pojos.TravelType;
import pojos.Other;
import pojos.RoomType;

import java.sql.DriverManager;
//import java.sql.Date;
//import java.util.ArrayList;

public class DBAdmin {

    public void iud(String sql) {
		Connection conn = null;
		Statement  stat = null;
		ResultSet  rSet = null;

		try {
			/*
				Carga en memoria de mala manera
				la clase Drive.
			*/
			Class.forName(DBConfig.DRIVER);

			conn = DriverManager.getConnection(
				DBConfig.URL,
				DBConfig.USER,
				DBConfig.PASSWORD
			);
			
			stat = conn.createStatement();
			stat.executeUpdate(sql);
			
		} catch (SQLException sqle) {
			System.out.println(sqle.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			/*
				Cerrar todos los elementos de
				forma inversa al que se han
				habierto.
			*/
			try {
				if (rSet != null) {rSet.close();}
			} catch (Exception e) {}
			try {
				if (stat != null) {stat.close();}
			} catch (Exception e) {}
			try {
				if (conn != null) {conn.close();}
			} catch (Exception e) {}
		}
	}
    
    /**
     * This method return if the user an password
     * specified exists in the DB.
     */
    public boolean existsAccount(String name, String password) {
    	boolean ret = false;

		String sql = String.format(
			"SELECT * FROM agencies WHERE name='%s' AND password='%s';",
			name,
			password
		);
		
		Connection conn = null;
		Statement  stat = null;
		ResultSet  rSet = null;

		try {
			/*
				Carga en memoria de mala manera
				la clase Drive.
			*/
			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection(
				DBConfig.URL,
				DBConfig.USER,
				DBConfig.PASSWORD
			);
			
			stat = conn.createStatement();
			rSet = stat.executeQuery(sql);
			
			ret = rSet.next();
			
		} catch (SQLException sqle) {
			System.out.println(sqle.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			/*
				Cerrar todos los elementos de
				forma inversa al que se han
				habierto.
			*/
			try {
				if (rSet != null) {rSet.close();}
			} catch (Exception e) {}
			try {
				if (stat != null) {stat.close();}
			} catch (Exception e) {}
			try {
				if (conn != null) {conn.close();}
			} catch (Exception e) {}
		}
		
    	return ret;
    }
    
    public ArrayList<AgencyType> getAgencyTypes() {
		ArrayList<AgencyType> ret = new ArrayList<AgencyType>();

		String sql = "SELECT * FROM agencyTypes;";
		
		Connection conn = null;
		Statement  stat = null;
		ResultSet  rSet = null;

		try {
			/*
				Carga en memoria de mala manera
				la clase Drive.
			*/
			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection(
				DBConfig.URL,
				DBConfig.USER,
				DBConfig.PASSWORD
			);
			
			stat = conn.createStatement();
			rSet = stat.executeQuery(sql);
			
			while (rSet.next()) {
				AgencyType agencyType = new AgencyType();
				
				agencyType.setId(rSet.getInt("id"));
				agencyType.setAid(rSet.getString("aid"));
				agencyType.setName(rSet.getString("name"));
				
				ret.add(agencyType);
			}
			
		} catch (SQLException sqle) {
			System.out.println(sqle.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			/*
				Cerrar todos los elementos de
				forma inversa al que se han
				habierto.
			*/
			try {
				if (rSet != null) {rSet.close();}
			} catch (Exception e) {}
			try {
				if (stat != null) {stat.close();}
			} catch (Exception e) {}
			try {
				if (conn != null) {conn.close();}
			} catch (Exception e) {}
		}
		
		return ret;
    }

    public ArrayList<RoomType> getRoomTypes() {
		ArrayList<RoomType> ret = new ArrayList<>();

		String sql = "SELECT * FROM roomTypes;";
		
		Connection conn = null;
		Statement  stat = null;
		ResultSet  rSet = null;

		try {
			/*
				Carga en memoria de mala manera
				la clase Drive.
			*/
			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection(
				DBConfig.URL,
				DBConfig.USER,
				DBConfig.PASSWORD
			);
			
			stat = conn.createStatement();
			rSet = stat.executeQuery(sql);
			
			while (rSet.next()) {
				RoomType roomType = new RoomType();
				
				roomType.setId(rSet.getInt("id"));
				roomType.setAid(rSet.getString("aid"));
				roomType.setName(rSet.getString("name"));
				
				ret.add(roomType);
			}
			
		} catch (SQLException sqle) {
			System.out.println(sqle.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			/*
				Cerrar todos los elementos de
				forma inversa al que se han
				habierto.
			*/
			try {
				if (rSet != null) {rSet.close();}
			} catch (Exception e) {}
			try {
				if (stat != null) {stat.close();}
			} catch (Exception e) {}
			try {
				if (conn != null) {conn.close();}
			} catch (Exception e) {}
		}
		
		return ret;
    }
	
	public ArrayList<MaxEmployees> getMaxEmployees() {
		ArrayList<MaxEmployees> ret = new ArrayList<MaxEmployees>();

		String sql = "SELECT * FROM maxEmployees;";
		
		Connection conn = null;
		Statement  stat = null;
		ResultSet  rSet = null;

		try {
			/*
				Carga en memoria de mala manera
				la clase Drive.
			*/
			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection(
				DBConfig.URL,
				DBConfig.USER,
				DBConfig.PASSWORD
			);
			
			stat = conn.createStatement();
			rSet = stat.executeQuery(sql);
			
			while (rSet.next()) {
				MaxEmployees maxEmployee = new MaxEmployees();
				
				maxEmployee.setId(rSet.getInt("id"));
				maxEmployee.setAid(rSet.getString("aid"));
				maxEmployee.setMaxEmployees(rSet.getInt("maxEmployee"));
				maxEmployee.setMessage(rSet.getString("message"));
				
				ret.add(maxEmployee);
			}
			
		} catch (SQLException sqle) {
			System.out.println(sqle.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			/*
				Cerrar todos los elementos de
				forma inversa al que se han
				habierto.
			*/
			try {
				if (rSet != null) {rSet.close();}
			} catch (Exception e) {}
			try {
				if (stat != null) {stat.close();}
			} catch (Exception e) {}
			try {
				if (conn != null) {conn.close();}
			} catch (Exception e) {}
		}
		
		return ret;
	}
	
	public void insertAgency(Agency agency) {
		
		String sql = String.format(
			"INSERT INTO agencies (idAgencyTypes, idMaxEmployees, name, password, logo, color) VALUES (%d, %d, '%s', '%s', '%s', '%s');",
			agency.getAgencyType().getId(),
			agency.getMaxEmployees().getId(),
			agency.getName(),
			agency.getPassword(),
			agency.getLogo(),
			agency.getColor()
		);
		
		iud(sql);
	}
	
	public Agency getAgency(String name, String password) {
        
        Agency ret = null;

		String sql = String.format(
					"SELECT * FROM agencies WHERE name='%s' AND password='%s';", name, password);
					
					
		Connection conn = null;
		Statement  stat = null;
		ResultSet  rSet = null;

		try {
			/*
				Carga en memoria de mala manera
				la clase Drive.
			*/
			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection(
				DBConfig.URL,
				DBConfig.USER,
				DBConfig.PASSWORD
			);
			
			stat = conn.createStatement();
			rSet = stat.executeQuery(sql);
			
			if (rSet.next()) {
                ret = new Agency();
			
				ret.setId(rSet.getInt("id"));
				ret.setName(rSet.getString("name"));
				ret.setPassword(rSet.getString("password"));
				ret.setLogo(rSet.getString("logo"));
				ret.setColor(rSet.getString("color"));
            }
			
		} catch (SQLException sqle) {
			System.out.println(sqle.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			/*
				Cerrar todos los elementos de
				forma inversa al que se han
				habierto.
			*/
			try {
				if (rSet != null) {rSet.close();}
			} catch (Exception e) {}
			try {
				if (stat != null) {stat.close();}
			} catch (Exception e) {}
			try {
				if (conn != null) {conn.close();}
			} catch (Exception e) {}
		}
		
		return ret;
    }
	
	public TravelType getTravelTypeById(int travelTypeId) {
        
        TravelType ret = null;

		String sql = String.format(
			"SELECT * FROM travelTypes WHERE id=%d;",
			travelTypeId
		);
					
					
		Connection conn = null;
		Statement  stat = null;
		ResultSet  rSet = null;

		try {
			/*
				Carga en memoria de mala manera
				la clase Drive.
			*/
			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection(
				DBConfig.URL,
				DBConfig.USER,
				DBConfig.PASSWORD
			);
			
			stat = conn.createStatement();
			rSet = stat.executeQuery(sql);
			
			if (rSet.next()) {
                ret = new TravelType();
			
				ret.setId(rSet.getInt("id"));
				ret.setAid(rSet.getString("aid"));
				ret.setDescription(rSet.getString("description"));
            }
			
		} catch (SQLException sqle) {
			System.out.println(sqle.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			/*
				Cerrar todos los elementos de
				forma inversa al que se han
				habierto.
			*/
			try {
				if (rSet != null) {rSet.close();}
			} catch (Exception e) {}
			try {
				if (stat != null) {stat.close();}
			} catch (Exception e) {}
			try {
				if (conn != null) {conn.close();}
			} catch (Exception e) {}
		}
		
		return ret;
    }
	
	public ArrayList<Travel> getTravelsByAgencyId(int agencyId) {
		
		ArrayList<Travel> ret = new ArrayList<>();

		String sql = String.format(
			"SELECT * FROM travels WHERE idAgency=%d;",
			agencyId
		);
		
		Connection conn = null;
		Statement  stat = null;
		ResultSet  rSet = null;

		try {
			/*
			#TODO traveltype ID tiene ES UN VARCHAR EN BBDD
				Carga en memoria de mala manera
				la clase Drive.
			*/
			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection(
				DBConfig.URL,
				DBConfig.USER,
				DBConfig.PASSWORD
			);
			
			stat = conn.createStatement();
			rSet = stat.executeQuery(sql);
			
			while (rSet.next()) {
				Travel travel = new Travel();
				
				travel.setId(rSet.getInt("id"));
				travel.setDuration(rSet.getInt("duration"));
				travel.setName(rSet.getString("name"));
				travel.setDescription(rSet.getString("description"));
				travel.setDescServiceNotIncluded(rSet.getString("descServiceNotIncluded"));
				travel.setTravelDate(rSet.getDate("travelDate"));
				travel.setTravelType(this.getTravelTypeById(rSet.getInt("idTravelType")));
				travel.setFlights(this.getFlightsByTravelId(travel.getId()));
				travel.setAccommodations(this.getAccommodationsByTravelId(travel.getId()));
				travel.setOthers(this.getOthersByTravelId(travel.getId()));
				
				ret.add(travel);
			}
			
		} catch (SQLException sqle) {
			System.out.println(sqle.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			/*
				Cerrar todos los elementos de
				forma inversa al que se han
				habierto.
			*/
			try {
				if (rSet != null) {rSet.close();}
			} catch (Exception e) {}
			try {
				if (stat != null) {stat.close();}
			} catch (Exception e) {}
			try {
				if (conn != null) {conn.close();}
			} catch (Exception e) {}
		}
		
		return ret;
	}
	
	public ArrayList<Flight> getFlightsByTravelId(int travelId) {
		
		ArrayList<Flight> ret = new ArrayList<>();

		String sql = String.format(
			"SELECT * FROM flights WHERE idTravel=%d;",
			travelId
		);
		
		Connection conn = null;
		Statement  stat = null;
		ResultSet  rSet = null;

		try {
			/*
				Carga en memoria de mala manera
				la clase Drive.
			*/
			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection(
				DBConfig.URL,
				DBConfig.USER,
				DBConfig.PASSWORD
			);
			
			stat = conn.createStatement();
			rSet = stat.executeQuery(sql);
			
			while (rSet.next()) {
				Flight flight = new Flight();
				
				flight.setId(rSet.getInt("id"));
				flight.setDuration(rSet.getInt("duration"));
				flight.setPrice(rSet.getInt("price"));
				flight.setCode(rSet.getString("code"));
				
				ret.add(flight);
			}
			
		} catch (SQLException sqle) {
			System.out.println(sqle.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			/*
				Cerrar todos los elementos de
				forma inversa al que se han
				habierto.
			*/
			try {
				if (rSet != null) {rSet.close();}
			} catch (Exception e) {}
			try {
				if (stat != null) {stat.close();}
			} catch (Exception e) {}
			try {
				if (conn != null) {conn.close();}
			} catch (Exception e) {}
		}
		
		return ret;
	}

	public ArrayList<Accommodation> getAccommodationsByTravelId(int travelId) {
		
		ArrayList<Accommodation> ret = new ArrayList<>();

		String sql = String.format(
			"SELECT * FROM accommodation WHERE idTravel=%d;",
			travelId
		);
		
		Connection conn = null;
		Statement  stat = null;
		ResultSet  rSet = null;

		try {
			/*
				Carga en memoria de mala manera
				la clase Drive.
			*/
			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection(
				DBConfig.URL,
				DBConfig.USER,
				DBConfig.PASSWORD
			);
			
			stat = conn.createStatement();
			rSet = stat.executeQuery(sql);
			
			while (rSet.next()) {
				Accommodation accommodation = new Accommodation();
				
				accommodation.setId(rSet.getInt("id"));
				accommodation.setPrice(rSet.getDouble("price"));
				accommodation.setName(rSet.getString("name"));
				accommodation.setEnterDate(rSet.getDate("EnterDate"));
				accommodation.setExitDate(rSet.getDate("exitDate"));
				
				ret.add(accommodation);
			}
			
		} catch (SQLException sqle) {
			System.out.println(sqle.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			/*
				Cerrar todos los elementos de
				forma inversa al que se han
				habierto.
			*/
			try {
				if (rSet != null) {rSet.close();}
			} catch (Exception e) {}
			try {
				if (stat != null) {stat.close();}
			} catch (Exception e) {}
			try {
				if (conn != null) {conn.close();}
			} catch (Exception e) {}
		}
		
		return ret;
	}
	
	public ArrayList<Other> getOthersByTravelId(int travelId) {
		
		ArrayList<Other> ret = new ArrayList<>();

		String sql = String.format(
			"SELECT * FROM others WHERE idTravel=%d;",
			travelId
		);
		
		Connection conn = null;
		Statement  stat = null;
		ResultSet  rSet = null;

		try {
			/*
				Carga en memoria de mala manera
				la clase Drive.
			*/
			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection(
				DBConfig.URL,
				DBConfig.USER,
				DBConfig.PASSWORD
			);
			
			stat = conn.createStatement();
			rSet = stat.executeQuery(sql);
			
			while (rSet.next()) {
				Other other = new Other();
				
				other.setId(rSet.getInt("id"));
				other.setPrice(rSet.getDouble("price"));
				other.setName(rSet.getString("Name"));
				other.setDescription(rSet.getString("description"));
				other.setEventDate(rSet.getDate("eventDate"));
				
				ret.add(other);
			}
			
		} catch (SQLException sqle) {
			System.out.println(sqle.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			/*
				Cerrar todos los elementos de
				forma inversa al que se han
				habierto.
			*/
			try {
				if (rSet != null) {rSet.close();}
			} catch (Exception e) {}
			try {
				if (stat != null) {stat.close();}
			} catch (Exception e) {}
			try {
				if (conn != null) {conn.close();}
			} catch (Exception e) {}
		}
		
		return ret;
	}

	public ArrayList<TravelType> getTravelTypes() {
		
		ArrayList<TravelType> ret = new ArrayList<>();

		String sql = "SELECT * FROM travelTypes;";
		
		Connection conn = null;
		Statement  stat = null;
		ResultSet  rSet = null;

		try {
			/*
				Carga en memoria de mala manera
				la clase Drive.
			*/
			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection(
				DBConfig.URL,
				DBConfig.USER,
				DBConfig.PASSWORD
			);
			
			stat = conn.createStatement();
			rSet = stat.executeQuery(sql);
			
			while (rSet.next()) {
				TravelType travelType = new TravelType();
				
				travelType.setId(rSet.getInt("id"));
				travelType.setAid(rSet.getString("aid"));
				travelType.setDescription(rSet.getString("description"));
				
				ret.add(travelType);
			}
			
		} catch (SQLException sqle) {
			System.out.println(sqle.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			/*
				Cerrar todos los elementos de
				forma inversa al que se han
				habierto.
			*/
			try {
				if (rSet != null) {rSet.close();}
			} catch (Exception e) {}
			try {
				if (stat != null) {stat.close();}
			} catch (Exception e) {}
			try {
				if (conn != null) {conn.close();}
			} catch (Exception e) {}
		}
		
		return ret;
	}
	
	public ArrayList<Country> getCountries() {
		
		ArrayList<Country> ret = new ArrayList<>();

		String sql = "SELECT * FROM countries ORDER BY name;";
		
		Connection conn = null;
		Statement  stat = null;
		ResultSet  rSet = null;

		try {
			/*
				Carga en memoria de mala manera
				la clase Drive.
			*/
			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection(
				DBConfig.URL,
				DBConfig.USER,
				DBConfig.PASSWORD
			);
			
			stat = conn.createStatement();
			rSet = stat.executeQuery(sql);
			
			while (rSet.next()) {
				Country country = new Country();
				
				country.setId(rSet.getInt("id"));
				country.setAid(rSet.getString("aid"));
				country.setName(rSet.getString("name"));
				
				ret.add(country);
			}
			
		} catch (SQLException sqle) {
			System.out.println(sqle.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			/*
				Cerrar todos los elementos de
				forma inversa al que se han
				habierto.
			*/
			try {
				if (rSet != null) {rSet.close();}
			} catch (Exception e) {}
			try {
				if (stat != null) {stat.close();}
			} catch (Exception e) {}
			try {
				if (conn != null) {conn.close();}
			} catch (Exception e) {}
		}
		
		return ret;
	}
	
	public ArrayList<City> getCities() {
		
		ArrayList<City> ret = new ArrayList<>();

		String sql = "SELECT * FROM cities ORDER BY name;";
		
		Connection conn = null;
		Statement  stat = null;
		ResultSet  rSet = null;

		try {
			/*
				Carga en memoria de mala manera
				la clase Drive.
			*/
			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection(
				DBConfig.URL,
				DBConfig.USER,
				DBConfig.PASSWORD
			);
			
			stat = conn.createStatement();
			rSet = stat.executeQuery(sql);
			
			while (rSet.next()) {
				City city = new City();
				
				city.setId(rSet.getInt("id"));
				city.setName(rSet.getString("name"));
				
				ret.add(city);
			}
			
		} catch (SQLException sqle) {
			System.out.println(sqle.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			/*
				Cerrar todos los elementos de
				forma inversa al que se han
				habierto.
			*/
			try {
				if (rSet != null) {rSet.close();}
			} catch (Exception e) {}
			try {
				if (stat != null) {stat.close();}
			} catch (Exception e) {}
			try {
				if (conn != null) {conn.close();}
			} catch (Exception e) {}
		}
		
		return ret;
	}
	

	public ArrayList<Airport> getAirports() {
		
		ArrayList<Airport> ret = new ArrayList<>();

		String sql = "SELECT * FROM airports ORDER BY name;";
		
		Connection conn = null;
		Statement  stat = null;
		ResultSet  rSet = null;

		try {
			/*
				Carga en memoria de mala manera
				la clase Drive.
			*/
			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection(
				DBConfig.URL,
				DBConfig.USER,
				DBConfig.PASSWORD
			);
			
			stat = conn.createStatement();
			rSet = stat.executeQuery(sql);
			
			while (rSet.next()) {
				Airport airport = new Airport();
				
				airport.setId(rSet.getInt("id"));
				airport.setAid(rSet.getString("aid"));
				airport.setName(rSet.getString("name"));
				
				ret.add(airport);
			}
			
		} catch (SQLException sqle) {
			System.out.println(sqle.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			/*
				Cerrar todos los elementos de
				forma inversa al que se han
				habierto.
			*/
			try {
				if (rSet != null) {rSet.close();}
			} catch (Exception e) {}
			try {
				if (stat != null) {stat.close();}
			} catch (Exception e) {}
			try {
				if (conn != null) {conn.close();}
			} catch (Exception e) {}
		}
		
		return ret;
	}
	
		public ArrayList<Airline> getAirlines() {
		
		ArrayList<Airline> ret = new ArrayList<>();

		String sql = "SELECT * FROM airlines ORDER BY name;";
		
		Connection conn = null;
		Statement  stat = null;
		ResultSet  rSet = null;

		try {
			/*
				Carga en memoria de mala manera
				la clase Drive.
			*/
			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection(
				DBConfig.URL,
				DBConfig.USER,
				DBConfig.PASSWORD
			);
			
			stat = conn.createStatement();
			rSet = stat.executeQuery(sql);
			
			while (rSet.next()) {
				Airline airline = new Airline();
				
				airline.setId(rSet.getInt("id"));
				airline.setAid(rSet.getString("aid"));
				airline.setName(rSet.getString("name"));
				
				ret.add(airline);
			}
			
		} catch (SQLException sqle) {
			System.out.println(sqle.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			/*
				Cerrar todos los elementos de
				forma inversa al que se han
				habierto.
			*/
			try {
				if (rSet != null) {rSet.close();}
			} catch (Exception e) {}
			try {
				if (stat != null) {stat.close();}
			} catch (Exception e) {}
			try {
				if (conn != null) {conn.close();}
			} catch (Exception e) {}
		}
		
		return ret;
	}
	
	public ArrayList<Flight> getFlightsByIdTravel(Travel travel) {
		
		ArrayList<Flight> ret = new ArrayList<>();

		String sql = String.format(
			"SELECT * FROM flights WHERE idTravel=%d ORDER BY code;",
			travel.getId()
		);
		
		Connection conn = null;
		Statement  stat = null;
		ResultSet  rSet = null;

		try {
			/*
				Carga en memoria de mala manera
				la clase Drive.
			*/
			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection(
				DBConfig.URL,
				DBConfig.USER,
				DBConfig.PASSWORD
			);
			
			stat = conn.createStatement();
			rSet = stat.executeQuery(sql);
			
			while (rSet.next()) {
				Flight flight = new Flight();
				
				flight.setId(rSet.getInt("id"));
				flight.setDuration(rSet.getInt("duration"));
				flight.setCode(rSet.getString("code"));
				flight.setStartMoment(rSet.getTimestamp("startMoment"));
				
				ret.add(flight);
			}
			
		} catch (SQLException sqle) {
			System.out.println(sqle.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			/*
				Cerrar todos los elementos de
				forma inversa al que se han
				habierto.
			*/
			try {
				if (rSet != null) {rSet.close();}
			} catch (Exception e) {}
			try {
				if (stat != null) {stat.close();}
			} catch (Exception e) {}
			try {
				if (conn != null) {conn.close();}
			} catch (Exception e) {}
		}
		
		return ret;
	}
	
	public Flight getFlightByCode(String code) {
		
		Flight ret = new Flight();

		String sql = String.format( //#XXX Si falla es esta comilla
			"SELECT * FROM flights WHERE code='%s';",
			code
		);
		
		Connection conn = null;
		Statement  stat = null;
		ResultSet  rSet = null;

		try {
			/*
				Carga en memoria de mala manera
				la clase Drive.
			*/
			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection(
				DBConfig.URL,
				DBConfig.USER,
				DBConfig.PASSWORD
			);
			
			stat = conn.createStatement();
			rSet = stat.executeQuery(sql);
			/*
			while (rSet.next()) {
				Flight flightt = new Flight();
				
				flightt.setId(rSet.getInt("id"));
				flightt.setDuration(rSet.getInt("duration"));
				flightt.setCode(rSet.getString("code"));
				flightt.setStartMoment(rSet.getTimestamp("startMoment"));
				
				ret.add(flight);
			
			}
			*/
		} catch (SQLException sqle) {
			System.out.println(sqle.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			/*
				Cerrar todos los elementos de
				forma inversa al que se han
				habierto.
			*/
			try {
				if (rSet != null) {rSet.close();}
			} catch (Exception e) {}
			try {
				if (stat != null) {stat.close();}
			} catch (Exception e) {}
			try {
				if (conn != null) {conn.close();}
			} catch (Exception e) {}
		}
		
		return ret;
	}
	
	public void insertTravel(Travel travel) {
		
		String sql = String.format(
			"INSERT INTO travels (name, description, descServiceNotIncluded, travelDate, duration, idAgency, idTravelType) VALUES ('%s', '%s', '%s', '%s', %d, %d, %d);",
			travel.getName(),
			travel.getDescription(),
			travel.getDescServiceNotIncluded(),
			travel.getTravelDate().toString(),
			travel.getDuration(),
			travel.getAgency().getId(),
			travel.getTravelType().getId()
		);
		
		iud(sql);
	}


	public void updateTravel(Travel travel) {
		
		String sql = String.format(
			"REPLACE INTO travels (name, description, descServiceNotIncluded, travelDate, duration, idAgency, idTravelType) VALUES ('%s', '%s', '%s', '%s', %d, %d, %d);",
			travel.getName(),
			travel.getDescription(),
			travel.getDescServiceNotIncluded(),
			travel.getTravelDate().toString(),
			travel.getDuration(),
			travel.getAgency().getId(),
			travel.getTravelType().getId()
		);
		
		iud(sql);
	}
	
	public void deleteTravel(Travel travel) {
		
		String sql = String.format(
			"DELETE FROM travels WHERE id = %d;",
			travel.getId()
		);
		
		iud(sql);
	}
	
	
	public void insertAccommodation(Accommodation accommodation) {
	
		String sql = String.format(
			"INSERT INTO accommodation (name, price, enterDate, exitDate, idTravel, idCity , idRoomType) VALUES ('%s', %f, '%s', '%s', %d, %d, %d);",
			accommodation.getName(),
			accommodation.getPrice(),
			accommodation.getEnterDate().toString(),
			accommodation.getExitDate().toString(),
			accommodation.getTravel().getId(),
			accommodation.getCity().getId(),
			accommodation.getRoomType().getId()
		);
		
		iud(sql);
	}
	
	public void updateAccommodation(Accommodation accommodation) {
	
		String sql = String.format(
			"REPLACE INTO accommodation (name, price, enterDate, exitDate, idTravel, idCity , idRoomType) VALUES ('%s', %f, '%s', '%s', %d, %d, %d);",
			accommodation.getName(),
			accommodation.getPrice(),
			accommodation.getEnterDate().toString(),
			accommodation.getExitDate().toString(),
			accommodation.getTravel().getId(),
			accommodation.getCity().getId(),
			accommodation.getRoomType().getId()
		);
		
		iud(sql);
	}
	
	public void insertFlight(Flight flight) {
        
		String sql = String.format(
			"INSERT INTO `flights` (`idTravel`, `idAirportStart`, `idAirportEnd`, `idAirline`, `code`, `price`, `startMoment`, `duration`) VALUES (%d,%d,%d,%d,'%s',%s,'%s',%d)",
			flight.getTravel().getId(),
			flight.getAirportStart().getId(),
			flight.getAirportEnd().getId(),
			flight.getAirline().getId(),
			flight.getCode(),
			String.valueOf(flight.getPrice()).replace(",", "."),
			flight.getStartMoment().toString().substring(0, 19),
			flight.getDuration()
		);

		iud(sql);
	}
	
	public void updateFlight(Flight flight) {
	
		String sql = String.format(
			"REPLACE INTO `flights` (`idTravel`, `idAirportStart`, `idAirportEnd`, `idAirline`, `code`, `price`, `startMoment`, `duration`) VALUES (%d,%d,%d,%d,'%s',%s,'%s',%d)",
			flight.getTravel().getId(),
			flight.getAirportStart().getId(),
			flight.getAirportEnd().getId(),
			flight.getAirline().getId(),
			flight.getCode(),
			String.valueOf(flight.getPrice()).replace(",", "."),
			flight.getStartMoment().toString().substring(0, 19),
			flight.getDuration()
		);
		
		iud(sql);
	}
	
	public void insertFlightPair(FlightPair flightPair) {
	
		String sql = String.format(
			"INSERT INTO `flightpairs` (`idTravel`, `idGoFlight`, `idReturnFlight`) VALUES (%d,%d,%d)",
			flightPair.getTravel().getId(),
			flightPair.getGoFlight().getId(),
			flightPair.getReturnFlight().getId()
		);
		
		iud(sql);
	}
	
	public void insertOther(Other other) {
		
		String sql = String.format(									// #XXX Si falla son las comillas
			"INSERT INTO `other` (`price`, `name`, `description`, `eventDate`, `idTravel`) VALUES (%f, %s, %s, %, %d)",
			other.getPrice(),
			other.getName(),
			other.getDescription(),
			other.getEventDate().toString(),
			other.getTravel().getId()
		);
		
		iud(sql);
	}
	
	public void updateOther(Other other) {
		
		String sql = String.format(									// #XXX Si falla son las comillas
			"REPLACE INTO `other` (`price`, `name`, `description`, `eventDate`, `idTravel`) VALUES (%f, %s, %s, %, %d)",
			other.getPrice(),
			other.getName(),
			other.getDescription(),
			other.getEventDate().toString(),
			other.getTravel().getId()
		);
		
		iud(sql);
	}
}



