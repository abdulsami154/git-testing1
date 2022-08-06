package domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Flight {
    private Long id;
    private String flightNumber;
    private String source;
    private String destination;
    private Double fare;
    private LocalDate date;
    private long aeroplaneId;
    private List<Passenger> passengerList=new ArrayList<>();

    public Flight(){

    }

    public Flight(Long id, String flightNumber, String source, String destination, Double fare, LocalDate date, long aeroplaneId, List<Passenger> passengerList) {
        this.id = id;
        this.flightNumber = flightNumber;
        this.source = source;
        this.destination = destination;
        this.fare = fare;
        this.date = date;
        this.aeroplaneId = aeroplaneId;
        this.passengerList = passengerList;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Double getFare() {
        return fare;
    }

    public void setFare(Double fare) {
        this.fare = fare;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public long getAeroplaneId() {
        return aeroplaneId;
    }

    public void setAeroplaneId(long aeroplaneId) {
        this.aeroplaneId = aeroplaneId;
    }

    public List<Passenger> getPassengerList() {
        return passengerList;
    }

    public void setPassengerList(List<Passenger> passengerList) {
        this.passengerList = passengerList;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "id=" + id +
                ", flightNumber='" + flightNumber + '\'' +
                ", source='" + source + '\'' +
                ", destination='" + destination + '\'' +
                ", fare=" + fare +
                ", date=" + date +
                ", aeroplaneId=" + aeroplaneId +
                ", passengerList=" + passengerList +
                '}';
    }

    public void populate(ResultSet rs) throws SQLException {
this.setId(Long.parseLong(rs.getString("id")));
this.setFlightNumber(rs.getString("flight_number"));
this.setDate(LocalDate.parse(rs.getString("flight_date")));
this.setSource(rs.getString("source"));
this.setDestination(rs.getString("destination"));
this.setFare(rs.getDouble("fare"));
this.setAeroplaneId(rs.getLong("aeroplane_id"));

    }
}
