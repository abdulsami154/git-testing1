package domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class Passenger {
    private Long id;
    private String name;
    private String contact;
    private String address;
    private Long flightId;

    public Passenger(String passengerName, String passengerAddress, String contact, String flightNumber){

    }

    public Passenger(String name, String contact, String address, Long flightId) {
        this.name = name;
        this.contact = contact;
        this.address = address;
        this.flightId = flightId;
    }

    public Passenger() {

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

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getFlightId() {
        return flightId;
    }

    public void setFlightId(Long flightId) {
        this.flightId = flightId;
    }

    public Passenger(Long id, String name, String contact, String address, Long flightId) {
        this.id = id;
        this.name = name;
        this.contact = contact;
        this.address = address;
        this.flightId = flightId;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", contact='" + contact + '\'' +
                ", address='" + address + '\'' +
                ", flightId=" + flightId +
                '}';
    }
    public void populate(ResultSet rs) throws SQLException {
        this.setId(Long.parseLong(rs.getString("id")));
        this.setName(rs.getString("name"));
        this.setContact(rs.getString("contact_Number"));
        this.setAddress(rs.getString("address"));
        this.setFlightId(Long.parseLong(rs.getString("flight_id")));


    }
}
