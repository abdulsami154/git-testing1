package repository;

import domain.Flight;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class FlightRepository extends BaseConnection {

    public static List<Flight> AddingFlight(Flight flight) {
        List<Flight> flightList=new ArrayList<>();
        try {
//            if (con.isClosed()){
//                openConnection();
//            }

            PreparedStatement ps = con.prepareStatement("insert into flight(flight_number,flight_date,source,destination,fare,) values(?,?,?,?,?)");
            ps.setString(1, flight.getFlightNumber());
            ps.setString(2, flight.getSource());
            ps.setString(3, flight.getDestination());
            ps.setString(4, flight.getDate().toString());
            ps.setString(5, flight.getFare().toString());

            int i = ps.executeUpdate();
            System.out.println(i);

        }catch (Exception e){
            e.printStackTrace();
        }
        return flightList;

    }


    public List<Flight> getAllFlight(String src, String des) {
        List<Flight> flightList = new ArrayList<>();
        try {
            String query = generateQuery(src, des);
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

    private String generateQuery(String src, String des) {
        String query = "select * from flight";
        if (!src.equalsIgnoreCase("src") && !des.equalsIgnoreCase("des")) {
            query = query + " where source ='" + src + "'and destination= '" + des + "'";
        } else if (!src.equalsIgnoreCase("src")) {
            query = query + "where source='" + src + "'";
        } else if (!des.equalsIgnoreCase("des")) {
            query = query + "where destination='" + des + "'";
        }
        return query;
    }

//    public static void main(String[] args) {
//        FlightRepository fl = new FlightRepository();
//        System.out.println(fl.generateQuery("ISB","KHI"));
//    }
}
