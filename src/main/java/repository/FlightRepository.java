package repository;

import domain.Flight;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FlightRepository extends BaseConnection {

    public Flight AddingFlight(Flight flight) {

        try {
//            if (con.isClosed()){
//                openConnection();
//            }

            PreparedStatement ps = con.prepareStatement("insert into flight(flight_number,flight_date,source,destination,fare,aeroplane_id) values(?,?,?,?,?,?)");
            ps.setString(1, flight.getFlightNumber());
            ps.setDate(2, Date.valueOf(flight.getDate()));
            ps.setString(3, flight.getSource());
            ps.setString(4, flight.getDestination());

            ps.setString(5, flight.getFare().toString());
            ps.setLong(6,flight.getAeroplaneId());

            int i = ps.executeUpdate();
            System.out.println(i);

        }catch (Exception e){
            e.printStackTrace();
        }


        return flight;
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

    public List<Flight> getAllFlightsByPlaneName(String planeName) {
        List<Flight> flightList=new ArrayList<>();
        try {
            if (con.isClosed()){
                openConnection();
            }
            String query=generateQueryForFLight(planeName);
            Statement st= con.createStatement();
            ResultSet rs=st.executeQuery(query);
            while (rs.next()){
                Flight flight=new Flight();
                flight.populate(rs);
                flightList.add(flight);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return flightList;
    }

    private String generateQueryForFLight(String planeName) {
        String query="select * from flight";
        if (planeName.equalsIgnoreCase("")){
            query="select * from flight";
        }else if (planeName.equalsIgnoreCase(planeName)){
            query=query+" where aeroplane_id in (select id from aeroplane where name ='"+planeName+"')";
        }
        return query;
    }

    public List<Flight> deleteFlightsFromPlane(Long planeId) {
        List<Flight> flightList=new ArrayList<>();
        try {
            if (con.isClosed()){
                openConnection();
            }
            String query="select * from flight where aeroplane_id = '"+planeId+"'";
            Statement st= con.createStatement();
            ResultSet rs=st.executeQuery(query);
            while (rs.next()){
                Flight flight=new Flight();
                flight.populate(rs);
                flightList.add(flight);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return flightList;
    }


    public List<Flight> deleteFlight(String flightId) {
        List<Flight> flightList=new ArrayList<>();
        try {
            if (con.isClosed()) {
                openConnection();
            }
            String query = "Delete from flight where flight_number ='"+flightId+"'";
            Statement st = con.createStatement();
            st.execute(query);

        } catch (Exception throwables) {
            throwables.printStackTrace();
        }finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
return flightList;
    }

    public Flight getFlightsById(Long planeId) {
        Flight flight=new Flight();
        try{
            if (con.isClosed()) {
                openConnection();
            }
            String query = "Select * from flight where aeroplane_id='"+ planeId +"'";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                flight.populate(rs);
            }

        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return flight;
    }

    public void updateFlight(String flightNumber, LocalDate flightDate, String flightSource, String flightDestination, double flightFare) {
        try{
            if(con.isClosed()){
                openConnection();
            }
            Statement st = con.createStatement();

            st.executeUpdate("update flight set flight_number = '"+flightNumber+"',flight_date ='"+flightDate+"' " +
                    ",source='"+flightSource+"',destination = '"+flightDestination+"',fare='"+flightFare+"' where id='3'");


        }catch (Exception e){
            e.printStackTrace();}
    }
    }

//    public static void main(String[] args) {
//        FlightRepository fl = new FlightRepository();
//        System.out.println(fl.generateQuery("ISB","KHI"));
//    }

