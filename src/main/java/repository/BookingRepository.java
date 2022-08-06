package repository;

import domain.Flight;
import domain.Passenger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BookingRepository extends BaseConnection{

    public List<Flight> getflight() {
        List<Flight> flightList = new ArrayList<>();
        try {
            if (con.isClosed()){
                openConnection();
            }
            String query = "select * from flight";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                Flight fl = new Flight();
                fl.populate(rs);
                flightList.add(fl);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return flightList;
    }


public Passenger bookingPassengers(Passenger passenger){
    try{
        if (con.isClosed()){
            openConnection();
        }

         PreparedStatement ps = con.prepareStatement("insert into passenger (name,address,contact_Number,flight_id) values(?,?,?,?)");
            ps.setString(1, passenger.getName());
            ps.setString(2, passenger.getContact());
            ps.setString(3, passenger.getAddress());
            ps.setInt(4, (passenger.getFlightId().intValue()));
        int i = ps.executeUpdate();
        System.out.println(i);
        } catch (SQLException throwables) {
        throwables.printStackTrace();
    }finally {
        try{
            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
//    System.out.println(i + "recorded");
    }
    return passenger;
}

//    public List<Passanger> getPassengerForInquiry(String contact) {
//        List<Passanger> passengerList = new ArrayList<>();
//        try {
//            Statement st = con.createStatement();
//            ResultSet rs = st.executeQuery("select id, p.name,p.address,p.contact,f.flight_name from passenger p inner join flight f on p.flight_id = f.id where p.contact='"+contact+"'");
//            while (rs.next()){
//                Passanger pass = new Passanger();
//                pass.populate(rs);
//                passengerList.add(pass);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return passengerList;
//    }
//
//}
}
