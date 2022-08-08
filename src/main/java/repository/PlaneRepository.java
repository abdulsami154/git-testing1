package repository;

import domain.Aeroplane;
import domain.Flight;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PlaneRepository extends BaseConnection{
    public List<Aeroplane> getAllAeroplane(){
        List<Aeroplane> aeroplaneList=new ArrayList<>();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from aeroplane");
            while (rs.next()) {
                Aeroplane aeroplane =new Aeroplane();
                aeroplane.populate(rs);
                aeroplaneList.add(aeroplane);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
          return aeroplaneList;
    }

    public List<Aeroplane> addingAeroplane(Aeroplane aeroplane){
        List<Aeroplane> aeroplaneList=new ArrayList<>();
        try {
            if (con.isClosed()){
                openConnection();
            }

            PreparedStatement ps = con.prepareStatement("insert into aeroplane(name,capacity,airline) values(?,?,?)");
            ps.setString(1, aeroplane.getName());
            ps.setInt(2, aeroplane.getCapacity());
            ps.setString(3, aeroplane.getAirline());
            int i = ps.executeUpdate();
            System.out.println(i);

        }catch (Exception e){
            e.printStackTrace();
        }
        return aeroplaneList;
    }

    public List<Aeroplane> deletePlane(String airline) {
        List<Aeroplane> planeList=new ArrayList<>();
        try {
    String query =generateDeleteQuery(airline);
    Statement st= con.createStatement();
    st.execute(query);

}catch (Exception e){
e.printStackTrace();
}finally {
    try {
        con.close();
    } catch (SQLException throwables) {
        throwables.printStackTrace();
    }
}
return planeList;
    }

    private String generateDeleteQuery(String airline) {
    String query="Delete from aeroplane";
    if (!airline.equalsIgnoreCase(" ")){
query=query+" where airline ='"+airline+"'";
    }
    return query;
    }

    public Aeroplane getAllPlaneByPlaneName(String airlineName) {
        Aeroplane aero = new Aeroplane();
        try {
            if (con.isClosed()) {
                openConnection();
            }
            String query = "select * from aeroplane where airline='" + airlineName + "'";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                aero.populate(rs);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return aero;
    }

    public void updatePlane(String name, Integer capacity, String airline, Long id) {
        try{
        if (con.isClosed()){
        openConnection();
            }
        Statement st= con.createStatement();
            st.executeUpdate("update aeroplane set name = '"+name+"'," +
                    " capacity = '"+capacity+"', airline = '"+airline+"' where id = '"+id+"'");

        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
