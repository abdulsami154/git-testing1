package domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class Aeroplane {
    private String name;
    private String capacity;
    private String airline;
    private List<Flight> flights;

    public Aeroplane() {

    }

    public Aeroplane(String name, String capacity, String airline) {
        this.name = name;
        this.capacity = capacity;
        this.airline = airline;
    }

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public List<Flight> getFlights() {
        return flights;
    }

    public void setFlights(List<Flight> flights) {
        this.flights = flights;
    }

    public Aeroplane(String name, String capacity, String airline, List<Flight> flights) {
        this.name = name;
        this.capacity = capacity;
        this.airline = airline;
        this.flights = flights;
    }

    @Override
    public String toString() {
        return "Aeroplane{" +
                "name='" + name + '\'' +
                ", capacity=" + capacity +
                ", airline='" + airline + '\'' +
                ", flights=" + flights +
                '}';
    }
    public void populate(ResultSet rs) throws SQLException {
        this.setAirline(rs.getString("name"));
        this.setCapacity(rs.getString("capacity"));
        this.setName(rs.getString("airline"));


    }



}
