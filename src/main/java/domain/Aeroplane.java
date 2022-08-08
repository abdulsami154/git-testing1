package domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class Aeroplane {
    private Long id;
    private String name;
    private Integer capacity;
    private String airline;
    private List<Flight> flights;

    public Aeroplane() {
    }

    public Aeroplane(Long id, String name, Integer capacity, String airline, List<Flight> flights) {
        this.id = id;
        this.name = name;
        this.capacity = capacity;
        this.airline = airline;
        this.flights = flights;
    }

    public Aeroplane(String name, Integer capacity, String airline) {
        this.name = name;
        this.capacity = capacity;
        this.airline = airline;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
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

    @Override
    public String toString() {
        return "Aeroplane{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", capacity='" + capacity + '\'' +
                ", airline='" + airline + '\'' +
                ", flights=" + flights +
                '}';
    }

        public void populate(ResultSet rs) throws SQLException {
        this.setId(Long.parseLong(rs.getString("id")));
        this.setAirline(rs.getString("name"));
        this.setCapacity(rs.getInt("capacity"));
        this.setName(rs.getString("airline"));


    }



}
